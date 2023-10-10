package baseNoStates;

import java.util.ArrayList;

public abstract class Area {
    protected final String id;
    protected static Area rootArea;
    protected ArrayList<Door> doors;
    public Area (String id, Area root, ArrayList<Door> doors){
        this.id = id;
        rootArea = root;
        this.doors = doors;
    }

    public Door[] getDoorsGivingAccess() {
        return null;
    }
    public static Area findAreaById(String id){
        return rootArea.findAreaById(id); // an Area or null if not found
    }
    public Space[] getSpaces() {
        return null;
    }
}
