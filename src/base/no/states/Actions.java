package base.no.states;

public final class Actions {
  // This class contains the possible actions that a User can do with a Door
  // possible actions in reader and area requests
  private Actions() { }
  public static final String LOCK = "lock";
  public static final String UNLOCK = "unlock";
  public static final String UNLOCK_SHORTLY = "unlock_shortly";
  // possible actions in door requests
  public static final String OPEN = "open";
  public static final String CLOSE = "close";
}
