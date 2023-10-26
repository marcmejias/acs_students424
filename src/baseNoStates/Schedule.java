package baseNoStates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Schedule {
  //when : date interval + weekdays + time interval in a day = Schedule
  //private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
  private final LocalDate fromDate;
  private final LocalDate toDate;
  private final ArrayList<String> weekdays;
  private final LocalTime fromHour;
  private final LocalTime toHour;

  public Schedule(ArrayList<String> dateInterval, ArrayList<String> weekdays, ArrayList<String> timeInterval) {
    this.fromDate = LocalDate.parse(dateInterval.get(0)); //example of parse content: "2024-03-01"
    this.toDate = LocalDate.parse(dateInterval.get(1));

    this.fromHour = LocalTime.parse(timeInterval.get(0)); // example of parse content: 09:00
    this.toHour = LocalTime.parse(timeInterval.get(1));

    this.weekdays = weekdays;
  }

  public boolean isInSchedule(LocalDateTime now){
    LocalDate nowDate = now.toLocalDate();
    LocalTime nowTime = now.toLocalTime();

    //Here we can check if the Hour and Date are true
    //System.out.print("Is hour:" + nowDate + (nowTime.isAfter(fromHour) && nowTime.isBefore(toHour)) + " ");
    //System.out.print("Is date:" +  nowTime+ (nowDate.isAfter(fromDate) && nowDate.isBefore(toDate)) + " ");

    if (nowDate.isAfter(fromDate) && nowDate.isBefore(toDate)){
      if (nowTime.isAfter(fromHour) && nowTime.isBefore(toHour)){
        for (String dayOfWeek : weekdays){
          if (now.getDayOfWeek().toString() == dayOfWeek){
            return true;
          }
        }
      }
    }

    return false;
  }
}