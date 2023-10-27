package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

// A Partition is a group of spaces or partitions, it has an Id and the Doors that belong in the Partition
public final class Partition extends Area{
    protected ArrayList<Area> children;
    //Important: Only Partition can have children, regardless if they are Partition or Space (therefore Area)
    public Partition(String id, Partition root) {
      super(id, root);
      children = new ArrayList<Area>();
  }
    public void addChild(Area child) {
      children.add(child);
    }
    public Area findAreaById(String id){
        if (this.id == id) {
            return this;
        }
        for (Area area : children) {
            Area res = area.findAreaById(id);
            if (res != null) {
                return res;
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
  public ArrayList<Door> getDoorsGivingAccess() {
      ArrayList<Door> doorList = new ArrayList<Door>();
      for (Area area : children) {
        doorList.addAll(area.getDoorsGivingAccess());
      }
      return doorList;
  }
  }
