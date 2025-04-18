public class ConsumableTest {
    public static void main(String[] args) {
        try {
            //            example();
            System.out.println("example() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.printf("example() test -FAILED-. Error Message: %s", e.getMessage());
        }
    }
}
