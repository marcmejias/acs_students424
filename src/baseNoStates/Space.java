package baseNoStates;

import java.util.ArrayList;

// A Space is a subcategory of Area that cannot have children of Area class (Partitions or Spaces), only doors
public class Space extends Area {
  protected ArrayList<Door> doors = new ArrayList<Door>();
  public Space(String id, Partition root, ArrayList<Door> doors) {
    super(id, root);
    this.doors = doors;
  }
  @Override
  public Space findAreaById(String id){
    if (this.id == id) {
      return this;
    }
    return null;
  }
  public ArrayList<Space> getSpaces() {
    ArrayList<Space> space = new ArrayList<Space>();
    space.add(this);
    return space;
  }
  public ArrayList<Door> getDoorsGivingAccess() {
    return doors;
  }
}
