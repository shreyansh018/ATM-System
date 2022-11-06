package atm.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ChangePin extends JFrame implements ActionListener {
    
    JButton change, back;
    JPasswordField pin, repin;
    String pinNumber;
    
    ChangePin(String pinNumber){
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(260, 280, 500, 35);
        text.setFont(new Font("System", Font.BOLD, 16));      
        text.setForeground(Color.white);
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN");
        pintext.setBounds(165, 320, 180, 25);
        pintext.setFont(new Font("System", Font.BOLD, 16));      
        pintext.setForeground(Color.white);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("System", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN");
        repintext.setBounds(165, 360, 180, 25);
        repintext.setFont(new Font("System", Font.BOLD, 16));      
        repintext.setForeground(Color.white);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("System", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);
        
        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == change){
       
        try{
            String newpin = pin.getText();
            String rpin = repin.getText();
            
            if(!newpin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
                
            }
            
            //yaha check karenge ki agar change button par click hua h.
            if(newpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter new Pin");
                return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please re-enter new Pin");
                return;
            }
            
            //ye uapr dono checks lagae h, ab check kar liya poora ki haa person ne dono pin daale h ab database ke saath connect krenge.
            
            //**NOTE** -> MySQL me bank, login and signupThree in teeno tables me Pin h to jab user yaha se pin change krega to teeno jagah pin change hona chahiye.
            //to yaha ab 3 queries likhni padengi, jo teeno tables m data ko update karengi.
            
            Con c = new Con();
            
            String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinNumber+"' ";
            String query2 = "update login set pinNumber = '"+rpin+"' where pinNumber = '"+pinNumber+"' ";
            String query3 = "update signupthree set pinNumber = '"+rpin+"' where pinNumber = '"+pinNumber+"' ";
            
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
            
            setVisible(false);
            new Transactions(rpin).setVisible(true);
        } catch(Exception e){
            System.out.println(e);
        }
     } else { //ab agar change button pr click nhi hua to back karna h.
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        
   }
    
    public static void main(String[] args){
        new ChangePin("").setVisible(true);
    }
    
}
