package baseNoStates;

import java.util.ArrayList;

public class UserGroup {
    private final String name;
    private final ArrayList<User> users;
    private Actions actions;
    private ArrayList<Area> permission;
    private Schedule schedule;
    public UserGroup(String name, ArrayList<User> users, Actions actions, ArrayList<Area> permission, Schedule schedule) {
        this.name = name;
        this.users = users;
        this.permission = permission;
        this.actions = actions;
        this.schedule = schedule;
    }

    public ArrayList<User> getUsers(){
        return users;
    }
}
