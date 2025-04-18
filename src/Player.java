import com.sun.security.jgss.InquireType;

public class Player {
    private final String name;
    private final Weapon weapon;
    private final Inventory inventory;

    private final int maxHealth;
    private int currentHealth;

    private boolean isAlive;

    public Player(String name) {
        this.name = name;
        this.weapon = new Weapon();
        this.inventory = new Inventory();

        this.maxHealth = 200;
        this.currentHealth = 200;
    }

    public void takeDamage(int incomingDamage) {
        currentHealth -= incomingDamage;
    }

    // Getters

    public int getCurrentHealth() {
        return currentHealth;
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        String playerName = String.format("Name: %s ", name);
        String playerHealth = String.format("HP: %d / %d", currentHealth, maxHealth);
        String playerWeapon = String.format("Weapon: %s", weapon.toString());
        String playerInventory = String.format("Inventory: %s", inventory.toString());

        return String.format("%s%n%s%n%s%n%s", playerName, playerWeapon, playerHealth, playerInventory);
    }

}
