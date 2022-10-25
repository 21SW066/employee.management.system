import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {
    Splash() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading = new JLabel("BANK EMPLOYEE  MANAGEMENT  SYSTEM");
        heading.setBounds(60, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.BOLD, 50));
        heading.setForeground(Color.RED);
        add(heading);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(50,100,1050,500);
        add(image);
        JButton clickHere = new JButton("CLICK HERE TO CONTINUE");
        clickHere.setBounds(400, 400, 300, 70);
        clickHere.setBackground(Color.black);
        clickHere.setForeground(Color.white);
        clickHere.setFocusable(false);

       image.add(clickHere);
       clickHere.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);
        while (true) {
            heading.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
            heading.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();

    }

    public static void main(String[] args) {
        new Splash();
    }


}
