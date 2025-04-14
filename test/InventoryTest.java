import java.util.Objects;

// Be sure to enable assertions via CLI args 'java -ea InventoryTest'
// or
// within your IDE's settings for your Java VM

public class InventoryTest {
    public static void main(String[] args) {
        // Need to catch AssertionError exception to see messages for failed tests

        try {
            initInventory();
            System.out.println("initInventory() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.println("initInventory() test -FAILED- | " + e.getMessage());
        }

        try {
            tooManyWeapons();
            System.out.println("tooManyWeapons() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.println("tooManyWeapons() test -FAILED- | " + e.getMessage());
        }

        try {
            weaponsTooHeavy();
            System.out.println("weaponsTooHeavy() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.println("weaponsTooHeavy() test -FAILED- | " + e.getMessage());
        }

        try {
            tooManyItems();
            System.out.println("tooManyItems() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.println("tooManyItems() test -FAILED- | " + e.getMessage());
        }

        try {
            itemsTooHeavy();
            System.out.println("itemsTooHeavy() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.println("itemsTooHeavy() test -FAILED- | " + e.getMessage());
        }

        try {
            dropWeapon();
            System.out.println("dropWeapon() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.println("dropWeapon() test -FAILED- | " + e.getMessage());
        }

        try {
            dropItem();
            System.out.println("dropItem() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.println("dropItem() test -FAILED- | " + e.getMessage());
        }

        try {
            inventoryFlow();
            System.out.println("inventoryFlow() test +PASSED+ !!!");
        } catch (AssertionError e) {
            System.err.println("inventoryFlow() test -FAILED- | " + e.getMessage());
        }

    }

    public static void initInventory() {
        Inventory inventory = new Inventory();

        // Weapons
        Weapon sword1 = new Weapon("Sword 1", 10, 10);
        Weapon sword2 = new Weapon("Sword 2", 10, 10);

        // Items
        Item item1 = new Item("Potion 1", 10, 10);
        Item item2 = new Item("Potion 2", 10, 10);
        Item item3 = new Item("Potion 3", 10, 10);
        Item item4 = new Item("Potion 4", 10, 10);
        Item item5 = new Item("Potion 5", 10, 10);

        // Add Weapons and Items to Inventory
        inventory.addWeapon(sword1);
        inventory.addWeapon(sword2);

        inventory.addItem(item1);
        inventory.addItem(item2);
        inventory.addItem(item3);
        inventory.addItem(item4);
        inventory.addItem(item5);

        // Assert correct Weapon and Item sizes
        assert inventory.getWeapons().size() == 2 : "Inventory should only have 2 weapons";
        assert inventory.getItems().size() == 5 : "Inventory should only have 5 weapons";

        // Assert that Weapons and Items were added correctly
        assert Objects.equals(inventory.getWeapon(0).getName(), "Sword 1") : "weapons[0] should be 'Sword 1'";
        assert Objects.equals(inventory.getWeapon(1).getName(), "Sword 2") : "weapons[1] should be 'Sword 2'";

        assert Objects.equals(inventory.getItem(0).getName(), "Potion 1") : "items[0] should be 'Potion 1'";
        assert Objects.equals(inventory.getItem(1).getName(), "Potion 2") : "items[1] should be 'Potion 2'";
        assert Objects.equals(inventory.getItem(2).getName(), "Potion 3") : "items[2] should be 'Potion 3'";
        assert Objects.equals(inventory.getItem(3).getName(), "Potion 4") : "items[3] should be 'Potion 4'";
        assert Objects.equals(inventory.getItem(4).getName(), "Potion 5") : "items[4] should be 'Potion 5'";
    }

    // When too many weapons are added
    public static void tooManyWeapons() {
        Inventory inventory = new Inventory();
        int maxWeaponSize = 3;
        inventory.setMaxInventoryWeight(100);
        inventory.setMaxWeaponSize(maxWeaponSize);

        // Valid amount of Weapons
        Weapon sword1 = new Weapon("Sword 1", 10, 10);
        Weapon sword2 = new Weapon("Sword 2", 10, 10);
        Weapon sword3 = new Weapon("Sword 3", 10, 10);

        // Add valid amount of Weapons to Inventory
        inventory.addWeapon(sword1);
        inventory.addWeapon(sword2);
        inventory.addWeapon(sword3);

        // Assert that only 3 weapons were added
        assert inventory.getWeapons().size() == maxWeaponSize : "Inventory should have " + maxWeaponSize + " weapons";

        // Try to add Weapon that's over Weapons capacity
        Weapon sword4 = new Weapon("Sword 4", 10, 10);
        inventory.addWeapon(sword4);

        // Assert that the Weapon over Weapons capacity wasn't added
        assert inventory.getWeapons().size() == maxWeaponSize : "Inventory should have " + maxWeaponSize + " weapons after trying to add one over the limit";
    }

    // When too many weapons are added
    public static void weaponsTooHeavy() {
        Inventory inventory = new Inventory();
        int maxInventoryWeight = 100;
        inventory.setMaxInventoryWeight(maxInventoryWeight);
        inventory.setMaxWeaponSize(3);

        // Add weapons within weight limit
        Weapon sword1 = new Weapon("Sword 1", 10, 40);
        Weapon sword2 = new Weapon("Sword 2", 10, 40);
        inventory.addWeapon(sword1);
        inventory.addWeapon(sword2);

        // Add weapon that will surpass weight limit
        Weapon sword3 = new Weapon("Sword 3", 10, 21);
        inventory.addWeapon(sword3);

        // Assert that the Weapon over Weapons capacity wasn't added
        assert inventory.getWeapons().size() == 2 : "Inventory should only have " + 2 + " weapons after trying to add one over the weight limit";
    }

    // When too many items are added
    public static void tooManyItems() {
        Inventory inventory = new Inventory();
        int maxItemsSize = 5;
        inventory.setMaxItemSize(maxItemsSize);
        inventory.setMaxInventoryWeight(100);

        // Add valid number of items
        Item item1 = new Item("Potion 1", 10, 10);
        Item item2 = new Item("Potion 2", 10, 10);
        Item item3 = new Item("Potion 3", 10, 10);
        Item item4 = new Item("Potion 4", 10, 10);
        Item item5 = new Item("Potion 5", 10, 10);

        inventory.addItem(item1);
        inventory.addItem(item2);
        inventory.addItem(item3);
        inventory.addItem(item4);
        inventory.addItem(item5);

        // Ensure items were added
        assert inventory.getItems().size() == maxItemsSize : "Inventory should have " + maxItemsSize + " items";

        // Try to add Weapon that's over Weapons capacity
        Item item6 = new Item("Potion 6", 10, 10);
        inventory.addItem(item6);

        // Assert that the Weapon over Weapons capacity wasn't added
        assert inventory.getItems().size() == maxItemsSize : "Inventory should have " + maxItemsSize + " items after trying to add one over the limit";
    }

    // When too many items are added
    public static void itemsTooHeavy() {
        Inventory inventory = new Inventory();
        inventory.setMaxItemSize(6);
        int maxInventoryWeight = 100;
        inventory.setMaxInventoryWeight(maxInventoryWeight);

        // Add items w/ valid weight
        Item item1 = new Item("Potion 1", 10, 20);
        Item item2 = new Item("Potion 2", 10, 20);
        Item item3 = new Item("Potion 3", 10, 20);
        Item item4 = new Item("Potion 4", 10, 20);
        Item item5 = new Item("Potion 5", 10, 20);

        inventory.addItem(item1);
        inventory.addItem(item2);
        inventory.addItem(item3);
        inventory.addItem(item4);
        inventory.addItem(item5);

        // Ensure items were added and are less than the max weight
        assert inventory.getItems().size() == 5 : "Inventory should have " + 5 + " items";
        assert inventory.currentWeight() <= maxInventoryWeight : "Inventory weight should be less than than or equal to the max inventory weight of " + maxInventoryWeight + " but the current inventory weight is " + inventory.currentWeight();

        // Try to add Weapon that's over Weapons capacity
        Item item6 = new Item("Potion 6", 10, 10);
        inventory.addItem(item6);

        // Ensure item that would overflow weight limit isn't added
        assert inventory.getItems().size() == 5 : "Inventory should have " + 5 + " items after trying to add one over the weight limit";
    }

    public static void dropWeapon() {
        Inventory inventory = new Inventory();

        // Add weapons
        Weapon weapon1 = new Weapon("Sword 1", 10, 25);
        Weapon weapon2 = new Weapon("Sword 2", 10, 25);
        inventory.addWeapon(weapon1);
        inventory.addWeapon(weapon2);

        // Drop a single weapon
        inventory.dropWeapon(0);

        assert inventory.getWeapons().size() == 1 : "After dropping a weapon, Weapon count should be 1, but is " + inventory.getWeapons().size();
    }

    public static void dropItem() {
        Inventory inventory = new Inventory();

        // Add Items
        Item item1 = new Item("Potion 1", 10, 10);
        Item item2 = new Item("Potion 2", 10, 10);
        inventory.addItem(item1);
        inventory.addItem(item2);

        // Drop a single item
        inventory.dropItem(0);

        assert inventory.getItems().size() == 1 : "After dropping an item, Item count should be 1, but is " + inventory.getItems().size();
    }

    public static void inventoryFlow() {
        Inventory inventory = new Inventory();
        inventory.setMaxWeaponSize(3);
        inventory.setMaxItemSize(5);
        inventory.setMaxInventoryWeight(100);

        // Add Weapons and Items that are within the max inventory weight and size
        Weapon sword1 = new Weapon("Sword 1", 25, 10);
        Weapon sword2 = new Weapon("Sword 2", 25, 10);

        inventory.addWeapon(sword1);
        inventory.addWeapon(sword2);

        Item item1 = new Item("Potion 1", 10, 5);
        Item item2 = new Item("Potion 2", 10, 5);
        Item item3 = new Item("Potion 3", 10, 5);

        inventory.addItem(item1);
        inventory.addItem(item2);
        inventory.addItem(item3);

        // Ensure items were added correctly
        assert inventory.getWeapons().size() == 2 : "Inventory should have 2 weapons";
        assert inventory.getItems().size() == 3 : "Inventory should have 3 items";

        // Add valid weapon
        Weapon sword3 = new Weapon("Sword 3", 25, 10);
        inventory.addWeapon(sword3);

        // Ensure 3rd weapon was added
        assert inventory.getWeapons().size() == 3 : "Inventory should be 3 after adding a weapon";

        // Total weight should be 45
        Item item4 = new Item("Potion 3", 10, 5);
        Item item5 = new Item("Really Heavy Potion", 10, 99);

        inventory.addItem(item4);
        inventory.addItem(item5);

        // item4 should get added, but not item5 due to weight overage
        assert inventory.getItems().size() == 4 : "Inventory should only have 4 items";
        assert !inventory.getItems().contains(item5) : "Item that was over the weight limit shouldn't have been added";

        // Inventory should have 3/3 weapons, drop one weapon, so that you can add another
        inventory.dropWeapon(0);
        Weapon sword4 = new Weapon("Sword 4", 25, 10);
        inventory.addWeapon(sword4);

        assert inventory.getWeapons().contains(sword4) : "Inventory should contain sword4, but doesn't";
    }

}
