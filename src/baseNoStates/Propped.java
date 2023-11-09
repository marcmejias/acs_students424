package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Propped extends DoorState {
    private static final Logger logger = LoggerFactory.getLogger("fita2");
    public Propped(Door door) {
        super(door);
        this.name = States.PROPPED;
    }
    void open() {
        // fall through
        logger.warn("Can't open door ", door.getId(), " because it's propped");
    }
    void close(){
        logger.info("Door " + door.getId() + " has been closed and will now be locked");
        door.setState(new Locked(door));
        door.setClosed(true);
    }
    void lock(){
        // fall through
        logger.warn("Can't lock door " , door.getId(), " because it's propped");
    }
    void unlock(){
        // fall through
        logger.warn("Can't unlock door ", door.getId(), " because it's propped");
    }
    void unlockShortly(){
        // fall through
        logger.warn("Can't unlock shortly door ", door.getId(), " because it's propped");
    }
}
