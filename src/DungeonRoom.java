/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

public class DungeonRoom {
    private int index;
    private final String name;
    private Enemy enemy;
    private TreasureChest chest;
    private boolean hasEnemy;
    private boolean hasChest;
    private boolean completed;

    public DungeonRoom(String name) {
        this.name = name;
    }

    // Getters

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    public Enemy getEnemy() {
        return this.enemy;
    }

    public TreasureChest getChest() {
        return this.chest;
    }

    // Setters

    public void setIndex(int index) {
        this.index = index;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void setChest(TreasureChest chest) {
        this.chest = chest;
    }

}
