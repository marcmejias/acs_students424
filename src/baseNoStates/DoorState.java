package baseNoStates;

public abstract class DoorState {
    protected Door door;
    protected String name;

    public DoorState (Door door) {
        this.door = door;
        //this.name = this.;
    }

    public String getName() {
        return name;
    }

    abstract void open();
    abstract void close();
    abstract void lock();
    abstract void unlock();
}
