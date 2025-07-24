import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sports Club Home");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel background = new JLabel(new ImageIcon("images/home.jpg"));
        background.setLayout(new BorderLayout());
        frame.setContentPane(background);

        JLabel heading = new JLabel("Welcome to the Sports Club", SwingConstants.CENTER);
        heading.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 28));
        heading.setForeground(Color.WHITE);
        background.add(heading, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 20, 20));
        buttonPanel.setBackground(new Color(0, 0, 0, 150));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 150, 50, 150));

        JButton footballBtn = new JButton("Football");
        JButton cricketBtn = new JButton("Cricket");
        JButton basketballBtn = new JButton("Basketball");
        JButton badmintonBtn = new JButton("Badminton");
        JButton adminBtn = new JButton("Admin Dashboard");
        JButton exitBtn = new JButton("Exit");

        java.awt.Font btnFont = new java.awt.Font("Arial", java.awt.Font.BOLD, 16);
        for (JButton btn : new JButton[] { footballBtn, cricketBtn, basketballBtn, badmintonBtn, adminBtn, exitBtn }) {
            btn.setFont(btnFont);
            buttonPanel.add(btn);
        }

        background.add(buttonPanel, BorderLayout.CENTER);

        footballBtn.addActionListener(e -> {
            frame.dispose();
            FootballPage.main(null);
        });

        cricketBtn.addActionListener(e -> {
            frame.dispose();
            CricketPage.main(null);
        });

        basketballBtn.addActionListener(e -> {
            frame.dispose();
            BasketballPage.main(null);
        });

        badmintonBtn.addActionListener(e -> {
            frame.dispose();
            BadmintonPage.main(null);
        });

        adminBtn.addActionListener(e -> {
            frame.dispose();
            AdminDashboard.main(null);
        });

        exitBtn.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }
}
