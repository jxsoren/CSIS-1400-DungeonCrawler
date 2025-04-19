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
        System.out.println(weapon1().toString());
        System.out.println(weapon2().toString());
        System.out.println(weapon3().toString());
        System.out.println(weapon4().toString());
    }

    private static Weapon weapon1() {
        WeaponType weapon = WeaponType.WOODEN_SWORD;
        return Weapon.createWeapon(weapon);
    }

    private static Weapon weapon2() {
        WeaponType weapon = WeaponType.STEEL_SWORD;
        return Weapon.createWeapon(weapon);
    }

    private static Weapon weapon3() {
        WeaponType weapon = WeaponType.IRON_AXE;
        return Weapon.createWeapon(weapon);
    }

    private static Weapon weapon4() {
        WeaponType weapon = WeaponType.EXCALIBUR;
        return Weapon.createWeapon(weapon);
    }

}
