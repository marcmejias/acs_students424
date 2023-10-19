package baseNoStates;
// Before executing enable assertions :
// https://se-education.org/guides/tutorials/intellijUsefulSettings.html

public class Main {
  private static void wait(int seconds) {
    try {
      Thread.sleep(1000*seconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    DirectoryAreas.makeDoors();
    DirectoryUserGroups.makeUserGroup();
    DirectoryAreas.makeAreas();
    new WebServer();
    final int period = 2; // seconds
    Clock clock = new Clock(period);
    clock.start();
    wait(11);
    // wait for 11 seconds while the clock runs
    // but you can do other things here instead
    clock.stop();
  }
}
