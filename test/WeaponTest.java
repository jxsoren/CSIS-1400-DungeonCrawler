import java.util.Objects;

public class WeaponTest {

    public static void main(String[] args) {
        // Run tests
        checkForValidAttributes();
        testUse();
    }

    public static void checkForValidAttributes() {
        String name = "Sword";
        int effectPoints = 75;
        int weight = 25;

        Weapon weapon = new Weapon(name, effectPoints, weight);

        // Test attributes
        assert Objects.equals(weapon.getName(), name) : "weapon's name should be " + name;
        assert weapon.getWeight() == weight : "weapon's weight should be " + weight;
    }

    public static void testUse() {
        String name = "Sword";
        int effectPoints = 75;
        int weight = 25;

        int negativeEffectPoints = -effectPoints;

        Weapon weapon = new Weapon(name, effectPoints, weight);

        assert weapon.use() == effectPoints : "use should be " + negativeEffectPoints;
    }


}
