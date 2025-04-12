import java.util.Objects;

public class WeaponTest {

    public static void main(String[] args) {

    }

    public void checkForValidAttributes() {
        String name = "Sword";
        int effectPoints = 75;
        int weight = 25;

        Item item = new Item(name, effectPoints, weight);

        assert Objects.equals(item.getName(), name) : "Item's name should be " + name;
        assert item.getEffectPoints() == effectPoints : "Item's effect points should be " + effectPoints;
        assert item.getWeight() == weight : "Item's weight should be " + weight;
    }
}
