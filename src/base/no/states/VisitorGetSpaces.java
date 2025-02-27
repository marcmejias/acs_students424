package base.no.states;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

// This class uses the Visitor to get the spaces of a given Partition
// without needing to implement the functionality in Partition
public class VisitorGetSpaces implements Visitor {
  private ArrayList<Space> result = new ArrayList<>();
  private static final Logger LOGGER =
      LoggerFactory.getLogger("Fita2");

  public VisitorGetSpaces(final Area area) {
    LOGGER.info("Searching for spaces in area: {}", area.getId());
    area.acceptVisitor(this);
  }
  public ArrayList<Space> getResult() {
    return result;
  }
  // This function returns every children that is a Space
  @Override
  public void visitPartition(final Partition partition) {
    for (Area area : partition.getChild()) {
      area.acceptVisitor(this);
    }
  }
  @Override
  public void visitSpace(final Space space) {
    result.add(space);
  }
  @Override
  public void visitDoor(final Door door) {
    // do nothing, doors don't have spaces
  }
}
