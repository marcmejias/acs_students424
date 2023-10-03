package baseNoStates;

public abstract class DoorState {
    protected Door door;
    protected String name;

    void DoorState (Door door) {

    }

    abstract void open();
    abstract void close();
    abstract void lock();
    abstract void unlock();
}
