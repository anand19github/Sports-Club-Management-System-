
// SignUpPage.java
import javax.swing.*;
import java.awt.*;

public class SignUpPage extends JFrame {

    public SignUpPage() {
        setTitle("User Registration - Sports Club");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Dark background
        getContentPane().setBackground(Color.DARK_GRAY);

        JLabel titleLabel = new JLabel("Create a New Account");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
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

        JButton signUpBtn = new JButton("Register");
        signUpBtn.setBounds(140, 170, 120, 30);
        add(signUpBtn);

        // Sign-up logic
        signUpBtn.addActionListener(e -> {
            String username = userText.getText();
            String password = String.valueOf(passText.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all fields.");
                return;
            }

            UserStore.addUser(username, password);
            JOptionPane.showMessageDialog(null, "User registered successfully!");
            new LoginPage();
            dispose();
        });

        setVisible(true);
    }
}
