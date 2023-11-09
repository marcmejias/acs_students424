package baseNoStates;

import java.time.Duration;
import java.util.Observer;
import java.util.Observable;
import java.time.LocalDateTime;
public class UnlockedShortly extends DoorState implements Observer{
    private static final long UNLOCKED_TIME = 10;
    private LocalDateTime time;
    private static Clock clock = new Clock(1);

    public UnlockedShortly(Door door) {
        super(door);
        clock.start();
        this.name = "unlocked_shortly";
        this.time = LocalDateTime.now();
        clock.addObserver(this);
    }
    void open() {
        if (!door.isClosed()) {
            System.out.println("Can't open door " + door.getId() + " because it's already open");
        } else {
            System.out.println("Door" + door.getId() + "has been opened");
            door.setClosed(false);
        }
    }
    void close() {
        if (door.isClosed()) {
            System.out.println("Can't close door " + door.getId() + " because it's already closed");
        } else {
            System.out.println("Door " + door.getId() + " has been closed");
            door.setClosed(true);
        }

    }
    void lock() {
        if (door.isClosed()) {
            System.out.println("Door " + door.getId() + " has been locked");
            door.setState(new Locked(door));
            clock.stop();
        }
    }
    void unlock() {
        // fall through
        System.out.println("Can't unlock door " + door.getId() + " because it's unlocked shortly");
    }
    void unlockShortly(){
        // fall through
        System.out.println("Can't unlock shortly door "  + door.getId() + " because it's already unlocked shortly");
    }
    @Override
    public void update(Observable observable, Object obj) {
        LocalDateTime now = (LocalDateTime) obj;
        Duration duration = Duration.between(time, now);

        if (Math.abs(duration.toSeconds()) > UNLOCKED_TIME) {
            if (door.isClosed()) { // In case the door gets closed after time runs out...
                clock.deleteObserver(this);
                System.out.println("Door " + door.getId() + " time has run out and becomes locked");
                door.setState(new Locked(door));
            } else { // In case the door doesn't get closed after time runs out...
                clock.deleteObserver(this);
                System.out.println("Door " + door.getId() + " time has run out and becomes propped");
                door.setState(new Propped(door));
            }
        }
    }
}
