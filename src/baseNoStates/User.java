package baseNoStates;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class User  {
  //extends UserGroup
  private final String name;
  private final String credential;
  private UserGroup group;

  public User(String name, String credential) {
    this.name = name;
    this.credential = credential;

  }
  public UserGroup getGroup() {
    return group;
  }
  public void setGroup(UserGroup group){ this.group = group;}
  public String getCredential() {
    return credential;
  }
  public boolean canSendRequests(LocalDateTime now) {
    if (group.getSchedule().isInSchedule(now)){
      return true;
    }
    return false;
  }
  public boolean canBeInSpace(Space space) {
    for (Space spaces: getSpaces()) {
      if(spaces == space){
        return true;
      }
    }
    return false;
  }
  public boolean canDoAction(String action) {
    for (String actions: group.getActions()) {
      if (actions.equals(action)){
        return true;
      }
    }
    return false;
  }
  public ArrayList<Space> getSpaces(){
    return group.getPermittedSpace();
  }
  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }
}
