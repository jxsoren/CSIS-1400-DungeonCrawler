public class Weapon extends Item {

    public Weapon(String name, String description, int effectPoints, int weight) {
        // Use constructor for parent class Item
        super(name, description, effectPoints, weight);
    }

    public Weapon(String name, int effectPoints, int weight) {
        // Use constructor for parent class Item
        super(name, effectPoints, weight);
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
