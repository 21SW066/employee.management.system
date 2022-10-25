import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    JButton add,view,remove;
    Home(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);
        JLabel heading=new JLabel("Employee Management System");
        heading.setBounds(620,20,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(heading);
        add=new JButton("Add Employee");
        add.setFocusable(false);
        add.setBounds(650,80,150,40);
        add.addActionListener(this);
        image.add(add);
        view=new JButton("View Employee");
        view.setFocusable(false);
        view.setBounds(820,80,150,40);
        view.addActionListener(this);
        image.add(view);

       remove=new JButton("Remove Employee");
        remove.setFocusable(false);
        remove.setBounds(820,140,150,40);
        remove.addActionListener(this);
        image.add(remove);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==add){
        setVisible(false);
        new AddEmployee();
    } else if (e.getSource()==view) {
        setVisible(false);
        new ViewEmployee();

    }else {
        setVisible(false);
        new RemoveEmployee();
    }
    }
        public static void main(String[] args) {
        new Home();
    }


}
