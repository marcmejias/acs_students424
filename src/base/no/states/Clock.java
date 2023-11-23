package base.no.states;

import java.util.Timer;
import java.time.LocalDateTime;
import java.util.TimerTask;
import java.util.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Clock extends Observable {
    private LocalDateTime date;
    private Timer timer;
    public static final int NUMERO = 1000;
    private int period; // seconds
    private static Clock singleInstance = null;
    private static final Logger LOGGER = LoggerFactory.getLogger("Fita2");
    public Clock(final int periodLocal) {
        this.period = periodLocal;
        timer = new Timer();
    }
    public void start() { // This function gets the clock running
        TimerTask repeatedTask = new TimerTask() {
            public void run() { // instance of anonymous class
                date = LocalDateTime.now();
                LOGGER.debug("tick del reloj en: {}", date);
                setChanged();
                notifyObservers(date);
            }
        };
        timer.scheduleAtFixedRate(repeatedTask, 0, NUMERO * period);
    }
    public static synchronized Clock getInstance() {
        if (singleInstance == null) {
            singleInstance = new Clock(1);
        }
        return singleInstance;
    }
    public void stop() {
        timer.cancel();
    }
    public int getPeriod() {
        return period;
    }
    public LocalDateTime getDate() {
        return date;
    }
}
