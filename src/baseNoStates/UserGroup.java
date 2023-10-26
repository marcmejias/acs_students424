package baseNoStates;

import java.util.ArrayList;
import static baseNoStates.DirectoryAreas.rootArea;

public class UserGroup {
    private final String name;
    private final ArrayList<User> users;
    private ArrayList<String> actions;
    private ArrayList<Space> permittedSpaces = new ArrayList<>();
    private Schedule schedule;
    public UserGroup(String name, ArrayList<User> users, ArrayList<String> actions, ArrayList<String> permittedSpaces, Schedule schedule) {
        this.name = name;
        this.users = users;
        if (permittedSpaces != null) {
            for (String space : permittedSpaces) {
                Space sp = (Space) rootArea.findAreaById(space);
                this.permittedSpaces.add(sp);
            }
        }
        this.actions = actions;
        this.schedule = schedule;
        for (User user : this.users){
            user.setGroup(this);
        }
    }
    public String getName(){ return name; }
    public ArrayList<User> getUsers(){
        return users;
    }
    public ArrayList<String> getActions(){ return actions; }
    public ArrayList<Space> getPermittedSpace(){ return permittedSpaces; }
    public Schedule getSchedule(){ return schedule; }
}
