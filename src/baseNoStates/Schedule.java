package baseNoStates;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Schedule {
  //when : date interval + weekdays + time interval in a day = Schedule
  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
  private final LocalDateTime fromDate;
  private final LocalDateTime toDate;
  private final ArrayList<String> weekdays;
  private final String fromHour;
  private final String toHour;

  public Schedule(ArrayList<String> dateInterval, ArrayList<String> weekdays, ArrayList<String> timeInterval) {
    //We need to add a random hour so LocalDateTime can parse the date
    this.fromDate = LocalDateTime.parse(dateInterval.get(0) + " 00:00" , formatter); //example of parse content: "2024-03-01"
    this.toDate = LocalDateTime.parse(dateInterval.get(1)  + " 00:00" , formatter);

    this.fromHour = timeInterval.get(0);
    this.toHour = timeInterval.get(1);

    this.weekdays = weekdays;
  }

  public boolean isInSchedule(LocalDateTime now){
    //We need to add a random date (in this case today because we are checking it this instant)
    // so LocalDateTime can parse the date
    DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formattedDateTime = LocalDateTime.now().format(formatterDate);
    LocalDateTime fromHour = LocalDateTime.parse(formattedDateTime + this.fromHour, formatter); // example of parse content: 09:00
    LocalDateTime toHour = LocalDateTime.parse(formattedDateTime + this.toHour, formatter);

    if (now.isAfter(toDate) && now.isBefore(fromDate)){
      if (now.isAfter(toHour) && now.isBefore(fromHour)){
        for (String dayOfWeek : weekdays){
          if (now.toString() == dayOfWeek){
            return true;
          }
        }
      }
    }

    return false;
  }
}