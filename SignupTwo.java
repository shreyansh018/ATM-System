package atm.system;

import java.awt.*; 
import javax.swing.*; //frame is class se aata h
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, income, eduquali;
    String formno;
    
    
    SignupTwo(String formno){ //neeche new signuptwo(formno) daala tha isiliye yaha bhi formno daalana pdega
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details" ); //phone number m random number generate hone ab.
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion:" ); //phone number m random number generate hone ab.
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(name);
        
        //drop down box bana na h ab religion ke liye
        String ReligionVal[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(ReligionVal);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);
      
        JLabel fname = new JLabel("Category:" ); //phone number m random number generate hone ab.
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(fname);
        
        String CategoryVal[] = {"General","SC", "ST", "OBC"};
        category = new JComboBox(CategoryVal);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);
        
        JLabel dob = new JLabel("Income:" ); //phone number m random number generate hone ab.
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(dob);
        
        String IncomeCategory[] = {"NULL", "< 1.5 lakhs", "< 2.5 Lakhs", " < 5 lakhs", "Upto 10 lakhs"};
        income = new JComboBox(IncomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);
   
        
        JLabel gender = new JLabel("Educational" ); //phone number m random number generate hone ab.
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(gender);
    
        
        JLabel email = new JLabel("Qualification:" ); //phone number m random number generate hone ab.
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,315,200,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(email);
        
        String EduQualValues[] = {"SSC", "HSC", "Graduate", "Post- Graduate", "Doctorate", "Others"};
        eduquali = new JComboBox(EduQualValues);
        eduquali.setBounds(300, 315, 400, 30);
        eduquali.setBackground(Color.white);
        add(eduquali);
        
        JLabel marital = new JLabel("Occupation:" ); //phone number m random number generate hone ab.
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,200,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(marital);
        
        String OccupationValues[] = {"Student", "Salaried", "Self-Employed", "Bussiness", "Retired"};
        occupation = new JComboBox(OccupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);
        
        JLabel address = new JLabel("PAN Number: " ); //phone number m random number generate hone ab.
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(address);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        JLabel city = new JLabel("Aadhar Number: " ); //phone number m random number generate hone ab.
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(city);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        
        
        JLabel state = new JLabel("Senior Citizen:" ); //phone number m random number generate hone ab.
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(state);
        
        syes = new JRadioButton("Yes");
        syes.setBackground(Color.white);
        syes.setBounds(300, 540, 100, 30);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBackground(Color.white);
        sno.setBounds(450, 540, 100, 30);
        add(sno);
        
        ButtonGroup seniorCitizen = new ButtonGroup();
        seniorCitizen.add(syes);
        seniorCitizen.add(sno);
        
        JLabel pincode = new JLabel("Existing Acoount: "); //phone number m random number generate hone ab.
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,100,30); //frame ke andar set karte h is function ko use krke. setBounds tbhi kaam krega jab setLayout null hoga.
        add(pincode);
        
        eyes = new JRadioButton("Yes");
        eyes.setBackground(Color.white);
        eyes.setBounds(300, 590, 100, 30);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBackground(Color.white);
        eno.setBounds(450, 590, 50, 30);
        add(eno);
        
        ButtonGroup existingAcc = new ButtonGroup();
        existingAcc.add(eyes);
        existingAcc.add(eno);
        
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
        String sreligion = (String)religion.getSelectedItem(); //dropbox se item select karne ke liye getSelectedItem() function ka use karte h.
        //ek problem aaegi ki getSelectedItem() ek object ko return karta h, or mujhe chaihiye string to me String typecaste karwa dunga.
        String scategory = (String)category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seduquali = (String) eduquali.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        
        
        String seniorCitizen = null;
        if(syes.isSelected()) {
            seniorCitizen = "Yes";
        } else if(sno.isSelected()) {
            seniorCitizen = "No";
        }
        
        String existingAcc = null;
        if(eyes.isSelected()){
            existingAcc = "Yes";
        } else if(eno.isSelected()){
            existingAcc = "No";
        } 
        
        String stringPan = pan.getText();
        String saadhar = aadhar.getText();
        
        try{
                Con c = new Con();
                
                String query = "insert into signupTwo values ('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seduquali+"', '"+soccupation+"', '"+stringPan+"', '"+saadhar+"', '"+seniorCitizen+"', '"+existingAcc+"')";    
                c.s.executeUpdate(query); 
                
                //signupThree ka object
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
   
    
    public static void main(String[] args){
       new SignupTwo("");
    }
}
