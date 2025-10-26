import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;

public class FootballManager {
    ArrayList<Player> players;
    ArrayList<Team> teams;
    ArrayList<League> leagues;

    public PlayerAnalyzer playerAnalyzer;
    public TeamAnalyzer teamAnalyzer;

    public FootballManager() {
        players = new ArrayList<>();
        teams = new ArrayList<>();
        leagues = new ArrayList<>();

        playerAnalyzer = new PlayerAnalyzer(players, teams, leagues);
        teamAnalyzer = new TeamAnalyzer();
    }

    public ArrayList<League> getLeagues() {
        return leagues;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void showAllPlayers() {
        if (players.isEmpty()) {
            System.out.println("[!] No players registered.");
            return;
        }

        System.out.println("=== All Players ===");
        for (Player p : players) {
            System.out.println(" - " + p); // toString() 기준
        }
    }

    public void showAllTeams() {
        if (teams.isEmpty()) {
            System.out.println("[!] No teams registered.");
            return;
        }

        System.out.println("=== All Teams ===");
        for (Team t : teams) {
            //t.showPlayers();
            System.out.println(" - " + t.getName());
        }
    }

    public void showAllLeagues() {
        if (leagues.isEmpty()) {
            System.out.println("[!] No leagues registered.");
            return;
        }

        System.out.println("=== All Leagues ===");
        for (League l : leagues) {
            System.out.println(" - " + l.getName());
        }
    }


    public void registerPlayerSet(String inputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue; //빈 줄 무시 (trim: 공백 무시)

                String[] tokens = line.split(",");
                if (tokens.length != 28) {
                    System.out.println("[!] Error of data form: " + line);
                    continue;
                }

                String name = tokens[0].trim();
                int age = Integer.parseInt(tokens[1].trim());
                //String 을 int로 변환
                String country = tokens[2].trim();

                Player p = new Player(name, age, country);

                //if there is blank or lower case on textfile,
                //IllegalArgumentException occur
                p.setPreferredPosition(Position.valueOf(tokens[3].trim()));

                p.setLeftFoot(Integer.parseInt(tokens[4].trim()));
                p.setRightFoot(Integer.parseInt(tokens[5].trim()));

                p.setShooting(Integer.parseInt(tokens[6].trim()));
                p.setPassing(Integer.parseInt(tokens[7].trim()));
                p.setDribbling(Integer.parseInt(tokens[8].trim()));
                p.setCrossing(Integer.parseInt(tokens[9].trim()));
                p.setTackling(Integer.parseInt(tokens[10].trim()));
                p.setHeading(Integer.parseInt(tokens[11].trim()));
                p.setBallControl(Integer.parseInt(tokens[12].trim()));
                p.setVision(Integer.parseInt(tokens[13].trim()));
                p.setComposure(Integer.parseInt(tokens[14].trim()));
                p.setDecisionMaking(Integer.parseInt(tokens[15].trim()));
                p.setWorkRate(Integer.parseInt(tokens[16].trim()));
                p.setLeadership(Integer.parseInt(tokens[17].trim()));
                p.setPositioning(Integer.parseInt(tokens[18].trim()));
                p.setOffTheBall(Integer.parseInt(tokens[19].trim()));
                p.setPace(Integer.parseInt(tokens[20].trim()));
                p.setStamina(Integer.parseInt(tokens[21].trim()));
                p.setStrength(Integer.parseInt(tokens[22].trim()));
                p.setJumping(Integer.parseInt(tokens[23].trim()));
                p.setAgility(Integer.parseInt(tokens[24].trim()));
                p.setSaving(Integer.parseInt(tokens[25].trim()));
                p.setBuildupPlay(Integer.parseInt(tokens[26].trim()));
                p.setTeam(tokens[27].trim());
                p.calculateAllFit();

                players.add(p);
                System.out.println("Player " + p.getName() +  " registered successfully!");

                //p.showPlayer();
            }
        } catch (IOException e) {
            System.err.println("!! File read error: " + e.getMessage());
        }
    }

    //이미 등록된 선수 리스트를 돌면서 각 선수의 팀을 팀 리스트에 등록
    public void registerTeam() {
        boolean exists;
        for (Player player : players) {
            String teamName = player.getTeam().trim();
            exists = teams.stream().anyMatch(t -> t.getName().equalsIgnoreCase(teamName));
            if (!exists) {
                teams.add(new Team(teamName));
            }
        }
    }

    public void registerLeague() {

    }

    public void assignPlayerToTeam() {
        for (Player player : players) {
            Team team = findTeamByName(player.getTeam());
            if (team != null) {
                team.addPlayer(player);
            } else {
                System.out.println("[!] There is no team for " + player.getName());
            }
        }
    }

    public Team findTeamByName(String name) {
        for (Team t : teams) {
            if (t.getName().equalsIgnoreCase(name)) {
                return t;
            }
        }
        return null;
    }

    public Player findPlayerByName(String name) {
        for (Player p : players) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public void assignTeamToLeague() {

    }

    //Analyzer들을 실행하기 위한 FM의 메서드도 만들어줘야 함.
    //ㄴㄴ 그냥 footballManager.playerAnalyzer.(); 이렇게 하면 됨.
}
