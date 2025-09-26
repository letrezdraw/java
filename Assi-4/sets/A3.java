import javax.swing.*;
import java.awt.*;

public class A3 extends JFrame {

    // Components that need to be accessed later are declared as fields
    private final JTextArea textArea = new JTextArea("Welcome to Swing program\nSwing is used to design GUI");
    private final JLabel wordCountLabel = new JLabel("Words: 11");
    private final JLabel charCountLabel = new JLabel("Characters: 55");

    public A3() {
        super("Count words and characters");

        // --- Setup UI Components ---
        
        // Top panel for labels
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
        topPanel.add(wordCountLabel);
        topPanel.add(charCountLabel);
        add(topPanel, BorderLayout.NORTH);

        // Center text area with scroll bars
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Bottom panel with button and its action
        JButton countButton = new JButton("Count Words");
        countButton.addActionListener(e -> {
            String text = textArea.getText();
            String trimmedText = text.trim();
            // Update labels with calculated counts
            wordCountLabel.setText("Words: " + (trimmedText.isEmpty() ? 0 : trimmedText.split("\\s+").length));
            charCountLabel.setText("Characters: " + text.length());
        });
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(countButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // --- Finalize Window ---
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // Sizes the window to fit its components
        setLocationRelativeTo(null); // Centers the window on screen
    }

    public static void main(String[] args) {
        // Use a method reference for the most concise way to run the UI
        SwingUtilities.invokeLater(A3::new);
    }
}
