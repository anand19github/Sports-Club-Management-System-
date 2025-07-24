
// LoginPage.java
import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {

    public LoginPage() {
        setTitle("Sports Club Login");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Set dark background
        getContentPane().setBackground(Color.DARK_GRAY);

        JLabel titleLabel = new JLabel("Login to Sports Club");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(90, 20, 250, 30);
        add(titleLabel);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        userLabel.setBounds(50, 70, 80, 25);
        add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(150, 70, 180, 25);
        add(userText);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.WHITE);
        passLabel.setBounds(50, 110, 80, 25);
        add(passLabel);

        JPasswordField passText = new JPasswordField();
        passText.setBounds(150, 110, 180, 25);
        add(passText);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(80, 160, 100, 30);
        add(loginBtn);

        JButton signupBtn = new JButton("Sign Up");
        signupBtn.setBounds(200, 160, 100, 30);
        add(signupBtn);

        // Login logic for Admin and Users
        loginBtn.addActionListener(e -> {
            String username = userText.getText();
            String password = String.valueOf(passText.getPassword());

            if (username.equals("admin") && password.equals("admin123")) {
                JOptionPane.showMessageDialog(null, "Admin Login Successful!");
                new HomePage(); // Admin dashboard
                dispose();
            } else if (UserStore.isUserValid(username, password)) {
                JOptionPane.showMessageDialog(null, "User Login Successful!");
                new SportsListPage(); // User page
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid credentials!");
            }
        });

        // Sign-up page redirect
        signupBtn.addActionListener(e -> {
            new SignUpPage();
            dispose();
        });

        setVisible(true);
    }
}
