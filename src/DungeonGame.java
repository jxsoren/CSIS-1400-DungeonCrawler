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
            GameWindow.printErrorBox(e.getMessage());
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
                String[] options = {"1. Go to Next Room ⇨", "2. Go to Previous Room ⇦", "3. Loot Chest 💰", "4. Player Stats & Inventory 📊🎒"};

                System.out.println(GameWindow.optionsBox(options));
                int playerChoice = GameWindow.printDialogBox();

                switch (playerChoice) {
                    case 1 -> movePlayer("forwards");
                    case 2 -> movePlayer("backwards");
                    case 3 -> lootChest();
                    case 4 -> openPlayerStatsAndInventory();
                }

            } else {

                String[] options = {"1. Fight Enemy 🥊", "2. Go to Previous Room ⇦", "3. Player Stats & Inventory 📊🎒"};

                System.out.println(GameWindow.optionsBox(options));
                int playerChoice = GameWindow.printDialogBox();

                switch (playerChoice) {
                    case 1 -> attackLoop();
                    case 2 -> movePlayer("backwards");
                    case 3 -> openPlayerStatsAndInventory();
                }
            }
        }
    }

    public void attackLoop() {
        Enemy enemy = currentEnemy();

        do {
            GameWindow.printCombatHorizontal(getCurrentRoom(), player);

            String[] options = {"1. Attack Enemy ⚔️", "2. Player Stats & Inventory 📊🎒"};

            System.out.println(GameWindow.optionsBox(options));
            int playerInput = GameWindow.printDialogBox();

            switch (playerInput) {
                case 1 -> {
                    int enemyAttackValue = enemy.attack();
                    player.takeDamage(enemy.attack());

                    int playerAttackValue = player.attack();
                    enemy.takeDamage(player.attack());

                    String enemyAttacksPlayer = String.format("%s attacked %s for %d damage!", enemy.getName(), player.getName(), enemyAttackValue);
                    String playerAttacksEnemy = String.format("%s attacked %s for %d damage!", player.getName(), enemy.getName(), playerAttackValue);

                    String[] attackLog = {enemyAttacksPlayer, playerAttacksEnemy};

                    GameWindow.printAttackLog(attackLog);
                }
                case 2 -> openPlayerStatsAndInventory();
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

        String message = String.format("%s has been defeated!!!", enemy.getName());
        GameWindow.printSuccessBox(message);

        getCurrentRoom().completeRoom();
    }

    public void lootChest() {
        TreasureChest chest = currentTreasureChest();

        int weaponChoice = 0;
        int itemChoice = 0;

        int continueLooting = 1;

        while (continueLooting != 0) {
            System.out.println(GameWindow.chestLootingBox(chest));

            if (!chest.getWeapons().isEmpty()) {
                System.out.println("Which weapon?");
                weaponChoice = GameWindow.printDialogBox();

                if (weaponChoice == 0) {
                    continue;
                }

                if (weaponChoice == -1) {
                    break;
                }

                int weaponChoiceIndex = weaponChoice - 1;
                Weapon chosenWeapon = chest.takeWeapon(weaponChoiceIndex);

                playerInventory().addWeapon(chosenWeapon);

                String message = String.format("You added %s to your inventory!", chosenWeapon.getName());
                GameWindow.printSuccessBox(message);
            }

            if (!chest.getItems().isEmpty()) {
                System.out.println("Which Item?");
                itemChoice = GameWindow.printDialogBox();

                if (itemChoice == 0) {
                    continue;
                }

                if (itemChoice == -1) {
                    break;
                }

                int itemChoiceIndex = itemChoice - 1;
                Consumable chosenItem = chest.takeItem(itemChoiceIndex);

                playerInventory().addItem(chosenItem);

                String message = String.format("You added %s to your inventory!", chosenItem.getName());
                GameWindow.printSuccessBox(message);
            }

            // Print options to continue looting or not
            System.out.println("Continue Looting Chest?");
            String[] continueOptions = {"0. Exit Chest ", "1. Keep Looting"};

            System.out.println(GameWindow.optionsBox(continueOptions));
            continueLooting = GameWindow.printDialogBox();
        }

    }

    public void openPlayerStatsAndInventory() {
        int playerInput;

        do {
            System.out.println(GameWindow.playerStatsAndInventoryBox(player));

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
            GameWindow.printErrorBox("You don't have any weapons in your inventory!");
            return;
        }

        System.out.println(GameWindow.weaponsBox(playerInventory()));
        System.out.println("Which weapon would you like to equip?");

        int playerInput = GameWindow.printDialogBox();
        int weaponIndex = playerInput - 1;

        if (weaponIndex >= player.getInventory().getWeapons().size() || weaponIndex < 0) {
            GameWindow.printErrorBox("Weapon selection invalid. Try again.");
        } else {
            player.equipWeapon(weaponIndex);
            String message = String.format("You've equipped %s!", playerInventory().getWeapon(weaponIndex).getName());
            GameWindow.printSuccessBox(message);
        }

    }

    private void consumeItemPrompt() {
        if (playerInventory().getItems().isEmpty()) {
            GameWindow.printErrorBox("You don't have any items in your inventory!");
            return;
        }

        System.out.println(GameWindow.itemsBox(playerInventory()));

        int playerInput = GameWindow.printDialogBox();
        int itemIndex = playerInput - 1;

        if (itemIndex >= player.getInventory().getItems().size() || itemIndex < 0) {
            GameWindow.printErrorBox("Item selection invalid. Try again.");
        } else {
            String chosenItemName = playerInventory().getItem(itemIndex).getName();
            player.consumeItem(itemIndex);
            String message = String.format("You've consumed %s!", chosenItemName);
            GameWindow.printSuccessBox(message);
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

    public DungeonRoom getCurrentRoom() {
        return dungeonRooms.get(currentRoomIndex);
    }

    // Setters

    private void initRooms() {
        dungeonRooms = GameInitializer.initDungeonRooms();
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
            throw new Exception("Cannot advance to next Room. You're already at the final room.");
        }

        if (!getCurrentRoom().isCompleted()) {
            throw new Exception("Cannot advanced to next room. Defeat enemy before you can move on.");
        }

        // Set attributes to point to next room
        this.currentRoomIndex++;
        setCurrentRoom(this.currentRoomIndex);

        // Enter the next room
        enterRoom(getCurrentRoom());
    }

    private void previousRoom(int currentRoomIndex) throws Exception {
        // If player tries to go back when they're in the first room
        if (currentRoomIndex == 0) {
            throw new Exception("Cannot move to the previous room. You're at the first room.");
        }

        // Set attributes to point to previous room
        this.currentRoomIndex--;
        setCurrentRoom(getCurrentRoomIndex());

        // Enter the previous room
        enterRoom(getCurrentRoom());
    }

}
