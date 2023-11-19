package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Locked extends DoorState { // This class dictates the cases to follow if a door is locked
    // A Door in the Locked state can be unlocked or unlocked_shortly (latter not implemented)
    private static final Logger logger = LoggerFactory.getLogger("fita1");
    public Locked (Door door) {
        super(door);
        this.name = States.LOCKED;
    }
    void open() {
        // fall through
        logger.info("Can't open door " + door.getId() + " because it's locked");
    }
    void close(){
        // fall through
        logger.info("Can't close door " + door.getId() + " because it's locked");
    }
    void lock(){
        // fall through
        logger.info("Can't lock door " + door.getId() + " because it's locked");
    }
    void unlock(){
        logger.info("Door " + door.getId() + "has been unlocked");
        door.setState(new Unlocked(door));
    }
    void unlockShortly(){
        logger.info("Door" + door.getId() + "has been temporarily unlocked for 10 seconds");
        door.setState(new UnlockedShortly(door));
    }
}