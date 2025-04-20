/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

import java.util.ArrayList;
import java.util.Scanner;

public class DungeonGame {
    private final Player player;
    private ArrayList<DungeonRoom> dungeonRooms;
    private DungeonRoom currentRoom;
    private int currentRoomIndex;
    private final Scanner input = new Scanner(System.in);

    public DungeonGame(Player player) {
        this.player = player;
        initRooms();
        currentRoomIndex = 0;
        setCurrentRoom(currentRoomIndex);
    }

    public void movePlayer(String requestedDirection) {
        try {
            switch (requestedDirection) {
                case "forwards" -> nextRoom(currentRoomIndex);
                case "backwards" -> previousRoom(currentRoomIndex);
                default -> throw new Exception("Cannot move that direction");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void startAttackPhase() {
        Enemy enemy = currentEnemy();

        while (!enemy.isDead() && !player.isDead()) {
            player.takeDamage(enemy.attack());
            enemy.takeDamage(player.attack());
        }

        currentRoom.completeRoom();
    }

    public void lootChest() {
        TreasureChest chest = currentTreasureChest();

        // Todo: Add loop to keep looping to
        //  allow the player to select all possible items
        chest.lootOptions();

        System.out.println("What weapon option would you like to grab from the chest? ");
        int weaponChoice = input.nextInt();
        chest.takeWeapon(weaponChoice);

        System.out.println("What item options would you like to grab from the chest?");
        int itemChoice = input.nextInt();
        chest.takeItem(itemChoice);

    }

    // Getters

    public Player getPlayer() {
        return player;
    }

    public ArrayList<DungeonRoom> getDungeonRooms() {
        return dungeonRooms;
    }

    public int getCurrentRoomIndex() {
        return currentRoomIndex;
    }

    public DungeonRoom getCurrentRoom() {
        return dungeonRooms.get(currentRoomIndex);
    }

    // Setters

    private void initRooms() {
        dungeonRooms = GameInitializer.dungeonRooms(10);
    }

    private void setCurrentRoom(int currentRoomIndex) {
        currentRoom = dungeonRooms.get(currentRoomIndex);
    }

    // Helper Methods

    private Enemy currentEnemy() {
        return dungeonRooms.get(currentRoomIndex).getEnemy();
    }

    private TreasureChest currentTreasureChest() {
        return dungeonRooms.get(currentRoomIndex).getChest();
    }

    private void nextRoom(int currentRoomIndex) throws Exception {
        int finalRoomIndex = dungeonRooms.size() - 1;
        if (currentRoomIndex == finalRoomIndex) {
            throw new Exception("Cannot advance to next Room. You're already at the final room.");
        }

        if (!currentRoom.isCompleted()) {
            throw new Exception("Cannot advanced to next room. Defeat enemy before you can move on.");
        }

        this.currentRoomIndex++;
        setCurrentRoom(currentRoomIndex);
    }

    private void previousRoom(int currentRoomIndex) throws Exception {
        // If player tries to go back when they're in the first room
        if (currentRoomIndex == 0) {
            throw new Exception("Cannot move to the previous room. You're at the first room.");
        }

        this.currentRoomIndex--;
        setCurrentRoom(currentRoomIndex);
    }

}
