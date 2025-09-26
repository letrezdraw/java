// java swing gui program - Vaccination details
// fields - Name, Dose (checkbox) - 1st, 2nd. Vaccine (radio) - Covishield, Covaxin, Sputnik V.
// Footer - Name (textbox), 1st dose (textbox), 2nd dose (textbox), Vaccine (textbox).
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class A2 extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3, t4;
    JCheckBox c1, c2;
    JRadioButton r1, r2, r3;
    JButton b1, b2;
    ButtonGroup bg;
    public A2() {
        l1 = new JLabel("Name");
        l1.setBounds(50, 50, 100, 30);
        t1 = new JTextField();
        t1.setBounds(150, 50, 150, 30);

        l2 = new JLabel("Dose");
        l2.setBounds(50, 100, 100, 30);
        c1 = new JCheckBox("1st");
        c1.setBounds(150, 100, 70, 30);
        c2 = new JCheckBox("2nd");
        c2.setBounds(230, 100, 70, 30);

        l3 = new JLabel("Vaccine");
        l3.setBounds(50, 150, 100, 30);
        r1 = new JRadioButton("Covishield");
        r1.setBounds(150, 150, 100, 30);
        r2 = new JRadioButton("Covaxin");
        r2.setBounds(250, 150, 100, 30);
        r3 = new JRadioButton("Sputnik V");
        r3.setBounds(350, 150, 100, 30);
        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);

        b1 = new JButton("Submit");
        b1.setBounds(50, 200, 100, 30);
        b1.addActionListener(this);

        b2 = new JButton("Reset");
        b2.setBounds(200, 200, 100, 30);
        b2.addActionListener(this);

        l4 = new JLabel("Footer:");
        l4.setBounds(50, 250, 100, 30);
        t2 = new JTextField("Name");
        t2.setBounds(150, 250, 150, 30);
        t3 = new JTextField("1st dose");
        t3.setBounds(310, 250, 150, 30);
        t4 = new JTextField("2nd dose");
        t4.setBounds(470, 250, 150, 30);
        
        add(l1);
        add(t1);
        add(l2);
        add(c1);
        add(c2);
        add(l3);
        add(r1);
        add(r2);
        add(r3);
        add(b1);
        add(b2);
        add(l4);
        add(t2);
        add(t3);
        add(t4);
        setSize(700, 400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String name = t1.getText();
            String dose = "";
            if (c1.isSelected()) dose += "1st ";
            if (c2.isSelected()) dose += "2nd ";
            String vaccine = "";
            if (r1.isSelected()) vaccine = "Covishield";
            else if (r2.isSelected()) vaccine = "Covaxin";
            else if (r3.isSelected()) vaccine = "Sputnik V";
            JOptionPane.showMessageDialog(this, "Name: " + name + "\nDose: " + dose + "\nVaccine: " + vaccine);
        } else if (e.getSource() == b2) {
            t1.setText("");
            c1.setSelected(false);
            c2.setSelected(false);
            bg.clearSelection();
        }
    }
    public static void main(String[] args) {
        new A2();
    }
}