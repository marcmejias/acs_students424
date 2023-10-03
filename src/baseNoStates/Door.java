package baseNoStates;

import baseNoStates.requests.RequestReader;
import org.json.JSONObject;


public class Door {
  private final String id;
  private boolean closed; // physically
  private boolean locked;

  public Door(String id) {
    this.id = id;
    closed = true;
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

  private void doAction(String action) {
    switch (action) {
      case Actions.OPEN:
        if (locked) {
          DoorState state = new Locked();
          state.open();
        } else {
          DoorState state = new Unlocked();
          state.open();
        }
        break;
      case Actions.CLOSE:
        if (locked) {
          DoorState state = new Locked();
          state.close();
        } else {
          DoorState state = new Unlocked();
          state.close();
        }
        break;
      case Actions.LOCK:
        if (locked) {
          DoorState state = new Locked();
          state.lock();
        } else {
          DoorState state = new Unlocked();
          state.lock();
        }
      case Actions.UNLOCK:
        if (locked) {
          DoorState state = new Locked();
          state.unlock();
        } else {
          DoorState state = new Unlocked();
          state.unlock();
        }
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
  public boolean isLocked() {
    return locked;
  }
  public void setLocked(boolean action) {  locked = action; }

  public String getId() {
    return id;
  }

  public String getStateName() {
    return "unlocked";
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
