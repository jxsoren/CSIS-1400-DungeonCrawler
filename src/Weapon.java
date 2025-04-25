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
            case WOODEN_SWORD -> new Weapon("Wooden Sword", "A small wooden sword", 25, 10, type);
            case STEEL_SWORD -> new Weapon("Steel Sword", "A sturdy steel sword", 40, 20, type);
            case IRON_AXE -> new Weapon("Iron Axe", "A strong iron axe", 60, 30, type);
            case EXCALIBUR -> new Weapon("Excalibur", "It's excalibur...", 100, 50, type);
            default -> new Weapon();
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
