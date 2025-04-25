/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

import java.util.ArrayList;
import java.util.Random;

import Enums.ChestType;
import Enums.ConsumableType;
import Enums.WeaponType;

public class TreasureChest {
    private final int weaponCapacity = 1;
    private final int itemCapacity = 3;

    private final ArrayList<Weapon> weapons = new ArrayList<>(weaponCapacity);
    private final ArrayList<Consumable> items = new ArrayList<>(itemCapacity);
    private final ChestType type;

    // Factory for creating curated chests
    public static TreasureChest createChest(ChestType type) {
        return switch (type) {
            case WOODEN_CHEST, GOLDEN_CHEST, SILVER_CHEST -> new TreasureChest(type);
        };
    }

    // Default chest
    public TreasureChest(ChestType type) {
        this.type = type;
        randomizeChest(type);
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

    private void randomizeChest(ChestType type) {
        // Randomize chest based on chest type

        ArrayList<Weapon> randomWeapons = randomWeapons(type);
        weapons.addAll(randomWeapons);

        ArrayList<Consumable> randomItems = randomItems(type);
        items.addAll(randomItems);
    }

    private ArrayList<Weapon> randomWeapons(ChestType type) {
        ArrayList<Weapon> randomWeapons = new ArrayList<>(weaponCapacity);
        Random random = new Random();

        for (int i = 0; i < weaponCapacity; i++) {
            switch (type) {
                case WOODEN_CHEST -> {
                    Weapon[] possibleWeapons = {
                            Weapon.createWeapon(WeaponType.WOODEN_SWORD),
                            Weapon.createWeapon(WeaponType.STEEL_SWORD),
                    };

                    int randomIndex = random.nextInt(0, possibleWeapons.length);
                    randomWeapons.add(possibleWeapons[randomIndex]);
                }
                case SILVER_CHEST -> {
                    Weapon[] possibleWeapons = {
                            Weapon.createWeapon(WeaponType.STEEL_SWORD),
                            Weapon.createWeapon(WeaponType.BATTLE_AXE)
                    };

                    int randomIndex = random.nextInt(0, possibleWeapons.length);
                    randomWeapons.add(possibleWeapons[randomIndex]);
                }
                case GOLDEN_CHEST -> {
                    Weapon[] possibleWeapons = {
                            Weapon.createWeapon(WeaponType.BATTLE_AXE),
                            Weapon.createWeapon(WeaponType.EXCALIBUR)
                    };

                    int randomIndex = random.nextInt(0, possibleWeapons.length);
                    randomWeapons.add(possibleWeapons[randomIndex]);
                }
            }
        }

        return randomWeapons;
    }

    private ArrayList<Consumable> randomItems(ChestType type) {
        ArrayList<Consumable> randomItems = new ArrayList<>(itemCapacity);
        Random random = new Random();

        for (int i = 0; i < itemCapacity; i++) {
            switch (type) {
                case WOODEN_CHEST -> {
                    Consumable[] possibleItems = {
                            Consumable.createConsumable(ConsumableType.BREAD),
                            Consumable.createConsumable(ConsumableType.APPLE),
                    };

                    int randomIndex = random.nextInt(0, possibleItems.length);
                    randomItems.add(possibleItems[randomIndex]);
                }
                case SILVER_CHEST -> {
                    Consumable[] possibleItems = {
                            Consumable.createConsumable(ConsumableType.APPLE),
                            Consumable.createConsumable(ConsumableType.BANDAGES),
                            Consumable.createConsumable(ConsumableType.HEALING_POTION),
                    };

                    int randomIndex = random.nextInt(0, possibleItems.length);
                    randomItems.add(possibleItems[randomIndex]);
                }
                case GOLDEN_CHEST -> {
                    Consumable[] possibleItems = {
                            Consumable.createConsumable(ConsumableType.BREAD),
                            Consumable.createConsumable(ConsumableType.HEALING_POTION),
                            Consumable.createConsumable(ConsumableType.HEALTH_ELIXIR),
                    };

                    int randomIndex = random.nextInt(0, possibleItems.length);
                    randomItems.add(possibleItems[randomIndex]);
                }
            }
        }

        return randomItems;
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
