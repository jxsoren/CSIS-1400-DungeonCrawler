public class TestHelpers {

    public static String assertionMessage(String subject, String expectedValue, String actualValue) {
        return String.format("%s is expected to be %s, but is actually %s", subject, expectedValue, actualValue);
    }

    public static String assertionMessage(String subject, int expectedValue, int actualValue) {
        return String.format("%s is expected to be %s, but is actually %s", subject, expectedValue, actualValue);
    }

    public static String assertionMessage(String subject, boolean expectedValue, boolean actualValue) {
        return String.format("%s is expected to be %s, but is actually %s", subject, expectedValue, actualValue);
    }

    public static String assertionMessage(String expectedSubject, String expression, int actualValue) {
        return String.format("%s is expected to be %s, but is actually %s", expectedSubject, expression, actualValue);
    }

}
