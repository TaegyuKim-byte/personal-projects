import java.util.EnumMap;
import java.util.Objects;

public class Player {
    //Information about player himself
    private String name;
    private int age;
    private String country;

    //Information about football skill

    private String teamName;

    //Preferred Position
    private Position preferredPosition;

    //Foot
    private int leftFoot;
    private int rightFoot;

    //Technical Skills //FM 2025 stats name
    private int shooting; //finishing
    private int passing; //passing
    private int dribbling; // dribbling
    private int crossing; //crossing
    private int tackling; //tackling
    private int heading; //heading
    private int ballControl; //First Touch

    //Mental Skills //FM 2025 stats name
    private int vision; //vision
    private int composure; //침착성 //composure
    private int decisionMaking; //decisions
    private int workRate; //활동량, 헌신성 //work rate
    private int leadership; //leadership
    private int positioning; //positioning
    private int offTheBall; //off the ball

    //Physical Skills //FM 2025 stats name
    private int pace; //스피드 (속도 + 가속도) //pace
    private int stamina; //체력 //stamina
    private int strength; //strength
    private int jumping; //jumping reach
    private int agility; //민첩성 (턴, 회피 등) //agility

    //GK 전용 //FM 2025 stats name
    private int saving; //Average of Aerial Reach + Handling + Reflexes + One-on-One + Rushing Out
    private int buildupPlay; //Average of Kicking + First Touch + Passing + Throwing

    private EnumMap<Position, Double> positionFitEnumMap;

    public Player(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;

        positionFitEnumMap = new EnumMap<>(Position.class);
    }

    public String getName() { return this.name; }
    public int getAge() { return this.age; }
    public String getCountry() { return this.country; }

    public String getTeam() { return teamName; }

    public void setTeam(String teamName) { this.teamName = teamName; }

    public Position getPreferredPosition() { return preferredPosition; }

    public void setPreferredPosition(Position preferredPosition) {
        this.preferredPosition = preferredPosition;
    }

    public int getLeftFoot() { return leftFoot; }

    public void setLeftFoot(int leftFoot) { this.leftFoot = leftFoot; }

    public int getRightFoot() { return rightFoot; }

    public void setRightFoot(int rightFoot) { this.rightFoot = rightFoot; }

    public int getShooting() {
        return shooting;
    }

    public void setShooting(int shooting) {
        this.shooting = shooting;
    }

    public int getPassing() {
        return passing;
    }

    public void setPassing(int passing) {
        this.passing = passing;
    }

    public int getDribbling() {
        return dribbling;
    }

    public void setDribbling(int dribbling) {
        this.dribbling = dribbling;
   }

    public int getCrossing() {
        return crossing;
    }

    public void setCrossing(int crossing) {
        this.crossing = crossing;
    }

    public int getTackling() {
        return tackling;
    }

