package atm.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pinNumber;
    
    FastCash(String pinNumber){
        this.pinNumber = pinNumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        //image ko scale karna padega.
        
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        //ab image ko wps imageicon me convert karna padega.
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210, 300, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 16));      
        text.setForeground(Color.white);
        //add(text);
        image.add(text); //mene jab add(text) likha tb koi text nhi show hua kyuki wo image ke peeche add hua image ke upar add krna to ese likhenge.
        
        
        // **NOTE -> y jo neeche names h buttons ke deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit ye sab change bhi kar sakte h.
        deposit = new JButton("Rs 100");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(355, 485, 150, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton("BACK");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
            
        } else {
            //ab jis amount par bhi click krenge jese Rs 500 par click kiya to show hona chahiye 500 debited.
            String amount = ((JButton) ae.getSource()).getText().substring(3); //substring use kiya taki jo Rs 500 he usme Rs or jo space h wo hat jaae or sirf 500 show ho.
            
            Con c = new Con();
            
            try{
                
                //check lagana h to 1st check hoga ki account me pese h bhi ki nahi, maan lo account me Rs 100 h or Rs 500 debit kr rhe h to show krega ki Insuffiecient balance.
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"' "); //yaha par mene wo sabhi values utha li jaha pin number is se match hota h.
                //mysql me bank table me dekhenge pin column h or amount column h, to pin column se check krenge jese For Ex-> 6199 pin me Rs 1000 the or mene Rs 200 debit kiya to withdrawl amount aa jaaega.
                //or us withdrawl amount se balance check krenge.
                
                int balance = 0;
                while(rs.next()){ //rs result set he uske andar hmari bank table ka data store karwaya h upar, to phr ab next() ka mtlb check krega wo data h agar h to aage operations karo.
                    if(rs.getString("type").equals("Deposit")){
                        //balance += rs.getString("amount"); //-> jab esa likhenge to error aaega ki Integer cannot be converted into string.
                        
                        //to use thk krne ke liye
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        //yaha se user ka balance nikal ke aaega.
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                    
                }
                
                //ab phrse check lagana h ki balance amount se jyada h ki kam h.
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)){  //amount string me tha usko String se nhai check karwa sakte the to Integer m convert kar diya.
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                //but agar yaha pr esa nahi h
                Date date = new Date();
                String query = "insert into bank values ( '"+pinNumber+"', '"+date+"', 'Withdrawl', '"+amount+"'  )";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Rs "+ amount + " Debited Successfully" );
                
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
                
            } catch(Exception e){
                System.out.println(e);
            }
        } 
    }
    
    
    public static void main(String[] args){
        new FastCash("");
    }
    
}
