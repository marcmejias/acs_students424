package baseNoStates;

import java.util.ArrayList;
import static baseNoStates.DirectoryAreas.rootArea;

public class UserGroup {
    // A userGroup is an agrupation of users that
    // share the same permissions and responsabilities
    private final String name;
    // list of members of the group
    private final ArrayList<User> users;
    // list of possible actions of the group
    private ArrayList<String> actions;
    // list of allowed spaces to the group
    private ArrayList<Area> permittedSpaces = new ArrayList<>();
    private Schedule schedule; // Dates, days, and weeks allowed to the group
    public UserGroup(final String nameLocal, final ArrayList<User> usersLocal,
                     final ArrayList<String> actionsLocal,
                     final ArrayList<String> permittedSpacesLocal,
                     final Schedule scheduleLocal) {
        this.name = nameLocal;
        this.users = usersLocal;
        if (permittedSpacesLocal != null) {
            // if the userGroup has permission for certain spaces...
            for (String space : permittedSpacesLocal) {
                // ...add all those spaces to the permissions
                VisitorFindAreaById v =
                    new VisitorFindAreaById(rootArea, space);
                Area sp = v.getResult();
                this.permittedSpaces.add(sp);
            }
        }
        this.actions = actionsLocal;
        this.schedule = scheduleLocal;
        for (User user : this.users) {
            //For every user in users,
            // we call the user and assign them to the userGroup
            user.setGroup(this);
        }
    }
    public String getName() {
        return name;
    }
    public ArrayList<User> getUsers() {
        return users;
    }
    public ArrayList<String> getActions() {
        return actions;
    }
    public ArrayList<Area> getPermittedSpace() {
        return permittedSpaces;
    }
    public Schedule getSchedule() {
        return schedule;
    }
}
