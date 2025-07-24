import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.sql.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class CricketPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cricket Registration");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Background image
        JLabel background = new JLabel(new ImageIcon("images/cricket.jpg"));
        background.setLayout(new BorderLayout());
        frame.setContentPane(background);

        JLabel title = new JLabel("Cricket Registration", SwingConstants.CENTER);
        title.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        background.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 15, 15));
        formPanel.setBackground(new Color(30, 30, 30));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 150, 30, 150));

        java.awt.Font labelFont = new java.awt.Font("Arial", java.awt.Font.PLAIN, 16);
        java.awt.Font inputFont = new java.awt.Font("Arial", java.awt.Font.PLAIN, 16);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        nameLabel.setForeground(Color.WHITE);
        JTextField nameField = new JTextField();
        nameField.setFont(inputFont);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(labelFont);
        emailLabel.setForeground(Color.WHITE);
        JTextField emailField = new JTextField();
        emailField.setFont(inputFont);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(labelFont);
        phoneLabel.setForeground(Color.WHITE);
        JTextField phoneField = new JTextField();
        phoneField.setFont(inputFont);

        JButton submitButton = new JButton("Register");
        JButton backButton = new JButton("Back to Home");

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(phoneLabel);
        formPanel.add(phoneField);
        formPanel.add(backButton);
        formPanel.add(submitButton);

        background.add(formPanel, BorderLayout.CENTER);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String sport = "Cricket";

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sportsclub", "root", "");
                    PreparedStatement stmt = conn.prepareStatement(
                            "INSERT INTO registrations (name, email, phone, sport) VALUES (?, ?, ?, ?)")) {

                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, phone);
                stmt.setString(4, sport);
                stmt.executeUpdate();

                // Generate PDF
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream("Cricket_Registration_" + name + ".pdf"));
                document.open();
                document.add(new Paragraph(
                        "Thank you " + name + " for registering for Cricket!\nWe'll contact you at " + email));
                document.close();

                JOptionPane.showMessageDialog(frame, "Registration Successful!\nPDF generated.");
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
