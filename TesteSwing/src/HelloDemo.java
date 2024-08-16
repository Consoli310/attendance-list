import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloDemo extends JFrame{

    private JPanel PanelMain;
    private JLabel Name;
    private JButton Buttonclick;
    private JTextField txtname;

    public HelloDemo() {
        Buttonclick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Buttonclick, txtname.getText() + ", Hello");
            }
        });
    }

    public static void main(String[] args) {
    HelloDemo h = new HelloDemo();
    h.setContentPane(h.PanelMain);
    h.setTitle("Hello");
    h.setSize(300,400);
    h.setVisible(true);
    h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
