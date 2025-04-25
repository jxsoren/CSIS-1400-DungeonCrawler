import Enums.EnemyType;

public class Enemy {
    private final String name;
    private final int maxHealth;
    private final Weapon weapon;
    private int currentHealth;
    private boolean isDead;
    private final EnemyType type;

    public static Enemy createEnemy(EnemyType type) {
        return switch (type) {
            case SPIDER -> new Enemy();
            case GOBLIN -> new Enemy();
            case SKELETON -> new Enemy();
            case DRAGON -> new Enemy();
        };
    }

    public Enemy() {
        this.name = "Default Enemy";
        this.maxHealth = 200;
        this.weapon = new Weapon();
        this.type = EnemyType.GOBLIN;

        currentHealth = maxHealth; // Initialize current health to the max health (full health)
    }

    public Enemy(String name, int maxHealth, Weapon weapon) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.weapon = weapon;
        this.type = EnemyType.GOBLIN;

        currentHealth = maxHealth; // Initialize current health to the max health (full health)
    }

    public Enemy(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.weapon = new Weapon();
        this.type = EnemyType.GOBLIN;

        currentHealth = maxHealth; // Initialize current health to the max health (full health)
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

    public boolean isDead() {
        return isDead;
    }

    public String[] attributesArr() {
        return new String[]{
                getName(),
                String.format("HP: %d / %d", currentHealth, maxHealth),
                weapon.toString()
        };
    }

    public String asciiArt() {
        return AsciiArt.asciiArtFactory(this.type.toString());
    }

    @Override
    public String toString() {
        String enemyName = String.format("Enemy Name: %s ", name);
        String enemyHealth = String.format("HP: %d / %d", currentHealth, maxHealth);
        String enemyWeapon = String.format("Weapon: %s", weapon.toString());

        return String.format("%s%n%s%n%s", enemyName, enemyWeapon, enemyHealth);
    }

    // Helper methods

    private void killEnemy() {
        currentHealth = 0;
        isDead = true;
    }
}
