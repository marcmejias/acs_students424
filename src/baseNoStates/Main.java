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
    DirectoryAreas.makeAreas();
    DirectoryUserGroups.makeUserGroup();
    new WebServer();
    final int period = 2; // seconds
    Clock clock = new Clock(period);
    clock.start();
    wait(11);
    // wait for 11 seconds while the clock runs
    // but you can do other things here instead
    clock.stop();

    //TEST D
    //Print de door locked, unlocked

    //TEST C
    //Print de spaces, partitions
    //Print del arbol de Areas mejor
    //ejecutar readerRequest/areaRequest el authorize para comporbar que funciona

    //TEST B
    //print de las variables de un user group
    //print de todos los nombres de user group
    //ejecutar isInSchedule para mostrar que funciona (en verdad es repetir el authorize())

    //TEST A
    //no se ha implementado, pero seria hacer print de door en unlock_shortly
  }
}
