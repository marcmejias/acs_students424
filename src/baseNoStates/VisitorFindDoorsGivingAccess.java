package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;

public class VisitorFindDoorsGivingAccess implements Visitor {
  private ArrayList<Door> result = new ArrayList<Door>();
  public static Logger logger = LoggerFactory.getLogger("fita2.visitor");

  public VisitorFindDoorsGivingAccess(Area area) {
    logger.debug("Searching for doors in area: {}", area.getId());
    area.acceptVisitor(this);
  }
  public ArrayList<Door> getResult(){
    return result;
  }
  // This function recursively travels through the Partition's children
  // and adds the set of Doors of every Space children
  @Override
  public void visitPartition(Partition partition) {
    for (Area area : partition.getChild()) {
      logger.debug("travelling : {}", area.getId());
      area.acceptVisitor(this);
    }
  }
  @Override
  public void visitSpace(Space space) {
    logger.debug("selecting doors from : {}", space.getId());
    result.addAll(space.getDoorsGivingAccess());
  }
  @Override
  public void visitDoor(Door door) {
    // do nothing, areas have all the information needed
  }
}
