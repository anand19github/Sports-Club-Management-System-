import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class AdminDashboard {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Admin Dashboard - View Registrations");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel background = new JLabel(new ImageIcon("images/admin.jpg"));
        background.setLayout(new BorderLayout());
        frame.setContentPane(background);

        JLabel heading = new JLabel("All Registrations", SwingConstants.CENTER);
        heading.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 26));
        heading.setForeground(Color.WHITE);
        background.add(heading, BorderLayout.NORTH);

        String[] columnNames = {"ID", "Name", "Email", "Phone", "Sport"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        table.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        table.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton backBtn = new JButton("Back to Home");
        backBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(30, 30, 30));
        bottomPanel.add(backBtn);

        background.add(scrollPane, BorderLayout.CENTER);
        background.add(bottomPanel, BorderLayout.SOUTH);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sportsclub", "root", "");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM registrations")) {

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("sport")
                };
                tableModel.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error loading data: " + e.getMessage());
        }

        backBtn.addActionListener(e -> {
            frame.dispose();
            HomePage.main(null);
        });

        frame.setVisible(true);
    }
}
