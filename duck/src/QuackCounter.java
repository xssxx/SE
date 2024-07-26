/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */
public class QuackCounter implements Quackable {
    Quackable duck;
    static int numberOfQuacks;
    static int numberOfPoliteQuacks;

    public QuackCounter (Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        if (duck.isPolite())
            numberOfPoliteQuacks++;
        else
            numberOfQuacks++;
    }

    @Override
    public boolean isPolite() {
        return false;
    }

    public static int getQuacks() {
        return numberOfQuacks;
    }

    public static int getPoliteQuacks() {
        return numberOfPoliteQuacks;
    }
}