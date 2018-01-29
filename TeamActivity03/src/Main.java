/**
 * This class main function creates an instance of {@link Player} and {@link Game}, fills the player with items, saves
 * that player in a JSON format in a file called player.txt, extracts that information, deserializes it, and then
 * displays the player's information.
 * @Authors: Daniel Hansen, Jay Fagerburg, & Moroni Jensen
 * @Since:   2018-01-24
 */

public class Main {

    public static void main(String[] args) {
        Player player = new Player("Steve", 20, 50, 100);
        player.addEquipment("bow", 5);
        player.addEquipment("sword", 150);
        player.addEquipment("arrows", 1);
        Game game = new Game(player);
        String saveFile = game.saveGame();
        game.loadGame(saveFile);
    }
}
