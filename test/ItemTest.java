import java.util.Objects;

public class ItemTest {
    public static void main(String[] args) {
        // Run tests
        checkForValidAttributes();
    }

    public static void checkForValidAttributes() {
        String name = "Potion";
        int effectPoints = 50;
        int weight = 10;

        Item item = new Item(name, effectPoints, weight);

        assert Objects.equals(item.getName(), name) : "Item's name should be " + name;
        assert item.getWeight() == weight : "Item's weight should be " + weight;
    }

    public static void testUse() {
        String name = "Potion";
        int effectPoints = 50;
        int weight = 10;

        Item item = new Item(name, effectPoints, weight);

        assert item.use() == effectPoints : "use should be " + effectPoints;
    }
}
