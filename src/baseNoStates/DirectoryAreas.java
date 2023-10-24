package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public final class DirectoryAreas {
    private static ArrayList<Door> allDoors;
    public static Area rootArea;

    public static void makeAreas(){
        //root
        Partition building = new Partition("building", null, null);
        rootArea = building;

        //independent
        Space stairs = new Space("stairs", building, null);
        Space exterior = new Space("exterior", building, null);

        //partitions
        ArrayList<Door> base = new ArrayList<>(Arrays.asList(allDoors.get(0), allDoors.get(1)));
        Partition basement = new Partition("basement", building, base);
        ArrayList<Door> gf = new ArrayList<>(Arrays.asList(allDoors.get(2), allDoors.get(3), allDoors.get(4), allDoors.get(5)));
        Partition ground_floor = new Partition("ground floor", building, gf);
        ArrayList<Door> f1 = new ArrayList<>(Arrays.asList(allDoors.get(6), allDoors.get(7), allDoors.get(8)));
        Partition floor_1 = new Partition("floor 1", building, f1);

        // basement
        ArrayList<Door> park = new ArrayList<>(Arrays.asList(allDoors.get(0), allDoors.get(1)));
        Space parking = new Space("parking", basement, park);
        allDoors.get(0).setFromSpace(null);
        allDoors.get(0).setToSpace(parking);
        allDoors.get(1).setFromSpace(stairs);
        allDoors.get(1).setToSpace(parking);

        // ground floor
        ArrayList<Door> hal = new ArrayList<>(Arrays.asList(allDoors.get(2), allDoors.get(3)));
        Space hall = new Space("hall", ground_floor, hal);
        allDoors.get(2).setFromSpace(exterior);
        allDoors.get(2).setToSpace(hall);
        allDoors.get(3).setFromSpace(stairs);
        allDoors.get(3).setToSpace(hall);
        ArrayList<Door> room1 = new ArrayList<>(Arrays.asList(allDoors.get(4)));
        Space room_1 = new Space("room 1", ground_floor, room1);
        allDoors.get(4).setFromSpace(hall);
        allDoors.get(4).setToSpace(room_1);
        ArrayList<Door> room2 = new ArrayList<>(Arrays.asList(allDoors.get(5)));
        Space room_2 = new Space("room 2", ground_floor, room2);
        allDoors.get(5).setFromSpace(hall);
        allDoors.get(5).setToSpace(room_2);

        // first floor
        ArrayList<Door> cor = new ArrayList<>(Arrays.asList(allDoors.get(6)));
        Space corridor = new Space("corridor", floor_1, cor);
        allDoors.get(6).setFromSpace(stairs);
        allDoors.get(6).setToSpace(corridor);
        ArrayList<Door> room3 = new ArrayList<>(Arrays.asList(allDoors.get(7)));
        Space room_3 = new Space("room 3", floor_1, room3);
        allDoors.get(7).setFromSpace(corridor);
        allDoors.get(7).setToSpace(room_3);
        ArrayList<Door> it = new ArrayList<>(Arrays.asList(allDoors.get(8)));
        Space IT = new Space("IT", floor_1, it);
        allDoors.get(8).setFromSpace(corridor);
        allDoors.get(8).setToSpace(IT);
    }
    public static void makeDoors() {
        // basement
        Door d1 = new Door("D1"); // exterior, parking
        Door d2 = new Door("D2"); // stairs, parking

        // ground floor
        Door d3 = new Door("D3"); // exterior, hall
        Door d4 = new Door("D4"); // stairs, hall
        Door d5 = new Door("D5"); // hall, room1
        Door d6 = new Door("D6"); // hall, room2

        // first floor
        Door d7 = new Door("D7"); // stairs, corridor
        Door d8 = new Door("D8"); // corridor, room3
        Door d9 = new Door("D9"); // corridor, IT

        allDoors = new ArrayList<>(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9));
        //independent
        Space stairs = new Space("stairs", rootArea, null);
        Space exterior = new Space("exterior", rootArea, null);
    }
    public static Area findAreaById(String id){
        return rootArea.findAreaById(id); // an Area or null if not found
    }
    public static Door findDoorById(String id) {
        for (Door door : allDoors) {
            if (door.getId().equals(id)) {
                return door;
            }
        }
        System.out.println("door with id " + id + " not found");
        return null; // otherwise we get a Java error
    }
    public static ArrayList<Door> getAllDoors() {
        return allDoors;
    }
    public static void setAllDoors(ArrayList<Door> allDoors) {
        DirectoryAreas.allDoors = allDoors;
    }
}
