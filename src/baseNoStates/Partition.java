package baseNoStates;

import java.util.ArrayList;

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
    public ArrayList<Area> getChild() {
        return children;
    }
    public void acceptVisitor(Visitor visitor) {
        visitor.visitPartition(this);
    }
}
