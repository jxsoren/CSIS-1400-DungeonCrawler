public class EnemyTest {
    public static void main(String[] args) {

        try {
            takeDamage();
            System.out.println("takeDamage() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.printf("takeDamage() test -FAILED-. Error Message: %s", e.getMessage());
        }

    }

    public static void takeDamage() {
        Enemy enemy = new Enemy("Goblin 1", 50);

        // Enemy takes damage
        enemy.takeDamage(50);

        // Enemy health should be 0
        assert enemy.getCurrentHealth() == 0 : TestHelpers.assertionMessage("Enemy's current health", 0, enemy.getCurrentHealth());

        // Enemy should be dead
        assert !enemy.isAlive() : "";
    }

}
