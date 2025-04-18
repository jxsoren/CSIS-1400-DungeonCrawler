public class DungeonRoomTest {

    public static void main(String[] args) {
        try {
            initRoom();
            System.out.println("initRoom() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.printf("initRoom() test -FAILED-. Error Message: %s", e.getMessage());
        }

    }

    private static void initRoom() {
        DungeonRoom room = basicRoom();

        System.out.println();
        System.out.println(room.toString());
        System.out.println();
    }

    private static DungeonRoom basicRoom() {
        int index = 0;
        String levelName = "First Level";
        Weapon weapon = new Weapon();
        Enemy enemy = new Enemy("Goblin", 10, weapon);
        TreasureChest treasureChest = new TreasureChest();

        return new DungeonRoom(index, levelName, enemy, treasureChest);
    }

}
