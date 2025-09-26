import javax.swing.*;
import java.awt.*;

public class VaccinationDetailsExactUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(VaccinationDetailsExactUI::createUI);
    }

    private static void createUI() {
        JFrame frame = new JFrame("Vaccination Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 400);
        frame.setLocationRelativeTo(null);

        // ===== Outer Main Panel with border =====
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // ===== Title =====
        JLabel title = new JLabel("Vaccination Details", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(title, BorderLayout.NORTH);

        // ===== Center Panel =====
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Row 1: Name
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(25);
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        centerPanel.add(namePanel);

        // Row 2: Dose + Vaccine side by side
        JPanel doseVaccinePanel = new JPanel(new GridLayout(1, 2));

        // Dose Panel
        JPanel dosePanel = new JPanel(new GridLayout(2, 1));
        dosePanel.setBorder(BorderFactory.createTitledBorder("Dose"));
        JCheckBox cb1 = new JCheckBox("1st Dose");
        JCheckBox cb2 = new JCheckBox("2nd Dose");
        dosePanel.add(cb1);
        dosePanel.add(cb2);

        // Vaccine Panel
        JPanel vaccinePanel = new JPanel(new GridLayout(3, 1));
        vaccinePanel.setBorder(BorderFactory.createTitledBorder("Vaccine"));
        JRadioButton rb1 = new JRadioButton("Covishield");
        JRadioButton rb2 = new JRadioButton("Covaxin");
        JRadioButton rb3 = new JRadioButton("Sputnik V");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1); bg.add(rb2); bg.add(rb3);
        vaccinePanel.add(rb1);
        vaccinePanel.add(rb2);
        vaccinePanel.add(rb3);

        doseVaccinePanel.add(dosePanel);
        doseVaccinePanel.add(vaccinePanel);

        centerPanel.add(doseVaccinePanel);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // ===== Bottom Panel (Static Underlined Labels) =====
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel row1 = new JLabel("Name : __________________    1st Dose : ________    2nd Dose : ________");
        JLabel row2 = new JLabel("Vaccine : ____________________________________________");

        row1.setFont(new Font("Serif", Font.PLAIN, 14));
        row2.setFont(new Font("Serif", Font.PLAIN, 14));

        bottomPanel.add(row1);
        bottomPanel.add(Box.createVerticalStrut(10));
        bottomPanel.add(row2);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // ===== Add to Frame =====
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}