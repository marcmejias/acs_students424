package baseNoStates;
// Before executing enable assertions :
// https://se-education.org/guides/tutorials/intellijUsefulSettings.html

import java.time.LocalDateTime;

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
    System.out.print("Is Schedule:" + DirectoryUserGroups.findUserByCredential("11343").canSendRequests(LocalDateTime.now()) + " ");
    System.out.print("Is ACTION:" + DirectoryUserGroups.findUserByCredential("11343").canDoAction("lock") + " ");
    System.out.print("Is FROM:" + DirectoryUserGroups.findUserByCredential("11343").canBeInSpace(DirectoryAreas.findDoorById("D2").getFromSpace()) + " ");
    System.out.print("Is to:" + DirectoryUserGroups.findUserByCredential("11343").canBeInSpace(DirectoryAreas.findDoorById("D2").getToSpace()) + " ");
    System.out.print(DirectoryAreas.findDoorById("D2").getFromSpace().id + " " + DirectoryAreas.findDoorById("D2").getToSpace().id+ " ");
    System.out.print(DirectoryAreas.findAreaById("stairs").getId());
    //System.out.print("space:" + DirectoryUserGroups.findUserByCredential("11343").getSpaces() + " ");
    for (Space space : DirectoryUserGroups.findUserByCredential("11343").getSpaces()){
      System.out.print("space:" + space.getId() + " ");
    }
    /*
    new WebServer();
    final int period = 2; // seconds
    Clock clock = new Clock(period);
    clock.start();
    wait(11);
    // wait for 11 seconds while the clock runs
    // but you can do other things here instead
    clock.stop();
    */
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
