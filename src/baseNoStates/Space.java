package baseNoStates;

import java.util.ArrayList;

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
