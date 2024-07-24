/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */
import java.util.List;

public class UserService {
    private List<Validator> validators;

    public UserService(List<Validator> validators) {
        this.validators = validators;
    }

    public boolean register(User user) {
        for (Validator validator : validators)
            validator.validate(user);

        return true;
    }
}