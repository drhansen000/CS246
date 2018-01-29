package user;

/**
 * This class creates a User, which has 3 member-variables. Its non-default constructor takes in a password and sets it.
 * Otherwise, it's mainly just getters and setters.
 * @author  Daniel Hansen
 * @since   2018-01-13
 */

public class User {
    //private member variables
    private String password;
    private String hash;
    private String salt;

    //non-default constructor
    public User (String password) {
        this.password = password;
    }

    //getters
    protected String getPassword() {
        return password;
    }
    protected String getHashedPassword() {
        return hash;
    }
    protected String getSalt() {
        return salt;
    }

    //setters
    protected void setPassword(String password) {
        this.password = password;
    }
    protected void setHashedPassword(String hash) {
        this.hash = hash;
    }
    protected void setSalt(String salt) {
        this.salt = salt;
    }
}
