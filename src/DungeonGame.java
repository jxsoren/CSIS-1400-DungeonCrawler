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
        
        int weaponChoice = 0;
        int itemChoice = 0;

        int continueLooting = 1;

        do {
            chest.lootOptions();

            String promptInstructions = "(-1 to skip. -2 to exit)";

            if (!chest.getWeapons().isEmpty()) {
                System.out.println("\n" + promptInstructions);
                System.out.print("What weapon option would you like to grab from the chest? ");
                weaponChoice = input.nextInt();

                if (weaponChoice == -1) {
                    continue;
                }

                if (weaponChoice == -2) {
                    break;
                }

                int weaponChoiceIndex = weaponChoice - 1;
                Weapon chosenWeapon = chest.takeWeapon(weaponChoiceIndex);

                playerInventory().addWeapon(chosenWeapon);
            }

            if (!chest.getItems().isEmpty()) {
                System.out.println("\n" + promptInstructions);
                System.out.print("What item options would you like to grab from the chest? ");
                itemChoice = input.nextInt();

                if (itemChoice == -1) {
                    continue;
                }

                if (itemChoice == -2) {
                    break;
                }

                int itemChoiceIndex = itemChoice - 1;
                Item chosenItem = chest.takeItem(itemChoiceIndex);

                playerInventory().addItem(chosenItem);
            }

            System.out.print("Continue Looting? 1 for Yes - 0 for No: ");
            continueLooting = input.nextInt();
        } while (continueLooting != 0);

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

    private Inventory playerInventory() {
        return getPlayer().getInventory();
    }

    private TreasureChest currentTreasureChest() {
        return dungeonRooms.get(currentRoomIndex).getChest();
    }

    private void nextRoom(int currentRoomIndex) throws Exception {
        int finalRoomIndex = dungeonRooms.size() - 1;
        if (currentRoomIndex == finalRoomIndex) {
            throw new Exception("Cannot advance to next Room. You're already at the final room.\n");
        }

        if (!currentRoom.isCompleted()) {
            throw new Exception("Cannot advanced to next room. Defeat enemy before you can move on.\n");
        }

        this.currentRoomIndex++;
        setCurrentRoom(currentRoomIndex);
    }

    private void previousRoom(int currentRoomIndex) throws Exception {
        // If player tries to go back when they're in the first room
        if (currentRoomIndex == 0) {
            throw new Exception("Cannot move to the previous room. You're at the first room.\n");
        }

        this.currentRoomIndex--;
        setCurrentRoom(currentRoomIndex);
    }

}
