import java.util.ArrayList;

public class TreasureChestTest {
    public static void main(String[] args) {

        try {
            validateChest();
            System.out.println("validateChest() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.printf("validateChest() test -FAILED-. Error Message: %s", e.getMessage());
        }

        try {
            testTakingThings();
            System.out.println("testTakingWeapon() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.printf("testTakingWeapon() test -FAILED-. Error Message: %s", e.getMessage());
        }

    }

    public static void validateChest() {
        // Parameterless constructor call (random items)
        TreasureChest treasureChest = new TreasureChest();

        // Ensure chest contains no more than 1 weapon
        int weaponCount = treasureChest.getWeapons().size();
        assert weaponCount <= 1 : TestHelpers.assertionMessage("Treasure Chest weapons", "<= 1", weaponCount);

        // Ensure chest contains 1 or more items
        int itemsCount = treasureChest.getItems().size();
        assert itemsCount >= 1 && itemsCount <= 3 : TestHelpers.assertionMessage("Treasure Chest items", ">= 1 && <= 3", itemsCount);
    }

    public static void testTakingThings() {
        // Initialize Items
        Item item1 = new Item();
        Item item2 = new Item();

        ArrayList<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        // Initialize Weapons
        Weapon sword1 = new Weapon();

        ArrayList<Weapon> weapons = new ArrayList<>();
        weapons.add(sword1);

        // Initialize Treasure Chest w/ parameterized constructor
        TreasureChest treasureChest = new TreasureChest(weapons, items);

        System.out.println();
        System.out.println(treasureChest.toString());
        System.out.println();

        // -- Start of tests --

        // Take weapon from chest
        Weapon chosenWeapon = treasureChest.takeWeapon(0);

        // Ensure the correct weapon was returned
        assert chosenWeapon == sword1 : TestHelpers.assertionMessage("Taken Treasure Chest Weapon", sword1.toString(), chosenWeapon.toString());

        System.out.println();
        System.out.println(treasureChest.toString());
        System.out.println();

        // Ensure that the weapon was removed from the chest
        assert weapons.isEmpty() : TestHelpers.assertionMessage("Treasure Chest Weapons", "empty", "not empty");

        // Take item from chest
        Item chosenItem = treasureChest.takeItem(0);

        System.out.println();
        System.out.println(treasureChest.toString());
        System.out.println();

        // Ensure that the item was removed from the chest
        assert chosenItem == item1 : TestHelpers.assertionMessage("Taken Treasure Chest Item", item1.toString(), chosenItem.toString());

        // Ensure that the weapon was removed from the chest
        int itemsCount = treasureChest.getItems().size();
        assert itemsCount == 1 : TestHelpers.assertionMessage("Treasure Chest Items", 1, itemsCount);
    }

}
