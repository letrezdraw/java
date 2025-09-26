import java.awt.*;
import javax.swing.*;
public class A3 extends JFrame {
    private final JTextArea textArea = new JTextArea("Welcome to Swing program\nSwing is used to design GUI");
    private final JLabel wordCountLabel = new JLabel("Words: 11");
    private final JLabel charCountLabel = new JLabel("Characters: 55");
    public A3() {
        super("Count words and characters");
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
        topPanel.add(wordCountLabel);
        topPanel.add(charCountLabel);
        add(topPanel, BorderLayout.NORTH);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        JButton countButton = new JButton("Count Words");
        countButton.addActionListener(e -> {
            String text = textArea.getText();
            String trimmedText = text.trim();
            wordCountLabel.setText("Words: " + (trimmedText.isEmpty() ? 0 : trimmedText.split("\\s+").length));
            charCountLabel.setText("Characters: " + text.length());
        });
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(countButton);
        add(bottomPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(A3::new);
    }
}
