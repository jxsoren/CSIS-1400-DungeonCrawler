/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

public class PlayGame {
    public static void main(String[] args) {
        //        openingCutScene();

        Player player = initPlayer();
        DungeonGame game = new DungeonGame(player);

        game.start();
    }

    private static Player initPlayer() {
        System.out.println("What's your name?");

        String playerName = GameWindow.printStringDialogBox();

        return new Player(playerName);
    }

    private static void openingCutScene() {
        String[] asciiArtCutScenes = AsciiArt.openingCutscenes();
        for (String scenes : asciiArtCutScenes) {
            try {
                GameWindow.printCutsceneWindow(scenes);
                Thread.sleep(3500);
            } catch (Exception _) {
            }
        }
    }
}
