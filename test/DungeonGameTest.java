public class DungeonGameTest {

    public static void main(String[] args) {

        try {
            //exampleMethod();
            System.out.println("exampleMethod() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.printf("exampleMethod() test -FAILED-. Error Message: %s", e.getMessage());

        }
    }

}
