package base.no.states.requests;

import base.no.states.Area;
import base.no.states.Door;
import base.no.states.VisitorFindDoorsGivingAccess;
import base.no.states.VisitorFindAreaById;
import base.no.states.Actions;
import base.no.states.DirectoryAreas;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RequestChildren implements Request {
  private final String areaId;
  private JSONObject jsonTree; // 1 level tree, root and children

  public RequestChildren(String areaId) {
    this.areaId = areaId;
  }

  public String getAreaId() {
    return areaId;
  }

  @Override
  public JSONObject answerToJson() {
    return jsonTree;
  }

  @Override
  public String toString() {
    return "RequestChildren{areaId=" + areaId + "}";
  }

  public void process() {
    Area area = DirectoryAreas.findAreaById(areaId);
    jsonTree = area.toJson(1);
  }
}
