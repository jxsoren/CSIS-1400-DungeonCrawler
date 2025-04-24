import java.util.Scanner;

/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

public class GameWindow {
    // Corners
    private static final String topLeftCorner = "┏";
    private static final String topRightCorner = "┓";
    private static final String bottomLeftCorner = "┗";
    private static final String bottomRightCorner = "┛";

    // Lines
    private static final String horizontalLine = "━";
    private static final String verticalLine = "┃";

    public static void printWindow(DungeonRoom currentRoom, Player player) {
        // Dimensions
        int width = 100;

        String top = buildTop(width).toString();
        String bottom = buildBottom(width).toString();

        System.out.println(lineWithPadding(top));
        printEmptyBody(width);

        String roomBox = roomBox(currentRoom);
        printInnerBoxes(roomBox, width);

        printEmptyBody(width);
        printEmptyBody(width);
        System.out.println(lineWithPadding(bottom));
    }

    public static void printCombat(DungeonRoom currentRoom, Player player) {
        // Dimensions
        int width = 160;

        String top = buildTop(width).toString();
        String bottom = buildBottom(width).toString();

        System.out.println(lineWithPadding(top));
        printEmptyBody(width);

        String enemyBox = enemyBox(currentRoom.getEnemy());
        printInnerBoxes(enemyBox, width);

        printEmptyBody(width);
        String playerBox = playerBox(player);
        printInnerBoxes(playerBox, width);

        printEmptyBody(width);
        System.out.println(lineWithPadding(bottom));
    }

    public static int printDialogBox() {
        Scanner input = new Scanner(System.in);
        System.out.print(lineWithPadding("❯ "));

        return input.nextInt();
    }

    public static String printStringDialogBox() {
        Scanner input = new Scanner(System.in);
        System.out.print(lineWithPadding("❯ "));

        return input.nextLine();
    }

    public static String optionsBox(String[] options) {
        int width = 32;

        String header = "Options";

        return buildInnerBox(width, header, options);
    }

    public static String printQuestionBox(String[] questions) {
        int width = 60;

        String header = "Question";

        return buildInnerBox(width, header, questions);
    }

    private static void printEmptyBody(int width) {
        String emptyBody = buildBody("", width).toString();
        System.out.println(lineWithPadding(emptyBody));
    }

    public static void printInnerBoxes(String box, int width) {
        String[] lines = box.split("\n");

        for (String line : lines) {
            String lineBody = buildBody(line, width).toString();
            System.out.println(lineWithPadding(lineBody));
        }
    }

    private static String lineWithPadding(String lineBody) {
        int paddingAmount = 0;
        StringBuilder line = new StringBuilder(lineBody);

        // Prepend empty space chars at beginning of line
        String spacePadding = "  ".repeat(paddingAmount);
        line.insert(0, spacePadding);

        return line.toString();
    }

    public static String enemyBox(Enemy enemy) {
        int width = 32;

        String header = enemy.getName();
        String asciiArt = enemy.asciiArt();
        String[] attributes = enemy.attributesArr();

        return buildInnerBox(width, header, attributes, asciiArt);
    }

    public static String chestBox(TreasureChest chest) {
        int width = 32;

        String header = chest.chestTypeString();
        String asciiArt = chest.asciiArt();
        String[] attributes = chest.attributesArr();

        return buildInnerBox(width, header, attributes, asciiArt);
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

        return buildBox(width, header, finalAttributes);
    }

    public static String playerBox(Player player) {
        int width = 22;
        String[] playerAttributes = player.attributesArr();

        String[][] finalAttributes = {playerAttributes};

        return buildBox(width, "Player", finalAttributes);
    }

    private static String buildBox(int width, String header, String[]... attributes) {
        StringBuilder line = new StringBuilder();

        // Print Header
        StringBuilder top = buildTop(width);
        StringBuilder divider = buildDivider(width);
        StringBuilder headerLine = buildBody(header, width);
        StringBuilder emptySpace = buildBody("", width);
        StringBuilder bottom = buildBottom(width);

        line.append(top);
        line.append("\n");
        line.append(headerLine);
        line.append("\n");
        line.append(divider);
        line.append("\n");
        line.append(emptySpace);
        line.append("\n");

        for (String[] attribute : attributes) {
            for (String s : attribute) {
                line.append(buildBody(s, width));
                line.append("\n");
            }
        }

        line.append(emptySpace);
        line.append("\n");

        line.append(bottom);
        line.append("\n");

        return line.toString();
    }

