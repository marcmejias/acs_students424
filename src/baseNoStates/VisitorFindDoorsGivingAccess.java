package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VisitorFindDoorsGivingAccess implements Visitor {
  public static Logger logger = LoggerFactory.getLogger(VisitorFindDoorsGivingAccess.class);
  @Override
  public void visitPartition(Partition partition) {

  }
  @Override
  public void visitSpace(Space space) {

  }
  @Override
  public void visitDoor(Door door) {

  }
}
