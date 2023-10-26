package baseNoStates;

// A Door in the Unlocked state can be opened, closed or locked
public class Unlocked extends DoorState {
    public Unlocked (Door door) {
        super(door);
        this.name = States.UNLOCKED;
    }
    void open() {
        if (door.isClosed()) {
            door.setClosed(false);
        } else {
            System.out.println("Can't open door " + name + " because it's already open");
        }
    }
    void close(){
        if (door.isClosed()) {
            System.out.println("Can't close door " + name + " because it's already closed");
        } else {
            door.setClosed(true);
        }
    }
    void lock(){
        if (door.isClosed()) {
            door.setState(new Locked(door));
        } else {
            System.out.println("Can't lock door " + name + " because it's open");
        }
    }
    void unlock(){
        // fall through
        System.out.println("Can't unlock door " + name + " because it's open");
    }
}
