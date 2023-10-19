package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public class DirectoryUserGroups {
  private static ArrayList<UserGroup> userGroups;

  public static void makeUserGroup(){
    // users without any privilege, just to keep temporally users instead of deleting them,
    // this is to withdraw all permissions but still to keep user data to give back
    // permissions later
    ArrayList<User> temporal = new ArrayList<>();
    temporal.add(new User("Bernat", "12345"));
    temporal.add(new User("Blai", "77532"));
    UserGroup temporals = new UserGroup("temporals", temporal, null, null, null);
    userGroups.add(temporals);

    // employees :
    // Sep. 1 2023 to Mar. 1 2024
    // week days 9-17h
    // just shortly unlock
    // ground floor, floor1, exterior, stairs (this, for all), that is, everywhere but the parking
    ArrayList<User> employee = new ArrayList<>();
    employee.add(new User("Ernest", "74984"));
    employee.add(new User("Eulalia", "43295"));
    UserGroup employees = new UserGroup("employees", employee, null, null, null);
    userGroups.add(employees);

    // managers :
    // Sep. 1 2023 to Mar. 1 2024
    // week days + saturday, 8-20h
    // all actions
    // all spaces
    ArrayList<User> manager = new ArrayList<>();
    manager.add(new User("Manel", "95783"));
    manager.add(new User("Marta", "05827"));
    UserGroup managers = new UserGroup("employees", manager, null, null, null);
    userGroups.add(managers);

    // admin :
    // always=2023 to 2100
    // all days of the week
    // all actions
    // all spaces
    ArrayList<User> admin = new ArrayList<>();
    admin.add(new User("Ana", "11343"));
    UserGroup admins = new UserGroup("employees", admin, null, null, null);
    userGroups.add(admins);

  }
  public static User findUserByCredential(String id) {
    for (UserGroup users : userGroups) {
      for (User user : users.getUsers()){
        if (user.getCredential().equals(id)) {
          return user;
        }
      }
    }
    System.out.println("user with credential " + id + " not found");
    return null; // otherwise we get a Java error
  }
}
