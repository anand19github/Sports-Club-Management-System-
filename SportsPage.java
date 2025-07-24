import javax.swing.*;
import java.awt.*;

public class SportsPage extends JFrame {
    public SportsPage() {
        setTitle("Sports Info");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel background = new JLabel(new ImageIcon("images/background.jpg"));
        background.setLayout(new BorderLayout());
        add(background);

        JLabel header = new JLabel("Available Sports", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setForeground(Color.WHITE);
        background.add(header, BorderLayout.NORTH);

        JTextArea area = new JTextArea("- Football\n- Cricket\n- Basketball\n- Volleyball\n- Badminton\n- Table Tennis\n- Swimming\n- Athletics");
        area.setFont(new Font("Monospaced", Font.PLAIN, 16));
        area.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(area);
        background.add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
