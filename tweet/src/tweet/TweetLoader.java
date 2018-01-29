package tweet;

import com.google.gson.Gson;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterObjectFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class does most of the heavy lifting. It creates a Twitter instance, taking in the necessary information (in
 * this case, mine). Then its retrieveTweetsWithHashTag method looks for tweets with the specified value, inserts the
 * results into a QueryResult, changes the JSON format into an object by utilizing the GSON object, and returns a map
 * whose key is a username and value is a BYUITweet.
 * <p>
 * @author  Daniel Hansen
 * @version 1.0
 * @since   2018-01-26 & 2018-01-29
 */

public class TweetLoader {
    private Twitter twitter;

    //default constructor
    TweetLoader() {
        configureKeys();
    }

/**
 * This method creates a Twitter instance, taking in the necessary information (in this case, mine).
 */
    private void configureKeys() {
        ConfigurationBuilder cb = new ConfigurationBuilder();

// This continuous set of function calls all connected together is referred to
// as "method chaining". It is a popular technique amongst web developers and has
// gradually found its way into other languages.
//
// The way it works is that each setter returns a reference to the object.
// For example, the code in the setDebugEnabled function might look like this:
//
//  ConfigurationBuilder setDebugEnabled(Boolean value) {
//      this.debugEnabled = value;
//
//      // Returning "this" allows method chaining.
//      return this;
//  }
//
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("z7RaFUP2fQj4HtSKB6zk8RfQ8")
                .setOAuthConsumerSecret("5vcPbdZwgA9PN03KZF55g81md1W8FP0IV9LtHEBnhGflcgXYtU")
                .setOAuthAccessToken("956783231382167552-mt1ju6KsGEPmyf278547aUaeVzyzMcY")
                .setOAuthAccessTokenSecret("OiOGc6HYBi1zuj2vFhWtasbaHMm97DLo2FuAOqOE4cwYG")
                .setJSONStoreEnabled(true);

        TwitterFactory tf = new TwitterFactory(cb.build());
        this.twitter = tf.getInstance();
    }
/**  This method looks for tweets with the specified value, inserts the results into a QueryResult, changes the
 * JSON format into an object by utilizing the GSON object, and returns the map, whose key is a username and value is
 * a BYUITweet.
*/
    public Map<String, BYUITweet> retrieveTweetsWithHashTag(String hashtag) {
        Map <String, BYUITweet> tweets = new TreeMap<>();
        Query query = new Query(hashtag);
        //I'm not too sure about this one
        QueryResult result = null;
        try {
            result = twitter.search(query);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        String twitterText;
        for (Status status : result.getTweets()) {
            twitterText = TwitterObjectFactory.getRawJSON(status);
            Gson gson = new Gson();
            BYUITweet byuiTweet = gson.fromJson(twitterText, BYUITweet.class);
            tweets.put(byuiTweet.getUser().getName(), byuiTweet);
        }
        return tweets;
    }
}
