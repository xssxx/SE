public class DuckCall implements Quackable {
    @Override
    public void quack() {
        System.out.println("Kwak");
    }

    @Override
    public boolean isPolite() {
        return false;
    }
}
