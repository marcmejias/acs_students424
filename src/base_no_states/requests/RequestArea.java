package base_no_states.requests;

import base_no_states.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RequestArea implements Request {
  private final String credential;
  private final String action;
  private final String areaId;
  private final LocalDateTime now;
  private ArrayList<RequestReader> requests = new ArrayList<>();
  //TODO logs request
  //private static final Logger logger = LoggerFactory.getLogger("Fita1");

  public RequestArea(final String credentialLocal, final String actionLocal,
                     final LocalDateTime nowLocal, final String areaIdLocal) {
    this.credential = credentialLocal;
    this.areaId = areaIdLocal;
    assert actionLocal.equals(Actions.LOCK)
        || actionLocal.equals(Actions.UNLOCK)
            : "invalid action " + actionLocal + " for an area request";
    this.action = actionLocal;
    this.now = nowLocal;
  }

  public String getAction() {
    return action;
  }

  @Override
  public JSONObject answerToJson() {
    JSONObject json = new JSONObject();
    json.put("action", action);
    json.put("areaId", areaId);
    JSONArray jsonRequests = new JSONArray();
    for (RequestReader rd : requests) {
      jsonRequests.put(rd.answerToJson());
    }
    json.put("requestsDoors", jsonRequests);
    return json;
  }

  @Override
  public String toString() {
    String requestsDoorsStr;
    if (requests.size() == 0) {
      requestsDoorsStr = "";
    } else {
      requestsDoorsStr = requests.toString();
    }
    return "Request{"
            + "credential=" + credential
            + ", action=" + action
            + ", now=" + now
            + ", areaId=" + areaId
            + ", requestsDoors=" + requestsDoorsStr
            + "}";
  }

  // processing the request of an area is creating the corresponding door
  // requests and forwarding them to all of its doors.
  // For some it may be authorized and action will be done,
  // for othersit won't be authorized and nothing will happen to them.
  public void process() {
    VisitorFindAreaById v = new VisitorFindAreaById(DirectoryAreas.getRootArea(), areaId);
    Area area = v.getResult();
    //
    // an Area is a Space or a Partition
    if (area != null) {
      // is null when from the app we click on an action but
      // no place is selected because
      // there (flutter) I don't control like I do in javascript
      // that all the parameters are provided
      //logger.warn("has entered: {}", area.getId());
      VisitorFindDoorsGivingAccess vdoor =
          new VisitorFindDoorsGivingAccess(area);
      ArrayList<Door> doors = vdoor.getResult();
      //area.getDoorsGivingAccess()
      //for (Door door : doors)
        //logger.warn("door: {}",door.getId());
      // Make all the door requests, one for each door in the area,
      // and process them.
      // Look for the doors in the spaces of this area
      // that give access to them.
      for (Door door : doors) {
        RequestReader requestReader = new RequestReader(credential,
            action, now, door.getId());
        requestReader.process();
        // after process() the area request contains the answer as the answer
        // to each individual door request,
        // that is read by the simulator/Flutter app
        requests.add(requestReader);
      }
    }

  }
}
