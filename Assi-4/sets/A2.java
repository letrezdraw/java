import javax.swing.*;
import java.awt.*;

public class VaccinationDetailsUI {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Vaccination Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        // Title
        JLabel title = new JLabel("Vaccination Details", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(title, BorderLayout.NORTH);

        // Main Panel
        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        frame.add(mainPanel, BorderLayout.CENTER);

        // Name Panel
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel nameLabel = new JLabel("Name: ");
        JTextField nameField = new JTextField(20);
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        mainPanel.add(namePanel);

        // Vaccine Panel (Radio Buttons)
        JPanel vaccinePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        vaccinePanel.setBorder(BorderFactory.createTitledBorder("Vaccine"));
        JRadioButton rb1 = new JRadioButton("Covishield");
        JRadioButton rb2 = new JRadioButton("Covaxin");
        JRadioButton rb3 = new JRadioButton("Sputnik V");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        vaccinePanel.add(rb1);
        vaccinePanel.add(rb2);
        vaccinePanel.add(rb3);
        mainPanel.add(vaccinePanel);

        // Dose Panel (CheckBoxes)
        JPanel dosePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dosePanel.setBorder(BorderFactory.createTitledBorder("Dose"));
        JCheckBox cb1 = new JCheckBox("1st Dose");
        JCheckBox cb2 = new JCheckBox("2nd Dose");
        dosePanel.add(cb1);
        dosePanel.add(cb2);
        mainPanel.add(dosePanel);

        // Make frame visible
        frame.setVisible(true);
    }
}