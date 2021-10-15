package User;

public class User {

    private static String username;
    private static String password;

    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        if (username.length() < 5 || username.length() > 20) {
            throw new IllegalArgumentException("Please set your username length to be between 5 to 20");
        }
        User.username = username;
    }

    public void setPassword(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Your password has to be greater than 8 characters");
        }
        User.password = password;
    }
}
