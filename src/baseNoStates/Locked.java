package baseNoStates;

// A Door in the Locked state can be unlocked or unlocked_shortly
public class Locked extends DoorState{
    public Locked (Door door) {
        super(door);
        this.name = "locked";
    }
    void open() {
        // fall through
        System.out.println("Can't open door " + name + " because it's locked");
    }
    void close(){
        // fall through
        System.out.println("Can't close door " + name + " because it's locked");
    }
    void lock(){
        // fall through
        System.out.println("Can't lock door " + name + " because it's locked");
    }
    void unlock(){
        door.setState(new Unlocked(door));
    }
}