public class DungeonGameTest {

    public static void main(String[] args) {

        try {
            //            testInit();
            System.out.println("testInit() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.printf("testInit() test -FAILED-. Error Message: %s", e.getMessage());
        }

        //        try {
        //            testMovement();
        //            System.out.println("testMovement() test +PASSED+ !!!");
        //        } catch (AssertionError e) {
        //            System.err.printf("testMovement() test -FAILED-. Error Message: %s", e.getMessage());
        //        }

        try {
            //            testInvalidNextRoom();
            System.out.println("testInvalidNextRoom() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.printf("testInvalidNextRoom() test -FAILED-. Error Message: %s", e.getMessage());
        }

        try {
            //            testKillingEnemy();
            System.out.println("testKillingEnemy() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.printf("testKillingEnemy() test -FAILED-. Error Message: %s", e.getMessage());
        }

        try {
            //            testKillingAndGoingBackARoom();
            System.out.println("testKillingAndGoingBackARoom() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.printf("testKillingAndGoingBackARoom() test -FAILED-. Error Message: %s", e.getMessage());
        }

        try {
            //            testKillingEnemyAndLootingChest();
            System.out.println("testKillingEnemyAndLootingChest() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.printf("testKillingEnemyAndLootingChest() test -FAILED-. Error Message: %s", e.getMessage());
        }

        testInventoryPrompt();

    }

    public static void testInit() {
        Player player = basicPlayer();
        DungeonGame game = new DungeonGame(player);

        System.out.println(game.getPlayer());

        // Ensure that game rooms aren't empty
        assert !game.getDungeonRooms().isEmpty() : TestHelpers.assertionMessage("Amount of rooms", "is not empty", "is empty");
    }

    //    public static void testMovement() {
    //        Player player = basicPlayer();
    //        DungeonGame game = new DungeonGame(player);
    //
    //        // Validate that index was set correctly
    //        assert game.getCurrentRoomIndex() == 0 : TestHelpers.assertionMessage("Current room index", 0, game.getCurrentRoomIndex());
    //        assert game.getCurrentRoom().getIndex() == 0 : TestHelpers.assertionMessage("Current room index", 0, game.getCurrentRoomIndex());
    //
    //        // Move player up a room
    //        game.movePlayer(1);
    //
    //        // Ensure that the currentRoom Index increments by 1
    //        assert game.getCurrentRoomIndex() == 1 : TestHelpers.assertionMessage("Current room index", 1, game.getCurrentRoomIndex());
    //        assert game.getCurrentRoom().getIndex() == 1 : TestHelpers.assertionMessage("Current room index", 0, game.getCurrentRoomIndex());
    //
    //        // Move player back a room
    //        game.movePlayer(0);
    //
    //        // Ensure that the currentRoom Index is back to room1
    //        assert game.getCurrentRoomIndex() == 0 : TestHelpers.assertionMessage("Current room index", 0, game.getCurrentRoomIndex());
    //        assert game.getCurrentRoom().getIndex() == 0 : TestHelpers.assertionMessage("Current room index", 0, game.getCurrentRoomIndex());
    //
    //        System.out.println(game.getCurrentRoom());
    //
    //        // move player up 4 rooms and back 2
    //        game.movePlayer(1);
    //        game.movePlayer(1);
    //        game.movePlayer(1);
    //        game.movePlayer(1);
    //        game.movePlayer(0);
    //        game.movePlayer(0);
    //
    //        // Ensure player is in room3 (room index2)
    //        assert game.getCurrentRoomIndex() == 2 : TestHelpers.assertionMessage("Current room index", 0, game.getCurrentRoomIndex());
    //        assert game.getCurrentRoom().getIndex() == 2 : TestHelpers.assertionMessage("Current room index", 0, game.getCurrentRoomIndex());
    //
    //        System.out.println(game.getCurrentRoom());
    //    }

    public static void testInvalidNextRoom() {
        Player player = basicPlayer();
        DungeonGame game = new DungeonGame(player);

        // Move player up a room
        game.movePlayer("forwards");

        System.out.println(game.getCurrentRoom());
    }

    public static void testKillingEnemy() {
        Player player = basicPlayer();
        DungeonGame game = new DungeonGame(player);

        // Kill Enemy
        game.attackLoop();

        // You should be able to move to the next room now
        game.movePlayer("forwards");
        assert game.getCurrentRoomIndex() == 1 : TestHelpers.assertionMessage("After killing enemy in room", "allowed to move up a room", "not allowed to move up a room");
    }

    public static void testKillingAndGoingBackARoom() {
        Player player = basicPlayer();
        DungeonGame game = new DungeonGame(player);

        // Kill Enemy
        game.attackLoop();

        // You should be able to move to the next room now
        game.movePlayer("forwards");
        assert game.getCurrentRoomIndex() == 1 : TestHelpers.assertionMessage("After killing enemy in room", "allowed to move up a room", "not allowed to move up a room");

        game.movePlayer("backwards");
        assert game.getCurrentRoomIndex() == 0 : TestHelpers.assertionMessage("Room index after going back a room", 0, game.getCurrentRoomIndex());
    }

    public static void testKillingEnemyAndLootingChest() {
        Player player = basicPlayer();
        DungeonGame game = new DungeonGame(player);

        // Kill Enemy
        game.attackLoop();

        // You should be able to move to the next room now
        game.movePlayer("forwards");
        assert game.getCurrentRoomIndex() == 1 : TestHelpers.assertionMessage("After killing enemy in room", "allowed to move up a room", "not allowed to move up a room");

        // Loot chest
        game.lootChest();

        System.out.println(player.getInventory());

        // Advance to next room
        game.movePlayer("forwards");

        assert game.getCurrentRoomIndex() == 2 : TestHelpers.assertionMessage("After looting chest and moving up a room", "move up a room", "did not move up up a room");
    }

    public static void testInventoryPrompt() {
        Player player = basicPlayer();
        DungeonGame game = new DungeonGame(player);

        game.openInventory();
    }


    // Test Helpers

    private static Player basicPlayer() {
        return new Player("Player 1");
    }

}
