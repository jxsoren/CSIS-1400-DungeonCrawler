/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

import java.util.ArrayList;
import java.util.Random;

public class TreasureChest {
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();

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
        if (weaponIndex >= weapons.size()) {
            return null;
        }

        Weapon chosenWeapon = weapons.get(weaponIndex);
        weapons.remove(weaponIndex);

        return chosenWeapon;
    }

    public Item takeItem(int itemIndex) {
        if (itemIndex >= items.size()) {
            return null;
        }

        Item chosenItem = items.get(itemIndex);
        items.remove(itemIndex);

        return chosenItem;
    }

    // Helper Methods

    private void randomizeChest() {
        ArrayList<Weapon> randomWeapons = randomWeapons(1);
        weapons.addAll(randomWeapons);

        ArrayList<Item> randomItems = randomItems(3);
        items.addAll(randomItems);
    }

    private ArrayList<Weapon> randomWeapons(int numOfWeapons) {
        if (numOfWeapons > weaponCapacity) {
            numOfWeapons = weaponCapacity;
        }

        ArrayList<Weapon> randomWeaponList = new ArrayList<>();

        for (int i = 0; i < numOfWeapons; i++) {
            Weapon weapon = new Weapon();
            randomWeaponList.add(weapon);
        }

        return randomWeaponList;
    }

    private ArrayList<Item> randomItems(int numOfItems) {
        if (numOfItems > itemCapacity) {
            numOfItems = itemCapacity;
        }

        ArrayList<Item> randomItemList = new ArrayList<>();

        for (int i = 0; i < numOfItems; i++) {
            Item item = new Item();
            randomItemList.add(item);
        }

        return randomItemList;
    }

    // Getters

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }


    @Override
    public String toString() {
        String chestWeapons = String.format("Weapons: %s", getWeapons());
        String chestItems = String.format("Items: %s", getItems());

        return String.format("%s%n%s%n", chestWeapons, chestItems);
    }

}
