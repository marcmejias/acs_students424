package base_no_states;

// This class implements Visitor pattern and
// access the classes Space, Partition, and Door
// and use certain funcionalities without
// needing to implement them on the classes
public interface Visitor {
  void visitSpace(Space space);
  void visitPartition(Partition partition);
  void visitDoor(Door door);
}
