package user;

/**
 * This class simply extends the Exception object and utilizes its non-default constructor. I got help from Udemy.com.
 * @author  Daniel Hansen
 * @since   2018-01-13
 */
public class WeakPassword extends Exception {
    WeakPassword (String message) {
        super(message);
    }
}
