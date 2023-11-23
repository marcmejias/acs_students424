package base.no_states;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Observer;
import java.util.Observable;
import java.time.LocalDateTime;
public class UnlockedShortly extends DoorState implements Observer{
    private static final long UNLOCKED_TIME = 10;
    private LocalDateTime time;
    private static Clock clock = new Clock(1);
    private static final Logger logger = LoggerFactory.getLogger("Fita2.locked");

    public UnlockedShortly(Door door) {
        super(door);
        Clock clock = Clock.getInstance();
        logger.debug("A clock has been instantiated");
        clock.start();
        this.name = States.UNLOCKED_SHORTLY;
        this.time = LocalDateTime.now();
        clock.addObserver(this);
    }
    void open() {
        if (!door.isClosed()) {
            logger.info("Can't open door {} because it's already open", door.getId());
        } else {
            logger.info("Door {} has been opened", door.getId());
            door.setClosed(false);
        }
    }
    void close() {
        if (door.isClosed()) {
            logger.info("Can't close door {} because it's already closed", door.getId());
        } else {
            logger.info("Door {} has been closed", door.getId());
            door.setClosed(true);
        }

    }
    void lock() {
        if (door.isClosed()) {
            logger.info("Door {} has been locked", door.getId());
            door.setState(new Locked(door));
            clock.stop();
        }
    }
    void unlock() {
        // fall through
        logger.warn("Can't unlock door {} because it's unlocked shortly", door.getId());
    }
    void unlockShortly(){
        // fall through
        logger.warn("Can't unlock shortly door {} because it's already unlocked shortly", door.getId());
    }
    @Override
    public void update(Observable observable, Object obj) {
        LocalDateTime now = (LocalDateTime) obj;
        Duration duration = Duration.between(time, now);

        //TODO stop update from printing and stop clock
        if (Math.abs(duration.toSeconds()) > UNLOCKED_TIME) {
            if (door.isClosed()) { // In case the door gets closed after time runs out...
                clock.deleteObserver(this);
                logger.info("Door {} time has run out and becomes locked", door.getId());
                clock.stop();
                door.setState(new Locked(door));
            } else { // In case the door doesn't get closed after time runs out...
                clock.deleteObserver(this);
                clock.stop();
                logger.info("Door {} time has run out and becomes propped", door.getId());
                door.setState(new Propped(door));
            }
        }
    }
}
