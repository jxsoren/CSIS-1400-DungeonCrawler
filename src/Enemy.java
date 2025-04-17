public class Enemy {
    private String name;
    private int maxHealth;
    private int currentHealth;
    private boolean isAlive;

    public Enemy(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth; // Initialize current health to the max health (full health)
        this.isAlive = true;
    }

    public void takeDamage(int incomingDamageAmount) {
        this.currentHealth -= incomingDamageAmount;

        // Check if damage caused puts currentHealth less than 0
        if (currentHealth <= 0) {
            killEnemy();
        }
    }

    // Getters

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    // Helper methods

    private void killEnemy() {
        this.currentHealth = 0;
        this.isAlive = false;
    }
}
