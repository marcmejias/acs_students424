package base.no.states;

public final class States {
    // This class contains declared constants that
    // can be called to set door states
    // possible states in door requests
    private States() { }
    public static final String LOCKED = "locked";
    public static final String UNLOCKED = "unlocked";
    public static final String UNLOCKED_SHORTLY = "unlocked_shortly";
    public static final String PROPPED = "propped";
}
