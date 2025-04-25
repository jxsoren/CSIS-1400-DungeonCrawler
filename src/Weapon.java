/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

import Enums.WeaponType;
import Enums.ItemRarityType;

public class Weapon extends Item {
    private final WeaponType type;
    private final ItemRarityType rarityType;

    // Factory for creating Weapons
    public static Weapon createWeapon(WeaponType type) {
        return switch (type) {
            // Player Weapons
            case WOODEN_SWORD ->
                    new Weapon("Wooden Sword", "A simple training sword", 25, 10, type, ItemRarityType.COMMON);
            case STEEL_SWORD ->
                    new Weapon("Steel Sword", "A reliable warrior's weapon", 40, 20, type, ItemRarityType.UNCOMMON);
            case BATTLE_AXE ->
                    new Weapon("Battle Axe", "A heavy weapon with serious cleaving power", 60, 35, type, ItemRarityType.LEGENDARY);
            case EXCALIBUR -> new Weapon("Excalibur", "It's excalibur...", 100, 50, type, ItemRarityType.EXOTIC);

            // Enemy Weapons
            case SPIDER_FANG ->
                    new Weapon("Spider Fang", "A wickedly sharp fang from a spider", 30, 8, type, ItemRarityType.COMMON);
            case RUSTY_DAGGER ->
                    new Weapon("Rusty Dagger", "A neglected blade favored by goblins", 15, 5, type, ItemRarityType.COMMON);
            case ANCIENT_SWORD ->
                    new Weapon("Ancient Sword", "A weathered blade wielded by the undead", 25, 15, type, ItemRarityType.UNCOMMON);
            case FIRE_BREATH ->
                    new Weapon("Fire Breath", "The fiery breath of a dragon", 45, 0, type, ItemRarityType.EXOTIC);
        };
    }

    // Default weapon
    public Weapon(ItemRarityType rarityType) {
        type = WeaponType.WOODEN_SWORD;
        this.rarityType = rarityType;
        createWeapon(type);
    }

    // Getters
    public WeaponType getType() {
        return type;
    }

    // Getters
    public ItemRarityType getRarityType() {
        return rarityType;
    }

    @Override
    public String toString() {
        return String.format("%s [ATK: %d]", super.getName(), super.getEffectPoints());
    }

    // Hide parameterized constructor to force curated weapons
    private Weapon(String name, String description, int effectPoints, int weight, WeaponType type, ItemRarityType rarityType) {
        super(name, description, effectPoints, weight);
        this.type = type;
        this.rarityType = rarityType;
    }

}
