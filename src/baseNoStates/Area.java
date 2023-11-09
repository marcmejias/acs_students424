package baseNoStates;

import java.util.ArrayList;



public abstract class Area { // Areas are the non-specified version of Partitions and Spaces, i.e. their shared values
    protected final String id;
    protected static Partition rootArea;

    public Area (String id, Partition root){
        this.id = id;
        rootArea = root;
        if (this.rootArea != null) { //If this area has a father...
            this.rootArea.addChild(this); //we notify the father of this area that it has a new children
        }
    }
    public String getId() {
        return id;
    }
    public abstract ArrayList<Door> getDoorsGivingAccess(); // Check Partitions or Space for specific implementation
    public abstract Area findAreaById(String id); // Check Partitions or Space for specific implementation
    public abstract ArrayList<Space> getSpaces(); // Check Partitions or Space for specific implementation
}
