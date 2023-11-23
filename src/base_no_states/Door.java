package base_no_states;
import base_no_states.requests.RequestReader;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// This class keeps tracts of the properties of any given door in the system
public class Door {
  private final String id;
  private boolean closed; // physically
  // State of the door, can either be locked or unlocked (currently)
  private DoorState state;
  // The space where the keypad to open the door is accesible
  private Space from;
  private Space to; // The space where the door gives access to
  private static final Logger LOGGER = LoggerFactory.getLogger("fita1");
  // Default constructor, lacks from and to spaces
  public Door(final String idLocal) {
    this.id = idLocal;
    closed = true;
    state = new Unlocked(this); // Every door is unlocked by default
  }
  // Complete constructor, this is the one usually called
  public Door(final String idLocal, final Space fromLocal,
              final Space toLocal) {
    this.id = idLocal;
    this.from = fromLocal;
    this.to = toLocal;
    toLocal.addDoor(this);
    closed = true;
    state = new Unlocked(this);
  }
  public void processRequest(final RequestReader request) {
    // it is the Door that process the request
    // because the door has and knows
    // its state, and if closed or open
    if (request.isAuthorized()) {
      String action = request.getAction();
      doAction(action);
    } else {
      LOGGER.warn("not authorized");
    }
    request.setDoorStateName(getStateName());
  }
  // This function executes the action passed through a String
  private void doAction(final String action) {
    switch (action) {
      case Actions.OPEN:
        state.open();
        break;
      case Actions.CLOSE:
        state.close();
        break;
      case Actions.LOCK:
        state.lock();
        break;
      case Actions.UNLOCK:
        state.unlock();
        break;
      case Actions.UNLOCK_SHORTLY:
        state.unlockShortly();
        break;
      default:
        assert false : "Unknown action " + action;
        System.exit(-1);
    }
  }
  public boolean isClosed() {
    return closed;
  }
  public void setClosed(final boolean action) {
    closed = action;
  }
  public void setState(final DoorState stateLocal) {
    this.state = stateLocal;
  }
  public String getId() {
    return id;
  }
  public String getStateName() {
    return state.getName();
  }
  public Space getFromSpace() {
    return from;
  }
  public Space getToSpace() {
    return to;
  }
  @Override
  public String toString() {
    return "Door{"
        + ", id='" + id + '\''
        + ", closed=" + closed
        + ", state=" + getStateName()
        + "}";
  }
  public JSONObject toJson() {
    JSONObject json = new JSONObject();
    json.put("id", id);
    json.put("state", getStateName());
    json.put("closed", closed);
    return json;
  }
  // This function allows the Visitor class
  // to access Space
  public void acceptVisitor(final Visitor visitor) {
    visitor.visitDoor(this);
  }
}
