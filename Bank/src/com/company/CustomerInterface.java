package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Scanner;
//import javax.activation.MimeType;
//import javax.mail.*;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Authenticator;
//import javax.mail.PasswordAuthentication;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.regex.Pattern;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class CustomerInterface extends JFrame implements ActionListener, FocusListener,KeyListener {


    // Frames
    private JFrame viewFrame;
    private JFrame depositFrame;
    private JFrame withDrawFrame;
    private JFrame transferFrame;
    private JFrame billsFrame;
    private JFrame electricityFrame;
    private JFrame gasFrame;
    private JFrame waterFrame;
    private JFrame loansFrame;
    private JFrame tempFrame;
    private JFrame carLoanFrame;
    private JFrame homeLoanFrame;
     
    // Panels
    private  JPanel depositPanel;
    private JPanel withDrawPanel;
    private JPanel transferPanel;
    private JPanel viewPanel;

    // Go Back Buttons
    private JButton goBack;
    private JButton viewGoBack;
    private JButton depositGoBack;
    private JButton withDrawGoBack;
    private JButton transferGoBack;
    private JButton billsGoBack;
    private  JButton electricityGoBack;
    private JButton gasGoBack;
    private JButton waterGoBack;
    private JButton loansGoBack;
    private JButton loansTypesGoBack;
    private JButton viewBack;
    
    // TextFields
    private JTextField depositField;
    private JTextField withDrawField;
    private JTextField transferAccountNoField;
    private JTextField transferAmountField;
    private JTextField electricityField;
    private JTextField gasField;
    private JTextField waterField;
    private JTextField Temp;
     
    // Buttons
    private JButton viewAccount;
    private JButton depositAmount;
    private JButton withDrawAmount;
    private JButton transferAmount;
    private JButton payBills;
    private JButton Loans;
    private JButton carLoanButton;
    private JButton homeLoanButton;

    // Loans fields

    private JTextField principalField;
    private JTextField rateOfInterestField;
    private JTextField noOfYearsField;
    private JTextField makeField;
    private JTextField modelField;
    private JTextField nameOfOwnerField;
    private JTextField cityField;
    private JTextArea addressField;

    private JButton electricityBill;
    private JButton gasBill;
    private JButton waterBill;


    int BillType = 0; //  this will tell about the type of bill
    byte LoanType = 0; // this will tell about the type of loan
    boolean alreadyPaid = false; // this will check whether bill is already or not
    static String accno; // account no of customer who has signed in
    static String name;
    static String type;
    static String signedInemail;

    
    ImageIcon icon;
    boolean answer = false;
    static String balance;
    private static JButton withDrawButton;
    private static JButton depositButton;
    private static JButton transferButton;
    private static JButton pay; // used to pay bills
    private static JButton lend; // used to lend loans

    // Labels
    private JLabel viewAccountLabel;
    private JLabel depositAmountLabel;
    private JLabel withDrawAmountLabel;
    private JLabel transferAmountLabel;
    private JLabel payBillsLabel;
    private JLabel LoansLabel;
    private JLabel carLoanLabel;
    private JLabel homeLoanLabel;

    private JLabel principalLabel;
    private JLabel rateOfInterestLabel;
    private  JLabel noOfYearsLabel;
    private JLabel makeLabel;
    private JLabel modelLabel;
    private  JLabel nameOfOwnerLabel;
    private  JLabel cityLabel;
    private JLabel addressLabel;

    // Image
    private Image img;
    private  Image newImg;

    // font
    private Font font;

    CustomerInterface()
    {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1300,700);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.white);
        this.setTitle("Customer");

        font = new Font("Arial",Font.PLAIN,20);

        byte extraHeight = 30;

        // view Account Button
        viewAccount = new JButton();
        viewAccount.setBounds(100,220 + extraHeight,150,150 );
        img = ( new ImageIcon("images/viewAcc.png")).getImage();
        newImg = img.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        viewAccount.setIcon( new ImageIcon(newImg));
        viewAccount.addActionListener(this);
        this.add(viewAccount);

        // viewAccountLabel
        viewAccountLabel = new JLabel("View Account");
        viewAccountLabel.setBounds(115,390 + extraHeight,140,30);
        viewAccountLabel.setFont(font);
        viewAccountLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        viewAccountLabel.setVerticalTextPosition(SwingConstants.CENTER);
        this.add(viewAccountLabel);
        
        // depositAmount Button
        depositAmount = new JButton();
        depositAmount.setBounds(300,220 + extraHeight,150,150);
        img = ( new ImageIcon("images/deposit.png")).getImage();
        depositAmount.setBackground(Color.white);
        newImg = img.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        depositAmount.setIcon( new ImageIcon(newImg));
        depositAmount.addActionListener(this);
        this.add(depositAmount);

        // depositLabel
        depositAmountLabel = new JLabel("Deposit");
        depositAmountLabel.setBounds(340,390 + extraHeight,140,30);
        depositAmountLabel.setFont(font);
        depositAmountLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        depositAmountLabel.setVerticalTextPosition(SwingConstants.CENTER);
        this.add(depositAmountLabel);

        // withDraw button
        withDrawAmount = new JButton();
        withDrawAmount.setBounds(500,220 + extraHeight,150,150);
        img = ( new ImageIcon("images/withDraw.png")).getImage();
        withDrawAmount.setBackground(Color.white);
        newImg = img.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        withDrawAmount.setIcon( new ImageIcon(newImg));
        withDrawAmount.addActionListener(this);
        this.add(withDrawAmount);

        // withDraw Label
        withDrawAmountLabel = new JLabel("WithDraw");
        withDrawAmountLabel.setBounds(530,390 + extraHeight,140,30);
        withDrawAmountLabel.setFont(font);
        withDrawAmountLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        withDrawAmountLabel.setVerticalTextPosition(SwingConstants.CENTER);
        this.add(withDrawAmountLabel);

        // transfer Amount
        transferAmount = new JButton();
        transferAmount.setBounds(700,220 + extraHeight,150,150);
        img = ( new ImageIcon("images/send.png")).getImage();
        transferAmount.setBackground(Color.white);
        newImg = img.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        transferAmount.setIcon( new ImageIcon(newImg));
        transferAmount.addActionListener(this);
        this.add(transferAmount);

        // transferAmount Label
        transferAmountLabel = new JLabel("Transfer");
        transferAmountLabel.setBounds(740,390 + extraHeight,140,30);
        transferAmountLabel.setFont(font);
        transferAmountLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        transferAmountLabel.setVerticalTextPosition(SwingConstants.CENTER);
        this.add(transferAmountLabel);

        // payBills Button
        payBills = new JButton();
        payBills.setBounds(900,220 + extraHeight,150,150);
        img = ( new ImageIcon("images/bills.png")).getImage();
        payBills.setBackground(Color.white);
        newImg = img.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        payBills.setIcon( new ImageIcon(newImg));
        payBills.addActionListener(this);
        this.add(payBills);
        
        // payBills Label
        payBillsLabel = new JLabel("Bills");
        payBillsLabel.setBounds(950,390 + extraHeight,140,30);
        payBillsLabel.setFont(font);
        payBillsLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        payBillsLabel.setVerticalTextPosition(SwingConstants.CENTER);
        this.add(payBillsLabel);

        // Loans Button
        Loans = new JButton();
        Loans.setBounds(1100,220 + extraHeight,150,150);
        img = ( new ImageIcon("images/loan.png")).getImage();
        Loans.setBackground(Color.white);
        newImg = img.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        Loans.setIcon( new ImageIcon(newImg));
        Loans.addActionListener(this);
        this.add(Loans);

        // LoansLabel
        LoansLabel = new JLabel("Loans");
        LoansLabel.setBounds(1150,390 + extraHeight,140,30);
        LoansLabel.setFont(font);
        LoansLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        LoansLabel.setVerticalTextPosition(SwingConstants.CENTER);
        this.add(LoansLabel);

        // Go back button

        goBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);

        goBack.setIcon( new ImageIcon(newImg) );
        goBack.setBounds(10,10,30,25);
        goBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        goBack.setToolTipText("Go back");
        goBack.addActionListener(this);
        this.add(goBack);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);


    }

    // this will check whether bill is paid or not
    void checkBillStatus(int i) throws IOException {

        File file = new File("BillsStatus.txt");
        Scanner reader;
        String[] data = new String[5];

        if( file.exists() )
        {
            reader = new Scanner(file);
            reader.useDelimiter("[,\n]");

            while( reader.hasNext() )
            {
                data[0] = reader.next();
                data[1] = reader.hasNext() ? reader.next() : "0";
                data[2] = reader.hasNext() ? reader.next() : "0";
                data[3] = reader.hasNext() ? reader.next() : "0";
                data[4] = reader.hasNext() ? reader.next() : "0";
                System.out.println("Data[2] = " + data[2]);
                System.out.println("Data[3] = " + data[3]);

                if( data[0].equals(CustomerInterface.accno))
                {
                    if( data[i].equals("Paid")) {
                        icon = new ImageIcon("images/successIcon.png");
                        img = (icon.getImage());
                        newImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                        icon = new ImageIcon(newImg);
                        JOptionPane.showMessageDialog(null, "Already Paid", "Paid", JOptionPane.INFORMATION_MESSAGE, icon);
                        reader.close();
                        tempFrame.dispose();
                        this.setVisible(true);
                        break;
                    }
                }
            }
            reader.close();
        }
    }

    // changes bill status from unpaid to paid
    public void payBill(int i) throws IOException {
        String[] data = new String[5];

            File oldFile = new File("BillsStatus.txt");
            File tempFile = new File("Temp2.txt");
            FileWriter fw = new FileWriter( tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.flush();
            PrintWriter writer = new PrintWriter( bw );
            Scanner read;
            if( oldFile.exists() ) {
                read = new Scanner(oldFile);
                read.useDelimiter("[,\n]");

                    while (read.hasNext()) {
                        data[0] = read.next();
                        data[1] = read.next();
                        data[2] = read.next();
                        data[3] = read.next();
                        data[4] = read.hasNext() ? read.next() : ",";

                        if (!(data[0].equals(CustomerInterface.accno))) {
                            writer.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + ",");
                        } else {
                            icon = new ImageIcon("images/successIcon.png");
                            data[i] = "Paid";
                            img = ( icon.getImage());
                            newImg = img.getScaledInstance(30,30,Image.SCALE_SMOOTH);
                            icon = new ImageIcon(newImg);
                            writer.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + ",");
                            JOptionPane.showMessageDialog(null, "Bill paid Successfully", "Paid", JOptionPane.INFORMATION_MESSAGE,icon);
                        }
                    }
                    read.close();

                     writer.flush();
                bw.flush();
                    writer.close();

                    oldFile.delete();
                    tempFile.renameTo(new File("BillsStatus.txt"));
                }
            tempFrame.dispose();
            new CustomerInterface();
    }

    // used to model and display gas frame
    void GasBillFrame() throws IOException {
        JLabel label = new JLabel();
        BillType = 2;
        JLabel amountLabel = new JLabel("Amount"); // used near text field
        pay = new JButton("Pay");
        gasFrame = new JFrame("Gas bill");

        gasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gasFrame.setSize(1300,700);
        gasFrame.setLayout(null);
        gasFrame.getContentPane().setBackground(Color.white);

        label.setBounds(290,40,250,220);
        Image img = (new ImageIcon("images/loginAccountImage.png")).getImage();
        Image newImg = img.getScaledInstance(250,280, Image.SCALE_SMOOTH);
        ImageIcon accIcon = new ImageIcon( newImg );

        label.setIcon(accIcon);
        label.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,false));

        JPanel gasPanel = new JPanel();
        gasPanel.setLayout(null);
        gasPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,true));
        gasPanel.setBounds(230,70,900,550);
        gasPanel.setBackground(Color.white);

        gasField = new JTextField("Enter amount to pay");
        gasField.setFont(font);
        gasField.setBorder(BorderFactory.createLineBorder(Color.black,1,true));
        gasField.setBounds(267,290,300,40);
        gasField.addFocusListener(this);
        gasField.addKeyListener(this);

        amountLabel.setBounds(167,295,100,40);
        amountLabel.setFont(font);
        gasPanel.add(amountLabel);

        pay.setBounds(335,370,170,40);
        pay.setBackground(Color.white);
        pay.addActionListener(this);
        gasPanel.add(pay);
        gasPanel.add(gasField);
        Temp = gasField;
        gasPanel.add(label);

        // Go back button
        gasGoBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);

        gasGoBack.setIcon( new ImageIcon(newImg) );
        gasGoBack.setBounds(10,10,30,25);
        gasGoBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        gasGoBack.setToolTipText("Go back");
        gasGoBack.addActionListener(this);
        gasFrame.add(gasGoBack);

        gasFrame.add(gasPanel);
        gasFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        gasFrame.setVisible(true);
        tempFrame = gasFrame;
        checkBillStatus(BillType);
    }

    void WaterBillFrame() throws IOException {
        JLabel label = new JLabel();
        BillType = 3;
        JLabel amountLabel = new JLabel("Amount"); // used near text field

        pay = new JButton("Pay");

        waterFrame = new JFrame("Water bill");

        waterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        waterFrame.setSize(1300,700);
        waterFrame.setLayout(null);
        waterFrame.getContentPane().setBackground(Color.white);

        label.setBounds(290,40,250,220);
        Image img = (new ImageIcon("images/loginAccountImage.png")).getImage();
        Image newImg = img.getScaledInstance(250,280, Image.SCALE_SMOOTH);
        ImageIcon accIcon = new ImageIcon( newImg );


        label.setIcon(accIcon);
        label.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,false));


        JPanel waterPanel = new JPanel();
        waterPanel.setLayout(null);
        waterPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,true));
        waterPanel.setBounds(230,70,900,550);
        waterPanel.setBackground(Color.white);

        waterField = new JTextField("Enter amount to pay");
        waterField.setFont(font);
        waterField.setBorder(BorderFactory.createLineBorder(Color.black,1,true));
        waterField.setBounds(267,290,300,40);
        waterField.addFocusListener(this);
        waterField.addKeyListener(this);
        amountLabel.setBounds(167,295,100,40);
        amountLabel.setFont(font);
        waterPanel.add(amountLabel);

        pay.setBounds(335,370,170,40);
        pay.setBackground(Color.white);
        pay.addActionListener(this);
        waterPanel.add(pay);
        waterPanel.add(waterField);
        waterPanel.add(label);
        Temp = waterField;

        // Go back button
        waterGoBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);

        waterGoBack.setIcon( new ImageIcon(newImg) );
        waterGoBack.setBounds(10,10,30,25);
        waterGoBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        waterGoBack.setToolTipText("Go back");
        waterGoBack.addActionListener(this);
        waterFrame.add(waterGoBack);

        waterFrame.add(waterPanel);
        waterFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        waterFrame.setVisible(true);
        tempFrame = waterFrame;
        checkBillStatus(BillType);
    }


    void ElectricityBillFrame() throws IOException {

        JLabel label = new JLabel();
        BillType = 1;
        JLabel amountLabel = new JLabel("Amount"); // used near text field
        pay = new JButton("Pay");

        electricityFrame = new JFrame("Electricity bill");

        electricityFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        electricityFrame.setSize(1300,700);
        electricityFrame.setLayout(null);
        electricityFrame.getContentPane().setBackground(Color.white);

        label.setBounds(290,40,250,220);
        Image img = (new ImageIcon("images/loginAccountImage.png")).getImage();
        Image newImg = img.getScaledInstance(250,280, Image.SCALE_SMOOTH);
        ImageIcon accIcon = new ImageIcon( newImg );

        label.setIcon(accIcon);
        label.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,false));

        JPanel electricityPanel = new JPanel();
        electricityPanel.setLayout(null);
        electricityPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,true));
        electricityPanel.setBounds(230,70,900,550);
        electricityPanel.setBackground(Color.white);

        electricityField = new JTextField("Enter amount to pay");
        electricityField.setFont(font);
        electricityField.setBorder(BorderFactory.createLineBorder(Color.black,1,true));
        electricityField.setBounds(267,290,300,40);
        electricityField.addFocusListener(this);
        electricityField.addKeyListener(this);

        amountLabel.setBounds(167,295,100,40);
        amountLabel.setFont(font);
        electricityPanel.add(amountLabel);

        pay.setBounds(335,370,170,40);
        pay.setBackground(Color.white);
        pay.addActionListener(this);
        electricityPanel.add(pay);
        electricityPanel.add(electricityField);
        electricityPanel.add(label);
        Temp = electricityField;

        // Go back button
        electricityGoBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);

        electricityGoBack.setIcon( new ImageIcon(newImg) );
        electricityGoBack.setBounds(10,10,30,25);
        electricityGoBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        electricityGoBack.setToolTipText("Go back");
        electricityGoBack.addActionListener(this);
        electricityFrame.add(electricityGoBack);

        electricityFrame.add(electricityPanel);
        electricityFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        electricityFrame.setVisible(true);
        tempFrame = electricityFrame;
        checkBillStatus(BillType);
    }


