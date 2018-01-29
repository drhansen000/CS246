import com.google.gson.Gson;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class contains a {@link Player} class and can save or load the game with a player. When it saves it serializes
 * the Player information. When it loads it deserializes the Player information and displays it.
 * @Authors: Daniel Hansen, Jay Fagerburg, & Moroni Jensen
 * @Since:   2018-01-24
 */

public class Game {
    //properties
    private Player player1;

    //non-default constructor
    Game (Player player) {
        player1 = player;
    }

    //This serializes the Player object, changes it to a JSON format, and then writes the information to a .txt file
    public String saveGame() {
        //create GSON object
        Gson gson = new Gson();

        //convert Player object to String in JSON format
        String savedPlayer = gson.toJson(player1);

        try {
            //create writer object, will write to file called player.txt
            PrintWriter out = new PrintWriter("player.txt");
            //write to said file
            out.println(savedPlayer);
            //close the file
            out.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return "player.txt";
    }

    //this method creates a new Game instance using the contents of the specified file
    public static Game loadGame(String fileName) {
        String loadPlayer = null;
        try {
            //put info in file into a String
            loadPlayer = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        //create GSON object
        Gson gson = new Gson();
        //use recently created GSON object to convert String in JSON format back into Player object
        Player player2 = gson.fromJson(loadPlayer, Player.class);

        System.out.println(player2);;

        Game game = new Game(player2);

        return game;
    }
}
