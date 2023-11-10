package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Visitor {
  public static final Logger logger = LoggerFactory.getLogger("fita2");

  public void visitSpace(Space space);
  public void visitPartition(Partition partition);
  public void visitDoor(Door door);
}
