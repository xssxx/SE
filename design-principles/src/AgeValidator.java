/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */
public class AgeValidator implements Validator {

    @Override
    public void validate(User user) {
        if (user.getAge() < 20) {
            throw new IllegalArgumentException("Age should be more than 20 years");
        }
    }
}
