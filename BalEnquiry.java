package atm.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalEnquiry extends JFrame implements ActionListener {
    
    JButton back;
    String pinNumber;
    
    BalEnquiry(String pinNumber){
        this.pinNumber = pinNumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);    
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        //ab sabse pehle balance ko display karwana padega
        //bank table ke andar jitne bhi fields h unko nikalna padega, jo kaam humne Fast Cash ke case m kiya tha.
        
        Con c = new Con();  //**NOTE** -> is code ko humne constructor ke andar daala h, ese hum actionPerformed() ke andar daalte the
        int balance = 0;    // but me chahat hu ki jese hi mera frame khule, to frame ke khulte hi mera balance display ho jaae.
                            //to esa kuch kaam karna h bina button ke click ke to constructor ke andar code daalna padhta h.
        try{
                
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"' "); //yaha par mene wo sabhi values utha li jaha pin number is se match hota h.
            
            while(rs.next()){ //rs result set he uske andar hmari bank table ka data store karwaya h upar, to phr ab next() ka mtlb check krega wo data h agar h to aage operations karo.
                if(rs.getString("type").equals("Deposit")){

                balance += Integer.parseInt(rs.getString("amount"));
        } else {

                balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
                    
        } catch(Exception e){
                System.out.println(e);
        }
        
        //balance=0 ko try and catch ke bahar likha taki uska scope try and catch ke bahar mil jae.
        JLabel text = new JLabel("Your Current Account balance is Rs " + balance);
        text.setForeground(Color.white);
        text.setBounds(170, 300, 400, 30);
        image.add(text);
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
        
    }
    
    public static void main(String[] args){
        new BalEnquiry("");
    }
    
}
