import Enums.WeaponType;

/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

public class Weapon extends Item {
    private final WeaponType type;

    // Factory for creating weapons
    public static Weapon createWeapon(WeaponType type) {
        return switch (type) {
            // Player Weapons
            case WOODEN_SWORD -> new Weapon("Wooden Sword", "A simple training sword", 25, 10, type);
            case STEEL_SWORD -> new Weapon("Steel Sword", "A reliable warrior's weapon", 40, 20, type);
            case BATTLE_AXE -> new Weapon("Battle Axe", "A heavy weapon with serious cleaving power", 60, 35, type);
            case EXCALIBUR -> new Weapon("Excalibur", "It's excalibur...", 100, 50, type);

            // Enemy Weapons
            case SPIDER_FANG -> new Weapon("Spider Fang", "A wickedly sharp fang from a spider", 30, 8, type);
            case RUSTY_DAGGER -> new Weapon("Rusty Dagger", "A neglected blade favored by goblins", 15, 5, type);
            case ANCIENT_SWORD -> new Weapon("Ancient Sword", "A weathered blade wielded by the undead", 25, 15, type);
            case FIRE_BREATH -> new Weapon("Fire Breath", "The fiery breath of a dragon", 45, 0, type);
        };
    }

    // Default weapon
    public Weapon() {
        super("Wooden Sword", "A small wooden sword", 25, 10);
        this.type = WeaponType.WOODEN_SWORD;
    }

    public Weapon(String name, String description, int effectPoints, int weight, WeaponType type) {
        super(name, description, effectPoints, weight);
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s [ATK: %d]", super.getName(), super.getEffectPoints());
    }

}
