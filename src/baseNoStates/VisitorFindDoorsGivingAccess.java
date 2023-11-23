package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;

// This class uses the Visitor to get the doors of a given Space
// without needing to implement the functionality in Space
public class VisitorFindDoorsGivingAccess implements Visitor {
  private ArrayList<Door> result = new ArrayList<Door>();
  private static final Logger LOGGER =
      LoggerFactory.getLogger("fita2.visitor");

  public VisitorFindDoorsGivingAccess(final Area area) {
    LOGGER.debug("Searching for doors in area: {}", area.getId());
    area.acceptVisitor(this);
  }
  public ArrayList<Door> getResult() {
    return result;
  }
  // This function recursively travels through the Partition's children
  // and adds the set of Doors of every Space children
  @Override
  public void visitPartition(final Partition partition) {
    for (Area area : partition.getChild()) {
      LOGGER.debug("travelling : {}", area.getId());
      area.acceptVisitor(this);
    }
  }
  @Override
  public void visitSpace(final Space space) {
    LOGGER.debug("selecting doors from : {}", space.getId());
    result.addAll(space.getDoorsGivingAccess());
  }
  @Override
  public void visitDoor(final Door door) {
    // do nothing, areas have all the information needed
  }
}
