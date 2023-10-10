package baseNoStates;

public abstract class Area {
    private final String id;
    private static Area rootArea;

    public Area (String id, Area root){
        this.id = id;
        rootArea = root;
    }

    public Door[] getDoorsGivingAccess() {
        return null;
    }
    public static Area findAreaById(String id){
        return rootArea.findAreaById(id); // an Area or null if not found
    }
    public Space[] getSpaces() {

    }
}
