package base_no_states;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// This class uses the Visitor to get an Area on the tree
// without needing to implement the functionality in Area
public class VisitorFindAreaById implements Visitor {
  private String id;
  private Area result;
  private static final Logger LOGGER = LoggerFactory.getLogger("Fita2");

  public VisitorFindAreaById(final Area rootArea, final String idLocal) {
    this.id = idLocal;
    LOGGER.debug("Searching for area: {}", idLocal);
    rootArea.acceptVisitor(this);
  }
  public Area getResult() {
    return result;
  }
  // This function iterates the children of a Partition
  // regardless if they are Partition or Space
  // in order to find the Area we want
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
