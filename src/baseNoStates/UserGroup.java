package baseNoStates;

import java.util.ArrayList;

public class UserGroup {
    private final String name;
    private final ArrayList<User> users;
    private ArrayList<String> actions;
    private ArrayList<String> prohibitedSpaces; // Igual son areas en vez de espacios
    private Schedule schedule;
    public UserGroup(String name, ArrayList<User> users, ArrayList<String> actions, ArrayList<String> prohibitedSpaces, Schedule schedule) {
        this.name = name;
        this.users = users;
        this.prohibitedSpaces = prohibitedSpaces;
        this.actions = actions;
        this.schedule = schedule;
    }

    public ArrayList<User> getUsers(){
        return users;
    }
}
