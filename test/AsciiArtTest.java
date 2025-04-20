public class AsciiArtTest {
    public static void main(String[] args) {
        testArt();
    }
    private static void testArt(){
        System.out.println("Testing Art");
        String[] art = {"goblin", "chest", "sword", "potion", "door", "spider", "entrance"};
        for(String s : art){
            System.out.println("\n" + AsciiArt.asciiArtFactory(s) + "\n");
        }

    }
}
