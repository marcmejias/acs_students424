package baseNoStates;

public class Unlocked extends DoorState{
    void open() {
        door.setClosed(false);
    }
    void close(){
        door.setClosed(true);
    }
    void lock(){
        door.setLocked(true);
    }
    void unlock(){
        // fall through
    }
}
