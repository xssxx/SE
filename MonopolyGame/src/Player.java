/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private final String name;
    private final MGame game;
    private final Scanner scanner;
    private final Piece piece;
    private final Board board;
    private final Die[] dice;
    private int money;
    private int jailRounds;

    public Player(String name, Die[] dice, Board board, int money, Scanner scanner, MGame game) {
        this.name = name;
        this.board = board;
        this.money = money;
        this.game = game;
        this.dice = dice;
        this.scanner = scanner;
        this.jailRounds = 0;
        this.piece = new Piece(board.getStartSquare());

        for (int i = 0; i < MGame.MAX_DICE; i++)
            dice[i] = new Die();
    }

    /*
     * check if in jail then handle jail turn
     * roll dice & move piece
     * ask for buying
     */
    public void takeTurn() {
        if (this.isInJail()) {
            handleJailTurn();
            return; // Skip round
        }

        int total = rollDice();
        movePiece(total);

        Square newLoc = piece.getLocation();
        System.out.println("Price: " + newLoc.getPrice());
        System.out.println("Total money: " + this.getMoney());

        // Check if the price is 0, then skip buying
        if (newLoc.getPrice() == 0) {
            System.out.println("Special square");
        } else {
            buy(newLoc);
        }

        System.out.println('\n');
    }

    /*
     * roll 2 dices
     * @return value between 1-12
     */
    private int rollDice() {
        int total = 0;
        for (int i = 0; i < MGame.MAX_DICE; i++) {
            dice[i].roll();
            total += dice[i].getFaceValue();
        }
        return total;
    }

    /*
     * @param total: number of move to move
     * get old location and then move to new location
     * if move to someone else property then pay tax
     */
    private void movePiece(int total) {
        Square oldLoc = piece.getLocation();
        Square newLoc = board.getSquare(oldLoc, total);
        piece.setLocation(newLoc);
        System.out.println(name + " moves " + total + " spaces");
        System.out.println(name + " moved from " + oldLoc.getLocation() + " to " + newLoc.getLocation() + ' ' + newLoc.getName());

        if (newLoc.hasJail()) {
            System.out.println("You're in jail for 2 rounds.");
            this.goToJail();
        }

        // not me & not null = other player property
        if (newLoc.getOwner() != null && newLoc.getOwner() != this) {
            payTax(newLoc);
        }
    }

    /*
     * ask for choice to get out of jail
     * if not select choice then do nothing
     * and reduce jail round by 1
     */
    private void handleJailTurn() {
        System.out.println(name + " is in jail (round " + jailRounds + ").");

        if (jailRounds >= 2) {
            System.out.println(name + " has served " + jailRounds + " rounds in jail and must now pay $100 to be released. (y/n)");
            String ans = scanner.nextLine();

            while (true) {
                switch (ans.toLowerCase()) {
                    case "y":
                        payToGetOut();
                        return;
                    case "n":
                        return;
                    default:
                        System.out.println("Invalid input. Please enter 'y' or 'n'.");
                        ans = scanner.nextLine();
                        break;
                }
            }
        } else {
            System.out.println("Options:");
            System.out.println("1. Pay $500 to get out immediately.");
            System.out.println("2. Attempt to roll doubles on your next turn.");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline after nextInt()

            switch (choice) {
                case 1:
                    payToGetOut();
                    break;
                case 2:
                    if (tryRollDoubles()) {
                        System.out.println(name + " rolled doubles and is out of jail!");
                        jailRounds = 0;
                    } else {
                        System.out.println(name + " did not roll doubles.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Skipping turn.");
                    break;
            }
        }

        jailRounds--;
    }

    /*
     * pay 100 to get out of jail immediately
     */
    private void payToGetOut() {
        if (money >= 100) {
            money -= 100;
            jailRounds = 0; // Reset jail rounds
            System.out.println(name + " paid $100 to get out of jail.");
        } else {
            System.out.println(name + " does not have enough money to pay $100. You'll try to roll doubles on the next turn.");
        }
    }

    /*
     * roll 2 dice and check if there's a double (get same number both dice)
     */
    private boolean tryRollDoubles() {
        dice[0].roll();
        dice[1].roll();
        System.out.println(name + " rolled " + dice[0].getFaceValue() + " and " + dice[1].getFaceValue() + ".");
        return dice[0].getFaceValue() == dice[1].getFaceValue();
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void goToJail() {
        this.jailRounds = 2; // Player starts with 2 rounds in jail
    }

    public boolean isInJail() {
        return jailRounds > 0;
    }

    public ArrayList<Square> getOwnedSquare() {
        ArrayList<Square> ownedSquares = new ArrayList<>();
        for (Square square : board.getAllSquares()) {
            if (square.getOwner() == this)
                ownedSquares.add(square);
        }
        return ownedSquares;
    }

    /*
     * pay tax to owner of square
     * if can't pay tax then remove player from game
     */
    public void payTax(Square loc) {
        Player owner = loc.getOwner();
        int tax = loc.getTax();

        if (owner == null || owner == this) {
            return;
        }

        if (this.money >= tax) {
            this.money -= tax;
            owner.receiveMoney(tax);
            System.out.println(name + " paid $" + tax + " to " + owner.getName() + " as tax.");
        } else {
            System.out.println(name + " cannot afford to pay the tax of $" + tax);
            // lose game
            game.removePlayer(this);
        }
    }

    /*
     * receive tax from player that move to property
     * @param money: amount of tax to receive
     */
    public void receiveMoney(int money) {
        this.money += money;
    }

    /*
     * ask for buying
     * @param newLoc: location to buy property
     */
    public void buy(Square newLoc) {
        if (this.money < newLoc.getPrice()) {
            System.out.println("Not enough money to buy " + newLoc.getLocation());
            return;
        }

        String ans;
        while (true) {
            System.out.println("Do you want to buy " + newLoc.getLocation() + "? (y/n)");
            ans = scanner.nextLine();

            switch (ans.toLowerCase()) {
                case "y":
                    newLoc.setOwner(this);
                    System.out.println("You bought " + newLoc.getLocation());
                    this.money -= newLoc.getPrice();
                    return;
                case "n":
                    System.out.println("You chose not to buy " + newLoc.getLocation());
                    return;
                default:
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                    break;
            }
        }
    }
}
