package baseNoStates;

public class Locked extends DoorState { // This class dictates the cases to follow if a door is locked
    // A Door in the Locked state can be unlocked or unlocked_shortly (latter not implemented)
    public Locked (Door door) {
        super(door);
        this.name = States.LOCKED;
    }
    void open() {
        // fall through
        System.out.println("Can't open door " + door.getId() + " because it's locked");
    }
    void close(){
        // fall through
        System.out.println("Can't close door " + door.getId() + " because it's locked");
    }
    void lock(){
        // fall through
        System.out.println("Can't lock door " + door.getId() + " because it's locked");
    }
    void unlock(){
        System.out.println("Door " + door.getId() + "has been unlocked");
        door.setState(new Unlocked(door));
    }
    void unlockShortly(){
        System.out.println("Door" + door.getId() + "has been temporarily unlocked for 10 seconds");
        door.setState(new UnlockedShortly(door));
    }
}