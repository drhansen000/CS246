import java.util.HashMap;
import java.util.Map;

/**
 * This class is a Player class. It creates a Player, displays its contents, changes its contents, and can add equipment
 * to it Map property called equipment, whose key is a String and Value is an Integer.
 * @Authors: Daniel Hansen, Jay Fagerburg, & Moroni Jensen
 * @Since:   2018-01-24
 */

public class Player {
    //properties
    private String name;
    private int health;
    private int mana;
    private int gold;
    private Map<String, Integer> equipment = new HashMap<>();

    //non-default contructor
    Player (String name, int health, int mana, int gold) {
        setName(name);
        setHealth(health);
        setMana(mana);
        setGold(gold);

    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getGold() {
        return gold;
    }

    public int getMana() {
        return mana;
    }
    public Map<String, Integer> getEquipment() {
        return equipment;
    }


    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setEquipment(Map<String, Integer> equipment) {
        this.equipment = equipment;
    }

    //adds equipment to the map property called equipment
    public void addEquipment(String equip, int cost) {
        try {
            equipment.put(equip, cost);
        } catch (Exception e) {
            e.getMessage();
        }
    }


    //displays the properties of Player
    public String toString() {
        System.out.println("Name: "      + name);
        System.out.println("Health: "    + health);
        System.out.println("Mana: "      + mana);
        System.out.println("Gold: "      + gold);

        //got this from Ken Chan from StackOverflow
        for (String temp: equipment.keySet()) {
            String key = temp.toString();
            String value = equipment.get(temp).toString();
            System.out.println("Has a " + key + " which costs " + value + " gold");
        }
        return "End of player stats";
    }
}
