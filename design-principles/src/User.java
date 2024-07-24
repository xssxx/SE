/*
 * Author: Prariyavit Tachakitmatetumrong
 * Student ID: 6510450593
 */
public class User {
    private String name;
    private String email;
    private int age;

    public User(String email, String name, int age) {
        this.email = email;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