    private static String buildInnerBox(int width, String header, String[] attributes, String asciiArt) {
        StringBuilder line = new StringBuilder();

        // Print Header
        StringBuilder top = buildTop(width);
        StringBuilder divider = buildDivider(width);
        StringBuilder headerLine = buildBody(header, width);
        StringBuilder emptySpace = buildBody("", width);
        StringBuilder bottom = buildBottom(width);

        line.append(top);
        line.append("\n");
        line.append(headerLine);
        line.append("\n");
        line.append(divider);
        line.append("\n");
        line.append(emptySpace);
        line.append("\n");

        for (String attribute : attributes) {
            line.append(buildBody(attribute, width));
            line.append("\n");
        }

        line.append(emptySpace);
        line.append("\n");

        // Sanitize ASCII art lines
        String[] artLines = asciiArt.split("\n");
        for (String enemyLine : artLines) {
            String strippedLine = enemyLine.strip();
            line.append(buildBody(strippedLine, width));
            line.append("\n");
        }

        line.append(bottom);
        line.append("\n");

        return line.toString();
    }

    private static String buildInnerBox(int width, String header, String[]... attributes) {
        StringBuilder line = new StringBuilder();

        // Print Header
        StringBuilder top = buildTop(width);
        StringBuilder divider = buildDivider(width);
        StringBuilder headerLine = buildBody(header, width);
        StringBuilder emptySpace = buildBody("", width);
        StringBuilder bottom = buildBottom(width);

        line.append(top);
        line.append("\n");
        line.append(headerLine);
        line.append("\n");
        line.append(divider);
        line.append("\n");
        line.append(emptySpace);
        line.append("\n");

        for (String[] attribute : attributes) {
            for (String s : attribute) {
                line.append(buildBody(s, width));
                line.append("\n");
            }
        }

        line.append(emptySpace);
        line.append("\n");

        line.append(bottom);
        line.append("\n");

        return line.toString();
    }

    public static String weaponsBox(Inventory inventory) {
        int width = 30;

        String header = "WEAPONS";

        String[][] attributes = new String[][]{inventory.weaponStrings()};

        return buildBox(width, header, attributes).toString();
    }

    public static String itemsBox(Inventory inventory) {
        int width = 30;

        String header = "ITEMS";

        String[][] attributes = new String[][]{inventory.itemStrings()};

        return buildBox(width, header, attributes);
    }

    public static String weaponsBox(String[] weapons, String header) {
        int width = 30;

        return buildBox(width, header, weapons);
    }

    public static String itemsBox(String[] items, String header) {
        int width = 30;

        return buildBox(width, header, items);
    }

    public static String inventoryBox(Player player) {
        int width = 42;

        String[] playerAttributes = playerBox(player).split("\n");
        String[] weaponsAttributes = weaponsBox(player.getInventory()).split("\n");
        String[] itemsAttributes = itemsBox(player.getInventory()).split("\n");
        String[] inventoryAttributes = player.getInventory().inventoryStats().split("\n");

        String[][] finalAttributes = {playerAttributes, inventoryAttributes, weaponsAttributes, itemsAttributes};

        return buildBox(width, "Player Stats & Inventory", finalAttributes);
    }

    public static String chestLootingBox(TreasureChest chest) {
        int width = 42;

        String header = chest.chestTypeString();

        String[] weapons = chest.lootingAttributesArr()[0];
        String[] items = chest.lootingAttributesArr()[1];

        String[] weaponsAttributes = weaponsBox(weapons, "Chest Weapons").split("\n");
        String[] itemsAttributes = itemsBox(items, "Chest Items").split("\n");

        String[][] finalAttributes = {weaponsAttributes, itemsAttributes};

        return buildBox(width, header, finalAttributes);
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
        int paddingAmount = calculatePadding(totalLineWidth, content.length());

        line.append(verticalLine);

        line.append(" ".repeat(paddingAmount));
        // correct spacing if content is odd num of characters
        if (content.length() % 2 != 0) line.append(" ");
        line.append(content);
        line.append(" ".repeat(paddingAmount));
        line.append(verticalLine);

        return line;
    }

    private static int calculatePadding(int width, int contentLength) {
        return ((width - contentLength) / 2) + 1;
    }

}
