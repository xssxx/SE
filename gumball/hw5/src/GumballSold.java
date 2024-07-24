/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */

public class GumballSold implements State {
    GumballMachine gumballMachine;

    public GumballSold(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You can't eject, you haven't inserted a quarter yet");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned but there are no gumballs");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseGumball();

        if (gumballMachine.getGumballCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarter());
        } else {
            System.out.println("Machine is sold out");
            gumballMachine.setState(gumballMachine.getOutOfGumball());
        }
    }

    @Override
    public void choose(String flavor) {
        System.out.println("Insert quarter before choosing flavor!");
    }
}
