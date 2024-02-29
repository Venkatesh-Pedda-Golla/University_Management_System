package University_Management_System;
import java.awt.*;
import javax.swing.*;
public class About extends JFrame{
    About(){
        setSize(700,500);
        setLocation(400,150);
        getContentPane().setBackground(Color.white);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/about.jpg"));
        Image i2=i1.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,0,300,200);
        add(image);

        JLabel jav = new JLabel("RGUKT");
        jav.setBounds(90,20,300,130);
        jav.setFont(new Font("Tahoma",Font.BOLD,30));
        add(jav);

        JLabel name= new JLabel("Developed By: PG.Venkatesh");
        name.setBounds(70,220,550,40);
        name.setFont(new Font("Tahoma",Font.BOLD,30));
        add(name);

        JLabel roll_no = new JLabel("Roll no.15555454");
        roll_no.setBounds(70,280,550,40);
        roll_no.setFont(new Font("Tahoma",Font.BOLD,30));
        add(roll_no);

        JLabel email = new JLabel("Contact:venkateshpg@gmail.com");
        email.setBounds(70,340,550,40);
        email.setFont(new Font("Tahoma",Font.BOLD,20));
        add(email);

        setLayout(null);
        setVisible(true);
    }
    public static void main(String args[]){
        new About();
    }
}
