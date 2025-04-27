/**********************************************
 * Author(s): Josh Sorensen & Bowen Berthelson
 *
 * Assignment: CSIS 1400 Final Project
 ***********************************************/

import java.util.ArrayList;

public class GameInitializer {
    static final int numberOfRooms = 2;

    public static ArrayList<DungeonRoom> initDungeonRooms() {
        ArrayList<DungeonRoom> rooms = new ArrayList<>();

        for (int i = 0; i < numberOfRooms; i++) {
            DungeonRoom room = DungeonRoom.createDungeonRoom(i + 1);
            rooms.add(room);
        }

        return rooms;
    }

}
