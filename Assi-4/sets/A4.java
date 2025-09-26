import javax.swing.*;

public class ComboBoxExampleUI extends JFrame {

    public ComboBoxExampleUI() {
        // --- 1. Setup the main window (JFrame) ---
        super("ComboBox Example");
        setSize(420, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Use null layout for precise component placement

        // --- 2. Create the display label at the top ---
        final JLabel resultLabel = new JLabel("Programming language Selected: Java");
        resultLabel.setBounds(0, 40, 420, 30); // x, y, width, height
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(resultLabel);

        // --- 3. Create the combo box with language options ---
        String[] languages = {"Java", "C", "C++", "C#", "PHP"};
        final JComboBox<String> languageComboBox = new JComboBox<>(languages);
        languageComboBox.setBounds(80, 110, 120, 30);
        add(languageComboBox);

        // --- 4. Create the "Show" button ---
        JButton showButton = new JButton("Show");
        showButton.setBounds(220, 110, 80, 30);
        add(showButton);

        // --- 5. Add the button's functionality ---
        showButton.addActionListener(e -> {
            // Get the selected item from the combo box
            String selectedLanguage = (String) languageComboBox.getSelectedItem();
            
            // Update the top label with the selection
            resultLabel.setText("Programming language Selected: " + selectedLanguage);
        });

        // --- Finalize and display the window ---
        setLocationRelativeTo(null); // Center the window on the screen
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(() -> {
            new ComboBoxExampleUI().setVisible(true);
        });
    }
}
