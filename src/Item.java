/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

public class Item {
    private final String name;
    private int weight;
    private final int effectPoints;
    private String description = "Default description";
    private boolean consumed;

    public Item(String name, String description, int effectPoints, int weight) {
        this.name = name;
        this.effectPoints = effectPoints;
        this.description = description;
        setWeight(weight);
    }

    public Item(String name, int effectPoints, int weight) {
        this.name = name;
        this.effectPoints = effectPoints;
        setWeight(weight);
    }

    public int use() {
        // Don't return any effect if it's already been consumed
        if (isConsumed()) {
            return 0;
        }

        this.consumed = true;
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

    public String getDescription() {
        return description;
    }

    public boolean isConsumed() {
        return consumed;
    }

    // Setters

    private void setWeight(int weight) {
        int minWeight = 1;
        int maxWeight = 100;

        // Ensure item's weight is between 1-100
        if (weight <= maxWeight && weight >= minWeight) {
            this.weight = weight;
        } else {
            this.weight = minWeight;
        }
    }

    @Override
    public String toString() {
        return String.format("%s [Effect: %d]", getName(), getEffectPoints());
    }

}
