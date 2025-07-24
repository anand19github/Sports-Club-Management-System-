import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StaffPage extends JFrame {
    private ArrayList<String> staffs = new ArrayList<>();
    private JTextArea displayArea;

    public StaffPage() {
        setTitle("Staff Info");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel background = new JLabel(new ImageIcon("images/background.jpg"));
        background.setLayout(new BorderLayout());
        add(background);

        JLabel header = new JLabel("Registered Staff", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 22));
        header.setForeground(Color.WHITE);
        background.add(header, BorderLayout.NORTH);

        displayArea = new JTextArea();
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        displayArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(displayArea);
        background.add(scrollPane, BorderLayout.CENTER);

        JButton registerBtn = new JButton("Register Student");
        registerBtn.setBackground(new Color(0, 153, 76));
        registerBtn.setForeground(Color.WHITE);
        registerBtn.setFont(new Font("Arial", Font.BOLD, 14));
        registerBtn.setFocusPainted(false);

        registerBtn.addActionListener(e -> registerStudent());
        background.add(registerBtn, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void registerStudent() {
        String name = JOptionPane.showInputDialog(this, "Enter staff name:");
        if (name != null && !name.trim().isEmpty()) {
            staffs.add(name.trim());
            displayStaff();
        }
    }

    private void displayStaff() {
        StringBuilder sb = new StringBuilder("Registered Staff:\n");
        for (String s : staffs) {
            sb.append("- ").append(s).append("\n");
        }
        displayArea.setText(sb.toString());
    }
}