// used to model display deposit frame
    void deposit()
    {
        JLabel label = new JLabel();
        JLabel amountLabel = new JLabel("Amount"); // used near text field
        depositButton = new JButton("Deposit");


        depositFrame = new JFrame("Deposit Amount");

        depositFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        depositFrame.setSize(1300,700);
        depositFrame.setLayout(null);
        depositFrame.getContentPane().setBackground(Color.white);

        label.setBounds(290,40,250,220);
        Image img = (new ImageIcon("images/loginAccountImage.png")).getImage();
        Image newImg = img.getScaledInstance(250,280, Image.SCALE_SMOOTH);
        ImageIcon accIcon = new ImageIcon( newImg );


        label.setIcon(accIcon);
        label.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,false));


        depositPanel = new JPanel();
        depositPanel.setLayout(null);
        depositPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,true));
        depositPanel.setBounds(230,70,900,550);
        depositPanel.setBackground(Color.white);

        depositField = new JTextField("Enter amount to deposit");
        depositField.setFont(font);
        depositField.setBorder(BorderFactory.createLineBorder(Color.black,1,true));
        depositField.setBounds(267,290,300,40);
        depositField.addFocusListener(this);
        depositField.addKeyListener(this);
        amountLabel.setBounds(167,295,100,40);
        amountLabel.setFont(font);
        depositPanel.add(amountLabel);

        depositButton.setBounds(335,370,170,40);
        depositButton.setBackground(Color.white);
        depositButton.addActionListener(this);
        depositPanel.add(depositButton);
        depositPanel.add(depositField);
        Temp = depositField;
        depositPanel.add(label);

        // Go back button
        depositGoBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);

        depositGoBack.setIcon( new ImageIcon(newImg) );
        depositGoBack.setBounds(10,10,30,25);
        depositGoBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        depositGoBack.setToolTipText("Go back");
        depositGoBack.addActionListener(this);
        depositFrame.add(depositGoBack);

        depositFrame.add(depositPanel);
        depositFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        depositFrame.setVisible(true);


    }

    // used to display customer's details
    public void view() throws FileNotFoundException {

        int ew = 100; //ew means extra width
        int x = 70; // used to change x coordinates of labels

        Font font = new Font("Arial",Font.PLAIN,16);
        viewFrame = new JFrame("View Account");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(1300,700);
        viewFrame.setLayout(null);
        viewFrame.getContentPane().setBackground(Color.white);


        viewPanel = new JPanel(null);
        viewPanel.setBounds(150,70,1000,550);


        JLabel label = new JLabel();
        label.setBounds(350,30,250,200);
        Image img = (new ImageIcon("images/loginAccountImage.png")).getImage();
        Image newImg = img.getScaledInstance(250,230, Image.SCALE_SMOOTH);
        ImageIcon accIcon = new ImageIcon( newImg );
        label.setIcon(accIcon);
        label.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,false));
        viewPanel.add(label);


        JLabel Name = new JLabel("Name: ");
        Name.setBounds(50 + x,270,100,30);
        Name.setHorizontalTextPosition(SwingConstants.LEFT);
        Name.setFont(font);
        viewPanel.add(Name);

        JLabel NameValue = new JLabel();
        NameValue.setBounds(150 + x,270,100 + ew,30);
        NameValue.setFont(font);
        NameValue.setForeground( new Color(51,153,255));
        viewPanel.add(NameValue);

        JLabel Phone = new JLabel("Phone #: ");
        Phone.setBounds(600 + x,270,100,30);
        Phone.setHorizontalTextPosition(SwingConstants.LEFT);
        Phone.setFont(font);
        viewPanel.add(Phone);

        JLabel PhoneValue = new JLabel();
        PhoneValue.setBounds(700 + x,270,100 + ew,-30);
        PhoneValue.setFont(font);
        PhoneValue.setForeground( new Color(51,153,255));
        viewPanel.add(PhoneValue);

        JLabel Nic = new JLabel("Nic #: ");
        Nic.setBounds(50 + x,320,100,30);
        Nic.setHorizontalTextPosition(SwingConstants.LEFT);
        Nic.setFont(font);
        viewPanel.add(Nic);

        JLabel NicValue = new JLabel();
        NicValue.setBounds(150 + x,320,100+ ew,30);
        NicValue.setFont(font);
        NicValue.setForeground( new Color(51,153,255));
        viewPanel.add(NicValue);


        JLabel Age = new JLabel("Age: ");
        Age.setHorizontalTextPosition(SwingConstants.LEFT);
        Age.setBounds(600 + x,320,100,30);
        Age.setFont(font);

        viewPanel.add(Age);


        JLabel AgeValue = new JLabel();
        AgeValue.setBounds( 700 + x,320,100+ ew,30);
        AgeValue.setFont(font);
        AgeValue.setForeground( new Color(51,153,255));
        viewPanel.add(AgeValue);


        JLabel Gender = new JLabel("Gender: ");
        Gender.setBounds(50 + x,370,100,30);
        Gender.setFont(font);
        Gender.setHorizontalTextPosition(SwingConstants.LEFT);
        viewPanel.add(Gender);

        JLabel GenderValue = new JLabel();
        GenderValue.setBounds(150 + x,370,100+ ew,30);
        GenderValue.setFont(font);
        GenderValue.setForeground( new Color(51,153,255));
        viewPanel.add(GenderValue);

        JLabel Email = new JLabel("Email: ");
        Email.setBounds(600 + x,370,100,30);
        Email.setFont(font);
        Email.setHorizontalTextPosition(SwingConstants.LEFT);
        viewPanel.add(Email);

        JLabel EmailValue = new JLabel();
        EmailValue.setBounds(700 + x,370,100+ ew,30);
        EmailValue.setFont(font);
        EmailValue.setForeground( new Color(51,153,255));
        viewPanel.add(EmailValue);


        JLabel UserName = new JLabel("Password: ");
        UserName.setBounds(50 + x,420,100,30);
        UserName.setFont(font);
        UserName.setHorizontalTextPosition(SwingConstants.LEFT);
        viewPanel.add(UserName);

        JLabel UserNameValue = new JLabel();
        UserNameValue.setBounds(150 + x,420,100+ ew,30);
        UserNameValue.setFont(font);
        UserNameValue.setForeground( new Color(51,153,255));
        viewPanel.add(UserNameValue);

        JLabel type = new JLabel("Type: ");
        type.setBounds(600 + x,420,100,30);
        type.setFont(font);
        type.setHorizontalTextPosition(SwingConstants.LEFT);
        viewPanel.add(type);

        JLabel typeValue = new JLabel();
        typeValue.setBounds(700 + x,420,100+ ew,30);
        typeValue.setFont(font);
        typeValue.setForeground( new Color(51,153,255));
        viewPanel.add(typeValue);


        JLabel Address = new JLabel("Address: ");
        Address.setBounds(50 + x,470,100,30);
        Address.setFont(font);
        Address.setHorizontalTextPosition(SwingConstants.LEFT);
        viewPanel.add(Address);


        JLabel AddressValue = new JLabel();
        AddressValue.setBounds(150 + x,470,100+ ew,30);
        AddressValue.setFont(font);
        AddressValue.setForeground( new Color(51,153,255));
        viewPanel.add(AddressValue);


        JLabel balance = new JLabel("Balance: ");
        balance.setBounds(600 + x,470,100,30);
        balance.setFont(font);
        balance.setHorizontalTextPosition(SwingConstants.LEFT);
        viewPanel.add(balance);
        
    
        JLabel balanceValue = new JLabel();
        balanceValue.setBounds(700 + x,470,100+ ew,30);
        balanceValue.setFont(font);
        balanceValue.setForeground( new Color(51,153,255));
        viewPanel.add(balanceValue);


        viewGoBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);


        File file = new File("Accounts.txt");
        String[] data = new String[11];
        Scanner read;

        if( file.exists() )
        {
            read = new Scanner(file);
            read.useDelimiter("[,\n]");

            while( read.hasNext() )
            {
                data[0] = read.next();
                data[1] = read.next();
                data[2] = read.next();
                data[3] = read.next();
                data[4] = read.next();
                data[5] = read.next();
                data[6] = read.next();
                data[7] = read.next();
                data[8] = read.next();
                data[9] = read.next();
                data[10] = read.next();

                if( data[0].equals(CustomerInterface.accno) )
                {
                    read.close();
                    break;
                }
            }
        }

        // Reading data from file and storing it in label component
        NameValue.setText(data[1]);
        PhoneValue.setText(data[2]);
        NicValue.setText(data[3]);
        AgeValue.setText(data[4]);
        GenderValue.setText(data[5]);
        EmailValue.setText(data[6]);
        UserNameValue.setText(data[7]);
        typeValue.setText(data[8]);
        AddressValue.setText(data[9]);
        balanceValue.setText(data[10]);

        viewGoBack.setIcon( new ImageIcon(newImg) );
        viewGoBack.setBounds(10,10,30,25);
        viewGoBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        viewGoBack.setToolTipText("Go back");
        viewGoBack.addActionListener(this);
        viewFrame.add(viewGoBack);

        viewPanel.setBackground(Color.white);
        viewPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,false));
        viewFrame.add(viewPanel);
        viewFrame.setExtendedState(MAXIMIZED_BOTH);
        viewFrame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if( viewAccount.equals(source) )
        {
            this.dispose();
            try {
                view();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }

        if (depositAmount.equals(source)) {
            this.dispose();
            deposit();
        } else if (withDrawAmount.equals(source)) {
            this.dispose();
            withDraw();
        } else if (transferAmount.equals(source)) {
            this.dispose();
            transfer();
        } else if (payBills.equals(source)) {
            this.dispose();
            bills();
        } else if (Loans.equals(source)) {
            this.dispose();
            loans();
        }

        // deposits the amount in customer's account
        if( e.getSource() == depositButton )
        {
            if( !(depositField.getText().isEmpty()) &&  !(depositField.getText().equals("Enter amount to deposit"))) {

                System.out.println(CustomerInterface.accno);
                System.out.println(CustomerInterface.name);
                System.out.println(CustomerInterface.balance);
                String[] data = new String[11];
                double b;
                Scanner read = null;
                BufferedWriter bw = null;
                PrintWriter writer = null;
                File oldFile = null;
                File tempFile = null;
                String typeOfAccount;

               if( CustomerInterface.type.equals("Savings Account"))
               {
                   SavingsAccount.setType();
                   typeOfAccount = SavingsAccount.getType();
               }
               else
               {
                   CurrentAccount.setType();
                   typeOfAccount = CurrentAccount.getType();
               }

                try {
                    oldFile = new File("Accounts.txt");
                    tempFile = new File("Temp.txt");
                    FileWriter fw = new FileWriter(tempFile, true);
                    bw = new BufferedWriter(fw);
                    bw.flush();
                    writer = new PrintWriter(bw);
                    if (oldFile.exists()) {
                        read = new Scanner(oldFile);
                        read.useDelimiter("[,\n]");
                        int acc = Integer.parseInt(CustomerInterface.accno);
                        while (read.hasNext()) {
                            data[0] = (read.hasNext() ? read.next() : null);
                            data[1] = (read.hasNext() ? read.next() : null);
                            data[2] = (read.hasNext() ? read.next() : null);
                            data[3] = (read.hasNext() ? read.next() : null);
                            data[4] = (read.hasNext() ? read.next() : null);
                            data[5] = (read.hasNext() ? read.next() : null);
                            data[6] = (read.hasNext() ? read.next() : null);
                            data[7] = (read.hasNext() ? read.next() : null);
                            data[8] = (read.hasNext() ? read.next() : null);
                            data[9] = (read.hasNext() ? read.next() : null);
                            data[10] = (read.hasNext() ? read.next() : null);

                            if (!(Integer.parseInt(data[0]) == acc)) {
                                writer.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6]
                                        + "," + data[7] + "," + data[8] + "," + data[9] + "," + data[10]);
                            } else {
                                System.out.println("Deposit");
                                System.out.println(depositField.getText());
                                assert data[10] != null;
                                b = Double.parseDouble(data[10]);
                                b += Double.parseDouble(depositField.getText());
                                String c = String.valueOf(b);
                                writer.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6]
                                        + "," + data[7] + "," + data[8] + "," + data[9] + "," + c);
                                JOptionPane.showMessageDialog(null, "Deposited Successfully", "Deposited", JOptionPane.INFORMATION_MESSAGE);

                                if (isValid(CustomerInterface.signedInemail) && testInternetConnection() ) {
                                    //sendEmail(depositField.getText() + "Rs has been deposited in your " + typeOfAccount, "Amount Deposited", CustomerInterface.signedInemail, "SkyBank98432@gmail.com");
                                } else {
                                    System.out.println("Invalid email");
                                }

                            }
                        }
                        read.close();
                      bw.flush();
                        writer.flush();
                        writer.close();

                        oldFile.delete();
                        tempFile.renameTo(new File("Accounts.txt"));


                        // writing transaction to transactions.txt file

                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();

                        Transaction t = new Other(getAlphaNumericString(), CustomerInterface.accno, CustomerInterface.name, dtf.format(now), Temp.getText(), "Deposit");
                        t.setPurpose();
                        t.transactionToFile();
                        depositFrame.dispose();
                        new CustomerInterface();
                    }
                } catch (IOException | NumberFormatException ex) {
                    ex.printStackTrace();
                } //catch (MessagingException ex) {
                    //System.out.println("No Internet Connection");
                //}
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Enter amount to deposit","Empty Field",JOptionPane.ERROR_MESSAGE);
            }
        }
        // withdraw amount from customer's account
        if( e.getSource() == withDrawButton ) {
            if (!withDrawField.getText().isEmpty() && !withDrawField.getText().equals("Enter amount to WithDraw")) {

                withDrawCash();
                if (answer) {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();

                    Transaction t = new Other(getAlphaNumericString(), CustomerInterface.accno, CustomerInterface.name, dtf.format(now), Temp.getText(), "Withdraw");
                    t.setPurpose();
                    t.transactionToFile();
                }
                answer = false;
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Enter amount to withDraw","Invalid text",JOptionPane.ERROR_MESSAGE);
            }
        }

        if( e.getSource() == depositGoBack )
        {
            depositFrame.dispose();
            this.setVisible(true);
        }

        if( e.getSource() == withDrawGoBack )
        {
            withDrawFrame.dispose();
            this.setVisible(true);
        }
        if( e.getSource() == goBack )
        {
            this.dispose();
            new MainMenu();
        }

        if( e.getSource() == transferGoBack )
        {

            transferFrame.dispose();
            this.setVisible(true);
        }

        if( e.getSource() == billsGoBack )
        {
            billsFrame.dispose();
            this.setVisible(true);
        }

        if( e.getSource() == electricityBill )
        {
            billsFrame.dispose();
            try {
                ElectricityBillFrame();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource() == electricityGoBack)
        {
            electricityFrame.dispose();
            billsFrame.setVisible(true);
        }

        if( e.getSource() == viewGoBack )
        {
            viewFrame.dispose();
            this.setVisible(true);
        }

        if( e.getSource() == gasBill )
        {
            billsFrame.dispose();
            try {
                GasBillFrame();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource() == gasGoBack)
        {
            gasFrame.dispose();
            billsFrame.setVisible(true);
        }

        if( e.getSource() == loansTypesGoBack )
        {
            if( LoanType == 1 )
            {
                carLoanFrame.dispose();
                loansFrame.setVisible(true);
            }
            else
            {
                homeLoanFrame.dispose();
                loansFrame.setVisible(true);
            }
        }

        if( e.getSource() == waterBill )
        {
            billsFrame.dispose();
            try {
                WaterBillFrame();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource() == waterGoBack)
        {
            waterFrame.dispose();
            billsFrame.setVisible(true);
        }

        if( e.getSource() == loansGoBack )
        {
            loansFrame.dispose();
            this.setVisible(true);
        }

        if( e.getSource() == carLoanButton )
        {
            loansFrame.dispose();
            try {
                CarLoanFrame(); // function that displays carLoan Frame
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }

        if( e.getSource() == homeLoanButton )
        {
            loansFrame.dispose();
            try {
                HomeLoanFrame();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }

        if( e.getSource() == pay ) {

            Transaction t = null;

            if (BillType == 1) {

                withDrawCash();
                if (answer) {
                    t = new ElectricityBill();
                    try {
                        payBill(BillType);
                    } catch (IOException ex) {
                        ex.printStackTrace();

                    }
                    answer = false;
                }
            }

            if( BillType == 2 ) {

                    withDrawCash();
                    if (answer) {
                        t = new GasBill();
                        try {
                            payBill(BillType);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        answer = false;
                    }
                }

            if( BillType == 3 ) {
                withDrawCash();
                if (answer) {
                    t = new WaterBill();
                    try {
                        payBill(BillType);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    answer = false;
                }
            }

                if (t instanceof ElectricityBill) {

                    t.setId(getAlphaNumericString());
                    t.setAccNo(CustomerInterface.accno);
                    t.setName(CustomerInterface.name);
                    t.setAmount(Temp.getText());
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    t.setTimeOfTransaction(dtf.format(now));
                    t.setPurpose();
                    t.setTransactionType();
                    t.transactionToFile();
                }

                if (t instanceof GasBill) {
                    t.setId(getAlphaNumericString());
                    t.setAccNo(CustomerInterface.accno);
                    t.setName(CustomerInterface.name);
                    t.setAmount(Temp.getText());
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    t.setTimeOfTransaction(dtf.format(now));
                    t.setPurpose();
                    t.setTransactionType();
                    t.transactionToFile();

                }


                if (t instanceof WaterBill) {
                    t.setId(getAlphaNumericString());
                    t.setAccNo(CustomerInterface.accno);
                    t.setName(CustomerInterface.name);
                    t.setAmount(Temp.getText());
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    t.setTimeOfTransaction(dtf.format(now));
                    t.setPurpose();
                    t.setTransactionType();
                    t.transactionToFile();

                }
        }

        if( e.getSource() == lend ) {
            boolean canLend = true;
            if (LoanType == 1) {
                if (principalField.getText().isEmpty() || noOfYearsField.getText().isEmpty() || makeField.getText().isEmpty()
                        || modelField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill all fields", "Incomplete Form", JOptionPane.WARNING_MESSAGE);
                    canLend = false;
                } else {
                    canLend = true;
                }
            } else if (LoanType == 2) {
                if (principalField.getText().isEmpty() || noOfYearsField.getText().isEmpty() || cityField.getText().isEmpty()
                        || addressField.getText().isEmpty() || nameOfOwnerField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill all fields", "Incomplete Form", JOptionPane.WARNING_MESSAGE);
                    canLend = false;
                } else {
                    canLend = true;
                }
            }

            if (canLend) {

                String[] data = new String[3];

                File oldFile = new File("LoansStatus.txt");
                File tempFile = new File("Temp3.txt");
                FileWriter fw = null;
                try {
                    fw = new FileWriter(tempFile, true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                BufferedWriter bw = new BufferedWriter(fw);
                try {
                    bw.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                PrintWriter writer = new PrintWriter(bw);
                Scanner read = null;

                if (oldFile.exists()) {
                    try {
                        read = new Scanner(oldFile);
                        read.useDelimiter("[,\n]");
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }


                    while (read.hasNext()) {
                        data[0] = read.next();
                        data[1] = read.next();
                        data[2] = read.next();
                        if (!(data[0].equals(CustomerInterface.accno))) {
                            writer.println(data[0] + "," + data[1] + ",");
                        } else {
                            ImageIcon icon = new ImageIcon("images/successIcon.png");
                            data[1] = "Debt";
                            img = (icon.getImage());
                            newImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                            icon = new ImageIcon(newImg);
                            writer.println(data[0] + "," + data[1] + ",");
                            JOptionPane.showMessageDialog(null, "lent money Successfully", "Lent", JOptionPane.INFORMATION_MESSAGE, icon);
                        }
                    }
                    read.close();
                    writer.flush();
                    writer.close();

                    oldFile.delete();
                    tempFile.renameTo(new File("LoansStatus.txt"));
                }
                if (LoanType == 1) {
                    carLoanFrame.dispose();
                } else {
                    homeLoanFrame.dispose();
                }
                new CustomerInterface();
            }
        }

        if( e.getSource() == transferButton )
        {
            transferMoney();
        }
    }
    //Function that generates randoms ID's for transactions
    String getAlphaNumericString()
    {

        // chose a Character random from this String
        String AlphaNumericString = "0123456789";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(10);

        for (int i = 0; i < 10; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    // Function that withdraws cash
    void withDrawCash() {
        boolean canPay = true;
        System.out.println(CustomerInterface.accno);
        System.out.println(CustomerInterface.name);
        System.out.println(CustomerInterface.balance);

        if (BillType == 1 || BillType == 2 || BillType == 3) {
            if (!Temp.getText().isEmpty() && !Temp.getText().equals("Enter amount to pay")) {
                canPay = true;
            } else {
                JOptionPane.showMessageDialog(null, "Enter valid amount", "Invalid amount", JOptionPane.WARNING_MESSAGE);
                canPay = false;
            }
        }

        if (canPay) {
            String[] data = new String[11];
            try {
                File oldFile = new File("Accounts.txt");
                File tempFile = new File("Temp.txt");
                FileWriter fw = new FileWriter(tempFile, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.flush();
                PrintWriter writer = new PrintWriter(bw);
                Scanner read;
                if (oldFile.exists()) {
                    read = new Scanner(oldFile);
                    read.useDelimiter("[,\n]");
                    int acc = Integer.parseInt(CustomerInterface.accno);
                    while (read.hasNext()) {

                        data[0] = read.next();
                        data[1] = (read.hasNext() ? read.next() : null);
                        data[2] = (read.hasNext() ? read.next() : null);
                        data[3] = (read.hasNext() ? read.next() : null);
                        data[4] = (read.hasNext() ? read.next() : null);
                        data[5] = (read.hasNext() ? read.next() : null);
                        data[6] = (read.hasNext() ? read.next() : null);
                        data[7] = (read.hasNext() ? read.next() : null);
                        data[8] = (read.hasNext() ? read.next() : null);
                        data[9] = (read.hasNext() ? read.next() : null);
                        data[10] = (read.hasNext() ? read.next() : "0.0");

                        if (!(Integer.parseInt(data[0]) == acc)) {
                            writer.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6]
                                    + "," + data[7] + "," + data[8] + "," + data[9] + "," + data[10]);
                        } else {
                            double b = Double.parseDouble(data[10]);
                            double b1 = Double.parseDouble(Temp.getText());
                            try {
                                if (b1 <= b) {
                                    b -= b1;
                                    answer = true;
                                    System.out.println("b = " + b);
                                    if (b != 0.0)
                                        writer.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6]
                                                + "," + data[7] + "," + data[8] + "," + data[9] + "," + String.valueOf(b));
                                    else
                                        writer.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6]
                                                + "," + data[7] + "," + data[8] + "," + data[9] + "," + "0.0");


                                    if( isValid(CustomerInterface.signedInemail ) && testInternetConnection() )
                                    {
                                        //sendEmail(Temp.getText() + "Rs has been withdrawn from your account", "Amount Withdrawn",CustomerInterface.signedInemail,"SkyBank98432@gmail.com");
                                    }
                                    else {
                                        System.out.println("Invalid Email");
                                    }
                                    JOptionPane.showMessageDialog(null, "Withdrawn Successfully", "Withdrawn", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    writer.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6]
                                            + "," + data[7] + "," + data[8] + "," + data[9] + "," + String.valueOf(b));
                                    throw new ArithmeticException();
                                }
                            } catch (ArithmeticException e) {
                                JOptionPane.showMessageDialog(null, "Withdrawal amount exceeded the balance", "Insufficient Balance", JOptionPane.ERROR_MESSAGE);
                            } //catch (MessagingException e) {
                                //e.printStackTrace();
                            //}
                        }
                    }
                    read.close();
                    bw.flush();
                    writer.flush();
                    writer.close();

                    oldFile.delete();
                    tempFile.renameTo(new File("Accounts.txt"));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // function that model and display withDraw window
    void withDraw()
    {
        JLabel label = new JLabel();
        JLabel amountLabel = new JLabel("Amount"); // used near text field
        withDrawButton = new JButton("WithDraw");


        withDrawFrame = new JFrame("WithDraw Amount");

        withDrawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        withDrawFrame.setSize(1300,700);
        withDrawFrame.setLayout(null);
        withDrawFrame.getContentPane().setBackground(Color.white);

        label.setBounds(290,40,250,220);
        Image img = (new ImageIcon("images/loginAccountImage.png")).getImage();
        Image newImg = img.getScaledInstance(250,280, Image.SCALE_SMOOTH);
        ImageIcon accIcon = new ImageIcon( newImg );


        label.setIcon(accIcon);
        label.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,false));


        withDrawPanel = new JPanel();
        withDrawPanel.setLayout(null);
        withDrawPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,true));
        withDrawPanel.setBounds(230,70,900,550);
        withDrawPanel.setBackground(Color.white);

        withDrawField = new JTextField("Enter amount to WithDraw");
        withDrawField.setFont(font);
        withDrawField.setBorder(BorderFactory.createLineBorder(Color.black,1,true));
        withDrawField.setBounds(267,290,300,40);
        withDrawField.addFocusListener(this);
        withDrawField.addKeyListener(this);

        amountLabel.setBounds(167,295,100,40);
        amountLabel.setFont(font);
        withDrawPanel.add(amountLabel);

        withDrawButton.setBounds(335,370,170,40);
        withDrawButton.setBackground(Color.white);
        withDrawButton.addActionListener(this);
        withDrawPanel.add(withDrawButton);
        withDrawPanel.add(withDrawField);
        withDrawPanel.add(label);
        Temp = withDrawField;

        // Go back button
        withDrawGoBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);

        withDrawGoBack.setIcon( new ImageIcon(newImg) );
        withDrawGoBack.setBounds(10,10,30,25);
        withDrawGoBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        withDrawGoBack.setToolTipText("Go back");
        withDrawGoBack.addActionListener(this);
        withDrawFrame.add(withDrawGoBack);


        withDrawFrame.add(withDrawPanel);
        withDrawFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        withDrawFrame.setVisible(true);
        
    }

    // Function that model and display transfer window
    void transfer()
    {
        JLabel label = new JLabel();
        JLabel amountLabel = new JLabel("Amount"); // used near text field
        JLabel accountNoLabel = new JLabel("Account #");
        transferButton = new JButton("Transfer");


        transferFrame = new JFrame("transfer Amount");

        transferFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        transferFrame.setSize(1300,700);
        transferFrame.setLayout(null);
        transferFrame.getContentPane().setBackground(Color.white);

        label.setBounds(290,40,250,220);
        Image img = (new ImageIcon("images/loginAccountImage.png")).getImage();
        Image newImg = img.getScaledInstance(250,280, Image.SCALE_SMOOTH);
        ImageIcon accIcon = new ImageIcon( newImg );


        label.setIcon(accIcon);
        label.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,false));


        transferPanel = new JPanel();
        transferPanel.setLayout(null);
        transferPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,true));
        transferPanel.setBounds(230,70,900,550);
        transferPanel.setBackground(Color.white);

        transferAmountField = new JTextField("Enter amount to transfer");
        transferAmountField.setFont( new Font("Arial",Font.PLAIN,15));
        transferAmountField.setBorder(BorderFactory.createLineBorder(Color.black,1,true));
        transferAmountField.setBounds(267,350,300,40);
        transferAmountField.addFocusListener(this);
        transferAmountField.addKeyListener(this);


        transferAccountNoField = new JTextField("Enter account # to transfer money");
        transferAccountNoField.setFont( new Font("Arial",Font.PLAIN,15));
        transferAccountNoField.setBorder(BorderFactory.createLineBorder(Color.black,1,true));
        transferAccountNoField.setBounds(267,290,300,40);
        transferAccountNoField.addFocusListener(this);
        transferAccountNoField.addKeyListener(this);
        
        

        accountNoLabel.setBounds(167,295,100,40);
        accountNoLabel.setFont(font);
        transferPanel.add(accountNoLabel);
        
        amountLabel.setBounds(167,355,100,40);
        amountLabel.setFont(font);
        transferPanel.add(amountLabel);
        transferPanel.add(accountNoLabel);
        transferButton.setBounds(335,445,170,40);
        transferButton.setBackground(Color.white);
        transferButton.addActionListener(this);

        transferPanel.add(transferButton);
        transferPanel.add(transferAccountNoField);
        transferPanel.add(transferAmountField);
        transferPanel.add(label);

        // Go back button
        transferGoBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);

        transferGoBack.setIcon( new ImageIcon(newImg) );
        transferGoBack.setBounds(10,10,30,25);
        transferGoBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        transferGoBack.setToolTipText("Go back");
        transferGoBack.addActionListener(this);
        transferFrame.add(transferGoBack);

        transferFrame.add(transferPanel);
        transferFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        transferFrame.setVisible(true);
    }

    // Function that transfers money from one account to other
    void transferMoney() {

    String recipentName = null;
    String recipentEmail = null;
    boolean found2 = false; // will check whether account is found or not
    boolean found = false; // will check whether amount is withdrawn from the account
    if ((transferAccountNoField.getText().isEmpty() || transferAmountField.getText().isEmpty()) ||
            (transferAmountField.getText().equals("Enter amount to transfer") || transferAccountNoField.getText().equals("Enter account # to transfer money"))) {
        JOptionPane.showMessageDialog(null, "Fill all fields", "Incomplete", JOptionPane.WARNING_MESSAGE);
    }
    else {

        System.out.println(CustomerInterface.accno);
        System.out.println(CustomerInterface.name);
        System.out.println(CustomerInterface.balance);
        String[] data = new String[11];
        try {
            File oldFile = new File("Accounts.txt");
            Scanner read;
            if (oldFile.exists()) {
                read = new Scanner(oldFile);
                read.useDelimiter("[,\n]");
                int acc;
                while (read.hasNext()) {

                    data[0] = read.next();
                    data[1] = (read.hasNext() ? read.next() : null);
                    data[2] = (read.hasNext() ? read.next() : null);
                    data[3] = (read.hasNext() ? read.next() : null);
                    data[4] = (read.hasNext() ? read.next() : null);
                    data[5] = (read.hasNext() ? read.next() : null);
                    data[6] = (read.hasNext() ? read.next() : null);
                    data[7] = (read.hasNext() ? read.next() : null);
                    data[8] = (read.hasNext() ? read.next() : null);
                    data[9] = (read.hasNext() ? read.next() : null);
                    data[10] = (read.hasNext() ? read.next() : null);

                    if (data[0].equals(transferAccountNoField.getText()) && (!data[0].equals(CustomerInterface.accno))) {
                        found2 = true;
                        recipentName = data[1];
                        recipentEmail = data[6];
                        read.close();
                        System.out.println("Account Found");
                        break;
                    }
                }
                if (!found2) {
                    read.close();
                    JOptionPane.showMessageDialog(null, "Account not Found", "Not Found", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (found2) {

            try {
                File oldFile = new File("Accounts.txt");
                File tempFile = new File("Temp.txt");
                FileWriter fw = new FileWriter(tempFile, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.flush();
                PrintWriter writer = new PrintWriter(bw);
                Scanner read;

                if (oldFile.exists()) {
                    read = new Scanner(oldFile);
                    read.useDelimiter("[,\n]");
                    int acc = Integer.parseInt(CustomerInterface.accno);
                    System.out.println("Current acc: " + acc);

                    while (read.hasNext()) {

                        data[0] = read.next();
                        data[1] = (read.hasNext() ? read.next() : null);
                        data[2] = (read.hasNext() ? read.next() : null);
                        data[3] = (read.hasNext() ? read.next() : null);
                        data[4] = (read.hasNext() ? read.next() : null);
                        data[5] = (read.hasNext() ? read.next() : null);
                        data[6] = (read.hasNext() ? read.next() : null);
                        data[7] = (read.hasNext() ? read.next() : null);
                        data[8] = (read.hasNext() ? read.next() : null);
                        data[9] = (read.hasNext() ? read.next() : null);
                        data[10] = (read.hasNext() ? read.next() : "0.0");

                        if (!(Integer.parseInt(data[0]) == acc)) {
                            writer.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8] + "," + data[9] + "," + data[10]);
                        }
                        else {
                            double b = Double.parseDouble(data[10]);
                            double b1 = Double.parseDouble(transferAmountField.getText());
                            try {
                                if ( b1 <= b) {
                                    found = true;
                                    b = b - b1;
                                    if( b != 0.0)
                                        writer.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8] + "," + data[9] + "," + b);
                                    else
                                        writer.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8] + "," + data[9] + "," + "0.0");

                                    JOptionPane.showMessageDialog(null, "Withdrawn Successfully", "Withdrawn", JOptionPane.INFORMATION_MESSAGE);

                                    if( isValid(CustomerInterface.signedInemail ) && testInternetConnection() )
                                    {
                                        //sendEmail(transferAmountField.getText() + "Rs has been withdrawn from your account", "Amount Withdrawn",CustomerInterface.signedInemail,"SkyBank98432@gmail.com");
                                    }
                                    else {
                                        System.out.println("Invalid Email");
                                    }

                                    System.out.println(transferAmountField.getText());

                                } else {
                                    writer.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8] + "," + data[9] + "," + b);
                                    throw new ArithmeticException();
                                }
                            } catch (ArithmeticException e) {
                                JOptionPane.showMessageDialog(null, "Withdrawal amount exceeded the balance", "Insufficient Balance", JOptionPane.ERROR_MESSAGE);
                            }// catch (MessagingException e) {
                               // e.printStackTrace();
                            //}
                        }
                    }

                    read.close();
                    bw.flush();
                    writer.flush();
                    writer.close();
                    oldFile.delete();
                    tempFile.renameTo(new File("Accounts.txt"));

                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if (found) {
            double b;
            try {
                File oldFile = new File("Accounts.txt");
                File tempFile = new File("Temp.txt");
                FileWriter fw = new FileWriter(tempFile, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.flush();
                PrintWriter writer = new PrintWriter(bw);
                Scanner read;
                if (oldFile.exists()) {
                    read = new Scanner(oldFile);
                    read.useDelimiter("[,\n]");
                    int acc = Integer.parseInt(transferAccountNoField.getText());
                    while (read.hasNext()) {
                        data[0] = read.next();
                        data[1] = (read.hasNext() ? read.next() : null);
                        data[2] = (read.hasNext() ? read.next() : null);
                        data[3] = (read.hasNext() ? read.next() : null);
                        data[4] = (read.hasNext() ? read.next() : null);
                        data[5] = (read.hasNext() ? read.next() : null);
                        data[6] = (read.hasNext() ? read.next() : null);
                        data[7] = (read.hasNext() ? read.next() : null);
                        data[8] = (read.hasNext() ? read.next() : null);
                        data[9] = (read.hasNext() ? read.next() : null);
                        data[10] = (read.hasNext() ? read.next() : "0.0");

                        if (!(Integer.parseInt(data[0]) == acc)) {
                            writer.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8] + "," + data[9] + "," + data[10]);
                        } else {
                            System.out.println("Transfer");
                            System.out.println(transferAmountField.getText());
                            b = Double.parseDouble(data[10]);
                            b += (Double.parseDouble(transferAmountField.getText()));
                            writer.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6]
                                    + "," + data[7] + "," + data[8] + "," + data[9] + "," + String.valueOf(b));
                            JOptionPane.showMessageDialog(null, "Transferred Successfully", "Transferred", JOptionPane.INFORMATION_MESSAGE);
                            Temp = transferAmountField;

                            if( isValid(recipentEmail) && testInternetConnection()) {
                                //sendEmail(transferAmountField.getText() + "Rs has been deposited in your account", "Amount Deposited",recipentEmail,"SkyBank98432@gmail.com");
                            }
                            else
                            {
                                System.out.println("Invalid email");
                            }
                        }
                    }

                    read.close();
                    bw.flush();
                    writer.flush();
                    writer.close();

                    oldFile.delete();
                    tempFile.renameTo(new File("Accounts.txt"));

                    transferFrame.dispose();
                    new CustomerInterface();
                }
                // JOptionPane.showMessageDialog(null,"Account Deleted Successfully","Deleted Account",JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (found && found2) {

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            Transaction t = new Other(getAlphaNumericString(),CustomerInterface.accno,CustomerInterface.name,dtf.format(now),Temp.getText(),"Withdraw");
            t.setPurpose();
            try {
                FileWriter fw = new FileWriter("Transactions.txt",true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.flush();
                PrintWriter writer = new PrintWriter(bw);
                writer.println(t.getId() + "," + t.getAccNo() + "," + t.getName() + "," + t.getAmount() + "," + t.getTimeOfTransaction() + "," + t.getTransactionType()
                        + "," + t.getPurpose());
                writer.flush();
                writer.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }


             dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
             now = LocalDateTime.now();

             t = new Other(getAlphaNumericString(), transferAccountNoField.getText(), recipentName, dtf.format(now), Temp.getText(), "Deposit");
            t.setPurpose();
            try {
                FileWriter fw = new FileWriter("Transactions.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.flush();
                PrintWriter writer = new PrintWriter(bw);
                writer.println(t.getId() + "," + t.getAccNo() + "," + t.getName() + "," + t.getAmount() + "," + t.getTimeOfTransaction() + "," + t.getTransactionType()
                        + "," + t.getPurpose());
                writer.flush();
                writer.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

    // used to display bills menu
    void bills()
    {
        billsFrame = new JFrame("Bills");
        billsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        billsFrame.setSize(1300,700);
        billsFrame.setLayout(null);
        billsFrame.getContentPane().setBackground(Color.white);


        JLabel electricityBillLabel = new JLabel("Electricity Bill"); // used near text field
        electricityBillLabel.setBounds(190,420,200,40);
        electricityBillLabel.setFont(font);
        billsFrame.add(electricityBillLabel);

        JLabel gasBillLabel = new JLabel("Gas Bill"); // used near text field
        gasBillLabel.setBounds(605,420,100,40);
        gasBillLabel.setFont(font);
        gasBillLabel.setHorizontalTextPosition(JLabel.CENTER);
        billsFrame.add(gasBillLabel);

        JLabel waterBillLabel = new JLabel("Water Bill"); // used near text field
        waterBillLabel.setBounds(1005,420,100,40);
        waterBillLabel.setFont(font);
        waterBillLabel.setHorizontalTextPosition(JLabel.CENTER);
        billsFrame.add(waterBillLabel);

        electricityBill = new JButton();
        electricityBill.setBounds(150,250,200,150);
        img = ( new ImageIcon("images/electricityBill.png")).getImage();
        electricityBill.setBackground(Color.white);
        newImg = img.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        electricityBill.setIcon( new ImageIcon(newImg));
        electricityBill.addActionListener(this);
        electricityBill.setBackground(Color.white);
        billsFrame.add(electricityBill);

        gasBill = new JButton();
        gasBill.setBounds(550,250,200,150);
        img = ( new ImageIcon("images/gasBill.png")).getImage();
        gasBill.setBackground(Color.white);
        newImg = img.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        gasBill.setIcon( new ImageIcon(newImg));
        gasBill.addActionListener(this);
        gasBill.setBackground(Color.white);
        billsFrame.add(gasBill);

        waterBill = new JButton();
        waterBill.setBounds(950,250,200,150);
        img = ( new ImageIcon("images/waterBill.png")).getImage();
        waterBill.setBackground(Color.white);
        newImg = img.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        waterBill.setIcon( new ImageIcon(newImg));
        waterBill.addActionListener(this);
        waterBill.setBackground(Color.white);
        billsFrame.add(waterBill);

        // Go Back
        billsGoBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);

        billsGoBack.setIcon( new ImageIcon(newImg) );
        billsGoBack.setBounds(10,10,30,25);
        billsGoBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        billsGoBack.setToolTipText("Go back");
        billsGoBack.addActionListener(this);
        billsFrame.add(billsGoBack);

        billsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        billsFrame.setVisible(true);
    }

    // used to display loans menu
    void loans()
    {
        loansFrame = new JFrame("Loans");
        loansFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loansFrame.setLayout(null);
        loansFrame.setSize(1300,700);
        loansFrame.getContentPane().setBackground(Color.white);

        carLoanLabel = new JLabel("Car Loan");
        carLoanLabel.setBounds(300,420,120,30);
        carLoanLabel.setFont(font);
        loansFrame.add(carLoanLabel);

        carLoanButton = new JButton();
        carLoanButton.setBounds(250,200,200,200);
        img = ( new ImageIcon("images/carLoan.png")).getImage();
        carLoanButton.setBackground(Color.white);
        newImg = img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        carLoanButton.setIcon( new ImageIcon(newImg));
        carLoanButton.addActionListener(this);
        carLoanButton.setBackground(Color.white);
        loansFrame.add(carLoanButton);

        homeLoanLabel = new JLabel("Home Loan");
        homeLoanLabel.setBounds(850,420,120,30);
        homeLoanLabel.setFont(font);
        loansFrame.add(homeLoanLabel);

        homeLoanButton = new JButton();
        homeLoanButton.setBounds(800,200,200,200);
        img = ( new ImageIcon("images/homeLoan.png")).getImage();
        homeLoanButton.setBackground(Color.white);
        newImg = img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        homeLoanButton.setIcon( new ImageIcon(newImg));
        homeLoanButton.addActionListener(this);
        homeLoanButton.setBackground(Color.white);
        loansFrame.add(homeLoanButton);

        loansGoBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);

        loansGoBack.setIcon( new ImageIcon(newImg) );
        loansGoBack.setBounds(10,10,30,25);
        loansGoBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        loansGoBack.setToolTipText("Go back");
        loansGoBack.addActionListener(this);
        loansFrame.add(loansGoBack);

        loansFrame.setExtendedState(MAXIMIZED_BOTH);
        loansFrame.setVisible(true);
    }


    void HomeLoanFrame() throws FileNotFoundException {
        homeLoanFrame = new JFrame("Home Loan");
        JLabel label = new JLabel();
        LoanType = 2;

        lend = new JButton("Lend");

        homeLoanFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeLoanFrame.setSize(1300,700);
        homeLoanFrame.setLayout(null);
        homeLoanFrame.getContentPane().setBackground(Color.white);

        label.setBounds(400,30,250,200);
        Image img = (new ImageIcon("images/loginAccountImage.png")).getImage();
        Image newImg = img.getScaledInstance(250,230, Image.SCALE_SMOOTH);
        ImageIcon accIcon = new ImageIcon( newImg );

        label.setIcon(accIcon);
        label.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,false));

        JPanel homePanel = new JPanel();
        homePanel.setLayout(null);
        homePanel.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,true));
        homePanel.setBounds(150,70,1100,550);
        homePanel.setBackground(Color.white);

        principalLabel = new JLabel("Principal"); // used near text field
        principalLabel.setBounds(50,270,100,40);
        principalLabel.setFont(font);
        homePanel.add(principalLabel);

        principalField = new JTextField();
        principalField.setFont(font);
        principalField.setBorder(BorderFactory.createLineBorder(Color.black,1,true));
        principalField.setBounds(150,270,300,40);
        principalField.addKeyListener(this);
        principalField.addFocusListener(this);
        homePanel.add(principalField);

        rateOfInterestLabel = new JLabel("Rate Of Interest"); // used near text field
        rateOfInterestLabel.setBounds(550,270,100,40);
        rateOfInterestLabel.setFont(new Font("Arial",Font.BOLD,13));
        homePanel.add(rateOfInterestLabel);

        Loan.setRateOfInterest(5);
        rateOfInterestField = new JTextField(Loan.getRateOfInterest() + "%");
        rateOfInterestField.setFont(font);
        rateOfInterestField.setBorder(BorderFactory.createLineBorder(Color.black,1,true));
        rateOfInterestField.setBounds(700,270,300,40);
        rateOfInterestField.setEditable(false);
        homePanel.add(rateOfInterestField);

        noOfYearsLabel = new JLabel("No Of Years"); // used near text field
        noOfYearsLabel.setBounds(50,335,100,40);
        noOfYearsLabel.setFont(new Font("Arial",Font.BOLD,15));
        homePanel.add(noOfYearsLabel);

        noOfYearsField = new JTextField();
        noOfYearsField.setFont(font);
        noOfYearsField.setBorder(BorderFactory.createLineBorder(Color.black,1,true));
        noOfYearsField.setBounds(150,330,300,40);
        noOfYearsField.addKeyListener(this);
        noOfYearsField.addFocusListener(this);
        homePanel.add(noOfYearsField);

        nameOfOwnerLabel = new JLabel("Name of owner"); // used near text field
        nameOfOwnerLabel.setBounds(550,335,100,40);
        nameOfOwnerLabel.setFont(new Font("Arial",Font.BOLD,13));
        homePanel.add(nameOfOwnerLabel);

        nameOfOwnerField = new JTextField();
        nameOfOwnerField.setFont(font);
        nameOfOwnerField.setBorder(BorderFactory.createLineBorder(Color.black,1,true));
        nameOfOwnerField.setBounds(700,330,300,40);
        nameOfOwnerField.addFocusListener(this);
        homePanel.add(nameOfOwnerField);

        cityLabel = new JLabel("City"); // used near text field
        cityLabel.setBounds(50,395,100,40);
        cityLabel.setFont(font);
        homePanel.add(cityLabel);

        cityField = new JTextField();
        cityField.setFont(font);
        cityField.setBorder(BorderFactory.createLineBorder(Color.black,1,true));
        cityField.setBounds(150,390,300,40);
        cityField.addFocusListener(this);
        homePanel.add(cityField);

        addressLabel = new JLabel("Address"); // used near text field
        addressLabel.setBounds(550,390,100,40);
        addressLabel.setFont(font);
        homePanel.add(addressLabel);

        addressField = new JTextArea();
        addressField.setFont(font);
        addressField.setBorder(BorderFactory.createLineBorder(Color.black,1,true));
        addressField.setBounds(700,390,300,70);
        addressField.addFocusListener(this);
        homePanel.add(addressField);

        lend.setBounds(455,470,170,40);
        lend.setBackground(Color.white);
        lend.addActionListener(this);
        homePanel.add(lend);
        homePanel.add(label);

        // Go back button
        loansTypesGoBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);
        loansTypesGoBack.setIcon( new ImageIcon(newImg) );
        loansTypesGoBack.setBounds(10,10,30,25);
        loansTypesGoBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        loansTypesGoBack.setToolTipText("Go back");
        loansTypesGoBack.addActionListener(this);
        homeLoanFrame.add(loansTypesGoBack );

        homeLoanFrame.add(homePanel);
        homeLoanFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homeLoanFrame.setVisible(true);
        checkLoanStatus();
    }
    
    void CarLoanFrame() throws FileNotFoundException {
        carLoanFrame = new JFrame("Car Loan");
        JLabel label = new JLabel();
        LoanType = 1;
       
        lend = new JButton("Lend");

        carLoanFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        carLoanFrame.setSize(1300,700);
        carLoanFrame.setLayout(null);
        carLoanFrame.getContentPane().setBackground(Color.white);

        label.setBounds(400,30,250,200);
        Image img = (new ImageIcon("images/loginAccountImage.png")).getImage();
        Image newImg = img.getScaledInstance(250,230, Image.SCALE_SMOOTH);
        ImageIcon accIcon = new ImageIcon( newImg );
        label.setIcon(accIcon);
        label.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,false));

        JPanel carPanel = new JPanel();
        carPanel.setLayout(null);
        carPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,true));
        carPanel.setBounds(150,70,1100,550);
        carPanel.setBackground(Color.white);

        principalLabel = new JLabel("Principal"); // used near text field
        principalLabel.setBounds(50,270,100,40);
        principalLabel.setFont(font);
        carPanel.add(principalLabel);

        principalField = new JTextField();
        principalField.setFont(font);
        principalField.setBorder(BorderFactory.createLineBorder(Color.black,1,true));
        principalField.setBounds(150,270,300,40);
        principalField.addKeyListener(this);
        principalField.addFocusListener(this);
        carPanel.add(principalField);

        rateOfInterestLabel = new JLabel("Rate Of Interest"); // used near text field
        rateOfInterestLabel.setBounds(550,270,100,40);
        rateOfInterestLabel.setFont(new Font("Arial",Font.BOLD,13));
        carPanel.add(rateOfInterestLabel);

        Loan.setRateOfInterest(5);
        rateOfInterestField = new JTextField(Loan.getRateOfInterest() + "%");
        rateOfInterestField.setFont(font);
        rateOfInterestField.setBorder(BorderFactory.createLineBorder(Color.black,1,true));
        rateOfInterestField.setBounds(700,270,300,40);
        rateOfInterestField.setEditable(false);
        carPanel.add(rateOfInterestField);
        
        noOfYearsLabel = new JLabel("No Of Years"); // used near text field
        noOfYearsLabel.setBounds(50,335,100,40);
        noOfYearsLabel.setFont(new Font("Arial",Font.BOLD,15));
        carPanel.add(noOfYearsLabel);
        
        noOfYearsField = new JTextField();
        noOfYearsField.setFont(font);
        noOfYearsField.setBorder(BorderFactory.createLineBorder(Color.black,1,true));
        noOfYearsField.setBounds(150,330,300,40);
        noOfYearsField.addKeyListener(this);
        noOfYearsField.addFocusListener(this);
        carPanel.add(noOfYearsField);

        makeLabel = new JLabel("Make"); // used near text field
        makeLabel.setBounds(550,335,100,40);
        makeLabel.setFont(font);
        carPanel.add(makeLabel);
        
        makeField = new JTextField();
        makeField.setFont(font);
        makeField.setBorder(BorderFactory.createLineBorder(Color.black,1,true));
        makeField.setBounds(700,330,300,40);
        makeField.addFocusListener(this);
        carPanel.add(makeField);

        modelLabel = new JLabel("Model"); // used near text field
        modelLabel.setBounds(50,395,100,40);
        modelLabel.setFont(font);
        carPanel.add(modelLabel);
        
        modelField = new JTextField();
        modelField.setFont(font);
        modelField.setBorder(BorderFactory.createLineBorder(Color.black,1,true));
        modelField.setBounds(150,390,300,40);
        modelField.addFocusListener(this);
        carPanel.add(modelField);
        
        lend.setBounds(455,470,170,40);
        lend.setBackground(Color.white);
        lend.addActionListener(this);
        carPanel.add(lend);
        carPanel.add(label);

        // Go back button
        loansTypesGoBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);

        loansTypesGoBack.setIcon( new ImageIcon(newImg) );
        loansTypesGoBack.setBounds(10,10,30,25);
        loansTypesGoBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        loansTypesGoBack.setToolTipText("Go back");
        loansTypesGoBack.addActionListener(this);
        carLoanFrame.add(loansTypesGoBack );

        carLoanFrame.add(carPanel);
        carLoanFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        carLoanFrame.setVisible(true);
        checkLoanStatus();
    }

    void checkLoanStatus() throws FileNotFoundException {

        File file = new File("LoansStatus.txt");
        Scanner read;
        String[] data = new String[3];

        if( file.exists() )
        {
            read = new Scanner(file);

            read.useDelimiter("[,\n]");

            while( read.hasNext() )
            {
                data[0] = read.next();
                data[1] = read.hasNext() ? read.next() : null;
                data[2] = read.hasNext() ? read.next() : null;

                if( data[0].equals(CustomerInterface.accno) && data[1].equals("Debt"))
                {
                    icon = new ImageIcon("images/successIcon.png");
                    img = ( icon.getImage());
                    newImg = img.getScaledInstance(30,30,Image.SCALE_SMOOTH);
                    icon = new ImageIcon(newImg);
                    JOptionPane.showMessageDialog(null,"Already taken","Taken",JOptionPane.INFORMATION_MESSAGE,icon);
                    read.close();
                    if( LoanType == 1 )
                    {
                        carLoanFrame.dispose();
                    }
                    else
                    {
                        homeLoanFrame.dispose();
                    }
                    this.setVisible(true);
                    break;
                }
            }
            read.close();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if( e.getSource() == depositField )
        {
            depositField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
            if( depositField.getText().equals("Enter amount to deposit"))
            {
                depositField.setText("");
            }
        }

        if( e.getSource() == withDrawField )
        {
            withDrawField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
            if( withDrawField.getText().equals("Enter amount to WithDraw"))
            {
                withDrawField.setText("");
            }
        }

        if( e.getSource() == transferAmountField )
        {
            transferAmountField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
            if( transferAmountField.getText().equals("Enter amount to transfer"))
            {
                transferAmountField.setText("");
            }
        }

        if( e.getSource() == transferAccountNoField )
        {
            transferAccountNoField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
            if( transferAccountNoField.getText().equals("Enter account # to transfer money"))
            {
                transferAccountNoField.setText("");
            }
        }

        if( e.getSource() == electricityField )
        {
            electricityField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
            if( electricityField.getText().equals("Enter amount to pay"))
            {
                electricityField.setText("");
            }
        }

        if( e.getSource() == waterField )
        {
            waterField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
            if( waterField.getText().equals("Enter amount to pay"))
            {
                waterField.setText("");
            }
        }


        if( e.getSource() == gasField )
        {
            gasField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
            if( gasField.getText().equals("Enter amount to pay"))
            {
                gasField.setText("");
            }
        }

        if( e.getSource() == principalField )
        {
            principalField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }
        if( e.getSource() == makeField )
        {
            makeField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }
        if( e.getSource() == noOfYearsField )
        {
            noOfYearsField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }
        if( e.getSource() == addressField )
        {
            addressField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }
        if( e.getSource() == nameOfOwnerField )
        {
            nameOfOwnerField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }
        if( e.getSource() == cityField )
        {
            cityField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }
        if( e.getSource() == modelField )
        {
            modelField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

        if( e.getSource() == depositField )
        {
            depositField.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
            if( depositField.getText().isEmpty())
            {
                depositField.setText("Enter amount to deposit");
            }
        }

        if( e.getSource() == withDrawField )
        {
            withDrawField.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
            if( withDrawField.getText().isEmpty() )
            {
                withDrawField.setText("Enter amount to WithDraw");
            }
        }

        if( e.getSource() == transferAmountField )
        {
            transferAmountField.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
            if( transferAmountField.getText().isEmpty() )
            {
                transferAmountField.setText("Enter amount to transfer");
            }
        }

        if( e.getSource() == principalField )
        {
            principalField.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
        }

        if( e.getSource() == addressField )
        {
            addressField.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
        }

        if( e.getSource() == nameOfOwnerField )
        {
            nameOfOwnerField.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
        }

        if( e.getSource() == cityField )
        {
            cityField.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
        }

        if( e.getSource() == noOfYearsField )
        {
            noOfYearsField.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
        }

        if( e.getSource() == makeField )
        {
            makeField.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
        }

        if( e.getSource() == modelField )
        {
            modelField.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
        }

        if( e.getSource() == transferAccountNoField )
        {
            transferAccountNoField.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
            if( transferAccountNoField.getText().isEmpty() )
            {
                transferAccountNoField.setText("Enter account # to transfer money");
            }
        }

        if( e.getSource() == electricityField )
        {
            electricityField.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
            if( electricityField.getText().isEmpty())
            {
                electricityField.setText("Enter amount to pay");
            }
        }

        if( e.getSource() == waterField )
        {
            waterField.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
            if( waterField.getText().isEmpty())
            {
                waterField.setText("Enter amount to pay");
            }
        }

        if( e.getSource() == gasField )
        {
            gasField.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
            if( gasField.getText().isEmpty())
            {
                gasField.setText("Enter amount to pay");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c;
        c = e.getKeyChar();
        if ((c < '0' || c > '9') && (c != KeyEvent.VK_BACK_SPACE)) {
            e.consume(); // it ignores the event
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +  //part before @
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;

        return pat.matcher(email).matches();
    }

    boolean testInternetConnection()
    {
        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            System.out.println("Internet is connected");
            return true;
        } catch (IOException e) {
            System.out.println("Internet is not connected");
            return false;
        }
    }


//    //private static void sendEmail(String message, String subject, String to, String from) throws MessagingException {
//
//        // variable for gmail host
//        String  host = "smtp.gmail.com";
//
//        //get system properties
//
//        Properties properties = System.getProperties();
//
//        // setting important information to properties
//
//        //host set
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", "465");
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.starttls.required", "false");
//        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
//        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//
//
////        Authenticator auth = new Authenticator() {
////            protected PasswordAuthentication getPasswordAuthentication()
////            {
////
////                return new PasswordAuthentication("SkyBank98432@gmail.com","Fast1234");
////
////            }
////
////        };
//
//        Session session =  Session.getInstance(properties,auth);
//
//        session.setDebug(true);
//
//        MimeMessage m = new MimeMessage(session);
//
//        m.setFrom(new InternetAddress(from));
//
//        m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//
//        m.setSubject(subject);
//
//        // adding text to message
//        m.setText(message);
//
//        Transport.send(m);
//
//        System.out.println("Sent success...");
//    }
}
