package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public class DirectoryUserGroups {
  private static ArrayList<UserGroup> userGroup;

  public static void makeUserGroup(){
    Partition building = new Partition("building", null, null);


    //partitions
    ArrayList<Door> base = new ArrayList<>(Arrays.asList(allDoors.get(0), allDoors.get(1)));
    Partition basement = new Partition("basement", building, base);
    ArrayList<Door> gf = new ArrayList<>(Arrays.asList(allDoors.get(2), allDoors.get(3), allDoors.get(4), allDoors.get(5)));
    Partition ground_floor = new Partition("ground floor", building, gf);
    ArrayList<Door> f1 = new ArrayList<>(Arrays.asList(allDoors.get(6), allDoors.get(7), allDoors.get(8)));
    Partition floor_1 = new Partition("floor 1", building, f1);

    // basement
    ArrayList<Door> park = new ArrayList<>(Arrays.asList(allDoors.get(0), allDoors.get(1)));
    Space parking = new Space("parking", basement, park);

    // ground floor
    ArrayList<Door> hal = new ArrayList<>(Arrays.asList(allDoors.get(2), allDoors.get(3)));
    Space hall = new Space("hall", ground_floor, hal);
    ArrayList<Door> room1 = new ArrayList<>(Arrays.asList(allDoors.get(4)));
    Space room_1 = new Space("room 1", ground_floor, room1);
    ArrayList<Door> room2 = new ArrayList<>(Arrays.asList(allDoors.get(5)));
    Space room_2 = new Space("room 2", ground_floor, room2);

    // first floor
    ArrayList<Door> room3 = new ArrayList<>(Arrays.asList(allDoors.get(7)));
    Space room_3 = new Space("room 3", floor_1, room3);
    ArrayList<Door> cor = new ArrayList<>(Arrays.asList(allDoors.get(6)));
    Space corridor = new Space("corridor", floor_1, cor);
    ArrayList<Door> it = new ArrayList<>(Arrays.asList(allDoors.get(8)));
    Space IT = new Space("IT", floor_1, it);

    //independent
    Space stairs = new Space("stairs", building, null);
    Space exterior = new Space("exterior", building, null);

  }
  public static User findUserByCredential(String id) {
    /*for (UserGroup user : userGroup) {
      if ( ) {
        return user;
      }
    }

    return null; // otherwise we get a Java error
  }*/
}
