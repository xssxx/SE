/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */
public class NameValidator implements Validator {

    @Override
    public void validate(User user) {
        if (user.getName() == null || user.getName().trim().equals("")) {
            throw new IllegalArgumentException("Name should not be empty");
        }
        if (!user.getName().matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Name is in wrong format");
        }
    }
}
