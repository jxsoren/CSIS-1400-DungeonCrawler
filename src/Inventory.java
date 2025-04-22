/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

import java.util.ArrayList;

public class Inventory {
    private int maxWeaponSize = 2;
    private int maxItemsSize = 10;
    private int maxInventoryWeight = 200;

    private final ArrayList<Weapon> weapons;
    private final ArrayList<Consumable> items;

    public Inventory() {
        // Initialize Items and Weapons
        weapons = new ArrayList<>();
        weapons.add(new Weapon());
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

    // Display

    public void displayInventory() {
        // Inventory Top

        int lineWidth = 42;

        System.out.println();

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                 INVENTORY                  ┃");
        System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
        System.out.println("┃                                            ┃");
        System.out.println("┃                                            ┃");
        System.out.println("┃                                            ┃");
        System.out.println("┃                                            ┃");
        System.out.println("┃                                            ┃");
        System.out.println("┃                                            ┃");
        System.out.println("┃                                            ┃");
        System.out.println("┃                                            ┃");
        System.out.println("┃                                            ┃");
        System.out.println("┃                                            ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        System.out.println(getWeapons());

        GameWindow.printInventory(this);

        // Inventory Body

        // Inventory Bottom

    }

    public String inventoryStats() {
        return String.format("[%dlbs/%dlbs]", currentWeight(), maxInventoryWeight);
    }

    public StringBuilder weaponsString() {
        StringBuilder line = new StringBuilder();

        for (int i = 0; i < getWeapons().size(); i++) {
            String weapon = String.format("(%d) %s%n", i + 1, getWeapon(i));
            line.append(weapon);
        }

        return line;
    }

    public StringBuilder itemsString() {
        StringBuilder line = new StringBuilder();

        for (int i = 0; i < getItems().size(); i++) {
            String item = String.format("(%d) %s%n", i + 1, getItem(i));
            line.append(item);
        }

        return line;
    }

    public void printFormattedInventory() {
        GameWindow.printInventory(this);
    }

    @Override
    public String toString() {
        String inventoryStats = String.format("Inventory [%dlbs/%dlbs]:", currentWeight(), maxInventoryWeight);
        String weapons = String.format("\tWeapons (%s/%s): %s", getWeapons().size(), maxWeaponSize, getWeapons());
        String items = String.format("\tItems: (%s/%s): %s", getItems().size(), maxItemsSize, getItems());

        return String.format("%n%s%n%s%n%s%n", inventoryStats, weapons, items);
    }

}
