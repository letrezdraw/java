import javax.swing.*;
import java.awt.*;

public class VaccinationFormUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(VaccinationFormUI::createUI);
    }

    private static void createUI() {
        JFrame frame = new JFrame("Vaccination Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        // ===== Outer main panel with border =====
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mainPanel.setLayout(new BorderLayout(10, 10));

        // ===== Title =====
        JLabel title = new JLabel("Vaccination Details", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(title, BorderLayout.NORTH);

        // ===== Center panel for Name, Dose, Vaccine =====
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Name row
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel nameLabel = new JLabel("Name: ");
        JTextField nameField = new JTextField(25);
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        centerPanel.add(namePanel);

        // Dose + Vaccine row
        JPanel doseVaccinePanel = new JPanel(new GridLayout(1, 2, 20, 0));

        // Dose checkboxes
        JPanel dosePanel = new JPanel(new GridLayout(2, 1));
        dosePanel.setBorder(BorderFactory.createTitledBorder("Dose"));
        JCheckBox cb1 = new JCheckBox("1st Dose");
        JCheckBox cb2 = new JCheckBox("2nd Dose");
        dosePanel.add(cb1);
        dosePanel.add(cb2);

        // Vaccine radio buttons
        JPanel vaccinePanel = new JPanel(new GridLayout(3, 1));
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

        doseVaccinePanel.add(dosePanel);
        doseVaccinePanel.add(vaccinePanel);
        centerPanel.add(doseVaccinePanel);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // ===== Bottom bordered panel (like in image) =====
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2, 2, 10, 5));
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Row 1
        bottomPanel.add(new JLabel("Name :"));
        JTextField outName = new JTextField();
        bottomPanel.add(outName);

        bottomPanel.add(new JLabel("1st Dose:"));
        JTextField outDose1 = new JTextField();
        bottomPanel.add(outDose1);

        bottomPanel.add(new JLabel("2nd Dose:"));
        JTextField outDose2 = new JTextField();
        bottomPanel.add(outDose2);

        // Row 2
        bottomPanel.add(new JLabel("Vaccine:"));
        JTextField outVaccine = new JTextField();
        bottomPanel.add(outVaccine);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Add to frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}