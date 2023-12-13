package base.no.states;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

// A Space is a subcategory of Area that cannot have children of Area class
// (Partitions or Spaces), only doors
public class Space extends Area {
  protected ArrayList<Door> doors = new ArrayList<Door>();
  // Any space has at least a door, but some have more

  public Space(final String id, final Partition root) {
    super(id, root);
  }
  public ArrayList<Door> getDoorsGivingAccess() {
    return doors;
  }
  public void addDoor(final Door door) {
    doors.add(door);
  }
  // This function allows the Visitor class
  // to access Space
  public void acceptVisitor(final Visitor visitor) {
    visitor.visitSpace(this);
  }
  public JSONObject toJson(int depth) { // depth not used here
    JSONObject json = new JSONObject();
    json.put("class", "space");
    json.put("id", id);
    JSONArray jsonDoors = new JSONArray();
    for (Door d : doors) {
      jsonDoors.put(d.toJson());
    }
    json.put("access_doors", jsonDoors);
    return json;
  }
}
