/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

public class Weapon extends Item {

    public enum WeaponType {
        WOODEN_SWORD, STEEL_SWORD, IRON_AXE, EXCALIBUR
    }

    // Default weapon
    public Weapon() {
        super("Wooden Sword", "A small wooden sword", 10, 0);
    }

    public Weapon(WeaponType type) {

        switch (type) {
            case WOODEN_SWORD -> createWoodenSword();
            case STEEL_SWORD -> createSteelSword();
            case IRON_AXE -> createSteelSword();
            case EXCALIBUR -> createSteelSword();
        }

    }

    public Weapon(String name, String description, int effectPoints, int weight) {
        // Use constructor for parent class Item
        super(name, description, effectPoints, weight);
    }

    public Weapon(String name, int effectPoints, int weight) {
        // Use constructor for parent class Item
        super(name, effectPoints, weight);
    }

    private static Weapon createWoodenSword() {
        return new Weapon("Wooden Sword", "A small wooden sword", 25, 10);
    }

    private static Weapon createSteelSword() {
        return new Weapon("Steel Sword", "A sturdy steel sword", 40, 30);
    }

    @Override
    public int use() {
        return this.getEffectPoints();
    }

    @Override
    public String toString() {
        return String.format("%s [ATK: %d]", super.getName(), super.getEffectPoints());
    }

}
