/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */

public class GumballMachine {
    private State noQuarter;
    private State hasQuarter;
    private State gumballSold;
    private State outOfGumball;
    private State state;
    private int gumballCount;

    public GumballMachine(int gumballCount) {
        this.noQuarter = new NoQuarter(this);
        this.hasQuarter = new HasQuarter(this);
        this.gumballSold = new GumballSold(this);
        this.outOfGumball = new OutOfGumball(this);

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

    public void releaseGumball() {
        if (gumballCount != 0) {
            System.out.println("A gumball comes rolling out the slot...");
            gumballCount--;
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

    public int getGumballCount() {
        return gumballCount;
    }

    // setter
    public void setState(State state) {
        this.state = state;
    }
}
