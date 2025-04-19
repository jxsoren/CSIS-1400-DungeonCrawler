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

        testConstantWeapons();
    }

    public static void testUse() {
        Weapon weapon = new Weapon();
        int attackValue = weapon.getEffectPoints();

        assert weapon.use() == 25 : "use should be " + attackValue;
    }

    public static void testToString() {
        Weapon weapon = new Weapon();

        System.out.println();
        System.out.println(weapon.toString());
        System.out.println();
    }

    public static void testConstantWeapons() {
        WeaponType excalibur = WeaponType.EXCALIBUR;

        Weapon weapon = Weapon.createWeapon(excalibur);

        System.out.println();
        System.out.println(weapon.toString());
        System.out.println();
    }


}
