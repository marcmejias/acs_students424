package baseNoStates;

public abstract class DoorState { // This class manages the possible states of any given door
    protected Door door; // This is the door we want it's state tracked and/or changed
    protected String name; // Name of the state (only used in the state classes)
    public DoorState (Door door) {
        this.door = door;
    }
    public String getName() {
        return name;
    }
    abstract void open(); // This is called when the door is ordered to open (see specific states for implementation)
    abstract void close(); // This is called when the door is ordered to close (see specific states for implementation)
    abstract void lock(); // This is called when the door is ordered to lock (see specific states for implementation)
    abstract void unlock(); //This is called when the door is ordered to unlock (see specific states for implementation)
}
