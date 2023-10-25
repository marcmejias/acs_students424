package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

// A Partition is a group of spaces or partitions, it has an Id and the Doors that belong in the Partition
public final class Partition extends Area{
    protected ArrayList<Area> children;
    public Partition(String id, Partition root, ArrayList<Door> doors) {
      super(id, root, doors);
  }
    public void addChild(Area child) {
      children.add(child);
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