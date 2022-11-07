package atm.system;

import java.awt.*; 
import javax.swing.*; //frame is class se aata h
import java.util.*;
import com.toedter.calendar.JDateChooser; //libraries m jo jcalendar add kiya, us se yaha import karwa liya.
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {
    
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;
    
    
    SignupOne(){ 
        
        setLayout(null); //ye nhi likhenge to kuch bhi cheez hogi stuling ke baad bhi sahi se nahi aaegi isiliye layout null krna pdega tb sab styling sahi hogi.
        
        Random ran = new Random(); //random function unique phone number generate krne k liye use kar rahe h.
        
        random = Math.abs((ran.nextLong() % 9000L) + 1000L); //y hume 4 unique numbers dega har baar.
        //math abs isiliye use kiya kyuki bina uske negative numbers aa rhe the isiliye, iska use krenge to saare positive m aaenge.
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random ); //phone number m random number generate hone ab.
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140,20,600,40); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details" ); //phone number m random number generate hone ab.
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290,80,400,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(personalDetails);
        
        JLabel name = new JLabel("Name: " ); //phone number m random number generate hone ab.
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name: " ); //phone number m random number generate hone ab.
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth: " ); //phone number m random number generate hone ab.
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(Color.black);
        add(dateChooser);
        
        
        JLabel gender = new JLabel("Gender: " ); //phone number m random number generate hone ab.
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450,290,80,30);
        female.setBackground(Color.white);
        add(female);
        
        //agar abhi male or female select karenge to dono select honge agar dono pr click kiya to.
        //jese ek par select kiya to dusra deselect ho gaya wesa functionality lagani h to uske liye ye krenge.
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
       
        
        JLabel email = new JLabel("Email Address: " ); //phone number m random number generate hone ab.
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,340,200,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital Status: " ); //phone number m random number generate hone ab.
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,200,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.white);
        add(married);
        
        unmarried = new JRadioButton("Unmaried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.white);
        add(other);
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);
        
        JLabel address = new JLabel("Address: " ); //phone number m random number generate hone ab.
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);
        
        JLabel city = new JLabel("City: " ); //phone number m random number generate hone ab.
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        
        JLabel state = new JLabel("State: " ); //phone number m random number generate hone ab.
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pin Code: "); //phone number m random number generate hone ab.
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,200,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(pincode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);
        
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.white);
        
        setSize(850, 800);  // bas ye 3 cheez likhne se frame dikhne lgega.
        setLocation(350, 10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;   //random isiliye daala kyuki ab yaha pr values ko database me enter karwana h.
        //is se pehle sirf random likha tha to error aa raha tha- long cannot convert to string.
        // to hum " " + random likh dete concat karwa dete h ab random form ko as a string lega.
        
        String name = nameTextField.getText();
        String fname = nameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()) {
            gender = "Male";
        } else if(female.isSelected()) {
            gender = "Female";
        }
        
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        } else if(unmarried.isSelected()){
            marital = "Unmarried";
        } else if(other.isSelected()){
            marital = "other";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        
        //ab yaha se database acces krna h to kya krenge
        
        try{
            
            if(name.equals("")){  //validation laga rahe h ki agar name nahi daala to ye pop up dikha do
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                
                //ab database ke saath connection establish karna h
                Con c = new Con();
                
                String query = "insert into signup values ('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
                
                //signup ki table banaenge mysql me.
                c.s.executeUpdate(query); //iske andar DML command chalate h.
                //itna karn ke baad meri jo query h wo MySQL m run ho jaaegi.
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true); //formno hmari primary key h. Taki hum signupone or aignupTwo ke data ko interrelate kar sake.
                
            }
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
   
    
    public static void main(String[] args){
       new SignupOne();
    }
}
