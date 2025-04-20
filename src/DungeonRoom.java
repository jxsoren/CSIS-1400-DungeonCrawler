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

    public DungeonRoom(int index, String name, Enemy enemy, TreasureChest treasureChest) {
        this.index = index;
        this.name = name;
        this.enemy = enemy;
        this.treasureChest = treasureChest;
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

    @Override
    public String toString() {
        String roomName = String.format("Room Name: %s", getName());
        String roomEnemy = String.format("%s", getEnemy());
        String roomChest = String.format("%s", getChest());

        return String.format("%s%n%s%n%s%n", roomName, roomEnemy, roomChest);
    }

}
