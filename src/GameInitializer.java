import java.util.ArrayList;

/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

public class GameInitializer {

    public static ArrayList<DungeonRoom> dungeonRooms(int numberOfRooms) {
        ArrayList<DungeonRoom> rooms = new ArrayList<>();

        for (int i = 0; i < numberOfRooms; i++) {
            // Room Index
            int roomIndex = i;

            // Room Name
            int roomNumber = roomIndex + 1;
            String roomName = String.format("Room %s", roomNumber);

            // Room Enemy
            Enemy enemy = new Enemy("enemy", 50);

            // Room Chest
            TreasureChest treasureChest = new TreasureChest();

            DungeonRoom room = new DungeonRoom(roomIndex, roomName, enemy, treasureChest);
            rooms.add(room);
        }

        return rooms;
    }

}
