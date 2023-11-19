package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VisitorFindAreaById implements Visitor {
  private String id;
  private Area result;
  public static Logger logger = LoggerFactory.getLogger("fita2");

  public VisitorFindAreaById(Area rootArea, String id) {
    this.id = id;
    logger.debug("Searching for area: " + id);
    rootArea.acceptVisitor(this);
  }
  public Area getResult(){
    return result;
  }
  @Override
  public void visitPartition(Partition partition) {
    if (partition.getId().equals(id)) {
      logger.debug("Area " + id + " found.");
      result = partition;
    }
    for (Area area : partition.getChild()) {
      area.acceptVisitor(this);
    }
  }
  // This function is usually called by findAreaById of Partition
  // if the space is correct it will return itself, otherwise do nothing
  @Override
  public void visitSpace(Space space) {
    if (space.getId().equals(id)) {
      result = space;
    }
  }
  @Override
  public void visitDoor(Door door) {
    // do nothing, doors are not part of areas
  }
}