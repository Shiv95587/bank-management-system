package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import static javax.swing.JOptionPane.*;

public class Register extends JFrame implements ActionListener, FocusListener,KeyListener {

    JLabel firstNameLabel;
    JLabel lastNameLabel;
    JLabel NIC;
    JLabel GenderLabel;
    JLabel PhoneLabel;
    JLabel passwordLabel;
    JLabel DOB;
    JLabel addressLabel;
    JTextField fname;
    JTextField lname;
    JTextField phone;
    JRadioButton Male;
    JRadioButton Female;
    JTextField Nic;
    JPasswordField password;
    JTextArea address;
    JButton submit;
    JButton reset;
    JComboBox day;
    JComboBox month;
    JComboBox year;
    JButton goBack;
    Image newImg;
    Image img;
    JProgressBar bar;
    boolean hasUpper;
    boolean hasLower;
    boolean hasDigit;
    boolean hasSpecialChar;
    public Manager manager = new Manager();
    String c;
    JLabel strength; // used to display the strength of password(Weak,Moderate,Strong)

    public static final String[] dates
            = {"1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31"};
    public static final String[] months
            = {"Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec"};
    public static final String[] years
            = {"1960","1961","1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975",
             "1976","1977","1978","199","1980","1981","1982","1983","1984", "1985","1986","1987","1988","1989","1990","1991",
            "1992","1993","1994","1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002",
            "2003","2004"
     };

    ButtonGroup gender; // used to group radio buttons so that only one can be selected at a time

