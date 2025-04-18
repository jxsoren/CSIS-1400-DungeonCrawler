public class DungeonGameTest {

    public static void main(String[] args) {

        try {
            testInit();
            System.out.println("testInit() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.printf("testInit() test -FAILED-. Error Message: %s", e.getMessage());
        }

        try {
            testMovement();
            System.out.println("testMovement() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.printf("testMovement() test -FAILED-. Error Message: %s", e.getMessage());
        }
    }

    public static void testInit() {
        Player player = basicPlayer();
        DungeonGame game = new DungeonGame(player);

        System.out.println(game.getPlayer());

        // Ensure that game rooms aren't empty
        assert !game.getDungeonRooms().isEmpty() : TestHelpers.assertionMessage("Amount of rooms", "is not empty", "is empty");
    }

    public static void testMovement() {
        Player player = basicPlayer();
        DungeonGame game = new DungeonGame(player);

        // Validate that index was set correctly
        assert game.getCurrentRoomIndex() == 0 : TestHelpers.assertionMessage("Current room index", 0, game.getCurrentRoomIndex());

        // Move player up a room
        game.movePlayer(1);

        // Ensure that the currentRoom Index increments by 1
        assert game.getCurrentRoomIndex() == 1 : TestHelpers.assertionMessage("Current room index", 1, game.getCurrentRoomIndex());

        // Move player back a room
        game.movePlayer(0);

        // Ensure that the currentRoom Index is back to room1
        assert game.getCurrentRoomIndex() == 0 : TestHelpers.assertionMessage("Current room index", 0, game.getCurrentRoomIndex());

        // move player up 4 rooms and back 2
        game.movePlayer(1);
        game.movePlayer(1);
        game.movePlayer(1);
        game.movePlayer(1);
        game.movePlayer(0);
        game.movePlayer(0);

        // Ensure player is in room3 (room index2)
        assert game.getCurrentRoomIndex() == 2 : TestHelpers.assertionMessage("Current room index", 0, game.getCurrentRoomIndex());
    }

    // Test Helpers

    private static Player basicPlayer() {
        return new Player("Player 1");
    }

}
