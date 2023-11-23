package base.no.states;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Locked extends DoorState {
    // This class dictates the cases to follow if a door is locked
    // A Door in the Locked state can be unlocked or
    // unlocked_shortly (latter not implemented)
    private static final Logger LOGGER =
        LoggerFactory.getLogger("Fita1");
    public Locked(final Door door) {
        super(door);
        this.name = States.LOCKED;
    }
    void open() {
        // fall through
        LOGGER.info("Can't open door {} because it's locked", door.getId());
    }
    void close() {
        // fall through
        LOGGER.info("Can't close door {} because it's locked", door.getId());
    }
    void lock() {
        // fall through
        LOGGER.info("Can't lock door {} because it's locked", door.getId());
    }
    void unlock() {
        LOGGER.info("Door {} has been unlocked", door.getId());
        door.setState(new Unlocked(door));
    }
    void unlockShortly() {
        LOGGER.debug("Door {} has been temporarily unlocked for 10 seconds",
            door.getId());
        door.setState(new UnlockedShortly(door));
    }
}
