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
        createWoodenSword();
    }

    public Weapon(WeaponType type) {
        switch (type) {
            case WOODEN_SWORD -> createWoodenSword();
            case STEEL_SWORD -> createSteelSword();
            case IRON_AXE -> createIronAxe();
            case EXCALIBUR -> createExcalibur();
        }
    }

    public Weapon(String name, String description, int effectPoints, int weight) {
        // Use constructor for parent class Item
        super(name, description, effectPoints, weight);
    }

    private static void createWoodenSword() {
        new Weapon("Wooden Sword", "A small wooden sword", 25, 10);
    }

    private static void createSteelSword() {
        new Weapon("Steel Sword", "A sturdy steel sword", 40, 20);
    }

    private static void createIronAxe() {
        new Weapon("Iron Axe", "A strong iron axe", 60, 30);
    }

    private static void createExcalibur() {
        new Weapon("Excalibur", "It's excalibur...", 100, 50);
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
