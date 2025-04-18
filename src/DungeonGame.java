/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

import java.util.ArrayList;

public class DungeonGame {
    private Player player;
    private ArrayList<DungeonRoom> dungeonRooms;
    private int currentRoomIndex = 0;

    public DungeonGame(Player player) {
        this.player = player;
        initRooms();
    }

    public void movePlayer(int requestedDirection) {
        try {
            switch (requestedDirection) {
                case 0 -> previousRoom(currentRoomIndex);
                case 1 -> nextRoom(currentRoomIndex);
                default -> throw new Exception("Cannot move that direction");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
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

    // Setters

    private void initRooms() {
        dungeonRooms = GameInitializer.dungeonRooms(10);
    }

    public void setCurrentRoomIndex(int currentRoomIndex) {
        this.currentRoomIndex = currentRoomIndex;
    }

    // Helper Methods

    private void nextRoom(int currentRoomIndex) throws Exception {
        // If player is at last level and tries to go forward
        int finalRoomIndex = dungeonRooms.size() - 1;
        if (currentRoomIndex == finalRoomIndex) {
            throw new Exception("Cannot move to the next room");
        }

        this.currentRoomIndex++;
    }

    private void previousRoom(int currentRoomIndex) throws Exception {
        // If player tries to go back when they're in the first room
        if (currentRoomIndex == 0) {
            throw new Exception("Cannot move to the previous room");
        }

        this.currentRoomIndex--;
    }

}
