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

    // Getters

    public int getCurrentHealth() {
        return this.currentHealth;
    }

}
