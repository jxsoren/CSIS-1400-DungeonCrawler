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

    public void start() {
        enterRoom(currentRoom);
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

    private void enterRoom(DungeonRoom room) {
        roomLoop(currentRoom);
    }

    public void roomLoop(DungeonRoom currentRoom) {
        while (this.currentRoom == currentRoom) {
            GameWindow.printRoom(getCurrentRoom());
            GameWindow.printPlayer(getPlayer());

            if (getCurrentRoom().isCompleted()) {
                System.out.println("\nThe room is currently completed. What would you like to do next?\n");

                System.out.println("1. Go to Next Room");
                System.out.println("2. Go to Previous Room");
                System.out.println("3. Loot Chest");
                System.out.println("4. Open Inventory");

                System.out.print("Your choice: ");
                int playerChoice = input.nextInt();

                switch (playerChoice) {
                    case 1 -> movePlayer("forwards");
                    case 2 -> movePlayer("backwards");
                    case 3 -> lootChest();
                    case 4 -> openInventory();
                }

            } else {
                System.out.println("\nFight the enemy within this room to loot the chest and progress to the next level!\n");
                System.out.println("1. Fight Enemy");
                System.out.println("2. Go to Previous Room");
                System.out.println("3. Open Inventory");

                System.out.print("Your choice: ");
                int playerChoice = input.nextInt();

                switch (playerChoice) {
                    case 1 -> attackLoop();
                    case 2 -> movePlayer("backwards");
                    case 3 -> openInventory();
                }
            }
        }

    }

    public void attackLoop() {
        Enemy enemy = currentEnemy();

        do {
            int enemyAttackValue = enemy.attack();
            int playerAttackValue = player.attack();

            System.out.println();

            player.takeDamage(enemy.attack());
            System.out.printf("%s attacked %s for %d damage!%n", player.getName(), enemy.getName(), playerAttackValue);

            enemy.takeDamage(player.attack());
            System.out.printf("%s attacked %s for %d damage!%n", enemy.getName(), player.getName(), enemyAttackValue);

            System.out.println();
        } while (!enemy.isDead() && !player.isDead());

        if (player.isDead()) {
            System.out.println(AsciiArt.goblin());
            System.err.println("YOU DIED");
            System.err.println("HA HA");
            System.exit(0);
        }

        System.out.printf("%s has been defeated!!!%n", enemy.getName());

        getCurrentRoom().completeRoom();
    }

    public void lootChest() {
        TreasureChest chest = currentTreasureChest();

        int weaponChoice = 0;
        int itemChoice = 0;

        int continueLooting = 1;

        do {
            chest.lootOptions();

            // Instructions
            System.out.println("\n" + "-".repeat(50));
            System.out.println("Commands:");
            System.out.println("  Enter number to take an item");
            System.out.println("  Enter -1 to exit chest");
            System.out.println("  Enter 0 to skip current choice");
            System.out.println("-".repeat(50));

            if (!chest.getWeapons().isEmpty()) {
                System.out.print("\nWeapon choice: ");
                weaponChoice = input.nextInt();

                if (weaponChoice == 0) {
                    continue;
                }

                if (weaponChoice == -1) {
                    break;
                }

                int weaponChoiceIndex = weaponChoice - 1;
                Weapon chosenWeapon = chest.takeWeapon(weaponChoiceIndex);

                playerInventory().addWeapon(chosenWeapon);
                System.out.printf("You added %s to your inventory!\n", chosenWeapon.getName());
            }

            if (!chest.getItems().isEmpty()) {
                System.out.print("\nItem choice: ");
                itemChoice = input.nextInt();

                if (itemChoice == 0) {
                    continue;
                }

                if (itemChoice == -1) {
                    break;
                }

                int itemChoiceIndex = itemChoice - 1;
                Consumable chosenItem = chest.takeItem(itemChoiceIndex);

                playerInventory().addItem(chosenItem);
                System.out.printf("You added %s to your inventory!\n", chosenItem.getName());
            }

            System.out.print("\nContinue Looting? (1 for Yes, 0 for No): ");
            continueLooting = input.nextInt();
        } while (continueLooting != 0);

    }


    public void openInventory() {
        Scanner input = new Scanner(System.in);
        int playerInput;

        do {
            playerInventory().printFormattedInventory();

            System.out.println();
            System.out.println("What would you like to do with your inventory?\n");

            System.out.println("0. Exit Inventory");
            System.out.println("1. Equip a Weapon");
            System.out.println("2. Consume an Item");

            System.out.println();

            System.out.print("Your choice: ");
            playerInput = input.nextInt();

            switch (playerInput) {
                case 1 -> equipWeaponPrompt();
                case 2 -> consumeItemPrompt();
                default -> {
                    continue;
                }
            }

        } while (playerInput != 0);

    }

    private void equipWeaponPrompt() {
        playerInventory().listWeapons();

        if (playerInventory().getWeapons().isEmpty()) {
            System.out.println("You don't have any weapons in your inventory!");
            return;
        }

        Scanner input = new Scanner(System.in);
        System.out.print("What weapon would you like to equip? ");

        int playerInput = input.nextInt();
        int weaponIndex = playerInput - 1;
        player.equipWeapon(weaponIndex);

        System.out.println("You've equipped a new weapon!");
    }

    private void consumeItemPrompt() {
        playerInventory().listItems();

        if (playerInventory().getItems().isEmpty()) {
            System.out.println("You don't have any items in your inventory!");
            return;
        }

        Scanner input = new Scanner(System.in);
        System.out.println("What item would you like to consume?");

        int playerInput = input.nextInt();
        int itemIndex = playerInput - 1;
        player.consumeItem(itemIndex);

        System.out.println("You've consumed an item!");
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

        if (!getCurrentRoom().isCompleted()) {
            throw new Exception("Cannot advanced to next room. Defeat enemy before you can move on.\n");
        }

        // Set attributes to point to next room
        this.currentRoomIndex++;
        setCurrentRoom(currentRoomIndex);

        // Enter the next room
        enterRoom(getCurrentRoom());
    }

    private void previousRoom(int currentRoomIndex) throws Exception {
        // If player tries to go back when they're in the first room
        if (currentRoomIndex == 0) {
            throw new Exception("Cannot move to the previous room. You're at the first room.\n");
        }

        // Set attributes to point to previous room
        this.currentRoomIndex--;
        setCurrentRoom(getCurrentRoomIndex());

        // Enter the previous room
        enterRoom(getCurrentRoom());
    }

}
