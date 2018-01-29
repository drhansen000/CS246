package tweet;

import com.google.gson.annotations.SerializedName;

/**
 * This creates a class User that has a username and the number of followers. We used the @serializedName so that the
 * GSON can recognize the followers_count in the JSON object and put it into the followers property.
 * <p>
 * @author  Daniel Hansen
 * @version 1.0
 * @since   2018-01-26 & 2018-01-29
 */

public class User {
    private String name;

    @SerializedName("followers_count")
    private int followers;

    //getters
    public String getName() {
        return name;
    }

    public int getFollowers() {
        return followers;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }
}
