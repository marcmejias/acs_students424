package baseNoStates;

public abstract class DoorState {
    protected Door door;
    protected String name;

    void DoorState (Door door) {
        this.door = door;
        this.name = door.getId();
    }

    abstract void open();
    abstract void close();
    abstract void lock();
    abstract void unlock();
}
