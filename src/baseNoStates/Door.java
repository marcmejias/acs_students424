package baseNoStates;
import baseNoStates.requests.RequestReader;
import org.json.JSONObject;

public class Door {
  private final String id;
  private boolean closed; // physically
  private DoorState state;
  private Space from;
  private Space to;

  public Door(String id) {
    this.id = id;
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
      System.out.println("not authorized");
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
        // TODO
        System.out.println("Action " + action + " not implemented yet");
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
  public void setFromSpace(Space from) {
    this.from = from;
  }
  public void setToSpace(Space to) {
    this.to = to;
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
}
