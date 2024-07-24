/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */

public class Square {
    private final String name;
    private final int location;
    private final int price;
    private Player owner;

    public Square(int location, String name, int price) {
        this.location = location;
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    public void setOwner(Player player) {
        this.owner = player;
    }

    public Player getOwner() {
        return this.owner;
    }

    public int getTax() {
        return (int) (0.1 * this.price);
    }

    public boolean hasJail() {
        return this.name.toLowerCase().contains("jail");
    }
}
