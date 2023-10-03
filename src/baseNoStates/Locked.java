package baseNoStates;

public class Locked extends DoorState{
    void open() {
        // fall through
    }
    void close(){
        door.setClosed(true);
    }
    void lock(){
        // fall through
    }
    void unlock(){
        door.setLocked(false);
    }
}