import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField tfName, tfFName, tfAddress,tfPhone, tfEmail,tfMobileNo,tfSalary, tfdesignation;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel EmpId;
    JButton add, addDetail;
    Random ran=new Random();
    Long number= Long.valueOf(ran.nextInt(999999));
    AddEmployee(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel heading=new JLabel("Add Employee Detail");
        heading.setFont(new Font("SAN Serif",Font.BOLD,25));
        heading.setBounds(320,30,500,50);
        add(heading);
        JLabel labelName=new JLabel("Name");
        labelName.setBounds(50,150,150,30);
        labelName.setFont(new Font("serif",Font.PLAIN,20));
        add(labelName);

        tfName=new JTextField();
        tfName.setBounds(200,150,150,30);
        add(tfName);

        JLabel labelFName=new JLabel("Faher's Name");
        labelFName.setBounds(400,150,150,30);
        labelFName.setFont(new Font("serif",Font.PLAIN,20));
        add(labelFName);

        tfFName=new JTextField();
        tfFName.setBounds(600,150,150,30);
        add(tfFName);

        JLabel labelDop=new JLabel("Date of Birth");
        labelDop.setBounds(50,200,150,30);
        labelDop.setFont(new Font("serif",Font.PLAIN,20));
        add(labelDop);


        dcdob=new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);

        JLabel labelSalary=new JLabel("Salary");
        labelSalary.setBounds(400,200,150,30);
        labelSalary.setFont(new Font("serif",Font.PLAIN,20));
        add(labelSalary);

        tfSalary=new JTextField();
        tfSalary.setBounds(600,200,150,30);
        add(tfSalary);

        JLabel labelAddress=new JLabel("Address");
        labelAddress.setBounds(50,250,150,30);
        labelAddress.setFont(new Font("serif",Font.PLAIN,20));
        add(labelAddress);

        tfAddress=new JTextField();
        tfAddress.setBounds(200,250,150,30);
        add(tfAddress);

        JLabel labelPhone=new JLabel("Phone");
        labelPhone.setBounds(400,250,150,30);
        labelPhone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelPhone);

        tfPhone=new JTextField();
        tfPhone.setBounds(600,250,150,30);
        add(tfPhone);

        JLabel labelEmail=new JLabel("Email");
        labelEmail.setBounds(50,300,150,30);
        labelEmail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelEmail);

        tfEmail=new JTextField();
        tfEmail.setBounds(200,300,150,30);
        add(tfEmail);

        JLabel labelEducation=new JLabel("Highest Education");
        labelEducation.setBounds(400,300,150,30);
        labelEducation.setFont(new Font("serif",Font.PLAIN,20));
        add(labelEducation);

        String courses[]={"BBA","BCA","B.COM","BTech","BSC","MBA","MCA","MA","MTech","Phd"};

        cbeducation=new JComboBox(courses);
        cbeducation.setBackground(Color.white);
        cbeducation.setBounds(600,300,150,30);
        add(cbeducation);

        JLabel labeldesignation=new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldesignation);

        tfdesignation=new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        tfdesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(tfdesignation);

        JLabel labelMobileNO=new JLabel("Mobile Number");
        labelMobileNO.setBounds(400,350,150,30);
        labelMobileNO.setFont(new Font("serif",Font.PLAIN,20));
        add(labelMobileNO);

        tfMobileNo=new JTextField();
        tfMobileNo.setBounds(600,350,150,30);
        add(tfMobileNo);

        JLabel labelEmpId=new JLabel("Employee Id");
        labelEmpId.setBounds(50,400,150,30);
        labelEmpId.setFont(new Font("serif",Font.PLAIN,20));
        add(labelEmpId);

        EmpId=new JLabel(""+number);
        EmpId.setBounds(200,400,150,30);
        EmpId.setFont(new Font("serif",Font.PLAIN,20));
        add(EmpId);

        JButton add = new JButton("Add Employee");
        add.setBounds(450, 550, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setFocusable(false);
        add.addActionListener(this);
        add(add);
        addDetail = new JButton("Add Details");
        addDetail.setBounds(250, 550, 150, 40);
        addDetail.setBackground(Color.black);
        addDetail.setForeground(Color.white);
        addDetail.setFocusable(false);
        addDetail.addActionListener(this);
        add(addDetail);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,900);
        setLocation(300,50);
        setVisible(true);
    }

    public static void main(String[] args) {
    new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addDetail){
        String name=tfName.getText();
        String fName=tfFName.getText();
        String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
        String salary=tfSalary.getText();
        String address=tfAddress.getText();
        String phone=tfPhone.getText();
        String email=tfEmail.getText();
        String education= (String) cbeducation.getSelectedItem();
        String designation=tfdesignation.getText();
        String empId=EmpId.getText();
        String mobileNo=tfMobileNo.getText();
        try{
            Conn c=new Conn();
            String query="insert into employee values('"+name+"' , '"+fName+"', '"+dob+"' , '"+salary+"' , '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+mobileNo+"', '"+empId+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Details added Successfully");
            setVisible(false);
        }catch (Exception E){
            E.printStackTrace();
        }
        }else {
            setVisible(false);
            new Home();
        }
    }
}
