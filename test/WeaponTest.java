import java.util.Objects;

public class WeaponTest {

    public static void main(String[] args) {

        try {
            testUse();
            System.out.println("testUse() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.printf("testUse() test -FAILED-. Error Message: %s", e.getMessage());
        }

        testToString();
    }

    public static void testUse() {
        String name = "Sword";
        String description = "A cool sword!";
        int effectPoints = 75;
        int weight = 25;

        int negativeEffectPoints = -effectPoints;

        Weapon weapon = new Weapon(name, description, effectPoints, weight);

        assert weapon.use() == effectPoints : "use should be " + negativeEffectPoints;
    }

    public static void testToString() {
        String name = "Sword";
        String description = "A cool sword!";
        int effectPoints = 75;
        int weight = 25;

        int negativeEffectPoints = -effectPoints;

        Weapon weapon = new Weapon(name, description, effectPoints, weight);

        System.out.println();
        System.out.println(weapon.toString());
        System.out.println();
    }


}
