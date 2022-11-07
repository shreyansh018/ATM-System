package atm.system;

import javax.swing.*; //frame is class se aata h
import java.awt.*; //imge class iske andar hoti h
import java.awt.event.*; //action listener
import java.sql.*; //result set ko import kiya

public class Login extends JFrame implements ActionListener {
    
    JButton login, signup, clear; //globally defined and ready to use in actionperformed function.
    JTextField cardTextField; //pinTextField; //jtextfield ke andar pinTextField me password likhunga to text dikhenge usko hide krne ke liye jpasswordfield use krenge.
    JPasswordField pinTextField;
    
    //class ka object bana na h
    
    Login(){
        
        setTitle("ATM");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        //icon ko directly nhi laga sakte frame me to uske liye j label use krenge.
        
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        //icon thoda chota aae, scaling krne k liye Image use krte h, ab jese imageicon ko frame m daalne k liye jlabel use kiya, lekin image ko nhi daal skte directly to image ko imageicon me convert krna pdega.
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel label = new JLabel(i3);
        //ab j label ko frame ke upar place kr raha hu.
        // jb bhi kisi component ko apne frame ke upar place krna hota h add() use krte h.
        label.setBounds(70, 10, 100, 100);
        add(label); //jlabel variabel ka object label pass kiya frame m dikhane
        
        //j label ki help se frame ke upar kuch bhi likh sakte h
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        JLabel cardno = new JLabel("Card No: ");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Osward", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        
        pinTextField = new JPasswordField(); //pehle yaha JTextField tha to kyuki password dots m dikhna chahiye likhte time isiliye humne usko ese likha.
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);  //y function hume bataega ki yaha par button pr click hua h
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
    
        
        getContentPane().setBackground(Color.WHITE);  //frame ka color set krne k liye.
        
        
        setSize(800, 480);  //sirf itna likhne se frame ready ho jaata h lekin dikhega nhi, hiden hota h.
        setVisible(true); // ye likh diya to dikhne lgega frame, iski value by default false rehti h to true krna pahta h.
        setLocation(350, 200); //center me khulega ab, initially top left m khul raha tha.
  
    }
    
    // ye function humne isiliye likha kyuki jab action listener implement kiya to Login class m error aaya.
    // humare pas koi bhi interface h or hum us interface ko implement karwanate h to us interface ke andar jitne bhi methods hote h unhe override karwana padhta h.
    // y neeche wala function action listener ke andar tha, ek abstract method h, wo sirf waha decalred tha defined nahi tha.
    //overriding kar di ab Login class m koi error nahi aaega.
    
    
    public void actionPerformed(ActionEvent ae){
        // ab action litsen to karwa diya, ab button ke click krne par kya krna h usko is function ke andar define krte h.
        
        //abhi dekhe to Jbutton locally defined h constructor ke andar, hume unhe globally define krna pdega agr is function ke andar use krna h to.
        
     
        if(ae.getSource() == clear){
            cardTextField.setText(""); //manually value daal sakte h, to ab double quotes ke andar kuch nhi h to empty ho jaaegi value
            pinTextField.setText("");
            
        } else if (ae.getSource() == login){
            //ab jese mene login pr click kiya se to mujhe seedha transaction page pr jaana h to kese krenge.
            //database ke saath connection establish krenge.
            
            Con c = new Con();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            
            //abhi tk hum table me data send kr rhe the ab table me se data retrieve karenge.
            String query = "select * from login where cardnumber = '"+cardNumber+"' and '"+pinNumber+"' ";
            
            try{
                ResultSet rs = c.s.executeQuery(query); //ab yaha execute query use kiya kyuki data retrieve karna h.
                //result set me jo query execute kr rhe h uska saara data store ho jaata h.
                
                if(rs.next()){  //ab ye check krega kya data nikal ke aaya h yaha 
                    setVisible(false); //to current frame ko close kar do.
                    
                    new Transactions(pinNumber).setVisible(true); //ho gaya ab agar login pr click  kiya to direct transaction page pr redirect ho jaaega.
                    //agar pin yaha successfull aata h to aage kahi pin nahi chahiye mujhe. To pin ko aage forward karenge.
                    
                } else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            } catch(Exception e){
                System.out.println(e);
            }
            
        } else if(ae.getSource() == signup){
            //ab me chahta hu ki jab me signup par click karu to next page SigupOne par forward ho jaau.
            setVisible(false);
            
            //signup frame kholne h usko kholne ke liye signup frame ka object bana na pdega.
            //object banate hi constructor call hoga, or constructor call hote hi Frame samne aa jaaega.
            new SignupOne().setVisible(true);
          
        }        
        
    }
    
    public static void main(String [] args){
        new Login();   //jese hi class ko run kru mera frame open ho jaae
    }
}
