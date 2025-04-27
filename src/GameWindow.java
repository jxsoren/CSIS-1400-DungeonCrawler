/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

import java.util.Scanner;

public class GameWindow {
    // ANSI Color Sequences
    public static final String ANSI_RESET = "\u001B[0m";

    // Regular colors
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // Bold colors
    public static final String ANSI_BLACK_BOLD = "\u001B[1;30m";
    public static final String ANSI_RED_BOLD = "\u001B[1;31m";
    public static final String ANSI_GREEN_BOLD = "\u001B[1;32m";
    public static final String ANSI_YELLOW_BOLD = "\u001B[1;33m";
    public static final String ANSI_BLUE_BOLD = "\u001B[1;34m";
    public static final String ANSI_PURPLE_BOLD = "\u001B[1;35m";
    public static final String ANSI_CYAN_BOLD = "\u001B[1;36m";
    public static final String ANSI_WHITE_BOLD = "\u001B[1;37m";

    // Corners
    private static final String topLeftCorner = "┏";
    private static final String topRightCorner = "┓";
    private static final String bottomLeftCorner = "┗";
    private static final String bottomRightCorner = "┛";

    // Lines
    private static final String horizontalLine = "━";
    private static final String verticalLine = "┃";

    // Box Width
    private static final int optionsWidth = 42;
    private static final int messageBoxWidth = 60;
    private static final int smallBoxWidth = 32;

    public static void colorizedPrintLn(String message, String color) {
        String baseMessage = message + ANSI_RESET;

        switch (color) {
            case "red" -> System.out.println(ANSI_RED_BOLD + baseMessage);
            case "green" -> System.out.println(ANSI_GREEN_BOLD + baseMessage);
            case "blue" -> System.out.println(ANSI_BLUE_BOLD + baseMessage);
            case "yellow" -> System.out.println(ANSI_YELLOW_BOLD + baseMessage);
            case "cyan" -> System.out.println(ANSI_CYAN_BOLD + baseMessage);
        }
    }

    public static void colorizedPrint(String message, String color) {
        String baseMessage = message + ANSI_RESET;

        switch (color) {
            case "green" -> System.out.print(ANSI_GREEN_BOLD + baseMessage);
            case "red" -> System.out.print(ANSI_RED_BOLD + baseMessage);
            case "yellow" -> System.out.print(ANSI_YELLOW_BOLD + baseMessage);
        }
    }

    public static void printCutsceneWindow(String cutsceneArt) {
        int width = 140;

        String top = buildTop(width).toString();
        String bottom = buildBottom(width).toString();

        System.out.println(top);

        printEmptyBody(width);

        // Sanitize ASCII art lines
        String[] artLines = cutsceneArt.split("\n");
        for (String enemyLine : artLines) {
            String strippedLine = enemyLine.strip();
            System.out.println(buildBody(strippedLine, width));
        }

        System.out.println(bottom);
    }

    public static void printRoomWindow(DungeonRoom currentRoom) {
        // Dimensions
        int width = 80;

        String top = buildTop(width).toString();
        String bottom = buildBottom(width).toString();

        System.out.println(top);
        printEmptyBody(width);

        String roomBox = roomBox(currentRoom);
        printInnerBoxes(roomBox, width);

        System.out.println(bottom);
    }

    public static void printCombatHorizontal(DungeonRoom currentRoom, Player player, String[] attackLogs) {
        // Dimensions
        int width = 180;

        String top = buildTop(width).toString();
        String bottom = buildBottom(width).toString();

        System.out.println(top);
        printEmptyBody(width);

        String combatBox = combatBox(player, currentRoom.getEnemy());
        printInnerBoxes(combatBox, width);

        //        printInnerBoxes(attackLog(attackLogs), width);
        colorizePrintInnerBoxes(attackLog(attackLogs), width, "yellow");

        System.out.println(bottom);
    }

    public static String combatBox(Player player, Enemy enemy) {
        int width = 160;

        String[] content1 = playerBox(player).split("\n");
        String[] content2 = enemyBox(enemy).split("\n");

        return buildCombatBox(width, "Combat", content1, content2);
    }

    // Small Boxes

    public static String optionsBox(String[] options) {
        String header = "Options";

        return buildInnerBox(optionsWidth, header, null, options);
    }

    private static void printEmptyBody(int width) {
        String emptyBody = buildBody("", width).toString();
        System.out.println(emptyBody);
    }

    public static String weaponsBox(Inventory inventory) {
        int width = 30;

        String header = "WEAPONS";

        String[][] attributes = new String[][]{inventory.weaponStrings()};

        return buildBox(width, header, null, attributes);
    }

    public static String itemsBox(Inventory inventory) {
        int width = 30;

        String header = "ITEMS";

        String[][] attributes = new String[][]{inventory.itemStrings()};

        return buildBox(width, header, null, attributes);
    }

