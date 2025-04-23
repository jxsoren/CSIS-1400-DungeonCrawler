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

    public static void printWindow() {
        // Dimensions
        int width = 120;

        StringBuilder top = buildTop(width);
        StringBuilder bottom = buildBottom(width);
        String emptyBody = buildBody("", width).toString();

        System.out.println(lineWithPadding(top.toString()));
        System.out.println(lineWithPadding(emptyBody));
        System.out.println(lineWithPadding(emptyBody));
        System.out.println(lineWithPadding(emptyBody));
        System.out.println(lineWithPadding(emptyBody));
        System.out.println(lineWithPadding(emptyBody));

        DungeonRoom room = new DungeonRoom();
        String roomBox = roomBox(room);

        String[] roomLines = roomBox.split("\n");
        for (String roomLine : roomLines) {
            String lineBody = buildBody(roomLine, width).toString();
            System.out.println(lineWithPadding(lineBody));
        }

        System.out.println(lineWithPadding(emptyBody));
        System.out.println(lineWithPadding(emptyBody));
        System.out.println(lineWithPadding(emptyBody));

        String inventoryBox = inventoryBox(new Inventory());
        String[] inventoryLines = inventoryBox.split("\n");
        for (String inventoryLine : inventoryLines) {
            String lineBody = buildBody(inventoryLine, width).toString();
            System.out.println(lineWithPadding(lineBody));
        }

        System.out.println(lineWithPadding(emptyBody));
        System.out.println(lineWithPadding(emptyBody));
        System.out.println(lineWithPadding(emptyBody));
        System.out.println(lineWithPadding(emptyBody));
        System.out.println(lineWithPadding(bottom.toString()));
    }

    private static String lineWithPadding(String lineBody) {
        int paddingAmount = 20;
        StringBuilder line = new StringBuilder(lineBody);

        // Prepend empty space chars at beginning of line
        String spacePadding = "  ".repeat(paddingAmount);
        line.insert(0, spacePadding);

        return line.toString();
    }

    public static void printRoom(DungeonRoom room) {
        // Dimensions
        int width = 62;
        String header = room.getName();

        // Print Header
        StringBuilder top = buildTop(width);
        StringBuilder divider = buildDivider(width);
        StringBuilder headerLine = buildBody(header, width);
        StringBuilder bottom = buildBottom(width);

        System.out.println(top);
        System.out.println(headerLine);
        System.out.println(divider);
        System.out.println(buildBody("", width));

        // Print Enemy
        System.out.println(buildBody("ENEMY", width));
        String[] enemyAttributes = room.getEnemy().attributesArr();
        for (String attribute : enemyAttributes) {
            System.out.println(buildBody(attribute, width));
        }
        System.out.println(buildBody("", width));

        String entity = AsciiArt.door();
        String[] artLines = entity.split("\n");
        for (String line : artLines) {
            String strippedLine = line.strip();
            System.out.println(buildBody(strippedLine, width));
        }

        // Print Chest
        System.out.println(buildBody("CHEST", width));
        String[] attributesArr = room.getChest().attributesArr();
        for (String attribute : attributesArr) {
            System.out.println(buildBody(attribute, width));
        }
        System.out.println(buildBody("", width));

        System.out.println(bottom);
    }

    public static String roomBox(DungeonRoom room) {
        StringBuilder line = new StringBuilder();

        // Dimensions
        int width = 62;
        String header = room.getName();

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

        // Print Enemy
        line.append(buildBody("ENEMY", width));
        line.append("\n");
        String[] enemyAttributes = room.getEnemy().attributesArr();
        for (String attribute : enemyAttributes) {
            line.append(buildBody(attribute, width));
            line.append("\n");
        }

        line.append(emptySpace);
        line.append("\n");

        String enemy = AsciiArt.goblin();
        String[] artLines = enemy.split("\n");
        for (String enemyLine : artLines) {
            String strippedLine = enemyLine.strip();
            line.append(buildBody(strippedLine, width));
            line.append("\n");
        }

        // Print Chest
        line.append(buildBody("CHEST", width));
        line.append("\n");

        String[] attributesArr = room.getChest().attributesArr();
        for (String attribute : attributesArr) {
            line.append(buildBody(attribute, width));
            line.append("\n");
        }

        line.append(emptySpace);
        line.append("\n");

        line.append(bottom);
        line.append("\n");

        return line.toString();
    }

    public static void printPlayer(Player player) {
        // Dimensions
        int width = 62;
        String header = player.getName();

        // Print Header
        StringBuilder top = buildTop(width);
        StringBuilder divider = buildDivider(width);
        StringBuilder headerLine = buildBody(header, width);
        StringBuilder bottom = buildBottom(width);

        System.out.println(top);
        System.out.println(headerLine);
        System.out.println(divider);
        System.out.println(buildBody("", width));

        // Print Player
        System.out.println(buildBody("PLAYER", width));

        String[] attributesArr = player.attributesArr();
        for (String attribute : attributesArr) {
            System.out.println(buildBody(attribute, width));
        }
        System.out.println(buildBody("", width));

        System.out.println(buildBody("", width));
        System.out.println(bottom);
    }

    public static String inventoryBox(Inventory inventory) {
        // Dimensions
        final int width = 42;
        StringBuilder line = new StringBuilder();
        String header = "Inventory";

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

        // Print Weapons
        String weaponsString = inventory.weaponsString().toString();
        String[] splitWeapons = weaponsString.split("\n");
        line.append(buildBody("WEAPONS", width));
        line.append("\n");
        for (String itemString : splitWeapons) {
            line.append(buildBody(itemString, width));
            line.append("\n");
        }

        line.append(emptySpace);
        line.append("\n");

        // Print Items
        String itemsString = inventory.itemsString().toString();
        String[] splitItems = itemsString.split("\n");
        line.append(buildBody("ITEMS", width));
        line.append("\n");
        for (String itemString : splitItems) {
            line.append(buildBody(itemString, width));
            line.append("\n");
        }

        line.append(emptySpace);
        line.append("\n");

        line.append(bottom);
        line.append("\n");

        return line.toString();
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

    private static void printPadding(int paddingAmount) {
        System.out.println("\n".repeat(paddingAmount));
    }

}
