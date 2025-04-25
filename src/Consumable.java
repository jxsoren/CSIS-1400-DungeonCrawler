/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

import Enums.ConsumableType;

public class Consumable extends Item {
    private boolean consumed;

    public static Consumable createConsumable(ConsumableType type) {
        return switch (type) {
            case HEALING_POTION -> new Consumable("Healing Potion", "A healing potion", 50, 10);
            case BREAD -> new Consumable("Bread", "A piece of break", 15, 5);
            case APPLE -> new Consumable("Apple", "A single apple", 10, 2);
            default -> new Consumable();
        };
    }

    // Default Constructor
    public Consumable() {
        super("Default Potion", "A healing potion", 20, 10);
    }

    // Parameterized Constructor
    public Consumable(String name, String description, int effectPoint, int weight) {
        super(name, description, effectPoint, weight);
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
        return String.format("%s [Val: %d]", getName(), getEffectPoints());
    }

}
