import javax.swing.*;
import java.awt.*;

public class WelcomePage extends JFrame {
    public WelcomePage() {
        setTitle("Welcome - Sports Club");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBackground(new Color(30, 30, 30)); // Dark background

        JLabel title = new JLabel("Sports Club Management", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        JButton loginBtn = new JButton("Login");
        JButton signupBtn = new JButton("Sign Up");

        loginBtn.addActionListener(e -> {
            new LoginPage();
            dispose();
        });

        signupBtn.addActionListener(e -> {
            new SignUpPage();
            dispose();
        });

        panel.add(loginBtn);
        panel.add(signupBtn);

        add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
