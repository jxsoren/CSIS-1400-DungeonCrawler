public class PlayerTest {

    public static void main(String[] args) {

        try {
            takeDamage();
            System.out.println("takeDamage() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.println("takeDamage() test -FAILED- | " + e.getMessage());
        }

        try {
            inventoryTest();
            System.out.println("inventoryTest() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.println("inventoryTest() test -FAILED- | " + e.getMessage());
        }

    }

    public static void takeDamage() {
        Player player = new Player("player");
        int incomingDamage = 20;

        player.takeDamage(incomingDamage);
        int playerHealth = player.getCurrentHealth();

        assert playerHealth == 180 : TestHelpers.assertionMessage("Player's health after taking damage", 180, playerHealth);
    }

    public static void inventoryTest() {
        Player player = new Player("player");
        Weapon weapon = new Weapon();
        Inventory playerInventory = player.getInventory();

        playerInventory.addWeapon(weapon);

        System.out.println();
        System.out.println(player.toString());
    }

}
