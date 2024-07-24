/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Validator> validators = Arrays.asList(
                new NameValidator(),
                new EmailValidator(),
                new AgeValidator()
        );

        UserService userService = new UserService(validators);
        User user = new User("test@@example.com.", "test", 20);

        try {
            userService.register(user);
            System.out.println("User registration successful.");
        } catch (IllegalArgumentException e) {
            System.out.println("User registration failed: " + e.getMessage());
        }
    }
}