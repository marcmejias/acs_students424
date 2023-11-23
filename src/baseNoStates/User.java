package baseNoStates;

import java.time.LocalDateTime;

public class User { // This class instances the users of our system
  private final String name;
  // Unlike the name, the credential is a
  // personal unique code for each given user
  private final String credential;
  // group where the user belongs and gives
  // its authorizations and permissions
  private UserGroup group;
  public User(final String nameLocal, final String credentialLocal) {
    this.name = nameLocal;
    this.credential = credentialLocal;
  }
  public UserGroup getGroup() {
    return group;
  }
  public void setGroup(final UserGroup groupLocal) {
    this.group = groupLocal;
  }
  public String getCredential() {
    return credential;
  }
  public boolean canSendRequests(final LocalDateTime now) {
    //This function calls class Schedule to check if
    // the User is in a valid timetable regarding their userGroup
    if (group.getSchedule().isInSchedule(now)) {
      return true;
    }
    return false;
  }
  public boolean canBeInSpace(final Space space) {
    // This function checks if the user is allowed in the selected space
    return group.getPermittedSpace().contains(space);
  }
  public boolean canDoAction(final String action) {
    // This functions checks if the user is allowed to perform this action
    for (String actions: group.getActions()) {
      if (actions.equals(action)) {
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
