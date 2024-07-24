public class PoliteCountingDuckFactory extends AbstractDuckFactory {
    public Quackable createMallardDuck() {
        return new QuackCounter(new QuackPolite(new MallardDuck()));
    }

    public Quackable createRedheadDuck() {
        return new QuackCounter(new QuackPolite(new RedheadDuck()));
    }

    public Quackable createDuckCall() {
        return new QuackCounter(new QuackPolite(new DuckCall()));
    }

    public Quackable createRubberDuck() {
        return new QuackCounter(new QuackPolite(new RubberDuck()));
    }
}