    Register() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1100, 700);
        this.setLocationRelativeTo(null);
        this.setTitle("Registration Form");

        int thickness = 1;


        this.getContentPane().setBackground(Color.white);
        // Y - Gap = 60 X - GAP = = 400
        JLabel heading = new JLabel("Registration Form");

        heading.setBounds(550, 10, 700, 100);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
        this.add(heading);

        strength = new JLabel();

        firstNameLabel = new JLabel("First name");
        firstNameLabel.setBounds(100, 160, 100, 40);
        firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(firstNameLabel);

        fname = new JTextField();
        fname.setBounds(200, 160, 300, 40);
        fname.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, thickness, true));
        fname.setFont(new Font("Arial", Font.PLAIN, 20));
        fname.addFocusListener(this);
        this.add(fname);

        lastNameLabel = new JLabel("Last name");
        lastNameLabel.setBounds(800, 160, 100, 40);
        lastNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(lastNameLabel);

        lname = new JTextField();
        lname.setBounds(900, 160, 300, 40);
        lname.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, thickness, true));
        lname.setFont(new Font("Arial", Font.PLAIN, 20));
        lname.addFocusListener(this);
        this.add(lname);


        PhoneLabel = new JLabel("Phones #");
        PhoneLabel.setBounds(100, 220, 100, 40);
        PhoneLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(PhoneLabel);

        phone = new JTextField();
        phone.setBounds(200, 220, 300, 40);
        phone.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, thickness, true));
        phone.setFont(new Font("Arial", Font.PLAIN, 20));
        phone.addKeyListener(( this ));
        phone.addFocusListener(this);
        this.add(phone);

        // NIC
        NIC = new JLabel("NIC #");
        NIC.setBounds(800, 220, 100, 40);
        NIC.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(NIC);

        Nic = new JTextField();
        Nic.setBounds(900, 220, 300, 40);
        Nic.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, thickness, true));
        Nic.setFont(new Font("Arial", Font.PLAIN, 20));
        Nic.addKeyListener(this);
        Nic.addFocusListener(this);
        this.add(Nic);

        // Gender
        GenderLabel = new JLabel("Gender");
        GenderLabel.setBounds(100, 280, 100, 40);
        GenderLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(GenderLabel);

        Male = new JRadioButton("Male");
        Female = new JRadioButton("Female");
        Male.setBounds(200, 285, 100, 30);
        Male.setBackground(Color.white);
        Female.setBounds(310, 285, 100, 30);
        Female.setBackground(Color.white);
        gender = new ButtonGroup();
        gender.add(Male);
        gender.add(Female);
        this.add(Male);
        this.add(Female);

        // Date of birth

        DOB = new JLabel("Date of Birth");
        DOB.setBounds(800, 280 + 70, 100, 40);
        DOB.setFont(new Font("Arial", Font.BOLD, 17));
        this.add(DOB);

        day = new JComboBox(dates);
        day.setToolTipText("Day");
        day.setBounds(920,280 + 70,60,30);
        day.setFont( new Font("Arial",Font.PLAIN,15));
        day.setBackground(Color.white);
        this.add(day);

        month = new JComboBox(months);
        month.setBounds(1020,280 + 70,60,30);
        month.setToolTipText("Month");
        month.setBackground(Color.white);
        month.setFont( new Font("Arial",Font.PLAIN,15));
        this.add(month);

        year = new JComboBox(years);
        year.setToolTipText("Year");
        year.setBackground(Color.white);
        year.setBounds(1120,280 + 70,60,30);
        year.setFont( new Font("Arial",Font.PLAIN,15));
        this.add(year);


        // Password

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(100, 350, 100, 20);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(passwordLabel);

        password = new JPasswordField();
        password.setBounds(200, 340, 300, 40);
        password.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, thickness, true));
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.addFocusListener(this);
        password.addKeyListener(this);
        this.add(password);

        addressLabel = new JLabel("Address");
        addressLabel.setBounds(100, 440, 100, 20);
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(addressLabel);

        address = new JTextArea();
        address.setBounds(200, 440, 300, 100);
        address.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, thickness, true));
        address.setFont(new Font("Arial", Font.PLAIN, 20));
        address.addFocusListener(this);
        this.add(address);

        submit = new JButton("Submit");
        reset = new JButton("Reset");
        submit.setBackground(Color.white);
        submit.addActionListener(this);
        reset.setBackground(Color.white);
        reset.addActionListener(this);

        submit.setBounds(500, 630, 150, 40);
        reset.setBounds(700, 630, 150, 40);


        goBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);

        goBack.setIcon( new ImageIcon(newImg) );
        goBack.setBounds(10,10,30,25);
        goBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        goBack.setToolTipText("Go back");
        goBack.addActionListener(this);
        this.add(goBack);

        // Progress Bar used to indicate the strength of password

        bar = new JProgressBar(0,100);
        bar.setBounds(220,390,250,10);
        bar.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,true));
        bar.setBackground(Color.white);

        this.add(bar);
        this.add(submit);
        this.add(reset);
        this.add(strength);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);
        this.setVisible(true);


    }

    // ensure that every field / textBox is filled
    boolean check()
    {
        if(fname.getText().isEmpty() || lname.getText().isEmpty() || phone.getText().isEmpty() || Nic.getText().isEmpty() ||
                Objects.equals( password.getPassword(), "") || address.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Fill all fields","Incomplete Fields", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        else
        {
            return false;
        }
    }

    void Reset()
    {
        fname.setText("");
        lname.setText("");
        phone.setText("");
        address.setText("");
        Nic.setText("");
        bar.setValue(0);
        strength.setText("");
        password.setText("");
    }

    // Checks the strength of password
    String strengthChecker( char[] pass )
    {
        Set<Character> set = new HashSet<Character>(
                Arrays.asList('!', '@', '#', '$', '%', '^', '&',
                        '*', '(', ')', '-', '+'));
        byte length = (byte)pass.length;
        hasLower = false;
        hasUpper = false;
        hasDigit = false;
        hasSpecialChar = false;

        for( char i : pass )
        {
            if( Character.isLowerCase(i) )
            {
                hasLower = true;
            }
            if( Character.isUpperCase(i) )
            {
                hasUpper = true;
            }
            if( Character.isDigit(i) )
            {
                hasDigit = true;
            }
            if( set.contains(i) )
            {
                hasSpecialChar = true;
            }
        }

        if( hasUpper && hasLower && hasDigit && hasSpecialChar && (length >= 8))
        {
            return "Strong";
        }
        else if( (hasUpper || hasLower || hasDigit ) && (length >= 6))
        {
        return "Moderate";
        }
        else
        {
            return "Weak";
        }


    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == submit) {

            if (check()) {
                bar.setValue(0);
                strength.setText("");
                password.setText("");

            } else {
                manager.setFirstName(fname.getText());
                manager.setLastName(lname.getText());
                if (Male.isSelected()) {
                    manager.setGender("Male");
                } else {
                    manager.setGender("Female");
                }
                manager.setAddress(address.getText());
                manager.setMobileno(phone.getText());


                manager.setNICno((Nic.getText()));

                int age = calculateAge();

                manager.setAge(age);
                if(password.getPassword().length < 6)
                {
                    JOptionPane.showMessageDialog(null,"Password length must be greater than 5\n","Weak password", ERROR_MESSAGE);
                    password.setText("");
                }
                else {
                    manager.setPassword(String.copyValueOf(password.getPassword()));
                    try {
                        File file = new File("ManagerDetails.txt");
                        FileWriter fw = new FileWriter(file);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.flush();
                        PrintWriter writer = new PrintWriter( bw );

                        writer.println(manager.getFirstName() + " " + manager.getLastName() + "," + manager.getMobileno()
                         + "," + manager.getNICno() + "," + manager.getGender() + "," + manager.getAge() + "," +
                                manager.getPassword() + "," + manager.getAddress());
                        writer.flush();
                        writer.close();
                        JOptionPane.showMessageDialog(null,"Registration Completed","Successful", PLAIN_MESSAGE);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    new ManagerMenu();
                    this.dispose();
                }

            }

           bar.setValue(0);
            strength.setText("");

        }
            else if( e.getSource() == reset )
            {
                Reset();
            }

            if( e.getSource() == goBack )
            {
                this.dispose();
                new ManagerMenu();
            }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if( e.getSource() == fname )
        {
            fname.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }

        if( e.getSource() == lname )
        {
            lname.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }

        if( e.getSource() == phone )
        {
            phone.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }
        if( e.getSource() == Nic )
        {
            Nic.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }


        if( e.getSource() == password )
        {
            password.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }

        if( e.getSource() == address )
        {
            address.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if( e.getSource() == fname )
        {
            fname.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
        }

        if( e.getSource() == lname )
        {
            lname.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
        }

        if( e.getSource() == Nic )
        {
            Nic.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
        }

        if( e.getSource() == phone )
        {
            phone.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
        }

        if( e.getSource() == address )
        {
            address.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
        }

        if( e.getSource() == password )
        {
            password.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

        // makes textField number-only
        if( e.getSource() == Nic || e.getSource() == phone ) {
            char c;
            c = e.getKeyChar();
            if ((c < '0' || c > '9') && (c != KeyEvent.VK_BACK_SPACE)) {
                e.consume(); // it ignores the event
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    // used to check and display password strength
    void checker()
    {
            strength.setBounds(222,400,200,20);
            strength.setFont( new Font("Arial",Font.PLAIN,15) );
            strength.setForeground(Color.blue);
            strength.setBackground(Color.white);
            //strength.setForeground( new Color(0,0,190));
            strength.setOpaque(true);
            strength.setHorizontalAlignment(SwingConstants.LEFT);
            c = strengthChecker(password.getPassword());

            if( c.equals("Strong") )
            {
                bar.setValue(100);
                bar.setForeground(Color.green);
                strength.setText("Strong");
                strength.setFont( new Font("Arial",Font.BOLD,15));
                strength.setForeground(Color.green);
            }
            else if( c.equals("Moderate") )
            {
                bar.setValue(67);
                bar.setForeground(Color.yellow);
                strength.setText("Moderate");
                strength.setFont( new Font("Arial",Font.BOLD,15));
                strength.setForeground(Color.yellow);
            }
            else if( password.getPassword().length == 0 )
            {
                bar.setValue(0);
                bar.setForeground(Color.white);
                strength.setText("");
            }
            else if( c.equals("Weak") )
            {
                bar.setValue(33);
                bar.setForeground(Color.red);
                strength.setText("Weak");
                strength.setFont( new Font("Arial",Font.BOLD,15));
                strength.setForeground(Color.red);
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if( e.getSource() == password )
        {
            checker();
        }

    }
    // used to calculate Age by current date and admin's date of birth
    int calculateAge() {
        String current = String.valueOf((java.time.LocalDate.now()));
        System.out.println(current);
        System.out.println(current);
        Scanner readDate = new Scanner(current);
        readDate.useDelimiter("[-]");

        int y = Integer.parseInt(readDate.next());
        int m = Integer.parseInt(readDate.next());
        int d = Integer.parseInt(readDate.next());

        int y1 = Integer.parseInt(String.valueOf(year.getSelectedItem()));
        int d1 = Integer.parseInt(String.valueOf(day.getSelectedItem()));
        int m1 = month.getSelectedIndex() + 1;
        System.out.println(y1 + " " + d1 + "" + m1);

        int age = 0;
        if( y > y1 )
        {
            if( m > m1 )
            {
                age = y - y1;
            }
            else if( m < m1 )
            {
                age = y - y1 - 1;
            }
            else {

                if( d >= d1)
                {
                    age = y - y1;
                }
                else
                {

                    age = y - y1 - 1;
                }
            }
        }
        System.out.println("Age: " + age);
        readDate.close();
        return age;
    }
}
