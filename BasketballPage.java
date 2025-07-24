import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.sql.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class BasketballPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Basketball Registration");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel background = new JLabel(new ImageIcon("images/basketball.jpg"));
        background.setLayout(new BorderLayout());
        frame.setContentPane(background);

        JLabel title = new JLabel("Basketball Registration", SwingConstants.CENTER);
        title.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        background.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 15, 15));
        formPanel.setBackground(new Color(30, 30, 30));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 150, 30, 150));

        java.awt.Font labelFont = new java.awt.Font("Arial", java.awt.Font.PLAIN, 16);
        java.awt.Font inputFont = new java.awt.Font("Arial", java.awt.Font.PLAIN, 16);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(labelFont);
        JTextField nameField = new JTextField();
        nameField.setFont(inputFont);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(labelFont);
        JTextField emailField = new JTextField();
        emailField.setFont(inputFont);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setForeground(Color.WHITE);
        phoneLabel.setFont(labelFont);
        JTextField phoneField = new JTextField();
        phoneField.setFont(inputFont);

        JButton backButton = new JButton("Back to Home");
        JButton registerButton = new JButton("Register");

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(phoneLabel);
        formPanel.add(phoneField);
        formPanel.add(backButton);
        formPanel.add(registerButton);

        background.add(formPanel, BorderLayout.CENTER);

        registerButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String sport = "Basketball";

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sportsclub", "root", "");
                    PreparedStatement stmt = conn.prepareStatement(
                            "INSERT INTO registrations (name, email, phone, sport) VALUES (?, ?, ?, ?)")) {

                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, phone);
                stmt.setString(4, sport);
                stmt.executeUpdate();

                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream("Basketball_Registration_" + name + ".pdf"));
                document.open();
                document.add(new Paragraph(
                        "Thank you " + name + " for registering for Basketball!\nWe’ll contact you at " + email));
                document.close();

                JOptionPane.showMessageDialog(frame, "Registration Successful!\nPDF Generated.");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        backButton.addActionListener(e -> {
            frame.dispose();
            HomePage.main(null);
        });

        frame.setVisible(true);
    }
}
