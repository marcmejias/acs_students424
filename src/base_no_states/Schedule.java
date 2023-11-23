package base_no_states;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Schedule { // Schedule is the timetable set to a User/UserGroup
  // This class is used to check if the user is
  // operating under an allowed time period
  private final LocalDate fromDate; // Starting date of the schedule
  private final LocalDate toDate; // Ending date of the schedule
  // Set of allowed weekdays in the schedule
  private final ArrayList<String> weekdays;
  private final LocalTime fromHour; // Starting date of the schedule
  private final LocalTime toHour; // Ending date of the schedule

  public Schedule(final ArrayList<String> dateInterval,
                  final ArrayList<String> weekdaysLocal,
                  final ArrayList<String> timeInterval) {
    // Dates, weekdays, and hours are sent as strings so we parse them
    // into appropiate time formats
    // Dates are parsed using the LocalDate library
    this.fromDate = LocalDate.parse(dateInterval.get(0));
    //example of parse content: "2024-03-01"
    this.toDate = LocalDate.parse(dateInterval.get(1));
    // Hours are parsed using the LocalTime library
    this.fromHour = LocalTime.parse(timeInterval.get(0));
    // example of parse content: "09:00"
    this.toHour = LocalTime.parse(timeInterval.get(1));
    // We don't need to parse weekdays through any library
    // as they are always strings (kinda)
    this.weekdays = weekdaysLocal;
  }

  // This function checks if the hours, dates, and weekdays are in order
  public boolean isInSchedule(final LocalDateTime now) {
    LocalDate nowDate = now.toLocalDate();
    //we trim the current LocalDateTime to LocalDate
    LocalTime nowTime = now.toLocalTime();
    //we trim the current LocalDateTime to LocalTime

    if (nowDate.isAfter(fromDate) && nowDate.isBefore(toDate)) {
      if (nowTime.isAfter(fromHour) && nowTime.isBefore(toHour)) {
        for (String dayOfWeek : weekdays) {
          if (now.getDayOfWeek().toString() == dayOfWeek) {
            return true;
          }
        }
      }
    }

    return false;
  }
}
