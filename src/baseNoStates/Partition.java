package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

// A Partition is a group of spaces or partitions, it has an Id and the Doors that belong in the Partition
public final class Partition extends Area{
  //private static ArrayList<Partition> partitions;
    public Partition(String id, Area root, ArrayList<Door> doors) {
      super(id, root, doors);
  }

    /*
      public static ArrayList<Partition> getPartitions() {
      System.out.println(partitions);
      return partitions;
    }
*/
  }