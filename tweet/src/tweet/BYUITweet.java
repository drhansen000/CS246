package tweet;

/**
 * This creates a class that contains both a {@link User} and a text(from the tweet).
 * <p>
 * @author  Daniel Hansen
 * @version 1.0
 * @since   2018-01-26 & 2018-01-29
 */

public class BYUITweet {
    //properties
    private User user;
    private String text;

    //getters
    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    //setters
    public void setUser(User user) {
        this.user = user;
    }

    public void setText(String text) {
        this.text = text;
    }
}
