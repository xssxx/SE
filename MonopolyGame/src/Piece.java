/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */

public class Piece {
    private Square location;

    public Piece(Square location) {
        this.location = location;
    }

    /*
     * @return square index where this piece stay
     */
    public Square getLocation() {
        return location;
    }

    /*
     * @param: set piece to new square
     */
    public void setLocation(Square newLoc) {
        this.location = newLoc;
    }
}
