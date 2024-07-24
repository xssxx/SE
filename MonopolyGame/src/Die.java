/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */

import java.util.Random;

public class Die {
    private static final int SIDES = 6;
    private int faceValue;

    /*
     * set random number between 1-6 to faceValue
     */
    public void roll() {
        Random rand = new Random();
        faceValue = rand.nextInt(1, SIDES + 1); // 1-6
    }

    /*
     * @return dice face value
     */
    public int getFaceValue() {
        return faceValue;
    }
}
