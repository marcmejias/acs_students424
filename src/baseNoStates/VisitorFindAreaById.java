package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VisitorFindAreaById implements Visitor {
  public static Logger logger = LoggerFactory.getLogger("fita2");
  @Override
  public void visitPartition(Partition partition) {
  //TODO move all find,,,Id from all classes and directories to Visitors REFACTORING
  }
  @Override
  public void visitSpace(Space space) {

  }
  @Override
  public void visitDoor(Door door) {
    // do nothing, doors are not part of areas
  }
}
