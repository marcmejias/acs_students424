package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public final class DirectoryAreas {
    private static ArrayList<Door> allDoors;
    private Area rootArea;

    public void makeAreas(){
        //root
        Area a0 = new Space("building", null);
        rootArea = a0;
        Partition p1 = new Partition("basement", a0);
        Partition p2 = new Partition("ground floor", a0);
        Partition p3 = new Partition("floor 1", a0);

        // basement
        Area a1 = new Space("parking", p1);

        // ground floor
        Area a2 = new Space("hall", p2);
        Area a3 = new Space("room 1", p2);
        Area a4 = new Space("room 2", p2);

        // first floor
        Area a5 = new Space("room 3", p3);
        Area a6 = new Space("corridor", p3);
        Area a7 = new Space("IT", p3);

        //independent
        Area a8 = new Space("stairs", a0);
        Area a9 = new Space("exterior", a0);
    }
    /*
    public static Area findAreaById(String id){
        return rootArea.findAreaById(id); // an Area or null if not found
    }
    */
    public static Door findDoorById(String id) {
        for (Door door : allDoors) {
            if (door.getId().equals(id)) {
                return door;
            }
        }
        System.out.println("door with id " + id + " not found");
        return null; // otherwise we get a Java error
    }
    public ArrayList<Door> getAllDoors(){
        return allDoors;
    }
}
