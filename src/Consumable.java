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
            case BREAD -> new Consumable("Bread", "A freshly baked loaf of bread", 15, 5);
            case APPLE -> new Consumable("Apple", "A crisp, juicy apple", 10, 2);
            case BANDAGES -> new Consumable("Bandages", "Clean cloth bandages for treating wounds", 20, 4);
            case HEALING_POTION -> new Consumable("Healing Potion", "A magical red liquid that heals wounds", 50, 10);
            case HEALTH_ELIXIR -> new Consumable("Health Elixir", "Fully restores HP", 999, 25);
        };
    }

    // Default Constructor
    public Consumable() {
        createConsumable(ConsumableType.BREAD);
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

    // Getters

    public boolean isConsumed() {
        return consumed;
    }

    @Override
    public String toString() {
        return String.format("%s [Val: %d]", getName(), getEffectPoints());
    }

    // Hide parameterized constructor to force curated consumables
    private Consumable(String name, String description, int effectPoint, int weight) {
        super(name, description, effectPoint, weight);
        this.consumed = false;
    }

}
