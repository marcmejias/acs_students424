package baseNoStates;

// Before executing enable assertions :
// https://se-education.org/guides/tutorials/intellijUsefulSettings.html

public final class Main {
  private Main() { }
  public static void main(final String[] args) {
    DirectoryAreas.makeAreas();
    DirectoryUserGroups.makeUserGroup();
    new WebServer();
  }
}
