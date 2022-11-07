package atm.system;

import java.sql.*;
import com.mysql.cj.jdbc.Driver;

public class Con {
    
    Connection c;
    Statement s;
    
    public Con(){
        //exception handling karni padegi kyuki MySQl external entity h to error aane ke chances rehte h,
        // mostly runtime errors to unhi error ko catch karne k liye exception handling krni pdegi.
        
        try{
            
            // Class.forName(com.mysql.cj.jdbc.Driver);  //1. regiter the driver  //baad m is line ko hata diya register karne ki jarurat nhi h kyuki java apne aap se class ko pick kar sakta h, jo libraries m add kiya h abhi.
            
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Youandi@2818");  //2. create connection
            s = c.createStatement();
            
        } catch(Exception e){
            System.out.println(e);
        }
        
    }
    
}
