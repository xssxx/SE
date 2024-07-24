/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */

public class HasQuarter implements State {
    GumballMachine gumballMachine;

    public HasQuarter(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }


    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter return");
        gumballMachine.setState(gumballMachine.getNoQuarter());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine.setState(gumballMachine.getGumballSold());
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
