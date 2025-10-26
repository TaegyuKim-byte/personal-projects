import javax.swing.*;
import java.awt.*;

public class SpiderChartFrame extends JFrame {
    private Player player1;
    private Player player2;
    private String[] abilities;
    private Position position;
    
    public SpiderChartFrame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        
        // 기본 능력치 설정
        this.abilities = new String[]{"Shooting", "Passing", "Dribbling", "Pace", "Stamina", "Tackling"};
        this.position = null;
        
        // 프레임 설정
        setTitle("Player Comparison - Spider Chart");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        add(new SpiderChartPanel(player1, player2, abilities, position));
    }
    
    public SpiderChartFrame(Player player1, Player player2, String[] abilities, Position position) {
        this.player1 = player1;
        this.player2 = player2;
        this.abilities = abilities;
        this.position = position;
        
        // 프레임 설정
        setTitle("Player Comparison - " + position + " Position");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        add(new SpiderChartPanel(player1, player2, abilities, position));
    }
    
    // 텍스트를 출력하는 패널
    class TextPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // 제목 표시
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 20));
            g2d.drawString("Player Comparison", 50, 50);
            
            // 선수 정보 표시
            g2d.setFont(new Font("Arial", Font.PLAIN, 14));
            g2d.drawString(player1.getName() + " vs " + player2.getName(), 50, 80);
            
            // 능력치 비교 표시
            g2d.drawString("Shooting: " + player1.getShooting() + " vs " + player2.getShooting(), 50, 110);
            g2d.drawString("Passing: " + player1.getPassing() + " vs " + player2.getPassing(), 50, 130);
            g2d.drawString("Dribbling: " + player1.getDribbling() + " vs " + player2.getDribbling(), 50, 150);
            g2d.drawString("Pace: " + player1.getPace() + " vs " + player2.getPace(), 50, 170);
            g2d.drawString("Stamina: " + player1.getStamina() + " vs " + player2.getStamina(), 50, 190);
        }
    }

    class SpiderChartPanel extends JPanel {
        private Player player1;
        private Player player2;
        private String[] abilities;
        private Position position;

        public SpiderChartPanel(Player player1, Player player2) {
            this.player1 = player1;
            this.player2 = player2;
            this.abilities = new String[]{"Shooting", "Passing", "Dribbling", "Pace", "Stamina", "Tackling"};
            this.position = null;
        }
        
        public SpiderChartPanel(Player player1, Player player2, String[] abilities, Position position) {
            this.player1 = player1;
            this.player2 = player2;
            this.abilities = abilities;
            this.position = position;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // 패널 크기 가져오기
            int width = getWidth();
            int height = getHeight();
            int centerX = width / 2;
            int centerY = height / 2;
            int radius = Math.min(width, height) / 3;  // 차트 반지름
            
            // 배경 그리기
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, width, height);
            
            // 제목 그리기
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 18));
            String title = "Player Comparison - Spider Chart";
            FontMetrics fm = g2d.getFontMetrics();
            int titleX = (width - fm.stringWidth(title)) / 2;
            g2d.drawString(title, titleX, 30);
            
            // 선수 이름 그리기
            g2d.setFont(new Font("Arial", Font.PLAIN, 10));
            String player1Name = player1.getName() + " (Blue)";
            String player2Name = player2.getName() + " (Red)";
            g2d.setColor(Color.BLUE);
            g2d.drawString(player1Name, 20, height - 60);
            g2d.setColor(Color.RED);
            g2d.drawString(player2Name, 20, height - 40);
            
            // 축 그리기
            drawAxis(g2d, centerX, centerY, radius);
            
            // 선수 데이터 그리기
            drawPlayerData(g2d, centerX, centerY, radius, player1, Color.BLUE);
            drawPlayerData(g2d, centerX, centerY, radius, player2, Color.RED);
        }
        
        private void drawAxis(Graphics2D g2d, int centerX, int centerY, int radius) {
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.setStroke(new BasicStroke(1));
            
            int abilityCount = abilities.length;
            double angleStep = 360.0 / abilityCount;  // 동적 각도 계산
            
            // 축 그리기
            for (int i = 0; i < abilityCount; i++) {
                double angle = Math.toRadians(i * angleStep);
                int endX = centerX + (int) (radius * Math.cos(angle));
                int endY = centerY - (int) (radius * Math.sin(angle));
                g2d.drawLine(centerX, centerY, endX, endY);
                
                // 축 라벨 그리기
                String label = abilities[i];
                FontMetrics fm = g2d.getFontMetrics();
                int labelX = centerX + (int) ((radius + 20) * Math.cos(angle)) - fm.stringWidth(label) / 2;
                int labelY = centerY - (int) ((radius + 20) * Math.sin(angle)) + fm.getAscent() / 2;
                g2d.setColor(Color.BLACK);
                g2d.drawString(label, labelX, labelY);
            }
            
            // 동심원 그리기 (20, 40, 60, 80, 100 단위)
            for (int level = 1; level <= 5; level++) {
                int circleRadius = (radius * level) / 5;
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.drawOval(centerX - circleRadius, centerY - circleRadius, 
                             circleRadius * 2, circleRadius * 2);
            }
        }
        
        private void drawPlayerData(Graphics2D g2d, int centerX, int centerY, int radius, Player player, Color color) {
            g2d.setColor(color);
            g2d.setStroke(new BasicStroke(2));
            
            // 능력치 값 가져오기
            int[] values = getAbilityValues(player, abilities);
            
            // 다각형 그리기
            int[] xPoints = new int[abilities.length];
            int[] yPoints = new int[abilities.length];
            
            for (int i = 0; i < abilities.length; i++) {
                double angle = Math.toRadians(i * (360.0 / abilities.length));
                double valueRatio = values[i] / 100.0;  // 100점 만점 기준
                int pointRadius = (int) (radius * valueRatio);
                
                xPoints[i] = centerX + (int) (pointRadius * Math.cos(angle));
                yPoints[i] = centerY - (int) (pointRadius * Math.sin(angle));
            }
            
            // 다각형 채우기 (투명도 적용)
            Color fillColor = new Color(color.getRed(), color.getGreen(), color.getBlue(), 50);
            g2d.setColor(fillColor);
            g2d.fillPolygon(xPoints, yPoints, abilities.length);
            
            // 다각형 테두리 그리기
            g2d.setColor(color);
            g2d.drawPolygon(xPoints, yPoints, abilities.length);
            
            // 각 점에 원 그리기
            g2d.setColor(color);
            for (int i = 0; i < abilities.length; i++) {
                g2d.fillOval(xPoints[i] - 3, yPoints[i] - 3, 6, 6);
            }
        }
        
        private int[] getAbilityValues(Player player, String[] abilities) {
            int[] values = new int[abilities.length];
            for (int i = 0; i < abilities.length; i++) {
                switch (abilities[i]) {
                    case "Shooting": values[i] = player.getShooting(); break;
                    case "Passing": values[i] = player.getPassing(); break;
                    case "Dribbling": values[i] = player.getDribbling(); break;
                    case "Crossing": values[i] = player.getCrossing(); break;
                    case "Tackling": values[i] = player.getTackling(); break;
                    case "Heading": values[i] = player.getHeading(); break;
                    case "Ball Control": values[i] = player.getBallControl(); break;
                    case "Vision": values[i] = player.getVision(); break;
                    case "Composure": values[i] = player.getComposure(); break;
                    case "Decision Making": values[i] = player.getDecisionMaking(); break;
                    case "Work Rate": values[i] = player.getWorkRate(); break;
                    case "Leadership": values[i] = player.getLeadership(); break;
                    case "Positioning": values[i] = player.getPositioning(); break;
                    case "Off The Ball": values[i] = player.getOffTheBall(); break;
                    case "Pace": values[i] = player.getPace(); break;
                    case "Stamina": values[i] = player.getStamina(); break;
                    case "Strength": values[i] = player.getStrength(); break;
                    case "Jumping": values[i] = player.getJumping(); break;
                    case "Agility": values[i] = player.getAgility(); break;
                    case "Saving": values[i] = player.getSaving(); break;
                    case "Buildup Play": values[i] = player.getBuildupPlay(); break;
                }
            }
            return values;
        }
    }
} 