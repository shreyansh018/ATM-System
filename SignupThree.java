package atm.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {
    
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    
    SignupThree(String formno){
        this.formno = formno;
        
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);
        
        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.white);
        r1.setBounds(100, 180, 250, 30);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.white);
        r2.setBounds(350, 180, 250, 30);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.white);
        r3.setBounds(100, 220, 250, 30);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.white);
        r4.setBounds(350, 220, 250, 30);
        add(r4);
        
        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);
        
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);
        
        JLabel cardDetails = new JLabel("Your 16 digit Card Number");
        cardDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetails.setBounds(100, 330, 200, 20);
        add(cardDetails);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);
        
        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pinNumber.setBounds(330, 370, 300, 30);
        add(pinNumber);
        
        JLabel pinDetails = new JLabel("4 digit Pin Number");
        pinDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetails.setBounds(100, 400, 200, 20);
        add(pinDetails);
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 300, 30);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);
        
        c3 = new JCheckBox("Mobile banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);
 
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);
        
        c6 = new JCheckBox("E - Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);
        
        c7 = new JCheckBox("I hereby decalre that the above entered details are correct");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 680, 600, 30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        getContentPane().setBackground(Color.white);
        
        setSize(850, 820);
        setLocation(350, 10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Savings Acoount";
            } else if (r2.isSelected()){
                accountType = "Fixed Deposit Acoount";
            } else if (r3.isSelected()){
                accountType = "Current Account";
            } else if(r4.isSelected()){
                accountType = "Recurring Deposit Account";
            }
            
            Random ran = new Random();
            String cardNumber = "" + Math.abs((ran.nextLong() % 90000000L) + 8888555500000000L); //88885555 ye isiliye likha taki initial starting 8 values 88885555 y hi rahe.
            //"" + ye likha kyuki error aaya the pehle ki long string m convert nhi hota, ye likh diya to ab error nhi aaega.
            
            String pinNumber = "" + Math.abs((ran.nextLong() % 9000L) + 1000L);
            
            String facility = "";  //empty string liya kyuki yaha muliple facility le sakte h to unko store bhi to karna pdega
            if(c1.isSelected()){
                facility = facility + " ATM Card"; //facility = facility + "ATM Card" multiple facilities le rhe h store hota jaaega hmari empty string me.
            } else if(c2.isSelected()){
                facility = facility + " Internet Banking";
            } else if(c3.isSelected()){
                facility += " Mobile Banking";
            } else if(c4.isSelected()){
                facility += " Email & SMS Alerts";
            } else if(c5.isSelected()){
                facility += " Cheque Book";
            } else if(c6.isSelected()){
                facility += " E-Statement";
            }
            
            //ab in sab values ko database m bharna h.
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account type is Required");
                } else{
                    Con c = new Con();
                    String query1 = "insert into signupThree values ('"+formno+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')";
                    String query2 = "insert into login values ('"+formno+"', '"+cardNumber+"', '"+pinNumber+"')";
                    //ye query ek new login table ke liye banayi h, kyuki m nhi chahta ki signupThree table se data pick karu login karwane ke liye.
                    
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    
                    
                    //ab card number or pin generate ho jaaenge, ab user ko screen pr show bhi karwana h.
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n Pin: " + pinNumber);
                    
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(false);
                    
                    //ab yaha ye batana h ki jese hi account khola kuch pese deposit karne h, 0 based account nahi khol sakte.
                }
            } catch(Exception e){
                System.out.println(e);
            }
            
        } else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
        
    }
    
    public static void main(String args[]){
        new SignupThree("");
    }
}
