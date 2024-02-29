package University_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,cancel;
    JTextField tfuser,tfpass;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(40,20,100,20);
        add(user);

        tfuser = new JTextField();
        tfuser.setBounds(150,20,150,20);
        add(tfuser);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40,70,100,20);
        add(pass);

        tfpass = new JTextField();
        tfpass.setBounds(150,70,150,20);
        add(tfpass);

        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(300,170,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);

        setSize(600,300);
        setLocation(400,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==login ){
            String username = tfuser.getText();
            String password = tfpass.getText();

            String query = "select * from login where username='"+username+"' and password='"+password+"'";
            try{
                Conn c=new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){
                    setVisible(false);
                    new Project();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(false);
                }
                c.s.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==cancel){
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new Login();
    }
}
