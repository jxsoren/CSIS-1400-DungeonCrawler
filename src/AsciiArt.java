/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 * Title: Untitled Dungeon Crawler Game
 ***********************************************/

//will need to interact with the enemy class. we will have to create an enemy object. one of the methods of this object should include a printf statement.
//this will print out the enemy/object/chest
//we may need to make an AsciiLibrary class that has a list of these different artworks

public class AsciiArt {
    public static String asciiArtFactory(String name) {
        return switch (name.toLowerCase()) {
            case "chest" -> chest();
            case "goblin" -> goblin();
            case "sword" -> sword();
            case "potion" -> potion();
            case "door" -> door();
            case "spider" -> spider();
            case "entrance" -> entrance();
            default -> name;
        };
    }

    public static void main(String[] args) {
        displayWindow(chest());
    }

    //this method takes in a String from the methods at the bottom of the page
    public static void displayWindow(String thing) {
        System.out.printf("%s%n", "-".repeat(50));
        // Split the string into lines and add 25 spaces to each line
        String[] lines = thing.split("\n");
        for (String line : lines) {
            System.out.printf("%15s%s%n", "", line); // 25 spaces + line content
        }
        //System.out.printf("Your Health:%-21d Enemy Health:%d%n", Player.getCurrentHealth(), Enemy.getCurrentHealth());// will display player and enemy's health
        System.out.printf("%s%n%n", "-".repeat(50));
    }

    //this overflow method will display the screen if no String is given
    public static void displayWindow() {
        System.out.printf("%s%n%n%n%n%n%n%n%n", "-".repeat(50));

        System.out.printf("%s%n%n", "-".repeat(50));
    }

    public static String chest() {
        return """
                   __________
                  /\\____;;___\\
                 | /         /
                  .__________.
                  |\\ ________\\
                  | |---------|
                  \\ |         |
                   \\|_________|
                """;
    }

    public static String goblin() {
        return """
                      ,      ,
                     /(.-""-.)\\
                 |\\  \\/      \\/  /|
                 | \\ / =.  .= \\ / |
                 \\( \\   o\\/o   / )/
                  \\_, '-/  \\-' ,_/
                    /   \\__/   \\
                    \\ \\__/\\__/ /
                  ___\\ \\|--|/ /___
                 /`   \\      /    `\\
                /      '----'       \\
                """;
    }

    public static String sword() {
        return """
                        ()\s
                      __)(__
                      '-<>-'
                        )(\s
                        ||\s
                        ||\s
                        ||\s
                        ||\s
                        ||\s
                        ||\s
                        ||\s
                        ||\s
                        \\/
                """;
    }

    public static String potion() {
        return """
                      (------)
                       [ 0  ]
                       /0   \\
                      /    o \\
                     /  o   0 \\
                    /----------\\
                   /            \\
                  /              \\
                 /                \\
                /                  \\
                [                  ]
                \\__________________/
                """;
    }

    public static String door() {
        return """
                      ______
                   ,-' ;  ! `-.
                  / :  !  :  . \\
                 |_ ;   __:  ;  |
                 )| .  :)(.  !  |
                 |"    (##)  _  |
                 |  :  ;`'  (_) (
                 |  :  :  .     |
                 )_ !  ,  ;  ;  |
                 || .  .  :  :  |
                 |" .  |  :  .  |
                 |___.------.___|\
                """;
    }

    public static String spider() {
        return """
                         (
                          )
                         (
                   /\\  .-""\"-.  /\\
                  //\\\\/  ,,,  \\//\\\\
                  |/\\| ,;;;;;, |/\\|
                  //\\\\\\;-""\"-;///\\\\
                 //  \\/   .   \\/  \\\\
                (| ,-_| \\ | / |_-, |)
                  //`__\\.-.-./__`\\\\
                 // /.-(() ())-.\\ \\\\
                (\\ |)   '---'   (| /)
                 ` (|           |) `
                   \\)           (/""";
    }

    public static String entrance() {
        return """
                ______/TTTTTTTTTTTTT\\_______)__
                     |MMMMMMMMMMMmmmm|      (
                ____/MMMMMMMMMMMmmmmmm\\____<>____
                    |MMMMMMMMMMMmmmmmm|    ||
                ____|MMMMMMMMMMMmmmmmm|____||____
                    |MMMMMMMMMMMmmmmmm|
                ____|MMMMMMMMMMMmmmmmm|_______
                    |MMMMMMMMMMMmmmmmm|
                ____|MMMMMMMMMMMmmmmmm|____
                    |MMMMMMMMMMMmmmmmm|
                ____|MMMMMMMMMMMmmmmmm|____
                    |MMMMMMMMMmmmmmmmm|
                """;
    }
}
