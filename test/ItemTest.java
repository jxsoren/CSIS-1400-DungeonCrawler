import java.util.Objects;

public class ItemTest {
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

    }

    public static void checkForValidAttributes() {
        String name = "Potion";
        String description = "A really cool potion!";
        int effectPoints = 50;
        int weight = 10;

        Item item = new Item(name, description, effectPoints, weight);

        assert Objects.equals(item.getName(), name) : TestHelpers.assertionMessage("Item name", name, item.getName());
        assert Objects.equals(item.getName(), name) : TestHelpers.assertionMessage("Item description", name, item.getDescription());
        assert item.getWeight() == weight : TestHelpers.assertionMessage("Item weight", weight, item.getWeight());
    }

    public static void testUse() {
        Item item = defaultPotion();

        // Use item and Ensure the item returns the expected effect points
        assert item.use() == 50 : TestHelpers.assertionMessage("Item", 50, 50);

        // Ensure that the item was marked as being consumed
        assert item.isConsumed() : TestHelpers.assertionMessage("Item", "marked as consumed", "not marked as consumed");
    }

    public static void testMultipleUses() {
        Item item = defaultPotion();

        // Use once
        item.use();

        // Use additional times and ensure that you can't infinitely reuse an item
        assert item.use() == 0 : TestHelpers.assertionMessage("Item", "marked as consumed", "not marked as consumed");
        assert item.use() == 0 : TestHelpers.assertionMessage("Item", "marked as consumed", "not marked as consumed");
        assert item.use() == 0 : TestHelpers.assertionMessage("Item", "marked as consumed", "not marked as consumed");
    }

    // Test Variables

    public static Item defaultPotion() {
        String name = "Potion";
        String description = "A really cool potion!";
        int effectPoints = 50;
        int weight = 10;

        return new Item(name, description, effectPoints, weight);
    }

}
