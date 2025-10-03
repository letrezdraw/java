import javax.swing.*;
import java.awt.*;

public class B3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(B3::createUI);
    }

    private static void createUI() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));

        // ===== Display field =====
        JTextField display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(display, BorderLayout.NORTH);

        // ===== Buttons panel =====
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 10, 10));

        // Buttons (like in image)
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            ".", "0", "+", "="
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            buttonPanel.add(btn);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);

        // ===== Clear button =====
        JButton clearBtn = new JButton("Clear");
        clearBtn.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(clearBtn, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}