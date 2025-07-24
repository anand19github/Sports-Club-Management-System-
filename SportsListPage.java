import javax.swing.*;
import java.awt.*;

public class SportsListPage extends JFrame {

    public SportsListPage() {
        setTitle("Available Sports");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(Color.DARK_GRAY);

        JLabel titleLabel = new JLabel("Choose a Sport to Register");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(100, 30, 300, 30);
        add(titleLabel);

        JButton cricketBtn = new JButton("Cricket");
        cricketBtn.setBounds(150, 80, 200, 30);
        add(cricketBtn);

        JButton footballBtn = new JButton("Football");
        footballBtn.setBounds(150, 130, 200, 30);
        add(footballBtn);

        JButton basketballBtn = new JButton("Basketball");
        basketballBtn.setBounds(150, 180, 200, 30);
        add(basketballBtn);

        JButton badmintonBtn = new JButton("Badminton");
        badmintonBtn.setBounds(150, 230, 200, 30);
        add(badmintonBtn);

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(150, 280, 200, 30);
        add(logoutBtn);

        // Action listeners to open each sport page
        cricketBtn.addActionListener(e -> new CricketPage());
        footballBtn.addActionListener(e -> new FootballPage());
        basketballBtn.addActionListener(e -> new BasketballPage());
        badmintonBtn.addActionListener(e -> new BadmintonPage());
        logoutBtn.addActionListener(e -> {
            new LoginPage();
            dispose();
        });

        setVisible(true);
    }
}
