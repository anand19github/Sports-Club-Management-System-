// === FootballPage.java ===
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class FootballPage extends JFrame {
    public FootballPage() {
        setTitle("Football Registration");
        setSize(600, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel heading = new JLabel("Football Registration");
        heading.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));
        heading.setForeground(Color.WHITE);
        heading.setHorizontalAlignment(JLabel.CENTER);

        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.DARK_GRAY);
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.WHITE);
        JTextField nameField = new JTextField();
        nameField.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        JTextField emailField = new JTextField();
        emailField.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setForeground(Color.WHITE);
        JTextField phoneField = new JTextField();
        phoneField.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));

        JButton submitBtn = new JButton("Submit");
        submitBtn.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            saveToDatabase(name, email, phone, "Football");
            generatePDF(name, "Football");
            JOptionPane.showMessageDialog(this, "Registration Successful!");
        });

        JButton homeBtn = new JButton("Back to Home");
        homeBtn.addActionListener(e -> {
            dispose();
            new HomePage();
        });

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(phoneLabel);
        formPanel.add(phoneField);
        formPanel.add(submitBtn);
        formPanel.add(homeBtn);

        setLayout(new BorderLayout());
        add(heading, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void saveToDatabase(String name, String email, String phone, String sport) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sportsclub", "root", "");
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO registrations(name, email, phone, sport) VALUES (?, ?, ?, ?)");) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            stmt.setString(4, sport);
            stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void generatePDF(String name, String sport) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(name + "_" + sport + "_Registration.pdf"));
            document.open();
            document.add(new Paragraph("Thank you " + name + " for registering in " + sport + "."));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FootballPage();
    }
}
