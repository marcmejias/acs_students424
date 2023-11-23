package base.no_states;

import java.time.LocalDateTime;

public class User { // This class instances the users of our system
  private final String name;
  private final String credential; // Unlike the name, the credential is a personal unique code for each given user
  private UserGroup group; // group where the user belongs and gives its authorizations and permissions
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
    //This function calls class Schedule to check if the User is in a valid timetable regarding their userGroup
    if (group.getSchedule().isInSchedule(now)){
      return true;
    }
    return false;
  }
  public boolean canBeInSpace(Space space) { // This function checks if the user is allowed in the selected space
    return group.getPermittedSpace().contains(space);
  }
  public boolean canDoAction(String action) { // This functions checks if the user is allowed to perform this action
    for (String actions: group.getActions()) {
      if (actions.equals(action)){
        return true;
      }
    }
    return false;
  }
  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }
}
