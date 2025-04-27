import Enums.ChestType;
import Enums.EnemyType;

/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

public class DungeonRoom {
    private final int index;
    private final String name;
    private final Enemy enemy;
    private final TreasureChest treasureChest;
    private boolean completed;

    public static DungeonRoom createDungeonRoom(int roomLevel) {
        return switch (roomLevel) {
            case 1 ->
                    new DungeonRoom(0, "Webbed Entrance", Enemy.createEnemy(EnemyType.SPIDER), TreasureChest.createChest(ChestType.WOODEN_CHEST));
            case 2 ->
                    new DungeonRoom(1, "Goblin's Hideout", Enemy.createEnemy(EnemyType.GOBLIN), TreasureChest.createChest(ChestType.SILVER_CHEST));
            case 3 ->
                    new DungeonRoom(2, "Ancient Burial Chamber", Enemy.createEnemy(EnemyType.SKELETON), TreasureChest.createChest(ChestType.GOLDEN_CHEST));
            case 4 ->
                    new DungeonRoom(3, "Dragon's Lair", Enemy.createEnemy(EnemyType.DRAGON), TreasureChest.createChest(ChestType.GOLDEN_CHEST));
            default -> new DungeonRoom();
        };
    }

    // Default Constructor
    public DungeonRoom() {
        this.index = 0;
        this.name = "Default Room Name";
        this.enemy = Enemy.createEnemy(EnemyType.SPIDER);
        this.treasureChest = TreasureChest.createChest(ChestType.WOODEN_CHEST);
    }

    // Getters

    public boolean isCompleted() {
        return completed;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public TreasureChest getChest() {
        return treasureChest;
    }

    // Setters

    public void completeRoom() {
        // Only complete room if enemy is dead
        if (getEnemy().isDead()) {
            completed = true;
        }
    }

    public String[] attributesArr() {
        return new String[]{roomCompletedString()};
    }

    public String roomLevelString() {
        return String.format("(%d / %d)", getIndex() + 1, 4);
    }

    public String roomCompletedString() {
        if (completed) {
            return "LEVEL COMPLETED!!!";
        } else {
            return "LEVEL NOT COMPLETED";
        }
    }

    @Override
    public String toString() {
        String roomName = String.format("Room Name: %s", getName());
        String roomEnemy = String.format("%s", getEnemy());
        String roomChest = String.format("%s", getChest());

        return String.format("%s%n%s%n%s%n", roomName, roomEnemy, roomChest);
    }

    // Hide parameterized constructor to force curated enemies
    private DungeonRoom(int index, String name, Enemy enemy, TreasureChest treasureChest) {
        this.index = index;
        this.name = name;
        this.enemy = enemy;
        this.treasureChest = treasureChest;
    }

}
