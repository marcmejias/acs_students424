package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Unlocked extends DoorState { // This class dictates the cases to follow if a door is unlocked
    // A Door in the Unlocked state can be opened, closed or locked
    private static final Logger logger = LoggerFactory.getLogger("fita1.unlocked");
    public Unlocked (Door door) {
        super(door);
        this.name = States.UNLOCKED;
    }
    void open() {
        if (door.isClosed()) {
            door.setClosed(false);
        } else {
            logger.info("Can't open door {} because it's already open ", door.getId());
        }
    }
    void close(){
        if (door.isClosed()) {
            logger.info("Can't close door {} because it's already closed", door.getId());
        } else {
            door.setClosed(true);
        }
    }
    void lock(){
        if (door.isClosed()) {
            logger.info("Door {} has been locked", door.getId());
            door.setState(new Locked(door));
        } else {
            logger.info("Can't lock door {} because it's open",door.getId());
        }
    }
    void unlock(){
        // fall through
        logger.info("Can't unlock door {} because it's unlocked", door.getId());
    }
    void unlockShortly(){
        // fall through
        logger.info("Can't unlock shortly door {} because it's unlocked", door.getId());
    }
}
