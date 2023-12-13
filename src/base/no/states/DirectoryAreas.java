package base.no.states;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Arrays;

public final class DirectoryAreas {
    // This class manages all Doors and Areas, and by extension,
    // Spaces and Partitions
    private DirectoryAreas() { }
    // List of all doors in the building
    private static ArrayList<Door> allDoors;
    // Root of the tree, also known as building
    private static Partition rootArea;
    private static final Logger LOGGER = LoggerFactory.getLogger("Fita1");
    // This function creates all Spaces and Partitions
    public static void makeAreas() {
        //root
        rootArea = new Partition("building", null);
        //independent
        Space exterior = new Space("exterior", rootArea);
        Space stairs = new Space("stairs", rootArea);
        // basement
        Partition basement = new Partition("basement", rootArea);
        Space parking = new Space("parking", basement);
        Door d1 = new Door("D1", exterior, parking);
        Door d2 = new Door("D2",  stairs, parking);
        // ground_floor
        Partition groundFloor = new Partition("ground_floor", rootArea);
        Space hall = new Space("hall", groundFloor);
        Space room1 = new Space("room1", groundFloor);
        Space room2 = new Space("room2", groundFloor);
        Door d3 = new Door("D3", exterior, hall);
        Door d4 = new Door("D4", stairs, hall);
        Door d5 = new Door("D5", hall, room1);
        Door d6 = new Door("D6", hall, room2);
        // first_floor
        Partition floor1 = new Partition("floor1", rootArea);
        Space corridor = new Space("corridor", floor1);
        Space room3 = new Space("room3", floor1);
        Space iT = new Space("IT", floor1);
        Door d7 = new Door("D7", stairs, corridor);
        Door d8 = new Door("D8", corridor, room3);
        Door d9 = new Door("D9", corridor, iT);
        // and we add all created doors to a list so
        // we can have easier access to all of them
        allDoors = new ArrayList<>(Arrays.asList(d1, d2, d3, d4,
            d5, d6, d7, d8, d9));
    }
    public static Door findDoorById(final String id) {
        // This function travels the allDoors list
        // to find the door with the matching id
        for (Door door : allDoors) {
            if (door.getId().equals(id)) {
                return door;
            }
        }
        LOGGER.info("door with id {} not found",  id);
        return null; // otherwise we get a Java error
    }
    public static Area findAreaById(final String id) {
        if (id.equals("ROOT")) {
            // Special id that means that the wanted area is the root.
            // This is because the Flutter app client doesn't know the
            // id of the root, differently from the simulator
            return rootArea;
        } else {
            VisitorFindAreaById v = new VisitorFindAreaById(rootArea, id);
            return v.getResult();
        }
    }
    public static ArrayList<Door> getAllDoors() {
        return allDoors;
    }
    public static Partition getRootArea() {
        return rootArea;
    }
}
