import java.util.Objects;

public class ItemTest {
    public static void main(String[] args) {

    }

    public void checkForValidAttributes() {
        String name = "Potion";
        int effectPoints = 50;
        int weight = 10;

        Item item = new Item(name, effectPoints, weight);

        assert Objects.equals(item.getName(), name) : "Item's name should be " + name;
        assert item.getEffectPoints() == effectPoints : "Item's effect points should be " + effectPoints;
        assert item.getWeight() == weight : "Item's weight should be " + weight;
    }
}
