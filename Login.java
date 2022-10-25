import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField txUsername, txpassward;
    JButton login;
    Login() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel username = new JLabel("USERNAME");
        username.setBounds(40, 20, 100, 30);
        add(username);
        txUsername = new JTextField();
        txUsername.setBounds(150, 20, 150, 30);
        add(txUsername);
        JLabel passward = new JLabel("PASSWORD");
        passward.setBounds(40, 70, 100, 30);
        add(passward);
        txpassward = new JTextField();
        txpassward.setBounds(150, 70, 150, 30);
        add(txpassward);
        login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.addActionListener(this);
        //login.addActionListener(this);

        //image.add(clickHer);
        add(login);
        // login.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocation(450, 209);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Login();
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login) {
            String username = txUsername.getText();
            System.out.println(username);
            String passward = txpassward.getText();
            try {
                Conn c1 = new Conn();
                String query = "select * from login where username = '" + username + "' and passward = '" + passward + "'";
                new Home();
                this.dispose();
                ResultSet rs = c1.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        }
    }


}
