package baseNoStates;

public abstract class DoorState { // This manages the possible states of a given door
    protected Door door;
    protected String name;

    public DoorState (Door door) {
        this.door = door;
    }

    public String getName() {
        return name;
    }

    abstract void open();
    abstract void close();
    abstract void lock();
    abstract void unlock();
}
