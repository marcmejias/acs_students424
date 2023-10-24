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

    // TODO implementar para fita 2
    public ArrayList<Door> getDoorsGivingAccess() {
        return null;
    }
    public Area findAreaById(String id){
        if (this.id == id){
            return this;
        } else {
            for (Area area : children){
                return area.findAreaById(id);
            }

        }
        return null;
    }
    public String getId() {return id;}
    public void addChild(Area child) {
        children.add(child);
    }
    public ArrayList<Space> getSpaces() {
        ArrayList<Space> spaces = null;
        for (Area space : children){
            if(space.rootArea.getId() == id){
                spaces.add((Space) space);
            }
        }
        return spaces;
    }
}
