package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class DirectoryUserGroups { // This class manages all UserGroups, and by extension, Users
  private static ArrayList<UserGroup> userGroups = new ArrayList<>(); // List of all existing UserGroups
  private static final Logger logger = LoggerFactory.getLogger(DirectoryUserGroups.class);

  public static void makeUserGroup(){ // This functions makes and initializes Users and UserGroups
    // TEMPORALS :
    // users without any privilege, just to keep temporally users instead of deleting them,
    // this is to withdraw all permissions but still to keep user data to give back
    // permissions later
    // Users
    ArrayList<User> temporal = new ArrayList<>();
    temporal.add(new User("Bernat", "12345"));
    temporal.add(new User("Blai", "77532"));
    // Spaces
    ArrayList<String> temporalPermittedSpaces = null;
    // Actions
    ArrayList<String> actionsTemporal = new ArrayList<>();
    // Schedule
    // temporals have no schedule whatsoever, leave at null (MAY CAUSE SOME ERRORS)
    // Group
    UserGroup temporals =
            new UserGroup("temporals", temporal, actionsTemporal, temporalPermittedSpaces, null);
    userGroups.add(temporals);

    // EMPLOYEES :
    // Sep. 1 2023 to Mar. 1 2024
    // week days 9-17h
    // just shortly unlock
    // ground floor, floor1, exterior, stairs (this, for all), that is, everywhere but the parking
    // Users
    ArrayList<User> employee = new ArrayList<>();
    employee.add(new User("Ernest", "74984"));
    employee.add(new User("Eulalia", "43295"));
    // Actions
    ArrayList<String> actionsEmployee = new ArrayList<String>(Arrays.asList(Actions.OPEN, Actions.CLOSE));
    // Spaces
    ArrayList<String> employeePermittedSpaces =
            new ArrayList<>(Arrays.asList("ground_floor","floor1","stairs",
                    "exterior", "hall", "room1", "room2", "corridor", "room3", "IT"));
    // Schedule
    ArrayList<String> employeeDates = new ArrayList<String>(Arrays.asList("2023-09-01", "2024-03-01"));
    ArrayList<String> employeeDays =
            new ArrayList<String>(Arrays.asList("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"));
    ArrayList<String> employeeHours = new ArrayList<String>(Arrays.asList("09:00", "17:00"));
    Schedule employeeSchedule = new Schedule(employeeDates, employeeDays, employeeHours);
    // Group
    UserGroup employees =
            new UserGroup("employees", employee, actionsEmployee, employeePermittedSpaces, employeeSchedule);
    userGroups.add(employees);

    // MANAGERS :
    // Sep. 1 2023 to Mar. 1 2024
    // week days + saturday, 8-20h
    // all actions
    // all spaces
    // Users
    ArrayList<User> manager = new ArrayList<>();
    manager.add(new User("Manel", "95783"));
    manager.add(new User("Marta", "05827"));
    // Actions
    ArrayList<String> actionsManager =
            new ArrayList<String>(Arrays.asList(Actions.OPEN, Actions.CLOSE,
                    Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY));
    //  Spaces
    ArrayList<String> managerPermittedSpaces =
            new ArrayList<>(Arrays.asList("ground_floor","floor1","basement","stairs",
                    "exterior", "parking", "hall", "room1", "room2", "corridor", "room3", "IT"));
    //  Schedule
    ArrayList<String> managerDates = new ArrayList<String>(Arrays.asList("2023-09-01", "2024-03-01"));
    ArrayList<String> managerDays =
            new ArrayList<String>(Arrays.asList("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"));
    ArrayList<String> managerHours = new ArrayList<String>(Arrays.asList("08:00", "20:00"));
    Schedule managerSchedule = new Schedule(managerDates, managerDays, managerHours);
    //Group
    UserGroup managers =
            new UserGroup("managers", manager, actionsManager, managerPermittedSpaces, managerSchedule);
    userGroups.add(managers);

    // ADMINS :
    // always=2023 to 2100
    // all days of the week
    // all actions
    // all spaces
    // Users
    ArrayList<User> admin = new ArrayList<>();
    admin.add(new User("Ana", "11343"));
    // Actions
    ArrayList<String> actionsAdmin =
            new ArrayList<String>(Arrays.asList(Actions.OPEN, Actions.CLOSE,
                    Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY));
    //  Spaces
    ArrayList<String> adminPermittedSpaces =
            new ArrayList<>(Arrays.asList("ground_floor","floor1","basement","stairs",
                    "exterior", "parking", "hall", "room1", "room2", "corridor", "room3", "IT"));
    // Schedule
    ArrayList<String> adminDates = new ArrayList<String>(Arrays.asList("2023-01-01", "2100-01-01"));
    ArrayList<String> adminDays =
            new ArrayList<String>(Arrays.asList("MONDAY", "TUESDAY",
                    "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"));
    ArrayList<String> adminHours = new ArrayList<String>(Arrays.asList("00:00", "23:59"));
    Schedule adminSchedule = new Schedule(adminDates, adminDays, adminHours);
    // Group
    UserGroup admins = new UserGroup("admin", admin, actionsAdmin, adminPermittedSpaces, adminSchedule);
    userGroups.add(admins);
  }
  public static User findUserByCredential(String id) {
    // This functions searches the userGroup tree and the user tree inside that group
    // until it finds the user with the same id
    for (UserGroup users : userGroups) {
      for (User user : users.getUsers()){
        if (user.getCredential().equals(id)) {
          return user;
        }
      }
    }
    logger.debug("user with credential ", id, " not found");
    return null; // otherwise we get a Java error
  }
}
