import java.util.HashMap;
import java.util.Map;

//포지션 기반 스파이더 차트 비교를 위한 클래스. 조금 과하지 않나.. 라는 생각은 들긴 함. 겨우 이거 하나 때문에 클래스를 만든다라..
public class PositionAbilities {
    private static final Map<Position, String[]> positionAbilities = new HashMap<>();
    
    static {
        // 공격수 (ST, LW, RW)
        positionAbilities.put(Position.ST, new String[]{"Shooting", "Pace", "Off The Ball", "Composure", "Ball Control", "Strength"});
        positionAbilities.put(Position.LW, new String[]{"Pace", "Dribbling", "Crossing", "Off The Ball", "Ball Control", "Agility"});
        positionAbilities.put(Position.RW, new String[]{"Pace", "Dribbling", "Crossing", "Off The Ball", "Ball Control", "Agility"});
        
        // 미드필더 (CAM, CM, CDM, LM, RM)
        positionAbilities.put(Position.CAM, new String[]{"Passing", "Vision", "Dribbling", "Off The Ball", "Ball Control", "Composure"});
        positionAbilities.put(Position.CM, new String[]{"Passing", "Vision", "Work Rate", "Stamina", "Ball Control", "Decision Making"});
        positionAbilities.put(Position.CDM, new String[]{"Tackling", "Passing", "Work Rate", "Stamina", "Positioning", "Strength"});
        positionAbilities.put(Position.LM, new String[]{"Crossing", "Passing", "Work Rate", "Stamina", "Dribbling", "Pace"});
        positionAbilities.put(Position.RM, new String[]{"Crossing", "Passing", "Work Rate", "Stamina", "Dribbling", "Pace"});
        
        // 수비수 (CB, LB, RB, LWB, RWB)
        positionAbilities.put(Position.CB, new String[]{"Tackling", "Heading", "Strength", "Positioning", "Jumping", "Composure"});
        positionAbilities.put(Position.LB, new String[]{"Tackling", "Crossing", "Pace", "Stamina", "Positioning", "Passing"});
        positionAbilities.put(Position.RB, new String[]{"Tackling", "Crossing", "Pace", "Stamina", "Positioning", "Passing"});
        positionAbilities.put(Position.LWB, new String[]{"Tackling", "Crossing", "Pace", "Stamina", "Positioning", "Passing"});
        positionAbilities.put(Position.RWB, new String[]{"Tackling", "Crossing", "Pace", "Stamina", "Positioning", "Passing"});
        
        // 골키퍼 (GK)
        positionAbilities.put(Position.GK, new String[]{"Saving", "Buildup Play", "Composure", "Positioning", "Leadership", "Decision Making"});
    }
    
    public static String[] getAbilitiesForPosition(Position position) {
        return positionAbilities.get(position);
    }
    
    public static void showPositionMenu() {
        System.out.println("\n=== Select Position for Comparison ===");
        System.out.println("1. ST (Striker)");
        System.out.println("2. LW (Left Winger)");
        System.out.println("3. RW (Right Winger)");
        System.out.println("4. CAM (Central Attacking Midfielder)");
        System.out.println("5. CM (Central Midfielder)");
        System.out.println("6. CDM (Central Defensive Midfielder)");
        System.out.println("7. LM (Left Midfielder)");
        System.out.println("8. RM (Right Midfielder)");
        System.out.println("9. CB (Center Back)");
        System.out.println("10. LB (Left Back)");
        System.out.println("11. RB (Right Back)");
        System.out.println("12. LWB (Left Wing Back)");
        System.out.println("13. RWB (Right Wing Back)");
        System.out.println("14. GK (Goalkeeper)");
    }
    
    //포지션 선택 메뉴에서 선택한 포지션을 반환.
    public static Position getPositionByChoice(int choice) {
        switch (choice) {
            case 1: return Position.ST;
            case 2: return Position.LW;
            case 3: return Position.RW;
            case 4: return Position.CAM;
            case 5: return Position.CM;
            case 6: return Position.CDM;
            case 7: return Position.LM;
            case 8: return Position.RM;
            case 9: return Position.CB;
            case 10: return Position.LB;
            case 11: return Position.RB;
            case 12: return Position.LWB;
            case 13: return Position.RWB;
            case 14: return Position.GK;
            default: return null;
        }
    }
} 