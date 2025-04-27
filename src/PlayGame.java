/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

public class PlayGame {
    public static void main(String[] args) {
        openingCutScene();

        Player player = initPlayer();
        DungeonGame game = new DungeonGame(player);

        game.start();
    }

    private static Player initPlayer() {
        GameWindow.colorizedPrintLn("**Narrator**: Oh wait, before you engage... I forgot to grab your name. What is it?", "cyan");

        String playerName = GameWindow.printStringDialogBox();

        return new Player(playerName);
    }

    private static void openingCutScene() {
        String[] asciiArtCutScenes = AsciiArt.openingCutscenes();
        String[] narrativeText = {
                "**Narrator**: Welcome, brave adventurer!",
                "**Narrator**: Your journey begins as you approach a mysterious castle on the horizon...",
                "**Narrator**: Unable to find the main entrance, you search around the perimeter...",
                "**Narrator**: At last, you discover an ancient gate leading to what appears to be a dungeon...",
                "**Narrator**: As you descend into the first chamber, you hear a strange skittering sound...  *Something lurks in the darkness ahead*!"
        };

        String[] prompts = {
                "Press ENTER to begin your adventure...",
                "Press ENTER to approach the castle...",
                "Press ENTER to search for an entrance...",
                "Press ENTER to investigate the gate...",
                "Press ENTER to step into the shadows...",
                "Press ENTER to face what awaits below..."
        };

        for (int i = 0; i < asciiArtCutScenes.length; i++) {
            GameWindow.printCutsceneWindow(asciiArtCutScenes[i]);
            GameWindow.colorizedPrintLn(narrativeText[i], "yellow");
            System.out.println(prompts[i]);
            GameWindow.printStringDialogBox();
        }

    }
}


