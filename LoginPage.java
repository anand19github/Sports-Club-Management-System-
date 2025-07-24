import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton, signupButton;

    public LoginPage() {
        setTitle("Sports Club Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.DARK_GRAY);
        setLayout(null);

        JLabel heading = new JLabel("Login");
        heading.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));
        heading.setForeground(Color.WHITE);
        heading.setBounds(150, 20, 100, 30);
        add(heading);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        userLabel.setBounds(50, 80, 100, 30);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 80, 180, 30);
        add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.WHITE);
        passLabel.setBounds(50, 130, 100, 30);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 130, 180, 30);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(80, 190, 100, 30);
        loginButton.addActionListener(this);
        add(loginButton);

        signupButton = new JButton("Sign Up");
        signupButton.setBounds(200, 190, 100, 30);
        signupButton.addActionListener(this);
        add(signupButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        if (e.getSource() == loginButton) {
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sportsclub", "root", "");
                PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
                pst.setString(1, user);
                pst.setString(2, pass);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    String role = rs.getString("role");
                    if (role.equals("admin")) {
                        JOptionPane.showMessageDialog(this, "Welcome Admin!");
                        new AdminDashboard();
                    } else {
                        JOptionPane.showMessageDialog(this, "Welcome " + user + "!");
                        new HomePage(); // assuming HomePage is the main user dashboard
                    }
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid credentials!");
                }

                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == signupButton) {
            new SignUpPage();
            dispose();
        }
    }

    // ✅ Main method for direct execution
    public static void main(String[] args) {
        new LoginPage();
    }
}
