package tweet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This creates a {@link TweetLoader} instance, which then utilizes the Twitter API. It then displays the results,
 * first ordered by username(which is done by using a TreeMap), then by the number of followers (which utilizes the
 * {@link FollowersSorter} and an ArrayList class).
 * <p>
 * @author  Daniel Hansen
 * @version 1.0
 * @since   2018-01-26 & 2018-01-29
 */

public class Main {

    public static void main(String[] args) {
        //create the variables
        TweetLoader byuiTweet = new TweetLoader();
        Map<String, BYUITweet> sortedKeyMap;
        sortedKeyMap = byuiTweet.retrieveTweetsWithHashTag("#byui");

        //display the map sorted by usernames
        System.out.println("Map sorted by username:");

        for (Map.Entry<String, BYUITweet> entry : sortedKeyMap.entrySet()) {
            System.out.print(entry.getKey() + " (" + entry.getValue().getUser().getFollowers() + " Followers)");
            System.out.println(" - " + entry.getValue().getText());
        }

        //convert the tree into a list so that we can utilized the sort method
        List<BYUITweet> sortedValue = new ArrayList<>(sortedKeyMap.values());
        //utilize the List sort method, which takes a new comparator, FollowerSorter, for sorting by value
        sortedValue.sort(new FollowersSorter());

        //display the map, converted to list, sorted by followers
        System.out.println("\nMap sorted by followers:");

        for (int i = 0; i < sortedValue.size(); i++)
        {
            System.out.print(sortedValue.get(i).getUser().getName() + " (");
            System.out.print(sortedValue.get(i).getUser().getFollowers() + " Followers)");
            System.out.println(" - " + sortedValue.get(i).getText());
        }
    }
}
