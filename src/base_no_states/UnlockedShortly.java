package base_no_states;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Observer;
import java.util.Observable;
import java.time.LocalDateTime;
public class UnlockedShortly extends DoorState implements Observer {
    private static final long UNLOCKED_TIME = 10;
    private LocalDateTime time;
    private static Clock clock = new Clock(1);
    private static final Logger LOGGER =
        LoggerFactory.getLogger("Fita2");

    public UnlockedShortly(final Door door) {
        super(door);
        Clock clockLocal = Clock.getInstance();
        LOGGER.debug("A clock has been instantiated");
        clockLocal.start();
        this.name = States.UNLOCKED_SHORTLY;
        this.time = LocalDateTime.now();
        clockLocal.addObserver(this);
    }
    void open() {
        if (!door.isClosed()) {
            LOGGER.info("Can't open door {} because it's already open",
                door.getId());
        } else {
            LOGGER.info("Door {} has been opened", door.getId());
            door.setClosed(false);
        }
    }
    void close() {
        if (door.isClosed()) {
            LOGGER.info("Can't close door {} because it's already closed",
                door.getId());
        } else {
            LOGGER.info("Door {} has been closed", door.getId());
            door.setClosed(true);
        }

    }
    void lock() {
        if (door.isClosed()) {
            LOGGER.info("Door {} has been locked", door.getId());
            door.setState(new Locked(door));
            clock.stop();
        }
    }
    void unlock() {
        // fall through
        LOGGER.warn("Can't unlock door {} because it's unlocked shortly",
            door.getId());
    }
    void unlockShortly() {
        // fall through
        LOGGER.warn("Can't unlock shortly door {} "
                + "because it's already unlocked shortly",
            door.getId());
    }
    @Override
    public void update(final Observable observable, final Object obj) {
        LocalDateTime now = (LocalDateTime) obj;
        Duration duration = Duration.between(time, now);

        //TODO stop update from printing and stop clock
        if (Math.abs(duration.toSeconds()) > UNLOCKED_TIME) {
            if (door.isClosed()) {
                // In case the door gets closed after time runs out...
                clock.deleteObserver(this);
                LOGGER.info("Door {} time has run out and becomes locked",
                    door.getId());
                clock.stop();
                door.setState(new Locked(door));
            } else {
                // In case the door doesn't get closed after time runs out...
                clock.deleteObserver(this);
                clock.stop();
                LOGGER.info("Door {} time has run out and becomes propped",
                    door.getId());
                door.setState(new Propped(door));
            }
        }
    }
}
