/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

public class Enemy {
    private final String name;
    private final int maxHealth;
    private final Weapon weapon;
    private int currentHealth;
    private boolean isAlive;

    public Enemy(String name, int maxHealth, Weapon weapon) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.weapon = weapon;

        currentHealth = maxHealth; // Initialize current health to the max health (full health)
        isAlive = true;
    }

    public Enemy(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.weapon = new Weapon("Wooden Club", "A weak wooden club", 25, 10);

        currentHealth = maxHealth; // Initialize current health to the max health (full health)
        isAlive = true;
    }

    public void takeDamage(int incomingDamageAmount) {
        currentHealth -= incomingDamageAmount;

        // Check if damage caused puts currentHealth less than 0
        if (currentHealth <= 0) {
            killEnemy();
        }
    }

    public int attack() {
        return weapon.use();
    }

    // Getters

    public String getName() {
        return name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public String toString() {
        String enemyName = String.format("Name: %s ", name);
        String enemyHealth = String.format("HP: %d / %d", currentHealth, maxHealth);
        String enemyWeapon = String.format("Weapon: %s", weapon.toString());

        return String.format("%s%n%s%n%s", enemyName, enemyWeapon, enemyHealth);
    }

    // Helper methods

    private void killEnemy() {
        currentHealth = 0;
        isAlive = false;
    }
}
