package baseNoStates;

public class Propped extends DoorState {
    public Propped(Door door) {
        super(door);
        this.name = States.PROPPED;
    }
    void open() {
        // fall through
        System.out.println("Can't open door " + door.getId() + " because it's propped");
    }
    void close(){
        System.out.println("Door " + door.getId() + " has been closed and will now be locked");
        door.setState(new Locked(door));
        door.setClosed(true);
    }
    void lock(){
        // fall through
        System.out.println("Can't lock door " + door.getId() + " because it's propped");
    }
    void unlock(){
        // fall through
        System.out.println("Can't unlock door " + door.getId() + " because it's propped");
    }
    void unlockShortly(){
        // fall through
        System.out.println("Can't unlock shortly door " + door.getId() + " because it's propped");
    }
}
