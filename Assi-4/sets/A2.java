import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VaccinationDetailsUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(VaccinationDetailsUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Vaccination Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 420);
        frame.setLocationRelativeTo(null);

        // Top title
        JLabel title = new JLabel("Vaccination Details", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        frame.add(title, BorderLayout.NORTH);

        // ===== Left: bordered text area (the "bottom text field" you mentioned) =====
        JTextArea summaryArea = new JTextArea(12, 20);
        summaryArea.setEditable(false);
        summaryArea.setLineWrap(true);
        summaryArea.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(summaryArea);

        JPanel leftPanel = new JPanel(new BorderLayout());
        // simple border to match the screenshot's boxed area
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        leftPanel.add(scroll, BorderLayout.CENTER);
        leftPanel.setPreferredSize(new Dimension(240, 0));

        // ===== Right: form (name, vaccine radios, dose checkboxes, buttons) =====
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Name
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        formPanel.add(namePanel);

        formPanel.add(Box.createVerticalStrut(8));

        // Vaccine radio buttons
        JPanel vaccinePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        vaccinePanel.setBorder(BorderFactory.createTitledBorder("Vaccine"));
        JRadioButton rbCovishield = new JRadioButton("Covishield");
        JRadioButton rbCovaxin = new JRadioButton("Covaxin");
        JRadioButton rbSputnik = new JRadioButton("Sputnik V");
        ButtonGroup vaccineGroup = new ButtonGroup();
        vaccineGroup.add(rbCovishield);
        vaccineGroup.add(rbCovaxin);
        vaccineGroup.add(rbSputnik);
        vaccinePanel.add(rbCovishield);
        vaccinePanel.add(rbCovaxin);
        vaccinePanel.add(rbSputnik);
        formPanel.add(vaccinePanel);

        formPanel.add(Box.createVerticalStrut(8));

        // Dose checkboxes
        JPanel dosePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dosePanel.setBorder(BorderFactory.createTitledBorder("Dose"));
        JCheckBox cb1 = new JCheckBox("1st Dose");
        JCheckBox cb2 = new JCheckBox("2nd Dose");
        dosePanel.add(cb1);
        dosePanel.add(cb2);
        formPanel.add(dosePanel);

        formPanel.add(Box.createVerticalStrut(12));

        // Buttons
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton submit = new JButton("Submit");
        JButton reset = new JButton("Reset");
        buttons.add(submit);
        buttons.add(reset);
        formPanel.add(buttons);

        // ===== Actions: fill the left text area on submit, clear on reset =====
        submit.addActionListener(e -> {
            String name = nameField.getText().trim();
            String vaccine = "None selected";
            if (rbCovishield.isSelected()) vaccine = "Covishield";
            else if (rbCovaxin.isSelected()) vaccine = "Covaxin";
            else if (rbSputnik.isSelected()) vaccine = "Sputnik V";

            StringBuilder doses = new StringBuilder();
            if (cb1.isSelected()) doses.append("1st Dose");
            if (cb2.isSelected()) {
                if (doses.length() > 0) doses.append(", ");
                doses.append("2nd Dose");
            }
            String doseText = doses.length() > 0 ? doses.toString() : "None";

            StringBuilder out = new StringBuilder();
            out.append("Name: ").append(name.isEmpty() ? "<empty>" : name).append("\n\n");
            out.append("Vaccine: ").append(vaccine).append("\n\n");
            out.append("Dose: ").append(doseText).append("\n");

            summaryArea.setText(out.toString());
        });

        reset.addActionListener(e -> {
            nameField.setText("");
            vaccineGroup.clearSelection();
            cb1.setSelected(false);
            cb2.setSelected(false);
            summaryArea.setText("");
        });

        // ===== Put left and right panes together (mimics the screenshot layout) =====
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, formPanel);
        split.setDividerLocation(240);
        split.setOneTouchExpandable(true);
        frame.add(split, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}