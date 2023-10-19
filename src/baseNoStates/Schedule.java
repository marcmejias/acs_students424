package baseNoStates;

import java.util.ArrayList;

public class Schedule {
  //when : date interval + weekdays + time interval in a day = Schedule
  private final ArrayList<String> dateInterval;
  private final ArrayList<String> weekdays;
  private final ArrayList<String> timeInterval;

  public Schedule(ArrayList<String> dateInterval, ArrayList<String> weekdays, ArrayList<String> timeInterval) {
    this.dateInterval = dateInterval;
    this.weekdays = weekdays;
    this.timeInterval = timeInterval;
  }
}
