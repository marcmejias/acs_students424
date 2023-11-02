package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

// A Partition is a group of spaces or partitions, it has an Id and the Doors that belong in the Partition
public final class Partition extends Area {
    protected ArrayList<Area> children;
    //Only Partition can have children, regardless if they are Partition or Space (therefore the list are Area objects)
    public Partition(String id, Partition root) {
      super(id, root);
      children = new ArrayList<Area>();
    }
    public void addChild(Area child) {
      children.add(child);
    }
    public Area findAreaById(String id){
        // This function recursively travels through the Area tree to search for the given id
        if (this.id.equals(id)) {
            return this;
        }
        for (Area area : children) {
            Area aux = area.findAreaById(id);
            if (aux != null) {
                return aux;
            }
        }
        return null;
    }
    public ArrayList<Space> getSpaces() { // This function returns every children that is a Space
        ArrayList<Space> spaces = new ArrayList<Space>();
        for (Area space : children){
            spaces.addAll(space.getSpaces());
        }
        return spaces;
    }
  public ArrayList<Door> getDoorsGivingAccess() { // This function recursively travels through the Partition's children
        // and adds the set of Doors of every Space children
      ArrayList<Door> doorList = new ArrayList<Door>();
      for (Area area : children) {
        doorList.addAll(area.getDoorsGivingAccess());
      }
      return doorList;
  }
}
