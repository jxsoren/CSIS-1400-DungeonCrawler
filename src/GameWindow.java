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
        final int width = 120;
        final int height = 20;

        int topPadding = 2;
        int bottomPadding = 2;
        int leftPadding = 40;

        // Print Top
        printPadding(topPadding);
        System.out.printf("%n%40s%s%s", topLeftCorner, horizontalLine.repeat(width), topRightCorner);

        // Print Left and Right sides
        for (int i = 0; i < height; i++) {
            System.out.printf("%n%40s%121s", verticalLine, verticalLine);
        }

        // Print Bottom
        System.out.printf("%n%40s%s%s", bottomLeftCorner, horizontalLine.repeat(width), bottomRightCorner);
        printPadding(bottomPadding);
    }

    public static void printRoom(DungeonRoom room) {
        // Dimensions
        final int width = 62;
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

        AsciiArt.goblin();

        // Print Chest
        System.out.println(buildBody("CHEST", width));
        String[] attributesArr = room.getChest().attributesArr();
        for (String attribute : attributesArr) {
            System.out.println(buildBody(attribute, width));
        }
        System.out.println(buildBody("", width));

        System.out.println(bottom);
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

    public static void printInventory(Inventory inventory) {
        // Dimensions
        final int width = 42;

        // Print Header
        String header = "INVENTORY";
        StringBuilder line = buildBody(header, width);
        StringBuilder inventoryStats = buildBody(inventory.inventoryStats(), width);
        StringBuilder top = buildTop(width);
        StringBuilder divider = buildDivider(width);
        StringBuilder bottom = buildBottom(width);

        System.out.println(top);
        System.out.println(line);
        System.out.println(inventoryStats);
        System.out.println(divider);

        System.out.println(buildBody("", width));

        // Print Weapons
        String weaponsString = inventory.weaponsString().toString();
        String[] splitWeapons = weaponsString.split("\n");

        System.out.println(buildBody("WEAPONS", width));

        for (String itemString : splitWeapons) {
            System.out.println(buildBody(itemString, width));
        }

        System.out.println(buildBody("", width));

        // Print Items
        String itemsString = inventory.itemsString().toString();
        String[] splitItems = itemsString.split("\n");

        System.out.println(buildBody("ITEMS", width));

        for (String itemString : splitItems) {
            System.out.println(buildBody(itemString, width));
        }

        System.out.println(buildBody("", width));

        System.out.println(bottom);
    }

    private static StringBuilder buildTop(int width) {
        width += 2; // += 2 for each start and end character

        StringBuilder line = new StringBuilder();

        line.append("┏");
        line.append("━".repeat(width));
        line.append("┓");

        return line;
    }

    private static StringBuilder buildBottom(int width) {
        width += 2; // += 2 for each start and end character

        StringBuilder line = new StringBuilder();

        line.append("┗");
        line.append("━".repeat(width));
        line.append("┛");

        return line;
    }

    private static StringBuilder buildDivider(int width) {
        width += 2; // += 2 for each start and end character

        StringBuilder line = new StringBuilder();

        line.append("┃");
        line.append("━".repeat(width));
        line.append("┃");

        return line;
    }

    private static StringBuilder buildBody(String content, int totalLineWidth) {
        StringBuilder line = new StringBuilder();
        int paddingAmount = calculatePadding(totalLineWidth, content.length());

        line.append("┃");
        line.append(" ".repeat(paddingAmount));
        // correct spacing if content is odd num of characters
        if (content.length() % 2 != 0) line.append(" ");
        line.append(content);
        line.append(" ".repeat(paddingAmount));
        line.append("┃");

        return line;
    }

    private static int calculatePadding(int width, int contentLength) {
        return ((width - contentLength) / 2) + 1;
    }

    private static void printPadding(int paddingAmount) {
        System.out.println("\n".repeat(paddingAmount));
    }

}
