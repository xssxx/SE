/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GumballMachine {
    private State noQuarter;
    private State hasQuarter;
    private State gumballSold;
    private State outOfGumball;
    private State winner;

    private List<String> selectedFlavor;
    private State state;
    private int gumballCount;

    public GumballMachine(int gumballCount) {
        this.noQuarter = new NoQuarter(this);
        this.hasQuarter = new HasQuarter(this);
        this.gumballSold = new GumballSold(this);
        this.outOfGumball = new OutOfGumball(this);
        this.winner = new Winner(this);

        this.selectedFlavor = new ArrayList<String>();
        this.gumballCount = gumballCount;

        if (this.gumballCount > 0) {
            this.state = noQuarter;
        } else {
            this.state = outOfGumball;
        }
    }

    // methods
    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void choose(String flavor) {
        state.choose(flavor);
    }

    public void releaseGumball() {
        if (gumballCount != 0) {
            String flavor;
            if (selectedFlavor.isEmpty()) {
                flavor = "default flavor";
            } else {
                Random random = new Random();
                int index = random.nextInt(selectedFlavor.size());
                flavor = selectedFlavor.get(index);
            }
            System.out.println("A " + flavor + " gumball comes rolling out the slot...");
            gumballCount--;
        }
    }

    public void addFlavor(String flavor) {
        if (selectedFlavor.size() <= 2) {
            selectedFlavor.add(flavor);
        } else {
            System.out.println("Only two flavors can be selected.");
        }
    }

    @Override
    public String toString() {
        return "Inventory: " + gumballCount + " gumball(s)";
    }

    // getters
    public State getNoQuarter() {
        return noQuarter;
    }

    public State getHasQuarter() {
        return hasQuarter;
    }

    public State getGumballSold() {
        return gumballSold;
    }

    public State getOutOfGumball() {
        return outOfGumball;
    }

    public State getWinner() {
        return winner;
    }

    public int getGumballCount() {
        return gumballCount;
    }

    // setter
    public void setState(State state) {
        this.state = state;
    }
}
