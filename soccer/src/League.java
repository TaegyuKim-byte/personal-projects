import java.util.ArrayList;

public class League {
    private String name;
    private ArrayList<Team> teams;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public League(String name) {
        this.name = name;
        teams = new ArrayList<Team>();
    }
}
