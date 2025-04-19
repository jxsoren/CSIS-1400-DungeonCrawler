import java.util.Objects;

public class ConsumableTest {
    public static void main(String[] args) {

        try {
            checkForValidAttributes();
            System.out.println("checkForValidAttributes() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.println("checkForValidAttributes() test -FAILED- | " + e.getMessage());
        }

        try {
            testUse();
            System.out.println("testUse() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.println("testUse() test -FAILED- | " + e.getMessage());
        }

        try {
            testMultipleUses();
            System.out.println("testMultipleUses() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.println("testMultipleUses() test -FAILED- | " + e.getMessage());
        }

        try {
            testConsumables();
            System.out.println("testConsumables() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.println("testConsumables() test -FAILED- | " + e.getMessage());
        }

    }

    public static void checkForValidAttributes() {
        String name = "Potion";
        String description = "A really cool potion!";
        int effectPoints = 50;
        int weight = 10;

        Consumable consumable = new Consumable(name, description, effectPoints, weight);

        assert Objects.equals(consumable.getName(), name) : TestHelpers.assertionMessage("Consumable name", name, consumable.getName());
        assert Objects.equals(consumable.getName(), name) : TestHelpers.assertionMessage("Consumable description", name, consumable.getDescription());
        assert consumable.getWeight() == weight : TestHelpers.assertionMessage("Consumable weight", weight, consumable.getWeight());
    }

    public static void testUse() {
        Consumable consumable = defaultPotion();

        // Use consumable and Ensure the consumable returns the expected effect points
        assert consumable.use() == 50 : TestHelpers.assertionMessage("Consumable", 50, 50);

        // Ensure that the consumable was marked as being consumed
        assert consumable.isConsumed() : TestHelpers.assertionMessage("Consumable", "marked as consumed", "not marked as consumed");
    }

    public static void testMultipleUses() {
        Consumable consumable = defaultPotion();

        // Use once
        consumable.use();

        // Use additional times and ensure that you can't infinitely reuse a consumable
        assert consumable.use() == 0 : TestHelpers.assertionMessage("Consumable", "marked as consumed", "not marked as consumed");
        assert consumable.use() == 0 : TestHelpers.assertionMessage("Consumable", "marked as consumed", "not marked as consumed");
        assert consumable.use() == 0 : TestHelpers.assertionMessage("Consumable", "marked as consumed", "not marked as consumed");
    }

    public static void testConsumables() {
        System.out.println(healingPotion().toString());
        System.out.println(bread().toString());
        System.out.println(apple().toString());
    }

    // Test Variables

    public static Consumable defaultPotion() {
        String name = "Potion";
        String description = "A really cool potion!";
        int effectPoints = 50;
        int weight = 10;

        return new Consumable(name, description, effectPoints, weight);
    }

    public static Consumable healingPotion() {
        ConsumableType type = ConsumableType.HEALING_POTION;
        return Consumable.createConsumable(type);
    }

    public static Consumable bread() {
        ConsumableType type = ConsumableType.BREAD;
        return Consumable.createConsumable(type);
    }

    public static Consumable apple() {
        ConsumableType type = ConsumableType.APPLE;
        return Consumable.createConsumable(type);
    }

}
