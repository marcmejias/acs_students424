package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public final class Partition {
  private static ArrayList<Partition> partitions;

  public Partition(String basement) {

  }

  public static void makePartition() {
      // basement
      Partition p1 = new Partition("basement");
      Partition p2 = new Partition("ground floor");
      Partition p3 = new Partition("floor 1");


      partitions = new ArrayList<>(Arrays.asList(p1,p2,p3));
    }
      public static ArrayList<Partition> getPartitions() {
      System.out.println(partitions);
      return partitions;
    }

  }