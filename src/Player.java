import java.util.Random;

/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

public class Player {
    private final String name;
    private final Inventory inventory;
    private Weapon weapon;

    private final int maxHealth;
    private int currentHealth;

    private boolean isDead;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
        equipWeapon(0);

        this.maxHealth = 200;
        this.currentHealth = 200;
    }

    public void takeDamage(int incomingDamage) {
        currentHealth -= incomingDamage;

        // Check if damage caused puts currentHealth less than 0
        if (currentHealth <= 0) {
            killPlayer();
        }
    }

    public int attack() {
        return (int) (weapon.use() * randomDamageMultiplier());
    }

    public void equipWeapon(int weaponIndex) {
        this.weapon = inventory.getWeapon(weaponIndex);
    }

    public void consumeItem(int itemIndex) {
        Consumable chosenItem = inventory.getItem(itemIndex);
        currentHealth += chosenItem.use();
        inventory.dropItem(itemIndex);
    }

    // Getters

    public int getCurrentHealth() {
        return currentHealth;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public boolean isDead() {
        return isDead;
    }

    public String getName() {
        return this.name;
    }

    public String[] attributesArr() {
        return new String[]{getName(), String.format("HP: %d / %d", currentHealth, maxHealth), weapon.toString()};
    }

    @Override
    public String toString() {
        String playerName = String.format("Name: %s ", name);
        String playerHealth = String.format("HP: %d / %d", currentHealth, maxHealth);
        String playerWeapon = String.format("Equipped Weapon: %s", weapon.toString());
        String playerInventory = String.format("Inventory: %s", inventory.toString());

        return String.format("%s%n%s%n%s%n%s", playerName, playerWeapon, playerHealth, playerInventory);
    }

    private void killPlayer() {
        currentHealth = 0;
        isDead = true;
    }

    private double randomDamageMultiplier() {
        Random random = new Random();
        return random.nextDouble(1, 1.4);
    }
}
