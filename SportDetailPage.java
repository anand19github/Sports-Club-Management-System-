
// SportDetailPage.java
import javax.swing.*;
import java.awt.*;

public class SportDetailPage extends JFrame {

    public SportDetailPage(String sport) {
        setTitle("Register for " + sport.substring(0, 1).toUpperCase() + sport.substring(1));
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Background image
        String imagePath = "images/" + sport + ".jpg";
        ImageIcon bgIcon = new ImageIcon(imagePath);
        JLabel bgLabel = new JLabel(bgIcon);
        bgLabel.setLayout(new BorderLayout());
        setContentPane(bgLabel);

        // Transparent panel for form
        JPanel overlay = new JPanel();
        overlay.setLayout(null);
        overlay.setOpaque(false); // transparent background
        overlay.setBackground(new Color(0, 0, 0, 100));

        JLabel quote = new JLabel(getQuote(sport));
        quote.setFont(new Font("Serif", Font.BOLD, 18));
        quote.setForeground(Color.WHITE);
        quote.setBounds(40, 20, 700, 30);
        overlay.add(quote);

        JLabel nameLbl = new JLabel("Name:");
        nameLbl.setForeground(Color.WHITE);
        nameLbl.setBounds(100, 100, 100, 25);
        overlay.add(nameLbl);

        JTextField nameField = new JTextField();
        nameField.setBounds(200, 100, 200, 25);
        overlay.add(nameField);

        JLabel ageLbl = new JLabel("Age:");
        ageLbl.setForeground(Color.WHITE);
        ageLbl.setBounds(100, 140, 100, 25);
        overlay.add(ageLbl);

        JTextField ageField = new JTextField();
        ageField.setBounds(200, 140, 200, 25);
        overlay.add(ageField);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(200, 190, 100, 30);
        overlay.add(registerBtn);

        registerBtn.addActionListener(e -> {
            String name = nameField.getText();
            String age = ageField.getText();

            if (name.isEmpty() || age.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter all details!");
            } else {
                JOptionPane.showMessageDialog(null, "Registered successfully for " + sport + "!");
                new SportsListPage();
                dispose();
            }
        });

        bgLabel.add(overlay, BorderLayout.CENTER);
        setVisible(true);
    }

    private String getQuote(String sport) {
        switch (sport.toLowerCase()) {
            case "cricket":
                return "“Cricket is not just a game, it's a passion!”";
            case "football":
                return "“Football is a game of mistakes. Whoever makes the fewest wins.”";
            case "basketball":
                return "“Push yourself again and again. Don’t give an inch.”";
            case "badminton":
                return "“Badminton: the fastest racket sport in the world.”";
            default:
                return "Get inspired and give your best!";
        }
    }
}
