public class DungeonGameTest {

    public static void main(String[] args) {
        try {
            initRoom();
            System.out.println("initRoom() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.printf("initRoom() test -FAILED-. Error Message: %s", e.getMessage());

        }
    }

    private static void initRoom() {
        DungeonRoom room = new DungeonRoom("First Level");


    }

}
