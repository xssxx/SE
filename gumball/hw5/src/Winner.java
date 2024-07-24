/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */
public class Winner implements State {
    GumballMachine gumballMachine;

    public Winner(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
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
        System.out.println("YOU'RE A WINNER! You got two gumballs for your quarter");
        gumballMachine.releaseGumball();
        if(gumballMachine.getGumballCount() == 0) {
            gumballMachine.setState(gumballMachine.getOutOfGumball());
        } else {
            gumballMachine.releaseGumball();
            if(gumballMachine.getGumballCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarter());
            } else {
                System.out.println("Oops, out of gumball!");
                gumballMachine.setState(gumballMachine.getOutOfGumball());
            }
        }
    }

    @Override
    public void choose(String flavor) {
        System.out.println("Choose flavor after insert quarter");
    }
}