package University_Management_System;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
          c=DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","Venk@tesh");
          s=c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
/* 1.Register the driver class
   2.Creating Connection String
   3.Creating statement
   4.Execution MySQl Queries
   5.Closing the Connection
 */
