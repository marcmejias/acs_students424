package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VisitorFindAreaById implements Visitor {
  private String id;
  private Area result;
  private static final Logger LOGGER = LoggerFactory.getLogger("fita2.visitor");

  public VisitorFindAreaById(final Area rootArea, final String idLocal) {
    this.id = idLocal;
    LOGGER.debug("Searching for area: {}", idLocal);
    rootArea.acceptVisitor(this);
  }
  public Area getResult() {
    return result;
  }
  @Override
  public void visitPartition(final Partition partition) {
    if (partition.getId().equals(id)) {
      LOGGER.debug("Area {} found", id);
      result = partition;
    }
    for (Area area : partition.getChild()) {
      area.acceptVisitor(this);
    }
  }
  // This function is usually called by findAreaById of Partition
  // if the space is correct it will return itself, otherwise do nothing
  @Override
  public void visitSpace(final Space space) {
    if (space.getId().equals(id)) {
      result = space;
    }
  }
  @Override
  public void visitDoor(final Door door) {
    // do nothing, doors are not part of areas
  }
}