package baseNoStates;
import baseNoStates.requests.RequestReader;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Door { // This class keeps tracts of the properties of any given door in the system
  private final String id;
  private boolean closed; // physically
  private DoorState state; // State of the door, can either be locked or unlocked (currently)
  private Space from; // The space where the keypad to open the door is accesible
  private Space to; // The space where the door gives access to
  private static final Logger logger = LoggerFactory.getLogger("fita2");
  public Door(String id) { // Default constructor, lacks from and to spaces
    this.id = id;
    closed = true;
    state = new Unlocked(this); // Every door is unlocked by default
  }
  public Door(String id, Space from, Space to) { // Complete constructor, this is the one usually called
    this.id = id;
    this.from = from;
    this.to = to;
    to.addDoor(this);
    closed = true;
    state = new Unlocked(this);
  }
  public void processRequest(RequestReader request) {
    // it is the Door that process the request because the door has and knows
    // its state, and if closed or open
    if (request.isAuthorized()) {
      String action = request.getAction();
      doAction(action);
    } else {
      logger.info("not authorized");
    }
    request.setDoorStateName(getStateName());
  }
  private void doAction(String action) { // This function executes the action passed through a String
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
  public void setClosed(boolean action) {  closed = action; }
  public void setState(DoorState state) {
    this.state = state;
  }
  public String getId() {
    return id;
  }
  public String getStateName() {
    return state.getName();
  }
  public Space getFromSpace(){
    return from;
  }
  public Space getToSpace(){
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
  public void acceptVisitor(Visitor visitor) {visitor.visitDoor(this);}
}
