import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class A1 extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1, b2;

    public A1() {
        l1 = new JLabel("Username");
        l1.setBounds(50, 50, 100, 30);
        t1 = new JTextField();
        t1.setBounds(150, 50, 150, 30);

        l2 = new JLabel("Password");
        l2.setBounds(50, 100, 100, 30);
        p1 = new JPasswordField();
        p1.setBounds(150, 100, 150, 30);

        b1 = new JButton("Login");
        b1.setBounds(50, 150, 100, 30);
        b1.addActionListener(this);

        b2 = new JButton("Reset");
        b2.setBounds(200, 150, 100, 30);
        b2.addActionListener(this);

        add(l1);
        add(t1);
        add(l2);
        add(p1);
        add(b1);
        add(b2);

        setSize(400, 300);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String username = t1.getText();
            String password = new String(p1.getPassword());
            JOptionPane.showMessageDialog(this, "Username: " + username + "\nPassword: " + password);
        } else if (e.getSource() == b2) {
            t1.setText("");
            p1.setText("");
        }
    }

    public static void main(String[] args) {
        new A1();
    }
}