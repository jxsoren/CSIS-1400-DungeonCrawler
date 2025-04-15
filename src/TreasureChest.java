import java.util.ArrayList;
import java.util.Random;

public class TreasureChest {
    private ArrayList<Item> items;
    private ArrayList<Weapon> weapons;

    // Constants
    private final int weaponCapacity = 1;
    private final int itemCapacity = 3;

    // Parameterless constructor
    public TreasureChest() {
        randomizeChest();
    }

    // Parameterized constructor
    public TreasureChest(ArrayList<Weapon> weapons, ArrayList<Item> items) {
        this.weapons = weapons;
        this.items = items;
    }

    public Weapon takeWeapon(int weaponIndex) {
        // Todo:
        // return the weapon at the given weaponIndex
        // and remove the weapon at the given index
        // from the weapons ArrayList

    }

    public Item takeItem(int itemIndex) {
        // Todo:
        // return the item at the given itemIndex
        // and remove the item at the given index
        // from the items ArrayList

    }

    public void display() {
        // Todo:
        // print out the chest's weapons and items
        // to the console (call toString() on the
        // weapons and items)

        // And maybe above this, print out ASCII art of a chest
        // Ex: could be something like this:
        /*
            ⣿⣿⣿⣿⣿⣿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
            ⣿⣿⣿⣿⣿⣏⣀⣀⣀⡀⠀⠈⠉⠉⠉⠙⠛⠛⠛⠛⠿⠿⠿⠿⣿⣿⣿⣿⣿⣿
            ⣿⣿⣿⣿⣿⡏⠉⠙⣿⠉⠛⠛⠛⠛⠲⠶⠶⠶⢦⣤⣤⣤⣤⣰⠏⠀⢹⣿⣿⣿
            ⣿⣿⣿⣿⣿⣿⡀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⣄⠀⠀⠀⠀⠀⠹⣇⠀⢸⣿⣿⣿
            ⣿⣿⣿⣿⣿⣿⣧⢸⡇⠀⠀⠀⠀⠀⠀⠀⢰⣿⣆⣠⣦⠀⠀⠀⣻⡄⢸⣿⣿⣿
            ⣿⣿⣿⣿⣿⣿⣿⣿⣵⠶⢶⡴⠖⢶⣄⣤⣾⠁⠿⠋⢿⡤⢶⡟⠈⣷⣸⣿⣿⣿
            ⣿⣿⣿⣿⣿⣿⣿⠟⠃⠀⠀⠀⠀⠀⠈⠀⣿⡀⠀⠀⠀⢀⡾⣥⣤⣼⣿⣿⣿⣿
            ⣿⣿⣿⣿⣿⣛⣁⣀⠀⢀⣤⠀⠀⠀⠀⠀⠈⠙⠳⠶⠶⠟⠁⢈⣽⠟⣿⣿⣿⣿
            ⣿⣿⣿⠀⡏⠉⠉⠉⠙⣿⣿⠛⠳⠶⣶⠶⢦⣤⣤⣤⣄⣠⡾⠋⠁⠀⣿⣿⣿⣿
            ⣿⣿⣿⠀⠹⣄⠀⠀⡸⠇⣿⠐⡶⠀⣿⠀⠀⠀⠀⠀⠈⣿⠀⠀⠀⠀⣿⣿⣿⣿
            ⣿⣿⣿⠀⠀⠈⢫⣯⠁⠀⣿⣤⣥⣀⣿⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⣿⣿⣿⣿
            ⣿⣿⣿⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠉⠉⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⣿⣿⣿⣿
            ⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⣀⣴⣿⣿⣿⣿
            ⣿⣿⣏⠙⢻⣿⣿⣷⣶⣶⣶⣶⣤⣤⣤⣤⣄⣀⣀⣀⣀⣿⣤⡾⠿⢿⣍⣩⣿⣿
            ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣿⣿⣿⣿⣿
         */

    }

    private void randomizeChest() {
        // Todo:
        // Add logic to add a random amount of weapons between 0 and 1 (weaponCapacity)
        // add the random weapons to the ArrayList weapons

        // Todo:
        // Add logic to add a random amount of items between 1 and 3 (itemCapacity)
        // add the random items to the ArrayList items
    }

    // Getters

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }

}
