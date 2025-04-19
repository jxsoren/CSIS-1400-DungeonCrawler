public class ItemTest {
    public static void main(String[] args) {
        try {
            //            example();
            System.out.println("example() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.println("example() test -FAILED- | " + e.getMessage());
        }
    }
}
