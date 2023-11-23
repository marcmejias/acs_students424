package base.no_states;

import java.util.Timer;
import java.time.LocalDateTime;
import java.util.TimerTask;
import java.util.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Clock extends Observable {
    private LocalDateTime date;
    private Timer timer;
    private int period; // seconds
    private static Clock single_instance = null;
    private static final Logger logger = LoggerFactory.getLogger("Fita2.Clock");
    public Clock(int period) {
        this.period = period;
        timer = new Timer();
    }
    public void start() { // This function gets the clock running
        TimerTask repeatedTask = new TimerTask() {
            public void run() { // instance of anonymous class
                date = LocalDateTime.now();
                logger.debug("tick del reloj en: {}", date);
                setChanged();
                notifyObservers(date);
            }
        };
        timer.scheduleAtFixedRate(repeatedTask, 0, 1000 * period);
    }
    public static synchronized Clock getInstance() {
        if (single_instance == null)
            single_instance = new Clock(1);
        return single_instance;
    }
    public void stop() { timer.cancel(); }
    public int getPeriod() { return period; }
    public LocalDateTime getDate() { return date; }
}