package user;

import java.util.Scanner;
import static user.NSALoginController.hashUserPassword;
import static user.NSALoginController.verifyPassword;

/**
 * This class tests the other classes created in this program. It will prompt the user for a password and check if it's
 * a good password. If not, it will re-prompt the user until he types in a sufficiently strong password. Once the
 * password has pass the strength check, it will hash the password. After it hashes the password, it will ask the user
 * to verify the password and then it will compare them to make sure that they are the same.
 * @author  Daniel Hansen
 * @since   2018-01-13
 */

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //prompt the user for the password
        System.out.print("Please enter your password: ");
        String userPassword = scanner.nextLine();

        //create a new user using the provided password
        User user1 = new User(userPassword);

        //hash the password, the method throws so we need to catch it
        System.out.print("Password: " + user1.getPassword() + " Salt: " + user1.getSalt());
        System.out.println(" Hashed Password: " + user1.getHashedPassword());
        try {
            hashUserPassword(user1);
        } catch (WeakPassword e) {
            //re-prompt the user if the password is too weak
            while (userPassword.length() < 8) {
                System.out.println(e.getMessage());
                System.out.print("Please enter your password: ");
                userPassword = scanner.nextLine();
                user1.setPassword(userPassword);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //show the user values to verify that everything went well
        System.out.print("Password: " + user1.getPassword() + " Salt: " + user1.getSalt());
        System.out.println(" Hashed Password: " + user1.getHashedPassword());

        //prompt the user to type the password again
        System.out.print("Please re-enter your password: ");
        String verification = scanner.nextLine();

        //check if it's the same. Display a message either confirming or negating password verification
        user1.setPassword(verification);
        try {
            if (verifyPassword(user1)) {
                System.out.println("Passwords are the same.");
            }
        } catch (Exception e) {
            System.out.println("Passwords are not the same.");
        }
    }
}
