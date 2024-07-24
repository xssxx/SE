/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */

import java.util.Random;

public class HasQuarter implements State {
    GumballMachine gumballMachine;
    Random rand;

    public HasQuarter(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
        this.rand = new Random();
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
        System.out.println("You turned ...");
        int winner = rand.nextInt(10);
        if(winner == 0 && gumballMachine.getGumballCount() > 1) {
            gumballMachine.setState(gumballMachine.getWinner());
        } else {
            gumballMachine.setState(gumballMachine.getGumballSold());
        }
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    @Override
    public void choose(String flavor) {
        System.out.println("You have chosen the flavor " + flavor);
        gumballMachine.addFlavor(flavor);
    }
}
