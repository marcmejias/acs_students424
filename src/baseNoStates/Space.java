package baseNoStates;

import java.util.ArrayList;

// A Space is a subcategory of Area that cannot have children of Area class (Partitions or Spaces), only doors
public class Space extends Area {
  protected ArrayList<Door> doors = new ArrayList<Door>(); // Any space has at least a door, but some have more
  public Space(String id, Partition root) {
    super(id, root);
  }
  public Space findAreaById(String id){ // This function is usually called by findAreaById of Partition
    // if the space is correct it will return itself, otherwise do nothing
    if (this.id.equals(id)) {
      return this;
    }
    return null;
  }
  public ArrayList<Space> getSpaces() { // This functions returns the object itself, could use some tinkering
    ArrayList<Space> space = new ArrayList<Space>();
    space.add(this);
    return space;
  }
  public ArrayList<Door> getDoorsGivingAccess() {
    return doors;
  }
  public void addDoor(Door door) {
    doors.add(door);
  }
  public void acceptVisitor(Visitor visitor) {visitor.visitSpace(this);}
}
