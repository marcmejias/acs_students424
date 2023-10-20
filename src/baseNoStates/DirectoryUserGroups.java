package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public class DirectoryUserGroups {
  private static ArrayList<UserGroup> userGroups;

  public static void makeUserGroup(){
    // users without any privilege, just to keep temporally users instead of deleting them,
    // this is to withdraw all permissions but still to keep user data to give back
    // permissions later

    // Users
    ArrayList<User> temporal = new ArrayList<>();
    temporal.add(new User("Bernat", "12345"));
    temporal.add(new User("Blai", "77532"));

    // TODO Cambiar de espacios prohibidos a espacio en los que puede estar
    // TODO Use find area by id
    // Spaces

    // "stairs", "exterior", "parking", "hall","room 1", "room 2", "corridor", "room 3", "IT"
    ArrayList<Space> temporalPermittedSpaces = new ArrayList<>(Arrays.asList("stairs", "exterior", "parking", "hall",
        "room 1", "room 2", "corridor", "room 3", "IT"));

    // Group
    UserGroup temporals = new UserGroup("temporals", temporal, null, temporalPermittedSpaces, null);
    userGroups.add(temporals);

    // employees :
    // Sep. 1 2023 to Mar. 1 2024
    // week days 9-17h
    // just shortly unlock
    // ground floor, floor1, exterior, stairs (this, for all), that is, everywhere but the parking

    // Users
    ArrayList<User> employee = new ArrayList<>();
    employee.add(new User("Ernest", "74984"));
    employee.add(new User("Eulalia", "43295"));

    // Actions
    ArrayList<String> actionsEmployee = new ArrayList<>();
    actionsEmployee.add(Actions.UNLOCK_SHORTLY);

    // Prohibited Spaces
    ArrayList<String> employeeProhibitedSpaces = new ArrayList<>();
    employeeProhibitedSpaces.add("parking");

    // Schedule
    ArrayList<String> employeeDates = new ArrayList<String>(Arrays.asList("2023-09-01", "2024-03-01"));
    ArrayList<String> employeeDays = new ArrayList<String>(Arrays.asList("m", "t", "w", "r", "f"));
    ArrayList<String> employeeHours = new ArrayList<String>(Arrays.asList("09:00", "17:00"));
    Schedule employeeSchedule = new Schedule(employeeDates, employeeDays, employeeHours);

    // Group
    UserGroup employees = new UserGroup("employees", employee, actionsEmployee,
        employeeProhibitedSpaces, employeeSchedule);
    userGroups.add(employees);

    // managers :
    // Sep. 1 2023 to Mar. 1 2024
    // week days + saturday, 8-20h
    // all actions
    // all spaces

    // Users
    ArrayList<User> manager = new ArrayList<>();
    manager.add(new User("Manel", "95783"));
    manager.add(new User("Marta", "05827"));

    // Actions
    ArrayList<String> actionsManager = new ArrayList<String>(Arrays.asList(Actions.OPEN, Actions.CLOSE,
        Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY));

    //Schedule
    ArrayList<String> managerDates = new ArrayList<String>(Arrays.asList("2023-09-01", "2024-03-01"));
    ArrayList<String> managerDays = new ArrayList<String>(Arrays.asList("m", "t", "w", "r", "f", "s"));
    ArrayList<String> managerHours = new ArrayList<String>(Arrays.asList("08:00", "20:00"));
    Schedule managerSchedule = new Schedule(managerDates, managerDays, managerHours);

    UserGroup managers = new UserGroup("employees", manager, actionsManager, null, managerSchedule);
    userGroups.add(managers);

    // admin :
    // always=2023 to 2100
    // all days of the week
    // all actions
    // all spaces

    // Users
    ArrayList<User> admin = new ArrayList<>();
    admin.add(new User("Ana", "11343"));

    // Actions
    ArrayList<String> actionsAdmin = new ArrayList<String>(Arrays.asList(Actions.OPEN, Actions.CLOSE,
        Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY));

    // Spaces


    // Schedule
    ArrayList<String> adminDates = new ArrayList<String>(Arrays.asList("2023-01-01", "2100-01-01"));
    ArrayList<String> adminDays = new ArrayList<String>(Arrays.asList("m", "t", "w", "r", "f", "s", "u"));
    ArrayList<String> adminHours = new ArrayList<String>(Arrays.asList("00:00", "23:59"));
    Schedule adminSchedule = new Schedule(adminDates, adminDays, adminHours);

    // Group
    UserGroup admins = new UserGroup("employees", admin, actionsAdmin, null, adminSchedule);
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
