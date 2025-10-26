import java.util.Scanner;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class PlayerAnalyzer {
    //footballManager가 가지고 있는 플레이어 데이터 저장
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<League> leagues = new ArrayList<>();

    private Scanner keyboard = new Scanner(System.in);
    private String[] abilities = {
        "1. Shooting", "2. Passing", "3. Dribbling", "4. Crossing", "5. Tackling",
        "6. Heading", "7. Ball Control", "8. Vision", "9. Composure", "10. Decision Making",
        "11. Work Rate", "12. Leadership", "13. Positioning", "14. Off the Ball", "15. Pace",
        "16. Stamina", "17. Strength", "18. Jumping", "19. Agility", "20. Saving", "21. Buildup Play"
    };

    //색상 정의
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String RESET = "\u001B[0m";
    
    //footballManager가 가지고 있는 플레이어 데이터 저장 (원본 참조 or 복사본 참조)
    //추후에 커스텀 선수 or 커스텀 팀을 만들어 분석할 때를 위해 원본 참조로 결정
    public PlayerAnalyzer(ArrayList<Player> players, ArrayList<Team> teams, ArrayList<League> leagues) {
        this.players = players;
        this.teams = teams;
        this.leagues = leagues;
    }

    //메뉴 표시
    public void showMenu() {
        System.out.println("----- Player Analysis Options -----");
        System.out.println("(1) Player Comparison");
        System.out.println("(2) Ranking Top N");
        System.out.println("(3) Position-based Analysis");
        System.out.println("(0) Back to Analysis Menu");
    }

    //플레이어 비교 메뉴 1. 단순 능력치 나열 2. 스파이더 차트 비교
    public void playerComparison(Player player1, Player player2) {
        System.out.println("----- Player Comparison -----");
        System.out.println("(1) Simple Stats Comparison");
        System.out.println("(2) Spider Chart Comparison");
        int choice = keyboard.nextInt();
        keyboard.nextLine();

        switch (choice) {
            case 1: {
                System.out.println("----- Simple Stats Comparison -----");
                System.out.printf("%20s%20s%20s\n", "",player1.getName(), player2.getName());
                System.out.println("------------------------------------------");
                
                System.out.println("------------- Technical Skills -------------");
                compareAbility("Shooting", player1.getShooting(), player2.getShooting());
                compareAbility("Passing", player1.getPassing(), player2.getPassing());
                compareAbility("Dribbling", player1.getDribbling(), player2.getDribbling());
                compareAbility("Crossing", player1.getCrossing(), player2.getCrossing());
                compareAbility("Tackling", player1.getTackling(), player2.getTackling());
                compareAbility("Heading", player1.getHeading(), player2.getHeading());
                compareAbility("Ball Control", player1.getBallControl(), player2.getBallControl());

                System.out.println("--------------- Mental Skills ---------------");
                compareAbility("Vision", player1.getVision(), player2.getVision());
                compareAbility("Composure", player1.getComposure(), player2.getComposure());
                compareAbility("Decision Making", player1.getDecisionMaking(), player2.getDecisionMaking());
                compareAbility("Work Rate", player1.getWorkRate(), player2.getWorkRate());
                compareAbility("Work Rate", player1.getLeadership(), player2.getLeadership());
                compareAbility("Positioning", player1.getPositioning(), player2.getPositioning());   

                System.out.println("-------------- Physical Skills --------------");
                compareAbility("Pace", player1.getPace(), player2.getPace());
                compareAbility("Stamina", player1.getStamina(), player2.getStamina());
                compareAbility("Strength", player1.getStrength(), player2.getStrength());
                compareAbility("Jumping", player1.getJumping(), player2.getJumping());
                compareAbility("Agility", player1.getAgility(), player2.getAgility());

                System.out.println("--------------- GK Skills ---------------");
                compareAbility("Saving", player1.getSaving(), player2.getSaving());
                compareAbility("Buildup Play", player1.getBuildupPlay(), player2.getBuildupPlay());

                break;
            }
            case 2: {
                positionBasedSpiderChart(player1, player2);
                break;
            }
        }
    }
    
    //능력치 비교 및 색상 적용 (높은 값은 녹색, 낮은 값은 빨강)
    private void compareAbility(String abilityName, int value1, int value2) {
        String color1 = value1 >= value2 ? GREEN : RED;
        String color2 = value2 >= value1 ? GREEN : RED;
        
        System.out.printf("%20s%s%20s%s%s%20s%s\n", abilityName, color1, String.valueOf(value1), RESET, color2, String.valueOf(value2), RESET);
    }

    //포지션 기반 스파이더 차트 비교 -> playerComparison 메서드 내에서 호출.
    //PositionAbilities 클래스의 메서드들을 사용. (public class)
    private void positionBasedSpiderChart(Player player1, Player player2) {
        // 포지션 선택 메뉴 표시
        PositionAbilities.showPositionMenu();
        System.out.print("Choose position (1-14): ");
        
        int choice = keyboard.nextInt();
        Position selectedPosition = PositionAbilities.getPositionByChoice(choice);
        
        if (selectedPosition == null) {
            System.out.println("Invalid position choice!");
            return;
        }
        
        // 선택된 포지션의 능력치 가져오기
        String[] abilities = PositionAbilities.getAbilitiesForPosition(selectedPosition);
        
        System.out.println("\nSelected position: " + selectedPosition);
        System.out.println("Comparing abilities: " + String.join(", ", abilities));
        
        // SpiderChartFrame 생성
        SwingUtilities.invokeLater(() -> {
            SpiderChartFrame frame = new SpiderChartFrame(player1, player2, abilities, selectedPosition);
            frame.setVisible(true);
        });
    }

    //상위 N명 랭킹 표시
    public void rankingTopN(int rankingChoice) {
        switch (rankingChoice) {
            case 1: {
                //Position-based Ranking
                PositionAbilities.showPositionMenu();
                System.out.print("\nEnter the position's number you want to rank: ");
                int position = keyboard.nextInt();
                keyboard.nextLine();
                //개행문자 제거

                Position selectedPosition = PositionAbilities.getPositionByChoice(position);

                if (selectedPosition == null) {
                    System.out.println("Invalid position choice!");
                    return;
                }

                System.out.print("Enter the number of players you want to rank: ");
                int numberOfPlayers = keyboard.nextInt();
                while (numberOfPlayers < 0) {
                    System.out.print("Enter the number of players you want to rank: ");
                    numberOfPlayers = keyboard.nextInt();
                    keyboard.nextLine();
                    //개행문자 제거
                }

                //선수 리스트 복사 (원본 침해 방지지)
                List<Player> sortedPlayers = new ArrayList<>(players);

                //선수 정렬
                Collections.sort(sortedPlayers, (p1, p2) -> {
                    double rating1 = p1.evaluatePositionFit(selectedPosition);
                    double rating2 = p2.evaluatePositionFit(selectedPosition);
                    return Double.compare(rating2, rating1);
                });

                //출력
                System.out.println("\n----- Position-based Ranking -----");
                System.out.println("Selected position: " + selectedPosition);
                System.out.println("Number of players to rank: " + numberOfPlayers);

                for (int i = 0; i < Math.min(numberOfPlayers, sortedPlayers.size()); i++) {
                    Player player = sortedPlayers.get(i);
                    System.out.printf("%d. %s - %.2f\n", i + 1, player.getName(), player.evaluatePositionFit(selectedPosition));
                }

                break;
            }
            case 2: {
                //Stats-based Ranking
                
                break;
            }    
            case 0: {
                //Back to Analysis Menu
                break;
            }
            default: {
                System.out.println("[!] Invalid input. Please choose between 0 and 2.");
                break;
            }
        }

        return;
    }
    
    public void positionBasedAnalysis() {
    
    }
    
    
}
