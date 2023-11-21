package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Propped extends DoorState {
    private static final Logger logger = LoggerFactory.getLogger("fita1.propped");
    public Propped(Door door) {
        super(door);
        this.name = States.PROPPED;
    }
    void open() {
        // fall through
        logger.warn("Can't open door {} because it's propped" , door.getId());
    }
    void close(){
        logger.info("Door {} has been closed and will now be locked" , door.getId());
        door.setState(new Locked(door));
        door.setClosed(true);
    }
    void lock(){
        // fall through
        logger.warn("Can't lock door {} because it's propped", door.getId());
    }
    void unlock(){
        // fall through
        logger.warn("Can't unlock door {} because it's propped", door.getId());
    }
    void unlockShortly(){
        // fall through
        logger.warn("Can't unlock shortly door {} because it's propped", door.getId());
    }
}