    public static String entityBox(String[] weapons, String header) {
        return buildBox(smallBoxWidth, header, null, weapons);
    }

    public static String playerStatsAndInventoryBox(Player player) {
        int width = 72;

        String[] playerAttributes = playerBox(player).split("\n");
        String[] inv = inventoryBoxInner(player).split("\n");

        String[][] finalAttributes = {playerAttributes, inv};

        return buildBox(width, "Player Stats & Inventory", null, finalAttributes);
    }

    // Message Boxes

    public static void printSuccessBox(String message) {
        String header = "Success!!!";
        String[] messages = {message};

        String box = buildInnerBox(messageBoxWidth, header, null, messages);

        colorizedPrintLn(box, "green");
    }

    public static void printErrorBox(String errorMessage) {
        String header = "Error Message";
        String[] messages = {errorMessage};

        String box = buildInnerBox(messageBoxWidth, header, null, messages);

        System.out.println();
        colorizedPrintLn(box, "red");
        System.out.println();
    }

    public static String attackLog(String[] attackLogs) {
        String header = "Attack Log";

        return buildInnerBox(messageBoxWidth, header, null, attackLogs);
    }

    // Dialog Boxes

    public static int printDialogBox() {
        Scanner input = new Scanner(System.in);
        colorizedPrint("❯ ", "green");

        return input.nextInt();
    }

    public static String printStringDialogBox() {
        Scanner input = new Scanner(System.in);
        colorizedPrint("❯ ", "green");

        return input.nextLine();
    }

    public static void printInnerBoxes(String box, int width) {
        String[] lines = box.split("\n");

        for (String line : lines) {
            String lineBody = buildBody(line, width).toString();
            System.out.println(lineBody);
        }
    }

    public static void colorizePrintInnerBoxes(String box, int width, String color) {
        String[] lines = box.split("\n");

        for (String line : lines) {
            String lineBody = buildBody(line, width).toString();
            colorizedPrintLn(lineBody, color);
        }
    }

    public static String enemyBox(Enemy enemy) {
        String header = enemy.getName();
        String asciiArt = enemy.asciiArt();
        String[] attributes = enemy.attributesArr();

        return buildInnerBox(smallBoxWidth, header, asciiArt, attributes);
    }

    public static String chestBox(TreasureChest chest) {
        String header = chest.chestTypeString();
        String asciiArt = chest.asciiArt();
        String[] attributes = chest.attributesArr();

        return buildInnerBox(smallBoxWidth, header, asciiArt, attributes);
    }

    public static String roomBox(DungeonRoom room) {
        int width = 72;
        String header = String.format("%s %s", room.getName(), room.roomLevelString());

        String[] roomAttributes = room.attributesArr();

        Enemy roomEnemy = room.getEnemy();
        String enemyBox = enemyBox(roomEnemy);

        String[] enemyAttributes = enemyBox.split("\n");

        TreasureChest chest = room.getChest();
        String chestBox = chestBox(chest);

        String[] chestAttributes = chestBox.split("\n");

        String[][] finalAttributes = {roomAttributes, enemyAttributes, chestAttributes};

        return buildBox(width, header, null, finalAttributes);
    }

    public static String playerBox(Player player) {
        int width = 54;

        String[] playerAttributes = player.attributesArr();
        String asciiArt = AsciiArt.asciiArtFactory("player");

        return buildBox(width, "Player", asciiArt, playerAttributes);
    }

    private static String buildCombatBox(int width, String header, String[] attributes1, String[] attributes2) {
        StringBuilder line = buildLineHeader(width, header);

        // Choose the length of the larger array
        int largestLength = Math.max(attributes1.length, attributes2.length);

        for (int i = 0; i < largestLength; i++) {
            String content1;
            String content2;

            if (i >= attributes1.length) {
                content1 = " ".repeat(attributes1[0].length()); // preserve original spacing to properly space other element
            } else {
                content1 = attributes1[i];
            }

            if (i >= attributes2.length) {
                content2 = " ".repeat(attributes2[0].length()); // preserve original spacing to properly space other element
            } else {
                content2 = attributes2[i];
            }

            line.append(buildBody(content1, content2, width));

            line.append("\n");
        }

        StringBuilder bottom = buildBottom(width);
        line.append(bottom);
        line.append("\n");

        return line.toString();
    }

    private static StringBuilder buildLineHeader(int width, String header) {
        StringBuilder line = new StringBuilder();

        StringBuilder top = buildTop(width);
        StringBuilder divider = buildDivider(width);
        StringBuilder headerLine = buildBody(header, width);

        line.append(top);
        line.append("\n");
        line.append(headerLine);
        line.append("\n");
        line.append(divider);
        line.append("\n");

        return line;
    }

    // Builder Helpers

