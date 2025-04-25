/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

import Enums.ChestType;
import Enums.ConsumableType;
import Enums.WeaponType;

import java.util.ArrayList;
import java.util.Random;

public class TreasureChest {
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private ArrayList<Consumable> items = new ArrayList<>();
    private ChestType type;

    // Constants
    private final int weaponCapacity = 1;
    private final int itemCapacity = 3;

    // Parameterless constructor
    public TreasureChest() {
        randomizeChest();
    }

    // Parameterized constructor
    public TreasureChest(ArrayList<Weapon> weapons, ArrayList<Consumable> items) {
        this.weapons = weapons;
        this.items = items;
    }

    public Weapon takeWeapon(int weaponIndex) {
        if (weaponIndex >= weapons.size() || weaponIndex < 0) {
            return null;
        }

        Weapon chosenWeapon = weapons.get(weaponIndex);
        weapons.remove(weaponIndex);

        return chosenWeapon;
    }

    public Consumable takeItem(int itemIndex) {
        if (itemIndex >= items.size() || itemIndex < 0) {
            return null;
        }

        Consumable chosenItem = items.get(itemIndex);
        items.remove(itemIndex);

        return chosenItem;
    }

    // Helper Methods

    private void randomizeChest() {
        ArrayList<Weapon> randomWeapons = randomWeapons(1);
        weapons.addAll(randomWeapons);

        ArrayList<Consumable> randomItems = randomItems(3);
        items.addAll(randomItems);

        // Randomize Chest Type
        for (int i = 0; i < ChestType.values().length; i++) {
            this.type = ChestType.values()[i];
        }
    }

    private ArrayList<Weapon> randomWeapons(int numOfWeapons) {
        if (numOfWeapons > weaponCapacity) {
            numOfWeapons = weaponCapacity;
        }

        Random random = new Random();

        ArrayList<Weapon> randomWeaponList = new ArrayList<>();

        for (int i = 0; i < numOfWeapons; i++) {
            // Generate a random weapon type
            WeaponType[] weaponTypes = WeaponType.values();
            int randomIndex = random.nextInt(0, weaponTypes.length);

            Weapon weapon = Weapon.createWeapon(weaponTypes[randomIndex]);
            randomWeaponList.add(weapon);
        }

        return randomWeaponList;
    }

    private ArrayList<Consumable> randomItems(int numOfItems) {
        if (numOfItems > itemCapacity) {
            numOfItems = itemCapacity;
        }

        Random random = new Random();

        ArrayList<Consumable> randomItemList = new ArrayList<>();

        for (int i = 0; i < numOfItems; i++) {
            // Generate a random weapon type
            ConsumableType[] consumableTypes = ConsumableType.values();
            int randomIndex = random.nextInt(0, consumableTypes.length);

            Consumable consumable = Consumable.createConsumable(consumableTypes[randomIndex]);
            randomItemList.add(consumable);
        }

        return randomItemList;
    }

    // Getters

    public ArrayList<Consumable> getItems() {
        return this.items;
    }

    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }

    // Helpers

    public String[] attributesArr() {
        return new String[]{String.format("Weapons: %d / %d", weapons.size(), weaponCapacity), String.format("Items: %d / %d", items.size(), itemCapacity)};
    }

    public String[][] lootingAttributesArr() {

        String[] weapons;

        if (getWeapons().isEmpty()) {
            weapons = new String[1];
            weapons[0] = "No Weapons Left";
        } else {
            weapons = new String[getWeapons().size()];
            for (int i = 0; i < getWeapons().size(); i++) {
                int normalizedIndex = i + 1;
                String weaponsString = String.format("(%d). %s", normalizedIndex, getWeapons().get(i));
                weapons[i] = weaponsString;
            }
        }

        String[] items;

        if (getItems().isEmpty()) {
            items = new String[1];
            items[0] = "No Items Left";
        } else {
            items = new String[getItems().size()];
            for (int i = 0; i < getItems().size(); i++) {
                int normalizedIndex = i + 1;
                String itemsString = String.format("(%d). %s", normalizedIndex, getItems().get(i));
                items[i] = itemsString;
            }
        }

        return new String[][]{weapons, items};
    }

    public String asciiArt() {
        return AsciiArt.asciiArtFactory(this.type.toString());
    }

    public String chestTypeString() {
        return this.type.toString().replaceFirst("_", " ");
    }

    @Override
    public String toString() {
        String chestWeapons = String.format("Weapons: %s", getWeapons());
        String chestItems = String.format("Items: %s", getItems());

        return String.format("%s%n%s%n", chestWeapons, chestItems);
    }

}
