package baseNoStates;

public class Unlocked extends DoorState { // This class dictates the cases to follow if a door is unlocked
    // A Door in the Unlocked state can be opened, closed or locked
    public Unlocked (Door door) {
        super(door);
        this.name = States.UNLOCKED;
    }
    void open() {
        if (door.isClosed()) {
            door.setClosed(false);
        } else {
            System.out.println("Can't open door " + door.getId() + " because it's already open");
        }
    }
    void close(){
        if (door.isClosed()) {
            System.out.println("Can't close door " + door.getId() +  " because it's already closed");
        } else {
            door.setClosed(true);
        }
    }
    void lock(){
        if (door.isClosed()) {
            System.out.println("Door " + door.getId() + "has been locked");
            door.setState(new Locked(door));
        } else {
            System.out.println("Can't lock door " + door.getId() + " because it's open");
        }
    }
    void unlock(){
        // fall through
        System.out.println("Can't unlock door " + door.getId() +  " because it's unlocked");
    }
    void unlockShortly(){
        // fall through
        System.out.println("Can't unlock shortly door " + door.getId() + "because it's unlocked");
    }
}
