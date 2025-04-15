import java.util.ArrayList;

public class Inventory {
    private int maxWeaponSize = 2;
    private int maxItemsSize = 10;
    private int maxInventoryWeight = 200;

    private final ArrayList<Weapon> weapons;
    private final ArrayList<Item> items;

    public Inventory() {
        // Initialize Items and Weapons
        weapons = new ArrayList<>();
        items = new ArrayList<>();
    }

    // Adding Items & Weapons

    // Todo:
    // Edge Case - player tries to pick up weapon from chest, but their
    // inventory is already full. This causes the weapon to still be returned
    // from taking the item from the chest, but inventory can't store weapon,
    // so the weapon is essentially voided

    public void addWeapon(Weapon weapon) {
        if (canAdd(weapon)) {
            weapons.add(weapon);
        }
    }

    public void addItem(Item item) {
        if (canAdd(item)) {
            items.add(item);
        }
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

    public Weapon getWeapon(int weaponIndex) {
        return weapons.get(weaponIndex);
    }

    public Item getItem(int itemIndex) {
        return items.get(itemIndex);
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public ArrayList<Item> getItems() {
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


}