    private static void buildAsciiArtLines(int width, String asciiArt, StringBuilder line) {
        if (asciiArt == null) {
            return;
        }

        String[] artLines = asciiArt.split("\n");
        for (String enemyLine : artLines) {
            String strippedLine = enemyLine.strip();
            line.append(buildBody(strippedLine, width));
            line.append("\n");
        }
    }

    private static String buildBox(int width, String header, String asciiArt, String[]... attributes) {
        StringBuilder line = buildLineHeader(width, header);

        buildAsciiArtLines(width, asciiArt, line);

        for (String[] attribute : attributes) {
            for (String s : attribute) {
                line.append(buildBody(s, width));
                line.append("\n");
            }
        }

        StringBuilder bottom = buildBottom(width);
        line.append(bottom);
        line.append("\n");

        return line.toString();
    }

    private static String buildInnerBox(int width, String header, String asciiArt, String[]... attributes) {
        StringBuilder line = buildLineHeader(width, header);

        buildAsciiArtLines(width, asciiArt, line);

        for (String[] attribute : attributes) {
            for (String s : attribute) {
                line.append(buildBody(s, width));
                line.append("\n");
            }
        }

        StringBuilder bottom = buildBottom(width);
        line.append(bottom);
        line.append("\n");

        return line.toString();
    }

    public static String inventoryBoxInner(Player player) {
        int width = 54;

        String[] weaponsAttributes = weaponsBox(player.getInventory()).split("\n");
        String[] itemsAttributes = itemsBox(player.getInventory()).split("\n");
        String[] inventoryStats = new String[]{String.format("[%dlbs/%dlbs]", player.getInventory().currentWeight(), player.getInventory().getMaxInventoryWeight())};

        String[][] finalAttributes = {inventoryStats, weaponsAttributes, itemsAttributes};

        return buildBox(width, "Inventory", null, finalAttributes);
    }


    public static String chestLootingBox(TreasureChest chest) {
        int width = 42;

        String header = chest.chestTypeString();

        String[] weapons = chest.lootingAttributesArr()[0];
        String[] items = chest.lootingAttributesArr()[1];

        String[] weaponsAttributes = entityBox(weapons, "Chest Weapons").split("\n");
        String[] itemsAttributes = entityBox(items, "Chest Items").split("\n");

        String[][] finalAttributes = {weaponsAttributes, itemsAttributes};

        return buildBox(width, header, null, finalAttributes);
    }

    private static StringBuilder buildTop(int width) {
        width += 2; // += 2 for each start and end character

        StringBuilder line = new StringBuilder();

        line.append(topLeftCorner);
        line.append(horizontalLine.repeat(width));
        line.append(topRightCorner);

        return line;
    }

    private static StringBuilder buildBottom(int width) {
        width += 2; // += 2 for each start and end character

        StringBuilder line = new StringBuilder();

        line.append(bottomLeftCorner);
        line.append(horizontalLine.repeat(width));
        line.append(bottomRightCorner);

        return line;
    }

    private static StringBuilder buildDivider(int width) {
        width += 2; // += 2 for each start and end character

        StringBuilder line = new StringBuilder();

        line.append(verticalLine);
        line.append(horizontalLine.repeat(width));
        line.append(verticalLine);

        return line;
    }

    private static StringBuilder buildBody(String content, int totalLineWidth) {
        StringBuilder line = new StringBuilder();
        int paddingAmount = calculateCenteredPadding(totalLineWidth, content.length());

        // Left Wall
        line.append(verticalLine);

        // Padding amount should be in halves

        // Left half padding
        line.append(" ".repeat(paddingAmount));

        // Correct spacing if content is odd num of characters
        if (content.length() % 2 != 0) line.append(" ");

        // Add content in
        line.append(content);

        // Right half padding
        line.append(" ".repeat(paddingAmount));

        // Right Wall
        line.append(verticalLine);

        return line;
    }

    private static StringBuilder buildBody(String content1, String content2, int totalLineWidth) {
        StringBuilder line = new StringBuilder();
        int paddingAmount = calculateCenteredPadding(totalLineWidth, content1.length(), content2.length());

        // Add opening wall
        line.append(verticalLine);

        // Padding amount should be in thirds

        // Add first third of padding
        line.append(" ".repeat(paddingAmount));

        // Add content1
        line.append(content1);

        // Add second third of padding
        line.append(" ".repeat(paddingAmount));

        // Add content2
        line.append(content2);

        // Add final bit of padding
        line.append(" ".repeat(paddingAmount - 1));

        // Add closing wall
        line.append(verticalLine);

        return line;
    }

    private static int calculateCenteredPadding(int totalWidth, int contentLength) {
        return ((totalWidth - contentLength) / 2) + 1;
    }

    private static int calculateCenteredPadding(int totalWidth, int contentLength1, int contentLength2) {
        return ((totalWidth - (contentLength1 + contentLength2)) / 3) + 1;
    }

}
