package baseNoStates;

public class User  {
  //extends UserGroup
  private final String name;
  private final String credential;

  public User(String name, String credential) {
    this.name = name;
    this.credential = credential;
  }

  public String getCredential() {
    return credential;
  }
  public boolean canSendRequests(){
    return true;
  }
  public boolean canBeInSpace(Space space){
    return true;
  }
  public boolean canDoAction(Actions action){
    return true;
  }
  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }
}
