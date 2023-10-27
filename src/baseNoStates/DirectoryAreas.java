package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public final class DirectoryAreas { // This class manages all Doors and Areas, and by extension, Spaces and Partitions
    private static ArrayList<Door> allDoors; // List of all doors in the building
    public static Partition rootArea; // Root of the tree, also known as building

    public static void makeAreas(){ // This function creates all Spaces and Partitions
        /*
        //root
        Partition building = new Partition("building", null);
        rootArea = building;

        //independent
        ArrayList<Door> stair = new ArrayList<>(Arrays.asList(allDoors.get(1), allDoors.get(3), allDoors.get(6)));
        Space stairs = new Space("stairs", building, stair);
        ArrayList<Door> ext = new ArrayList<>(Arrays.asList(allDoors.get(0), allDoors.get(2)));
        Space exterior = new Space("exterior", building, ext);

        //partitions
        //ArrayList<Door> base = new ArrayList<>(Arrays.asList(allDoors.get(0), allDoors.get(1)));
        Partition basement = new Partition("basement", building);
        //ArrayList<Door> gf = new ArrayList<>(Arrays.asList(allDoors.get(2), allDoors.get(3), allDoors.get(4), allDoors.get(5)));
        Partition ground_floor = new Partition("ground_floor", building);
        //ArrayList<Door> f1 = new ArrayList<>(Arrays.asList(allDoors.get(6), allDoors.get(7), allDoors.get(8)));
        Partition floor_1 = new Partition("floor1", building);

        // basement
        ArrayList<Door> park = new ArrayList<>(Arrays.asList(allDoors.get(0), allDoors.get(1)));
        Space parking = new Space("parking", basement, park);
        System.out.print(parking.getId());
        allDoors.get(0).setFromSpace(exterior);
        allDoors.get(0).setToSpace(parking);
        allDoors.get(1).setFromSpace(stairs);
        allDoors.get(1).setToSpace(parking);

        // ground_floor
        ArrayList<Door> hal = new ArrayList<>(Arrays.asList(allDoors.get(2), allDoors.get(3)));
        Space hall = new Space("hall", ground_floor, hal);
        allDoors.get(2).setFromSpace(exterior);
        allDoors.get(2).setToSpace(hall);
        allDoors.get(3).setFromSpace(stairs);
        allDoors.get(3).setToSpace(hall);
        ArrayList<Door> room1 = new ArrayList<>(Arrays.asList(allDoors.get(4)));
        Space room_1 = new Space("room1", ground_floor, room1);
        allDoors.get(4).setFromSpace(hall);
        allDoors.get(4).setToSpace(room_1);
        ArrayList<Door> room2 = new ArrayList<>(Arrays.asList(allDoors.get(5)));
        Space room_2 = new Space("room2", ground_floor, room2);
        allDoors.get(5).setFromSpace(hall);
        allDoors.get(5).setToSpace(room_2);

        // first floor
        ArrayList<Door> cor = new ArrayList<>(Arrays.asList(allDoors.get(6)));
        Space corridor = new Space("corridor", floor_1, cor);
        allDoors.get(6).setFromSpace(stairs);
        allDoors.get(6).setToSpace(corridor);
        ArrayList<Door> room3 = new ArrayList<>(Arrays.asList(allDoors.get(7)));
        Space room_3 = new Space("room3", floor_1, room3);
        allDoors.get(7).setFromSpace(corridor);
        allDoors.get(7).setToSpace(room_3);
        ArrayList<Door> it = new ArrayList<>(Arrays.asList(allDoors.get(8)));
        Space IT = new Space("IT", floor_1, it);
        allDoors.get(8).setFromSpace(corridor);
        allDoors.get(8).setToSpace(IT);

        //adding children to every Partition
        basement.addChild(parking);
        basement.addChild(stairs);
        ground_floor.addChild(hall);
        ground_floor.addChild(room_1);
        ground_floor.addChild(room_2);
        ground_floor.addChild(stairs);
        floor_1.addChild(corridor);
        floor_1.addChild(room_3);
        floor_1.addChild(IT);
        floor_1.addChild(stairs);
        rootArea.addChild(exterior);
        rootArea.addChild(basement);
        rootArea.addChild(ground_floor);
        rootArea.addChild(floor_1);*/
        rootArea = new Partition("building", null);
        Space exterior = new Space("exterior", rootArea);
        Space stairs = new Space("stairs", rootArea);

        // basement con hijos y puertas
        Partition basement = new Partition("basement", rootArea);
        Space parking = new Space("parking", basement);
        Door d1 = new Door("D1", exterior, parking);
        Door d2 = new Door("D2",  stairs, parking);

        //ground floor con hijos y puertas
        Partition groundFloor = new Partition("ground_floor", rootArea);
        Space hall = new Space("hall", groundFloor);
        Space room1 = new Space("room1", groundFloor);
        Space room2 = new Space("room2", groundFloor);
        Door d3 = new Door("D3",exterior, hall);
        Door d4 = new Door("D4", stairs, hall);
        Door d5 = new Door("D5",hall, room1);
        Door d6 = new Door("D6",hall, room2);

        // first floor con hijos y puertas
        Partition floor1 = new Partition("floor1", rootArea);
        Space corridor = new Space("corridor", floor1);
        Space room3 = new Space("room3", floor1);
        Space IT = new Space("IT", floor1);
        Door d7 = new Door("D7",stairs, corridor);
        Door d8 = new Door("D8",corridor, room3);
        Door d9 = new Door("D9",corridor, IT);

        allDoors = new ArrayList<>(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9));
    }
    /*
    public static void makeDoors() { // This function creates all doors
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
    }*/
    public static Area findAreaById(String id){
        Area area = rootArea.findAreaById(id);
        //System.out.print("Is area:" + area.getId() + area.getSpaces().toString() +  " ");
        if (area == null) {
            System.out.println("Area not valid: " + id);
            return null;
        } else
            return area;
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
}
