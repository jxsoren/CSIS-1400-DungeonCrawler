public class EnemyTest {
    public static void main(String[] args) {

        try {
            takeDamage();
            System.out.println("takeDamage() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.printf("takeDamage() test -FAILED-. Error Message: %s", e.getMessage());
        }

        try {
            attack();
            System.out.println("attack() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.printf("attack() test -FAILED-. Error Message: %s", e.getMessage());
        }

        try {
            testToString();
            System.out.println("testToString() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.printf("testToString() test -FAILED-. Error Message: %s", e.getMessage());
        }

    }

    public static void takeDamage() {
        Weapon weapon = new Weapon();
        Enemy enemy = new Enemy("Goblin 1", 50, weapon);

        System.out.println("Before enemy takes damage:");
        System.out.println(enemy.toString());
        System.out.println();

        // Enemy takes damage
        enemy.takeDamage(50);

        System.out.println("After enemy takes damage:");
        System.out.println(enemy.toString());
        System.out.println();

        // Enemy health should be 0
        assert enemy.getCurrentHealth() == 0 : TestHelpers.assertionMessage("Enemy's current health", 0, enemy.getCurrentHealth());

        // Enemy should be dead
        assert !enemy.isDead() : TestHelpers.assertionMessage("Enemy's alive status", false, true);

        System.out.println();
        System.out.println(enemy.toString());
        System.out.println();
    }

    public static void attack() {
        int weaponEffectPoints = 25;
        Weapon weapon = new Weapon();
        Enemy enemy = new Enemy("Goblin 1", 50, weapon);

        // Enemy attack value should return weapon's damage number
        assert enemy.attack() == weaponEffectPoints : TestHelpers.assertionMessage("Enemy that attacks", weaponEffectPoints, enemy.attack());
    }

    public static void testToString() {
        Weapon weapon = new Weapon();
        Enemy enemy = new Enemy("Goblin 1", 50, weapon);

        System.out.println();
        System.out.println(enemy.toString());
        System.out.println();
    }

}
