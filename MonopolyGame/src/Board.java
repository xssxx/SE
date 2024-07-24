/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */

import java.util.ArrayList;

public class Board {
    private final ArrayList<Square> squares;
    public static final int BOARD_SIZE = 40;

    /*
     * initialize all squares index, name and price
     */
    public Board() {
        squares = new ArrayList<>();

        squares.add(new Square(0, "Start", 0));
        squares.add(new Square(1, "Mediterranean Avenue", 60));
        squares.add(new Square(2, "Community Chest", 0));
        squares.add(new Square(3, "Baltic Avenue", 60));
        squares.add(new Square(4, "Income Tax", 0));
        squares.add(new Square(5, "Reading Railroad", 200));
        squares.add(new Square(6, "Oriental Avenue", 100));
        squares.add(new Square(7, "Chance", 0));
        squares.add(new Square(8, "Vermont Avenue", 100));
        squares.add(new Square(9, "Connecticut Avenue", 120));

        squares.add(new Square(10, "Jail / Just Visiting", 0));
        squares.add(new Square(11, "St. Charles Place", 140));
        squares.add(new Square(12, "Electric Company", 150));
        squares.add(new Square(13, "States Avenue", 140));
        squares.add(new Square(14, "Virginia Avenue", 160));
        squares.add(new Square(15, "Pennsylvania Railroad", 200));
        squares.add(new Square(16, "St. James Place", 180));
        squares.add(new Square(17, "Community Chest", 0));
        squares.add(new Square(18, "Tennessee Avenue", 180));
        squares.add(new Square(19, "New York Avenue", 200));

        squares.add(new Square(20, "Free Parking", 0));
        squares.add(new Square(21, "Kentucky Avenue", 220));
        squares.add(new Square(22, "Chance", 0));
        squares.add(new Square(23, "Indiana Avenue", 220));
        squares.add(new Square(24, "Illinois Avenue", 240));
        squares.add(new Square(25, "B. & O. Railroad", 200));
        squares.add(new Square(26, "Atlantic Avenue", 260));
        squares.add(new Square(27, "Vent nor Avenue", 260));
        squares.add(new Square(28, "Water Works", 150));
        squares.add(new Square(29, "Marvin Gardens", 280));

        squares.add(new Square(30, "Go To Jail", 0));
        squares.add(new Square(31, "Pacific Avenue", 300));
        squares.add(new Square(32, "North Carolina Avenue", 300));
        squares.add(new Square(33, "Community Chest", 0));
        squares.add(new Square(34, "Pennsylvania Avenue", 320));
        squares.add(new Square(35, "Short Line", 200));
        squares.add(new Square(36, "Chance", 0));
        squares.add(new Square(37, "Park Place", 350));
        squares.add(new Square(38, "Luxury Tax", 0));
        squares.add(new Square(39, "Boardwalk", 400));
    }

    /*
     * @param start: old square
     * @param move: dice roll result to move
     * @return new square after moved
     */
    public Square getSquare(Square start, int move) {
        int i = (start.getLocation() + move) % Board.BOARD_SIZE;
        return squares.get(i);
    }

    /*
     * @return all squares
     */
    public ArrayList<Square> getAllSquares() {
        return this.squares;
    }

    /*
     * @return start square
     */
    public Square getStartSquare() {
        return squares.get(0);
    }
}
