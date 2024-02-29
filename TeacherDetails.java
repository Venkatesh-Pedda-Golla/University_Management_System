package University_Management_System;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class TeacherDetails extends JFrame implements ActionListener{
    Choice cEmpid;
    JTable table;
    JButton search, print, update, add, cancel;
    TeacherDetails(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(20,20,150,20);
        add(heading);

        cEmpid = new Choice();
        cEmpid.setBounds(180,20,150,20);
        add(cEmpid);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from teacher");
            while(rs.next()){
                cEmpid.add(rs.getString("employeeid"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        table=new JTable();

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e){
            e.printStackTrace();
        }


        JScrollPane jnp=new JScrollPane(table);
        jnp.setBounds(0,100,900,600);
        add(jnp);

        search =new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print =new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add(add);

        update =new JButton("Update");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        add(update);

        cancel =new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
        setLocation(280,30);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == search) {
            String query = "select * from teacher where employeeid='"+cEmpid.getSelectedItem()+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource()==update){

        } else if(ae.getSource()==add){
            setVisible(false);
            new AddTeacher();
        }else{
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new TeacherDetails();
    }
}
