package baseNoStates;

import java.util.ArrayList;

public abstract class Area {
    protected final String id;
    protected static Area rootArea;
    protected ArrayList<Door> doors;
    protected ArrayList<Area> children;
    public Area (String id, Area root, ArrayList<Door> doors){
        this.id = id;
        rootArea = root;
        this.doors = doors;
        if (this.rootArea != null) {
            this.rootArea.addChild(this);
        }
    }

    public ArrayList<Door> getDoorsGivingAccess() {
        return null;
    }
    public static Area findAreaById(String id){
        return rootArea.findAreaById(id); // an Area or null if not found
    }
    public String getId() {return id;}
    public void addChild(Area child) {
        children.add(child);
    }
    public ArrayList<Space> getSpaces() {
        ArrayList<Space> spaces = null;
        for (Area space : area){
            if(space.rootArea.getId() == id){
                spaces.add(space);
            }
        }
        return spaces;
    }
}
