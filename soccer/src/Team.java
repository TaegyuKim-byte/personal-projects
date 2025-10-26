import java.util.ArrayList;
import java.lang.String;

public class Team {
    private String name;
    private ArrayList<Player> players;

    public Team(String name) {
        this.name = name;
        players = new ArrayList<Player>();
    }

    public void addPlayer(Player player) {
        if (!players.contains(player))
            players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void showPlayers() {
        System.out.println("=== Team: " + this.name + " ===");

        for (Player player : players)
            //playerlist = playerlist + player.getName() + "\n"; -> make new obj every time.  less efficient
            System.out.println(" - " + player);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
