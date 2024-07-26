/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */
import java.util.ArrayList;
import java.util.Iterator;

public class Flock implements Quackable {
    ArrayList quackers = new ArrayList();
    Quackable leader;

    public void add(Quackable quacker) {
        if (leader == null)
            leader = quacker;
        else
            quackers.add(quacker);
    }

    public void quack() {
        for (int i = 0; i < 3; i++)
            leader.quack();

        Iterator iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = (Quackable)iterator.next();
            quacker.quack();
        }
    }

    @Override
    public boolean isPolite() {
        return false;
    }
}