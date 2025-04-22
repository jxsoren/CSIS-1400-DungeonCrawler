/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
        Player player = initPlayer();
        DungeonGame game = new DungeonGame(player);

        game.start();
    }

    private static Player initPlayer() {
        Scanner input = new Scanner(System.in);

        System.out.print("What's your name? ");
        String playerName = input.nextLine();

        return new Player(playerName);
    }
}
