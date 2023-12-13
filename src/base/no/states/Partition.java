package base.no.states;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

// A Partition is a group of spaces or partitions,
// it has an Id and the Doors that belong in the Partition
public final class Partition extends Area {
    protected ArrayList<Area> children;
    //Only Partition can have children,
    // regardless if they are Partition or Space
    // (therefore the list are Area objects)
    public Partition(final String id, final Partition root) {
      super(id, root);
      children = new ArrayList<Area>();
    }
    public void addChild(final Area child) {
      children.add(child);
    }
    public ArrayList<Area> getChild() {
        return children;
    }
    // This function allows the Visitor class
    // to access Partition
    public void acceptVisitor(final Visitor visitor) {
        visitor.visitPartition(this);
    }
    public JSONObject toJson(int depth) {
        // for depth=1 only the root and children,
        // for recusive = all levels use Integer.MAX_VALUE
        JSONObject json = new JSONObject();
        json.put("class", "partition");
        json.put("id", id);
        JSONArray jsonAreas = new JSONArray();
        if (depth > 0) {
            for (Area a : children) {
                jsonAreas.put(a.toJson(depth - 1));
            }
            json.put("areas", jsonAreas);
        }
        return json;
    }
}
