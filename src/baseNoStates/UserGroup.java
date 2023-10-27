package baseNoStates;

import java.util.ArrayList;
import static baseNoStates.DirectoryAreas.rootArea;

public class UserGroup {
    private final String name;
    private final ArrayList<User> users; // list of members of the group
    private ArrayList<String> actions; // list of possible actions of the group
    private ArrayList<Area> permittedSpaces = new ArrayList<>(); // list of allowed spaces to the group
    private Schedule schedule; // Dates, days, and weeks allowed to the group
    public UserGroup(String name, ArrayList<User> users, ArrayList<String> actions, ArrayList<String> permittedSpaces, Schedule schedule) {
        this.name = name;
        this.users = users;
        if (permittedSpaces != null) {
            for (String space : permittedSpaces) {
                Area sp = rootArea.findAreaById(space);
                this.permittedSpaces.add(sp);
            }
        }
        this.actions = actions;
        this.schedule = schedule;
        for (User user : this.users){ //For every user in users, we call the user and assign them to the userGroup
            user.setGroup(this);
        }
    }
    public String getName(){ return name; }
    public ArrayList<User> getUsers(){
        return users;
    }
    public ArrayList<String> getActions(){ return actions; }
    public ArrayList<Area> getPermittedSpace(){ return permittedSpaces; }
    public Schedule getSchedule(){ return schedule; }
}
