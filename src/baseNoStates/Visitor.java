package baseNoStates;

// This class implements Visitor pattern and
// access the classes Space, Partition, and Door
public interface Visitor {
  void visitSpace(Space space);
  void visitPartition(Partition partition);
  void visitDoor(Door door);
}
