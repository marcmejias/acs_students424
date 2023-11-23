package base.no_states.requests;

import org.json.JSONObject;

public interface Request {
  JSONObject answerToJson();
  String toString();
  void process();
}
