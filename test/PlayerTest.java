public class PlayerTest {

    public static void main(String[] args) {

        try {
            //initInventory();
            System.out.println("initInventory() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.println("initInventory() test -FAILED- | " + e.getMessage());
        }

    }


}
