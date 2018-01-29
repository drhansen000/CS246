package tweet;

import java.util.Comparator;

/**
 * This creates a class that implements the Comparator interface. This will order the two items being compared, first,
 * by their number of followers, and then (if the number of followers is the same), by the username.
 * <p>
 * @author  Daniel Hansen
 * @version 1.0
 * @since   2018-01-26 & 2018-01-29
 */

public class FollowersSorter implements Comparator<BYUITweet> {


    public int compare(BYUITweet lhs, BYUITweet rhs) {
        Integer byFollowers01 = lhs.getUser().getFollowers();
        Integer byFollowers02 = rhs.getUser().getFollowers();
        int result;

        //If the tweet has the same number of followers, then do it by user
        if (byFollowers01.equals(byFollowers02)) {
            String byName01 = new String(lhs.getUser().getName());
            String byName02 = new String(rhs.getUser().getName());

            result =  byName01.compareTo(byName02);
        } else {
            result =  byFollowers01.compareTo(byFollowers02);
        }

        return result;
    }
}