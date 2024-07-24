/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */

import java.util.ArrayList;
import java.util.Scanner;

public class MGame {
    public static final int MAX_ROUND = 20;
    public static final int MAX_DICE = 2;
    public static final int MAX_PLAYER = 8;

    private final ArrayList<Player> players;

    private int roundCount;

    public MGame() {
        this.roundCount = 0;
        Board board = new Board();
        Die[] dice = new Die[MAX_DICE];
        this.players = new ArrayList<>();

        for (int i = 0; i < MAX_DICE; i++) {
            dice[i] = new Die();
        }

        Scanner scanner = new Scanner(System.in);

        // Get player count
        int playerCount = 0;
        while (playerCount < 2 || playerCount > MAX_PLAYER) {
            System.out.println("Enter player count (2-8): ");
            if (scanner.hasNextInt()) {
                playerCount = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a number between 2 and 8.");
            }
        }

        // Get players' names
        for (int i = 0; i < playerCount; i++) {
            System.out.printf("Enter player %d name: ", i + 1);
            String name = scanner.nextLine();
            players.add(new Player(name, dice, board, 1000, scanner, this));
        }
    }

    private void playRound() {
        for (Player player : players) {
            System.out.println(player.getName() + "'s turn, round: " + roundCount);
            player.takeTurn();
        }
    }

    public void playGame() {
        while (roundCount < MAX_ROUND) {
            playRound();
            roundCount++;
        }
    }

    public void removePlayer(Player player) {
        System.out.println(player.getName() + " has lost and is removed from the game.");
        players.remove(player);

        // delete all property
        for (Square property : player.getOwnedSquare()) {
            property.setOwner(null);
            System.out.println(property.getName() + " is now available for purchase.");
        }
    }

    public static void main(String[] args) {
        MGame game = new MGame();
        game.playGame();
    }
}
