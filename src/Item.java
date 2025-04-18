/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

public class Item {
    private final String name;
    private final int weight;
    private final int effectPoints;
    private final String description;

    // Default Constructor
    public Item() {
        this.name = "Default Name";
        this.effectPoints = 0;
        this.description = "Default Description";
        this.weight = 0;
    }

    public Item(String name, int effectPoints, int weight, String description) {
        this.name = name;
        this.effectPoints = effectPoints;
        this.description = description;
        this.weight = weight;
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

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("%s [Effect: %d]", getName(), getEffectPoints());
    }

}
