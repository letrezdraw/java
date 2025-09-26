import javax.swing.*;
public class A4 extends JFrame {
    public A4() {
        super("ComboBox Example");
        setSize(420, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        final JLabel resultLabel = new JLabel("Programming language Selected: Java");
        resultLabel.setBounds(0, 40, 420, 30);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(resultLabel);
        String[] languages = {"Java", "C", "C++", "C#", "PHP"};
        final JComboBox<String> languageComboBox = new JComboBox<>(languages);
        languageComboBox.setBounds(80, 110, 120, 30);
        add(languageComboBox);
        JButton showButton = new JButton("Show");
        showButton.setBounds(220, 110, 80, 30);
        add(showButton);
        showButton.addActionListener(e -> {
            String selectedLanguage = (String) languageComboBox.getSelectedItem();
            resultLabel.setText("Programming language Selected: " + selectedLanguage);
        });
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new A4().setVisible(true);
        });
    }
}
