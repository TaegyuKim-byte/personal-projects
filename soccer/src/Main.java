//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FootballManager footballManager = new FootballManager();

        Scanner keyboard = new Scanner(System.in);
        int enter;
        boolean goon = true;

        do {
            System.out.println("==========================================");
            System.out.println("Welcome to the Football Manager Program");
            System.out.println("==========================================");
            System.out.println("Choose your option:");
            System.out.println("------------------------------------------");
            System.out.println("(1) Load Data from text File");
            System.out.println("(2) Search & View");
            System.out.println("(3) Analysis");
            /*System.out.println("(4) Show all Players in this world");
            System.out.println("(5) Show all Players in the Team");
            System.out.println("(6) Show all Teams in this world");
            System.out.println("(7) Show all Teams in the League");
            System.out.println("(8) Show all Leagues in this world");*/
            System.out.println("(0) Exit Program");
            System.out.println("==========================================");


            enter = keyboard.nextInt();

            switch (enter) {
                case 1: {
                    System.out.println("Enter TEXT FILE'S NAME what you want to register");
                    System.out.println("(If you want, You can add another player to text file)");
                    System.out.println("(You must be careful info's order)");
                    String filename = keyboard.next();

                    footballManager.registerPlayerSet(filename);
                    footballManager.registerTeam();
                    footballManager.assignPlayerToTeam();

                    footballManager.showAllPlayers();
                    footballManager.showAllTeams();

                    break;
                }
                case 2: {
                    System.out.println("----- Search Options -----");
                    System.out.println("(1) Players");
                    System.out.println("(2) Teams");
                    System.out.println("(3) Leagues");
                    System.out.println("(0) Back to Main Menu");
                    int subChoice = keyboard.nextInt();
                    keyboard.nextLine();
                    //개행문자 제거

                    switch (subChoice) {
                        case 1: {
                            System.out.println("----- Player Search Options -----");
                            System.out.println("(1) View All Players");
                            System.out.println("(2) View Players in a Team");
                            System.out.println("(3) View One Player by name");
                            System.out.println("(0) Back to Main Menu");
                            int subChoice1 = keyboard.nextInt();
                            keyboard.nextLine();
                            //개행문자 제거

                            switch (subChoice1) {
                                case 1: {
                                    footballManager.showAllPlayers();
                                    break;
                                }
                                case 2: {
                                    System.out.println("Choose a team.");
                                    footballManager.showAllTeams();

                                    String teamName = keyboard.nextLine();

                                    Team team = footballManager.findTeamByName(teamName);

                                    team.showPlayers();

                                    break;
                                }
                                case 3: {
                                    footballManager.showAllPlayers();
                                    System.out.print("Enter the player's name: ");

                                    String playerName = keyboard.nextLine();

                                    Player p = footballManager.findPlayerByName(playerName);
                                    if (p == null) {
                                        System.out.println("[!] There is no player whose name is " + playerName);
                                    } else {
                                        p.showPlayer();
                                    }

                                    break;
                                }
                                case 0: {
                                    break;
                                }
                                default: {
                                    System.out.println("[!] Invalid input. Please enter a number between 1 and 3.");
                                    break;
                                }
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("----- Team Search Options -----");
                            System.out.println("(1) View All Teams");
                            System.out.println("(2) View One Team by name");
                            System.out.println("(0) Back to Main Menu");
                            int subChoice2 = keyboard.nextInt();
                            keyboard.nextLine();
                            //개행문자 제거

                            switch (subChoice2) {
                                case 1: {
                                    footballManager.showAllTeams();
                                    break;
                                }
                                case 2: {
                                    footballManager.showAllTeams();
                                    System.out.print("Enter the team's name: ");
                                    String teamName = keyboard.nextLine();
                                    Team team = footballManager.findTeamByName(teamName);
                                    if (team == null) {
                                        System.out.println("[!] There is no team whose name is " + teamName);
                                    } else {
                                        team.showPlayers();
                                    }
                                    break;
                                }
                                case 0: {
                                    break;
                                }
                                default: {
                                    System.out.println("[!] Invalid input. Please choose between 1 and 3.");
                                    break;
                                }
                            }
                            break;
                        }
                        case 3: {
                            System.out.println("----- League Search Options -----");
                            System.out.println("(1) View All Leagues");
                            System.out.println("(2) View One League by name");
                            System.out.println("(0) Back to Main Menu");
                            int subChoice3 = keyboard.nextInt();
                            keyboard.nextLine();
                            //개행문자 제거

                            switch (subChoice3) {
                                case 1: {
                                    break;
                                }
                                case 2: {
                                    break;
                                }
                                case 0: {
                                    break;
                                }
                                default: {
                                    System.out.println("[!] Invalid input. Please choose between 1 and 2.");
                                    break;
                                }
                            }
                            break;
                        }
                        case 0: {
                            break;
                        }
                        default: {
                            System.out.println("[!] Invalid input. Please choose between 1 and 3.");
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    //Part of analyzer
                    boolean analysisContinue = true;
                    while (analysisContinue) { 
                        System.out.println("----- Analysis Options -----");
                        System.out.println("(1) Player Analysis");
                        System.out.println("(2) Team Analysis");
                        System.out.println("(0) Back to Main Menu");
                        int analysisChoice = keyboard.nextInt();
                        keyboard.nextLine();
                        //개행문자 제거
                       
                        switch (analysisChoice) {
                            case 1: {
                                footballManager.playerAnalyzer.showMenu();
                                int playerAnalysisChoice = keyboard.nextInt();
                                keyboard.nextLine();
                                //개행문자 제거

                                //PlayerAnalyzer class 사용 
                                switch (playerAnalysisChoice) {
                                    case 1: {
                                        footballManager.showAllPlayers();
                                        System.out.println("------------------------------------------");
                                        System.out.println("Enter the first player's name: ");
                                        String player1Name = null;
                                        Player player1 = null;
                                        //String player1Name = keyboard.nextLine();
                                        //Player player1 = footballManager.findPlayerByName(player1Name);
                                        //if (player1 == null) {
                                        //    System.out.println("[!] There is no player whose name is " + player1Name);
                                        //}
                                        while (player1 == null) { 
                                            player1Name = keyboard.nextLine();
                                            player1 = footballManager.findPlayerByName(player1Name);
                                            if (player1 == null) {
                                                System.out.println("[!] There is no player whose name is " + player1Name);
                                            }
                                        }

                                        
                                        System.out.println("Enter the second player's name: ");
                                        String player2Name = null;
                                        Player player2 = null;
                                        while (player2 == null) { 
                                            player2Name = keyboard.nextLine();
                                            player2 = footballManager.findPlayerByName(player2Name);
                                            if (player2 == null) {
                                                System.out.println("[!] There is no player whose name is " + player2Name);
                                            }
                                        }

                                        footballManager.playerAnalyzer.playerComparison(player1, player2);
                                        break;
                                    }
                                    case 2: {
                                        //Ranking Top N
                                        System.out.println("\n----- Ranking Top N -----");
                                        System.out.println("(1) Position-based Ranking");
                                        System.out.println("(2) Stats-based Ranking");
                                        System.out.println("(0) Back to Analysis Menu");
                                        int rankingChoice = -1;
                                        System.out.print("Enter the ranking choice: ");
                                        rankingChoice = keyboard.nextInt();
                                        keyboard.nextLine();
                                        //개행문자 제거

                                        while (rankingChoice < 0 || rankingChoice > 2) {
                                            System.out.print("Enter the ranking choice between 0 and 2: ");
                                            rankingChoice = keyboard.nextInt();
                                            keyboard.nextLine();
                                            //개행문자 제거
                                        }
                                        footballManager.playerAnalyzer.rankingTopN(rankingChoice);
                                        break;
                                    }
                                    case 3: {
                                        //Position-based Analysis
                                        break;
                                    }
                                    case 0: {
                                        //Back to Main Menu
                                        analysisContinue = false;
                                        break;
                                    }
                                    default: {
                                        System.out.println("[!] Invalid input. Please choose between 1 and 3.");
                                        break;
                                    }
                                }
                                break;
                            }
                            case 2: {
                                //Team Analysis
                                System.out.println("----- Team Analysis Options -----");
                                System.out.println("(1) Best 11 Auto Formation");
                                System.out.println("(2) Team Average Stats");
                                System.out.println("(3) Formation Suitability");
                                System.out.println("(0) Back to Analysis Menu");
                                int teamAnalysisChoice = keyboard.nextInt();
                                keyboard.nextLine();

                                switch (teamAnalysisChoice) {
                                    case 1: {
                                        
                                    } 
                                    case 2: {

                                    }
                                    case 3: {

                                    }
                                    case 0: {
                                        break;
                                    }
                                    default: {
                                        System.out.println("[!] Invalid input. Please choose between 1 and 3.");
                                        break;
                                    }
                                }
                                break;
                            }
                            case 0: {
                                analysisContinue = false;
                                break;
                            }         
                            default: {
                                System.out.println("[!] Invalid input. Please choose between 1 and 2.");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 0: {
                    System.out.println("Exit program..");
                    goon = false;
                    break;
                }
                default: {
                    System.out.println("[!] Invalid input. Please choose between 0 and 3.");
                    break;
                }
            }
        } while (goon);

    }
}