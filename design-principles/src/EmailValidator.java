/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class EmailValidator implements Validator{
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private Pattern validEmailPattern = Pattern.compile(EMAIL_PATTERN);

    @Override
    public void validate(User user) {
        if (user.getEmail() == null || user.getEmail().trim().equals("")) {
            throw new IllegalArgumentException("Email should not be empty");
        }
        if (!validEmailPattern.matcher(user.getEmail()).matches()) {
            throw new IllegalArgumentException("Email is in wrong format");
        }
        List<String> notAllowDomains = Arrays.asList("dom1.cc", "dom2.cc", "dom3.cc");
        String domain = user.getEmail().split("@")[1];
        if (notAllowDomains.contains(domain)) {
            throw new IllegalArgumentException("Domain Email is not allowed");
        }
    }
}
