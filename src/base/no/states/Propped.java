package base.no.states;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Propped extends DoorState {
    private static final Logger LOGGER =
        LoggerFactory.getLogger("Fita1");
    public Propped(final Door door) {
        super(door);
        this.name = States.PROPPED;
    }
    void open() {
        // fall through
        LOGGER.warn("Can't open door {} because it's propped",
            door.getId());
    }
    void close() {
        LOGGER.info("Door {} has been closed and will now be locked",
            door.getId());
        door.setState(new Locked(door));
        door.setClosed(true);
    }
    void lock() {
        // fall through
        LOGGER.warn("Can't lock door {} because it's propped", door.getId());
    }
    void unlock() {
        // fall through
        LOGGER.warn("Can't unlock door {} because it's propped", door.getId());
    }
    void unlockShortly() {
        // fall through
        LOGGER.warn("Can't unlock shortly door {} because it's propped",
            door.getId());
    }
}
