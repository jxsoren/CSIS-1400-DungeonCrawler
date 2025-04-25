import Enums.EnemyType;
import Enums.WeaponType;

public class Enemy {
    private final String name;
    private final int maxHealth;
    private final Weapon weapon;
    private int currentHealth;
    private boolean isDead;
    private final EnemyType type;

    public static Enemy createEnemy(EnemyType type) {
        return switch (type) {
            case SPIDER -> new Enemy("Spider", 75, Weapon.createWeapon(WeaponType.SPIDER_FANG), type);
            case GOBLIN -> new Enemy("Goblin", 100, Weapon.createWeapon(WeaponType.RUSTY_DAGGER), type);
            case SKELETON -> new Enemy("Skeleton", 150, Weapon.createWeapon(WeaponType.ANCIENT_SWORD), type);
            case DRAGON -> new Enemy("Dragon", 300, Weapon.createWeapon(WeaponType.FIRE_BREATH), type);
        };
    }

    public void takeDamage(int incomingDamageAmount) {
        currentHealth -= incomingDamageAmount;

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
        return new String[]{getName(), String.format("HP: %d / %d", currentHealth, maxHealth), weapon.toString()};
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

    // Hide parameterized constructor to force curated enemies
    private Enemy(String name, int maxHealth, Weapon weapon, EnemyType type) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.weapon = weapon;
        this.type = type;
        currentHealth = maxHealth;
    }

}
