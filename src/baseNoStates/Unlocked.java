package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Unlocked extends DoorState { // This class dictates the cases to follow if a door is unlocked
    // A Door in the Unlocked state can be opened, closed or locked
    private static final Logger logger = LoggerFactory.getLogger("fita1");
    public Unlocked (Door door) {
        super(door);
        this.name = States.UNLOCKED;
    }
    void open() {
        if (door.isClosed()) {
            door.setClosed(false);
        } else {
            logger.warn("Can't open door " + door.getId() + " because it's already open");
        }
    }
    void close(){
        if (door.isClosed()) {
            logger.warn("Can't close door " + door.getId() +  " because it's already closed");
        } else {
            door.setClosed(true);
        }
    }
    void lock(){
        if (door.isClosed()) {
            logger.info("Door " + door.getId() + "has been locked");
            door.setState(new Locked(door));
        } else {
            logger.warn("Can't lock door " + door.getId() + " because it's open");
        }
    }
    void unlock(){
        // fall through
        logger.warn("Can't unlock door " + door.getId() +  " because it's unlocked");
    }
    void unlockShortly(){
        // fall through
        logger.warn("Can't unlock shortly door " + door.getId() + "because it's unlocked");
    }
}
