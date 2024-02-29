package University_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EnterMarks extends JFrame implements ActionListener {

Choice crollno;
JButton submit,cancel;
JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;
JComboBox cbsemester;
    EnterMarks(){
        setSize(600,550);
        setLocation(420,100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 35));
        add(heading);

        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50, 70, 200, 20);
        lblrollnumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(250, 70, 150, 20);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(50, 120, 500, 20);
        lblsemester.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblsemester);

        String semester[] = {"Eng-1 Sem-1","Eng-1 Sem-2","Eng-2 Sem-1","Eng-2 Sem-2","Eng-3 Sem-1","Eng-3 Sem-2","Eng-4 Sem-1","Eng-4 Sem-2"};

        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(250,120,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        JLabel lblsubject = new JLabel("Enter Subject");
        lblsubject.setBounds(100, 150, 200, 40);
        lblsubject.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblsubject);

        JLabel lblmarks = new JLabel("Enter Marks");
        lblmarks.setBounds(320, 150, 200, 40);
        lblmarks.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblmarks);

        tfsub1 = new JTextField();
        tfsub1.setBounds(50,200,200,20);
        add(tfsub1);

        tfsub2 = new JTextField();
        tfsub2.setBounds(50,230,200,20);
        add(tfsub2);

        tfsub3 = new JTextField();
        tfsub3.setBounds(50,260,200,20);
        add(tfsub3);

        tfsub4 = new JTextField();
        tfsub4.setBounds(50,290,200,20);
        add(tfsub4);

        tfsub5 = new JTextField();
        tfsub5.setBounds(50,320,200,20);
        add(tfsub5);

        tfmarks1 = new JTextField();
        tfmarks1.setBounds(270,200,200,20);
        add(tfmarks1);

        tfmarks2 = new JTextField();
        tfmarks2.setBounds(270,230,200,20);
        add(tfmarks2);

        tfmarks3 = new JTextField();
        tfmarks3.setBounds(270,260,200,20);
        add(tfmarks3);

        tfmarks4 = new JTextField();
        tfmarks4.setBounds(270,290,200,20);
        add(tfmarks4);

        tfmarks5 = new JTextField();
        tfmarks5.setBounds(270,320,200,20);
        add(tfmarks5);

        submit = new JButton("Submit");
        submit.setBounds(300, 370, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(100, 370, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try{
                Conn c = new Conn();

                String query1 = "insert into subject values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"','"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"')";
                String query2 = "insert into marks values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"','"+tfmarks1.getText()+"','"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()+"','"+tfmarks5.getText()+"')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Marks Inserted Successfully");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
        } else{
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new EnterMarks();
    }
}
