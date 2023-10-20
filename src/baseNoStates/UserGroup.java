package baseNoStates;

import java.util.ArrayList;

public class UserGroup {
    private final String name;
    private final ArrayList<User> users;
    private ArrayList<String> actions;
    private ArrayList<Space> permittedSpaces;
    private Schedule schedule;
    public UserGroup(String name, ArrayList<User> users, ArrayList<String> actions, ArrayList<Space> permittedSpaces, Schedule schedule) {
        this.name = name;
        this.users = users;
        this.permittedSpaces = permittedSpaces;
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
