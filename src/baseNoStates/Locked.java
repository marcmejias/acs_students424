package baseNoStates;

public class Locked extends DoorState{
    public Locked (Door door) {
        super(door);
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