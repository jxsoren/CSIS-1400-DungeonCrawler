public class Item {
    private final String name;
    private int weight;
    private final int effectPoints;

    public Item(String name, int effectPoints, int weight) {
        this.name = name;
        this.effectPoints = effectPoints;
        setWeight(weight);
    }

    public int use() {
        return effectPoints;
    }

    // Getters

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getEffectPoints() {
        return effectPoints;
    }

    // Setters

    private void setWeight(int weight) {
        int minWeight = 1;
        int maxWeight = 100;

        // Ensure item's weight is between 1-100
        if (weight <= maxWeight && weight >= minWeight) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }
    }

}
