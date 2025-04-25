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

    private void movePlayer(String requestedDirection) {
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
        System.out.println("You've entered a new room!");
        roomLoop(room);
    }

    public void roomLoop(DungeonRoom currentRoom) {
        while (this.currentRoom == currentRoom) {
            GameWindow.printWindow(getCurrentRoom(), getPlayer());

            if (getCurrentRoom().isCompleted()) {
                String[] options = {"1. Go to Next Room ⇨", "2. Go to Previous Room ⇦", "3. Loot Chest 💰", "4. Open Inventory 🎒"};

                System.out.println(GameWindow.optionsBox(options));
                int playerChoice = GameWindow.printDialogBox();

                switch (playerChoice) {
                    case 1 -> movePlayer("forwards");
                    case 2 -> movePlayer("backwards");
                    case 3 -> lootChest();
                    case 4 -> openInventory();
                }

            } else {
                String[] options = {"1. Fight Enemy 🥊", "2. Go to Previous Room ⇦", "3. Open Inventory 🎒"};

                System.out.println(GameWindow.optionsBox(options));

                int playerChoice = GameWindow.printDialogBox();

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
            GameWindow.printCombat(getCurrentRoom(), player);

            String[] options = {"1. Attack Enemy", "2. Open Inventory"};

            System.out.println(GameWindow.optionsBox(options));
            int playerInput = GameWindow.printDialogBox();

            switch (playerInput) {
                case 1 -> {
                    int enemyAttackValue = enemy.attack();
                    player.takeDamage(enemy.attack());
                    System.out.printf("%s attacked %s for %d damage!%n", enemy.getName(), player.getName(), enemyAttackValue);

                    int playerAttackValue = player.attack();
                    enemy.takeDamage(player.attack());
                    System.out.printf("%s attacked %s for %d damage!%n", player.getName(), enemy.getName(), playerAttackValue);
                }
                case 2 -> openInventory();
                default -> System.err.println("Cannot do that.");
            }

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
            System.out.println(GameWindow.chestLootingBox(chest));

            String[] options = {"-1. Exit", "0. Skip"};

            System.out.println(GameWindow.optionsBox(options));

            continueLooting = GameWindow.printDialogBox();

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

            // Print options to continue looting or not
            String[] continueOptions = {"Continue Looting?", "0. No", "1. Yes"};

            System.out.println(GameWindow.optionsBox(continueOptions));
            continueLooting = GameWindow.printDialogBox();

        } while (continueLooting != 0);

    }


    public void openInventory() {
        int playerInput;

        do {
            System.out.println(GameWindow.inventoryBox(player));

            String[] options = {"0. Exit Inventory", "1. Equip a Weapon", "2. Consume an Item"};

            System.out.println(GameWindow.optionsBox(options));

            playerInput = GameWindow.printDialogBox();

            switch (playerInput) {
                case 1 -> equipWeaponPrompt();
                case 2 -> consumeItemPrompt();
                default -> {
                }
            }

        } while (playerInput != 0);

    }

    private void equipWeaponPrompt() {
        if (playerInventory().getWeapons().isEmpty()) {
            System.out.println("You don't have any weapons in your inventory!");
            return;
        }

        System.out.println(GameWindow.weaponsBox(playerInventory()));

        int playerInput = GameWindow.printDialogBox();
        int weaponIndex = playerInput - 1;

        player.equipWeapon(weaponIndex);

        System.out.printf("You've equipped %s!%n", playerInventory().getWeapon(weaponIndex).getName());
    }

    private void consumeItemPrompt() {
        if (playerInventory().getItems().isEmpty()) {
            System.out.println("You don't have any item in your inventory!");
            return;
        }

        System.out.println(GameWindow.itemsBox(playerInventory()));

        int playerInput = GameWindow.printDialogBox();
        int itemIndex = playerInput - 1;

        player.consumeItem(itemIndex);

        System.out.printf("You've consumed %s!%n", playerInventory().getItem(itemIndex).getName());
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
        dungeonRooms = GameInitializer.dungeonRooms(5);
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
