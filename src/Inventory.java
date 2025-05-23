/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

import Enums.WeaponType;

import java.util.ArrayList;

public class Inventory {
    private int maxWeaponSize = 6;
    private int maxItemsSize = 10;
    private int maxInventoryWeight = 200;

    private final ArrayList<Weapon> weapons;
    private final ArrayList<Consumable> items;

    public Inventory() {
        // Initialize Items and Weapons
        weapons = new ArrayList<>();
        // Start w/ default weapon
        weapons.add(Weapon.createWeapon(WeaponType.WOODEN_SWORD));

        items = new ArrayList<>();
    }

    public void listWeapons() {
        System.out.println("Weapons: ");
        for (int i = 0; i < getWeapons().size(); i++) {
            System.out.printf("%d - %s%n", i + 1, getWeapon(i));
        }
        System.out.println();
    }

    public void listItems() {
        System.out.println("Items: ");
        for (int i = 0; i < getItems().size(); i++) {
            System.out.printf("(%d) - %s%n", i + 1, getItem(i));
        }
        System.out.println();
    }

    public void addWeapon(Weapon weapon) {
        if (!canAdd(weapon)) {
            return;
        }

        weapons.add(weapon);
    }

    public void addItem(Consumable item) {
        if (!canAdd(item)) {
            return;
        }

        items.add(item);
    }

    public int currentWeight() {
        int weaponsWeight = 0;
        int itemsWeight = 0;

        for (Weapon weapon : weapons) {
            weaponsWeight += weapon.getWeight();
        }

        for (Item item : items) {
            itemsWeight += item.getWeight();
        }

        return weaponsWeight + itemsWeight;
    }

    // Dropping Items & Weapons

    public void dropWeapon(int weaponIndex) {
        weapons.remove(weaponIndex);
    }

    public void dropItem(int itemIndex) {
        items.remove(itemIndex);
    }

    // Getters

    public int getMaxInventoryWeight() {
        return maxInventoryWeight;
    }

    public Weapon getWeapon(int weaponIndex) {
        return weapons.get(weaponIndex);
    }

    public Consumable getItem(int itemIndex) {
        return items.get(itemIndex);
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public ArrayList<Consumable> getItems() {
        return items;
    }

    // Setters

    public void setMaxInventoryWeight(int maxInventoryWeight) {
        this.maxInventoryWeight = maxInventoryWeight;
    }

    public void setMaxWeaponSize(int maxWeaponSize) {
        this.maxWeaponSize = maxWeaponSize;
    }

    public void setMaxItemSize(int maxItemSize) {
        this.maxItemsSize = maxItemSize;
    }

    // Helpers

    private boolean canAdd(Weapon weapon) {
        int weaponWeight = weapon.getWeight();
        boolean withinCapacity = weapons.size() < maxWeaponSize;

        // Check if weight to add doesn't go over weight limit
        return withinCapacity && canStoreAdditionalWeight(weaponWeight);
    }

    private boolean canAdd(Item item) {
        int itemWeight = item.getWeight();
        boolean withinCapacity = items.size() < maxItemsSize;

        // Check if weight to add doesn't go over weight limit
        return withinCapacity && canStoreAdditionalWeight(itemWeight);
    }

    private boolean canStoreAdditionalWeight(int weightToAdd) {
        int pendingTotalWeight = weightToAdd + currentWeight();
        return pendingTotalWeight <= this.maxInventoryWeight;
    }

    public String inventoryStats() {
        return String.format("[%dlbs/%dlbs]", currentWeight(), maxInventoryWeight);
    }

    public String[] weaponStrings() {
        int sizeOfWeapons = getWeapons().size();
        String[] weaponStrings = new String[sizeOfWeapons];

        for (int i = 0; i < sizeOfWeapons; i++) {
            String weaponString = String.format("(%d) %s", i + 1, getWeapon(i));
            weaponStrings[i] = weaponString;
        }

        return weaponStrings;
    }

    public String[] itemStrings() {
        int sizeOfItems = getItems().size();
        String[] itemStrings = new String[sizeOfItems];

        for (int i = 0; i < sizeOfItems; i++) {
            String itemString = String.format("(%d) %s", i + 1, getItem(i));
            itemStrings[i] = itemString;
        }

        return itemStrings;
    }

    @Override
    public String toString() {
        String inventoryStats = String.format("Inventory [%dlbs/%dlbs]:", currentWeight(), maxInventoryWeight);
        String weapons = String.format("\tWeapons (%s/%s): %s", getWeapons().size(), maxWeaponSize, getWeapons());
        String items = String.format("\tItems: (%s/%s): %s", getItems().size(), maxItemsSize, getItems());

        return String.format("%n%s%n%s%n%s%n", inventoryStats, weapons, items);
    }

}
