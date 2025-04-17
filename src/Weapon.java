public class Weapon extends Item {

    public Weapon(String name, int effectPoints, int weight) {
        // Use constructor for parent class Item
        super(name, effectPoints, weight);
    }

    @Override
    public int use() {
        // Negative number to be used to subtract against health
        return -this.getEffectPoints();
    }

}
