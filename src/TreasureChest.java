/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

import java.util.ArrayList;
import java.util.Random;

public class TreasureChest {
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private ArrayList<Consumable> items = new ArrayList<>();

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

    public void lootOptions() {
        // Weapons Options
        System.out.println("Chest Weapons");

        if (getWeapons().isEmpty()) {
            System.out.println("No Weapons left");
        } else {
            for (int i = 0; i < getWeapons().size(); i++) {
                int normalizedIndex = i + 1;
                System.out.printf("(%d) %s%n", normalizedIndex, getWeapons().get(i));
            }

        }

        System.out.println("---------");

        // Consumable Options
        System.out.println("Chest Items");

        if (items.isEmpty()) {
            System.out.println("No Items left");
        } else {
            for (int i = 0; i < getItems().size(); i++) {
                int normalizedIndex = i + 1;
                System.out.printf("(%d) %s%n", normalizedIndex, getItems().get(i));
            }
        }


    }

    @Override
    public String toString() {
        String chestWeapons = String.format("Weapons: %s", getWeapons());
        String chestItems = String.format("Items: %s", getItems());

        return String.format("%s%n%s%n", chestWeapons, chestItems);
    }

}
