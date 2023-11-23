package baseNoStates;

// This class manages the possible states of any given door
public abstract class DoorState {
    // This is the door we want it's state tracked and/or changed
    protected Door door;
    // Name of the state (only used in the state classes)
    protected String name;
    public DoorState(final Door doorLocal) {
        this.door = doorLocal;
    }
    public String getName() {
        return name;
    }
    // This is called when the door is ordered to open
    // (see specific states for implementation)
    abstract void open();
    // This is called when the door is ordered to close
    // (see specific states for implementation)
    abstract void close();
    // This is called when the door is ordered to lock
    // (see specific states for implementation)
    abstract void lock();
    //This is called when the door is ordered to unlock
    // (see specific states for implementation)
    abstract void unlock();
    abstract void unlockShortly();
    //This is called when the door is ordered to unlock for a short time
    // (see specific states for implementation)
}
