/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

public class GameWindow {
    // Dimensions
    public static final int width = 80;
    public static final int height = 60;

    // Corners
    private static final String topLeftCorner = "┏";
    private static final String topRightCorner = "┓";
    private static final String bottomLeftCorner = "┗";
    private static final String bottomRightCorner = "┛";

    // Lines
    private static final String horizontalLine = "━";
    private static final String verticalLine = "┃";

    public static void printWindow() {
        int topPadding = 5;
        int bottomPadding = 5;
        int leftPadding = 40;


        // Print Top
        printPadding(topPadding);

        System.out.print(" ".repeat(leftPadding));
        System.out.print(topLeftCorner);
        System.out.print(horizontalLine.repeat(width));
        System.out.print(topRightCorner);


        // Print Left

        for (int i = 0; i < height; i++) {
            System.out.printf("%n%s%s%s%s", " ".repeat(leftPadding), verticalLine, " ".repeat(width), verticalLine);
        }


        // Print Right

        System.out.println();

        // Print Bottom
        System.out.print(" ".repeat(leftPadding));
        System.out.print("-".repeat(width));
        printPadding(bottomPadding);

    }

    private static void printPadding(int paddingAmount) {
        for (int i = 0; i < paddingAmount; i++) {
            System.out.println();
        }
    }


}
