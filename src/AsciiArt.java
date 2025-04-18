//will need to interact with the enemy class. we will have to create an enemy object. one of the methods of this object should include a printf statement.
//this will print out the enemy/object/chest
//we may need to make an AsciiLibrary class that has a list of these different artworks
//
public class AsciiArt {
    public static void main(String[] args) {
        EnemyArt enemy = new EnemyArt();
        displayThing(enemy.displayEnemy());
    }

    public static void displayThing(String thing) {
        System.out.printf("%s%n", "-".repeat(50));
        // Split the string into lines and add 25 spaces to each line
        String[] lines = thing.split("\n");
        for (String line : lines) {
            System.out.printf("%15s%s%n", "", line); // 25 spaces + line content
        }
        System.out.printf("%s%n%n", "-".repeat(50));
    }
}

class EnemyArt {
    public String displayEnemy() {
        return "   __________\n" +
                "  /\\____;;___\\\n" +
                " | /         /\n" +
                "  .__________.\n" +
                "  |\\ ________\\\n" +
                "  | |---------|\n" +
                "  \\ |         |\n" +
                "   \\|_________|\n";
    }
}
