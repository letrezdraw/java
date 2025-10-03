import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NotepadUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(NotepadUI::createUI);
    }

    private static void createUI() {
        JFrame frame = new JFrame("Notepad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        // ===== Text area with scroll =====
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // ===== Menu Bar =====
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // Edit Menu
        JMenu editMenu = new JMenu("Edit");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        JMenuItem selectAllItem = new JMenuItem("Select All");

        // Add actions
        cutItem.addActionListener(e -> textArea.cut());
        copyItem.addActionListener(e -> textArea.copy());
        pasteItem.addActionListener(e -> textArea.paste());
        selectAllItem.addActionListener(e -> textArea.selectAll());

        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.add(selectAllItem);

        menuBar.add(editMenu);

        // Help Menu
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        // Add
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }
}