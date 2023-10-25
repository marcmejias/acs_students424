package baseNoStates;

import java.util.ArrayList;

public abstract class Area {
    protected final String id;
    protected static Partition rootArea;
    protected ArrayList<Door> doors;

    public Area (String id, Partition root, ArrayList<Door> doors){
        this.id = id;
        rootArea = root;
        this.doors = doors;
        if (this.rootArea != null) {
            this.rootArea.addChild(this);
        }
    }
    public String getId() {
        return id;
    }
    // TODO implementar para fita 2
    public ArrayList<Door> getDoorsGivingAccess() {
        return null;
    }
    public abstract Area findAreaById(String id);
    public abstract ArrayList<Space> getSpaces();
}
