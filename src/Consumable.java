/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

public class Consumable extends Item {
    private boolean consumed;

    // Default Constructor
    public Consumable() {
        super();
    }

    // Parameterized Constructor
    public Consumable(String name, int effectPoints, int weight, String description) {
        super(name, effectPoints, weight, description);
    }

    @Override
    public int use() {
        // Don't return any effect if it's already been consumed
        if (isConsumed()) {
            return 0;
        }

        this.consumed = true;
        return this.getEffectPoints();
    }

    // Setters


    // Getters

    public boolean isConsumed() {
        return consumed;
    }

    @Override
    public String toString() {
        return String.format("%s [Amount: %d]", getName(), getEffectPoints());
    }

}