    public void setTackling(int tackling) {
        this.tackling = tackling;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public int getBallControl() {
        return ballControl;
    }

    public void setBallControl(int ballControl) {
        this.ballControl = ballControl;
    }

    public int getVision() {
        return vision;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }

    public int getComposure() {
        return composure;
    }

    public void setComposure(int composure) {
        this.composure = composure;
    }

    public int getDecisionMaking() {
        return decisionMaking;
    }

    public void setDecisionMaking(int decisionMaking) {
        this.decisionMaking = decisionMaking;
    }

    public int getWorkRate() {
        return workRate;
    }

    public void setWorkRate(int workRate) {
        this.workRate = workRate;
    }

    public int getLeadership() {
        return leadership;
    }

    public void setLeadership(int leadership) {
        this.leadership = leadership;
    }

    public int getPositioning() {
        return positioning;
    }

    public void setPositioning(int positioning) {
        this.positioning = positioning;
    }

    public int getOffTheBall() {
        return offTheBall;
    }

    public void setOffTheBall(int offTheBall) {
        this.offTheBall = offTheBall;
    }

    public int getPace() {
        return pace;
    }

    public void setPace(int pace) {
        this.pace = pace;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getJumping() {
        return jumping;
    }

    public void setJumping(int jumping) {
        this.jumping = jumping;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getSaving() {
        return saving;
    }

    public void setSaving(int saving) {
        this.saving = saving;
    }

    public int getBuildupPlay() {
        return buildupPlay;
    }

    public void setBuildupPlay(int buildupPlay) { this.buildupPlay = buildupPlay; }

    //포지션 적합도가 담긴 EnumMap 반환
    public EnumMap<Position, Double> getPositionFitEnumMap() {
        return this.positionFitEnumMap;
    }

    //단일 포지션 적합도 반환
    public double getSinglePositionFit(Position pos) {
        if (this.positionFitEnumMap.isEmpty()) calculateAllFit();
        return this.positionFitEnumMap.getOrDefault(pos, 0.0);
    }

    //단일 선수 검색(분석) 시 사용
    public void showPlayer() {
        System.out.println("=== Player Info ===");
        System.out.println("Name: " + name + " (" + age + ", " + country + ")");
        System.out.println("Foot: L" + leftFoot + " / R" + rightFoot);

        System.out.println("--- Technical Skills ---");
        System.out.println("Shooting: " + shooting + " | Passing: " + passing + " | Dribbling: " + dribbling);
        System.out.println("Crossing: " + crossing + " | Tackling: " + tackling + " | Heading: " + heading);
        System.out.println("Ball Control: " + ballControl);

        System.out.println("--- Mental Skills ---");
        System.out.println("Vision: " + vision + " | Composure: " + composure + " | Decision Making: " + decisionMaking);
        System.out.println("Work Rate: " + workRate + " | Leadership: " + leadership);
        System.out.println("Positioning: " + positioning + " | Off The Ball: " + offTheBall);

        System.out.println("--- Physical Skills ---");
        System.out.println("Pace: " + pace + " | Stamina: " + stamina + " | Strength: " + strength);
        System.out.println("Jumping: " + jumping + " | Agility: " + agility);

        System.out.println("--- Goalkeeper Skills ---");
        System.out.println("Saving: " + saving + " | Buildup Play: " + buildupPlay);

        System.out.println("--- Top 3 Position Fit Scores ---");
        // 포지션 적합도를 내림차순으로 정렬하여 상위 3개 출력
        positionFitEnumMap.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .limit(3)
                .forEach(entry -> System.out.printf(" %s: %.2f\n", entry.getKey(), entry.getValue()));
    }

    public void calculateAllFit() {
        for (Position pos : Position.values()) {
            double fitscore = evaluatePositionFit(pos);
            if (pos == preferredPosition) {
                fitscore *= 1.05;
            }
            this.positionFitEnumMap.put(pos, fitscore);
        }
    }

    //전술 트렌드에 따라 변경 가능
    public double getFootMultiplier(Position pos, boolean isInverted) {
        int footScore;

        switch (pos) {
            case RW: {
                footScore = isInverted ? leftFoot : rightFoot;
                break;
            }
            case RB:
                footScore = rightFoot;
                break;
            case LW: {
                footScore = isInverted ? rightFoot : leftFoot;
                break;
            }
            case LB: {
                footScore = leftFoot;
                break;
            }
            case RM: {
                footScore = isInverted ? leftFoot : rightFoot;
                break;
            }
            case LM: {
                footScore = isInverted ? rightFoot : leftFoot;
                break;
            }
            case LWB: {
                footScore = leftFoot;
                break;
            }
            case RWB: {
                footScore = rightFoot;
                break;
            }
            default:
                return 1.0; // 중앙 포지션 등은 보정 없음
        }

        // FM 스타일 보정 로직
        if (footScore >= 85) return 1.0;
        else if (footScore >= 70) return 0.95 + (footScore - 70) * 0.003;
        else if (footScore >= 60) return 0.85 + (footScore - 60) * 0.01;
        else if (footScore >= 50) return 0.75 + (footScore - 50) * 0.01;
        else return 0.6 + (footScore * 0.003); // 0~49
    }

    public double evaluatePositionFit(Position pos) {
        double base;

        switch (pos) {
            case ST: {
                return shooting * 0.4 + offTheBall * 0.3 + positioning * 0.2 + pace * 0.1;
            }
            case RW: {
                base = dribbling * 0.3 + pace * 0.3 + crossing * 0.2 + offTheBall * 0.2;
                double notInverted = getFootMultiplier(Position.RW, false) * base; //정발

                base = dribbling * 0.25 + offTheBall * 0.25 + shooting * 0.25 + composure * 0.15 + agility * 0.1;
                double Inverted = getFootMultiplier(Position.RW, true) * base; //역발

                return Math.max(Inverted, notInverted);
            }
            case LW: {
                base = dribbling * 0.3 + pace * 0.3 + crossing * 0.2 + offTheBall * 0.2;
                double notInverted = getFootMultiplier(Position.LW, false) * base; //정발

                base = dribbling * 0.25 + offTheBall * 0.25 + shooting * 0.25 + composure * 0.15 + agility * 0.1;
                double Inverted = getFootMultiplier(Position.LW, true) * base; //역발

                return Math.max(Inverted, notInverted);
            }
            case CAM: {
                return vision * 0.35 + passing * 0.3 + ballControl * 0.2 + decisionMaking * 0.15;
            }
            case CM: {
                return passing * 0.35 + stamina * 0.25 + vision * 0.2 + workRate * 0.2;
            }
            case CDM: {
                return tackling * 0.4 + positioning * 0.3 + strength * 0.2 + passing * 0.1;
            }
            case LM: {
                base = crossing * 0.35 + passing * 0.25 + stamina * 0.2 + workRate * 0.15 + pace * 0.05;
                double notInverted = getFootMultiplier(Position.LM, false) * base; // 정발 (크로스 중심)
    
                base = passing * 0.3 + shooting * 0.25 + offTheBall * 0.2 + composure * 0.15 + agility * 0.1;
                double inverted = getFootMultiplier(Position.LM, true) * base; // 역발 (안쪽 슈팅)
    
                return Math.max(inverted, notInverted);
            }
            case RM: {
                base = crossing * 0.35 + passing * 0.25 + stamina * 0.2 + workRate * 0.15 + pace * 0.05;
                double notInverted = getFootMultiplier(Position.RM, false) * base; // 정발 (크로스 중심)
    
                base = passing * 0.3 + shooting * 0.25 + offTheBall * 0.2 + composure * 0.15 + agility * 0.1;
                double inverted = getFootMultiplier(Position.RM, true) * base; // 역발 (안쪽 슈팅)
    
                return Math.max(inverted, notInverted);
            }
            case RB: {
                base = tackling * 0.3 + pace * 0.3 + crossing * 0.2 + stamina * 0.2;
                return base * getFootMultiplier(Position.RB, false);
            }
            case LB: {
                base = tackling * 0.3 + pace * 0.3 + crossing * 0.2 + stamina * 0.2;
                return base * getFootMultiplier(Position.LB, false);
            }
            case CB: {
                return tackling * 0.4 + heading * 0.3 + strength * 0.2 + positioning * 0.1;
            }
            case LWB: { 
                base = crossing * 0.3 + tackling * 0.25 + pace * 0.2 + stamina * 0.15 + passing * 0.1;
                return base * getFootMultiplier(Position.LWB, false);
            }
            case RWB: {
                base = crossing * 0.3 + tackling * 0.25 + pace * 0.2 + stamina * 0.15 + passing * 0.1;
                return base * getFootMultiplier(Position.RWB, false);
            }
            case GK: {
                return saving * 0.5 + positioning * 0.2 + buildupPlay * 0.2 + jumping * 0.1;
            }
            default:
                return 0.0;
        }
    }

    //팀 검색 시 구성원으로서의 출력 시 사용
    public String toString() {
        return (this.name + "(" + this.age + ", " + this.country + ", " + this.preferredPosition + ")");
    }
}