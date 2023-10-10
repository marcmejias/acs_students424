package baseNoStates;

public class Partition {
  private final String building;

  private final String basement;

  private final String parking;

  private final String ground_floor;

  private final String hall;

  private final String room1;

  private final String room2;

  private final String room3;

  private final String corridor;

  private final String IT;

  private final String floor1;

  private final String stairs;

  private final String exterior;


  public Partition(String building, String basement, String parking, String ground_floor, String hall, String room1, String room2, String room3, String corridor, String it, String floor1, String stairs, String exterior) {
    this.building = building;
    this.basement = basement;
    this.parking = parking;
    this.ground_floor = ground_floor;
    this.hall = hall;
    this.room1 = room1;
    this.room2 = room2;
    this.room3 = room3;
    this.corridor = corridor;
    IT = it;
    this.floor1 = floor1;
    this.stairs = stairs;
    this.exterior = exterior;
  }
}
