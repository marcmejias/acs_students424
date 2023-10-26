package baseNoStates;

import java.util.ArrayList;

// A Space is a subcategory of Area that cannot have children of Area class (Partitions or Spaces), only doors
public class Space extends Area {
  public Space(String id, Partition root, ArrayList<Door> doors) {
    super(id, root, doors);
  }
  @Override
  public Space findAreaById(String id){
    if (this.id == id) {
      return this;
    }
    return null;
  }
  public ArrayList<Space> getSpaces() {
    return null;
  }
}
