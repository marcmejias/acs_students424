package base.no_states;

import java.util.ArrayList;

// A Space is a subcategory of Area that cannot have children of Area class (Partitions or Spaces), only doors
public class Space extends Area {
  protected ArrayList<Door> doors = new ArrayList<Door>(); // Any space has at least a door, but some have more

  public Space(String id, Partition root) {
    super(id, root);
  }
  public ArrayList<Door> getDoorsGivingAccess() {
    return doors;
  }
  public void addDoor(Door door) {
    doors.add(door);
  }
  public void acceptVisitor(Visitor visitor) {visitor.visitSpace(this);}
}
