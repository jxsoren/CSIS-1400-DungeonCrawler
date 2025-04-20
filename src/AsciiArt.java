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
        return switch(name){
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
        return  "   __________\n" +
                "  /\\____;;___\\\n" +
                " | /         /\n" +
                "  .__________.\n" +
                "  |\\ ________\\\n" +
                "  | |---------|\n" +
                "  \\ |         |\n" +
                "   \\|_________|\n";
    }
    public static String goblin(){
        return  "      ,      ,\n" +
                "     /(.-\"\"-.)\\\n" +
                " |\\  \\/      \\/  /|\n" +
                " | \\ / =.  .= \\ / |\n" +
                " \\( \\   o\\/o   / )/\n" +
                "  \\_, '-/  \\-' ,_/\n" +
                "    /   \\__/   \\\n" +
                "    \\ \\__/\\__/ /\n" +
                "  ___\\ \\|--|/ /___\n" +
                " /`   \\      /    `\\\n" +
                "/      '----'       \\\n";
    }
    public static String sword(){
        return  "        () \n" +
                "      __)(__\n" +
                "      '-<>-'\n" +
                "        )( \n" +
                "        || \n" +
                "        || \n" +
                "        || \n" +
                "        || \n" +
                "        || \n" +
                "        || \n" +
                "        || \n" +
                "        || \n" +
                "        \\/\n" ;
    }
    public static String potion(){
        return  "      (------)\n" +
                "       [ 0  ]\n" +
                "       /0   \\\n" +
                "      /    o \\\n" +
                "     /  o   0 \\\n" +
                "    /----------\\\n" +
                "   /            \\\n" +
                "  /              \\\n" +
                " /                \\\n" +
                "/                  \\\n" +
                "[                  ]\n" +
                "\\__________________/\n";
    }
    public static String door(){
        return  "      ______\n" +
                "   ,-' ;  ! `-.\n" +
                "  / :  !  :  . \\\n" +
                " |_ ;   __:  ;  |\n" +
                " )| .  :)(.  !  |\n" +
                " |\"    (##)  _  |\n" +
                " |  :  ;`'  (_) (\n" +
                " |  :  :  .     |\n" +
                " )_ !  ,  ;  ;  |\n" +
                " || .  .  :  :  |\n" +
                " |\" .  |  :  .  |\n" +
                " |___.------.___|";
    }
    public static String spider(){
        return  "         (\n" +
                "          )\n" +
                "         (\n" +
                "   /\\  .-\"\"\"-.  /\\\n" +
                "  //\\\\/  ,,,  \\//\\\\\n" +
                "  |/\\| ,;;;;;, |/\\|\n" +
                "  //\\\\\\;-\"\"\"-;///\\\\\n" +
                " //  \\/   .   \\/  \\\\\n" +
                "(| ,-_| \\ | / |_-, |)\n" +
                "  //`__\\.-.-./__`\\\\\n" +
                " // /.-(() ())-.\\ \\\\\n" +
                "(\\ |)   '---'   (| /)\n" +
                " ` (|           |) `\n" +
                "   \\)           (/";
    }
    public static String entrance(){
        return  "______/TTTTTTTTTTTTT\\_______)__\n" +
                "     |MMMMMMMMMMMmmmm|      (\n" +
                "____/MMMMMMMMMMMmmmmmm\\____<>____\n" +
                "    |MMMMMMMMMMMmmmmmm|    ||\n" +
                "____|MMMMMMMMMMMmmmmmm|____||____\n" +
                "    |MMMMMMMMMMMmmmmmm|\n" +
                "____|MMMMMMMMMMMmmmmmm|_______\n" +
                "    |MMMMMMMMMMMmmmmmm|\n" +
                "____|MMMMMMMMMMMmmmmmm|____\n" +
                "    |MMMMMMMMMMMmmmmmm|\n" +
                "____|MMMMMMMMMMMmmmmmm|____\n" +
                "    |MMMMMMMMMmmmmmmmm|\n";
    }
}
