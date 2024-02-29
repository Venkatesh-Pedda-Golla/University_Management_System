package University_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Marks extends JFrame implements ActionListener {
    JButton cancel;
    String rollno;
    JComboBox cbsemester;
    Marks(String rollno){
        this.rollno = rollno;

        setSize(600,600);
        setLocation(300,100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Rajiv Gandhi University Of Knowledge Technologies");
        heading.setBounds(20,10,800,25);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel subheading = new JLabel("Result Of Examination");
        subheading.setBounds(180,50,500,20);
        subheading.setFont(new Font("Tahoma",Font.BOLD,20));
        subheading.setForeground(Color.BLUE);
        add(subheading);

        JLabel lblrollno = new JLabel("Roll No"+rollno);
        lblrollno.setBounds(100,100,500,20);
        lblrollno.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblrollno);

        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(60,130,500,25);
        lblsemester.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblsemester);


        JLabel sub1 = new JLabel();
        sub1.setBounds(60,230,500,20);
        sub1.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(60,260,500,20);
        sub2.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(60,290,500,20);
        sub3.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(60,320,500,20);
        sub4.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(60,350,500,20);
        sub5.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub5);

        try{
            Conn c=new Conn();
            ResultSet rs1=c.s.executeQuery("select * from subject where rollno='"+rollno+"'");
            while(rs1.next()){
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
            }

            ResultSet rs2=c.s.executeQuery("select * from marks where rollno='"+rollno+"'");
            while(rs2.next()){
                sub1.setText(sub1.getText() + " --------------- "+rs2.getString("Marks1"));
                sub2.setText(sub2.getText() + " --------------- "+rs2.getString("Marks2"));
                sub3.setText(sub3.getText() + " --------------- "+rs2.getString("Marks3"));
                sub4.setText(sub4.getText() + " --------------- "+rs2.getString("Marks4"));
                sub5.setText(sub5.getText() + " --------------- "+rs2.getString("Marks5"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        cancel = new JButton("Cancel");
        cancel.setBounds(250, 500, 120, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }


    public static void main(String args[]){
        new Marks("");
    }
}
