package com.company;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class Manager implements ActionListener, FocusListener, KeyListener {

    // Object members
    private String firstName;
    private String lastName;
    private String Gender;
    private String NICno;
    private String Mobileno;
    private String address;
    private String password;
    private int age;

    private JButton newgoBack;
    // end
    public SavingsAccount savingsAccount;

    // Gui Components

    private  Image img;
    private  Image newImg;

    private JButton  create;
    private JButton  view;
    private JButton  delete;
    private JButton  edit;
    private JButton  search;
    private  JButton  viewTransactions;

    // EditFrame TextFields
    private JTextField editNameField;
    private  JTextField editPhoneField;
    private JTextField editEmailField;
    private JPasswordField editPasswordField;
    private JTextArea editAddressField;
    // end edit frame fields
    
    // Frames
    private JFrame newFrame; // create Acc window
    private JFrame viewFrame; // view Acc window
    private JFrame searchFrame; // search Acc window
    private JFrame deleteFrame; // delete Acc window
    private JFrame editFrame; // edit Acc window
    private JFrame transactionFrame; // transactions window
    // End frames

    private JLabel createLabel; // create Acc label
    private JLabel viewLabel; // view Acc label
    private JLabel deleteLabel; // delete Acc label
    private  JLabel editLabel; // edit Acc label
    private JLabel searchLabel; // search Acc label
    private  JFrame frame; // Customer menu

    // create acc attributes
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel NIC;
    private JLabel GenderLabel;
    private JLabel PhoneLabel;
    private JLabel passwordLabel;
    private JLabel DOB;
    private JLabel addressLabel;
    private JTextField fname;
    private JTextField lname;
    private JTextField phone;
    private JRadioButton Male;
    private JRadioButton Female;
    private JTextField Nic;
    private JPasswordField passwordField;
    private JTextArea addressField;
    private JButton submit;
    private JButton reset;
    private ButtonGroup genderField;
//  end of attributes to create an account

    private JButton viewBack;
    private JButton goBack;
    private JButton transactionBack;
    private JButton searchBack; // back button used for search frame
    private JButton deleteBack;
    private JButton editBack;

    // Buttons used in edit and delete frames
    private JButton deleteButton; // used to delete selected account
    private JButton editButton;
    private JProgressBar bar;
    private boolean hasUpper;
    private boolean hasLower;
    private boolean hasDigit;
    private boolean hasSpecialChar=false;
    private String c;
    private JLabel strength;
    private JLabel userNameLabel;
    private JLabel emailLabel;
    private JLabel balanceLabel;
    private JLabel accountNoLabel;

     JTextField emailTextField;
    private  JTextField balanceTextField;
    private  JTextField userNameField;
    private  JTextField accountNoField;

    private  JTextField transactionSearchField;
    private  JTextField searchField;
    private String searchFieldText;

    private CurrentAccount currentAccount;
    private static JLabel type;
    DefaultTableModel model;
    private static JComboBox types;
    private static JComboBox day,month,year;
    private String[] data;
    private String[] typeOfAccounts = {"Savings Account","Current Account"};
    private DefaultTableModel tableModel = (DefaultTableModel)(Bank.accountsData.getModel()) ;
    // JTable

    // Navigation Menu buttons


    // end gui components

    Manager() {
        firstName = "";
        lastName = "";
        Gender = "";
        NICno = "";
        Mobileno = "";
        address = "";
        password = "";
        age = 0;
    }
    Manager(String firstName,String lastName, String gender, String NICno,String mobileno,String address,String password,int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Gender = gender;
        this.NICno = NICno;
        this.Mobileno = mobileno;
        this.address = address;
        this.password = password;
        this.age = age;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setMobileno(String mobileno) {
        Mobileno = mobileno;
    }

    public void setNICno(String NICno) {
        this.NICno = NICno;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileno() {
        return Mobileno;
    }

    public String getNICno() {
        return NICno;
    }

    public String getPassword() {
        return password;
    }

    public void managerMenu()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300,700);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Menu");
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);

        // setting image icons
        ImageIcon createImage = new ImageIcon("images/createAcc.png");
        ImageIcon viewImage = new ImageIcon("images/viewAcc.png");
        ImageIcon searchImage = new ImageIcon("images/searchAcc.png");
        ImageIcon deleteImage = new ImageIcon("images/removeAcc.png");
        ImageIcon editImage = new ImageIcon("images/updateAcc.png");
        ImageIcon viewTransactionImage = new ImageIcon("images/transactionIcon.png");

        //setting butttons
        byte extraHeight = 30;
        create = new JButton();
        create.setBounds(100,250,150,150);
        create.setBorder(BorderFactory.createLineBorder(Color.black,1,false));
        img = createImage.getImage();
        newImg = img.getScaledInstance(150,150, Image.SCALE_SMOOTH);
        createImage = new ImageIcon( newImg );
        create.setIcon(createImage);
        frame.add(create);

        createLabel = new JLabel("Open account");
        createLabel.setBounds(113,420,120,25);
        createLabel.setFont( new Font("Arial",Font.PLAIN,18));
        createLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(createLabel);

        view = new JButton();
        view.setBounds(300,220 + extraHeight,150,150);
         view.setBorder(BorderFactory.createLineBorder(Color.black,1,false));
        img = viewImage.getImage();
        newImg = img.getScaledInstance(150,150, Image.SCALE_SMOOTH);
        viewImage = new ImageIcon( newImg );
        view.setIcon(viewImage);
        frame.add(view);

        viewLabel = new JLabel("View accounts");
        viewLabel.setBounds(316,390 + extraHeight,120,25);
        viewLabel.setFont( new Font("Arial",Font.PLAIN,18));
        viewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(viewLabel);

        search = new JButton();
        search.setBounds(500,220 + extraHeight,150,150);
        search.setBorder(BorderFactory.createLineBorder(Color.black,1,false));
        img = searchImage.getImage();
        newImg = img.getScaledInstance(150,150, Image.SCALE_SMOOTH);
        searchImage = new ImageIcon( newImg );
        search.setIcon(searchImage);
        frame.add(search);

        searchLabel = new JLabel("Search account");
        searchLabel.setBounds(506,390 + extraHeight,140,25);
        searchLabel.setFont( new Font("Arial",Font.PLAIN,18));
        searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(searchLabel);

        delete = new JButton();
        delete.setBounds(700,220 + extraHeight,150,150);
        delete.setBorder(BorderFactory.createLineBorder(Color.black,1,false));
        img = deleteImage.getImage();
        newImg = img.getScaledInstance(150,150, Image.SCALE_SMOOTH);
        deleteImage = new ImageIcon( newImg );
        delete.setIcon(deleteImage);
        frame.add(delete);

        deleteLabel = new JLabel("Delete account");
        deleteLabel.setBounds(714,390 + extraHeight,120,30);
        deleteLabel.setFont( new Font("Arial",Font.PLAIN,18));
        deleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(deleteLabel);

        viewTransactions = new JButton();
        viewTransactions.setBounds(1100,220 + extraHeight,150,150);
        viewTransactions.setBorder(BorderFactory.createLineBorder(Color.black,1,false));
        viewTransactions.setBackground(Color.white);
        img = viewTransactionImage.getImage();
        newImg = img.getScaledInstance(200,150, Image.SCALE_SMOOTH);
        viewTransactionImage = new ImageIcon( newImg );
        viewTransactions.setIcon(viewTransactionImage);
        frame.add(viewTransactions);

        JLabel viewTransactionLabel = new JLabel("View Transactions");
        viewTransactionLabel.setBounds(1100,390 + extraHeight,150,30);
        viewTransactionLabel.setFont( new Font("Arial",Font.PLAIN,18));
        viewTransactionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(viewTransactionLabel);


        edit = new JButton();
        edit.setBounds(900,220 + extraHeight,150,150);
        edit.setBorder(BorderFactory.createLineBorder(Color.black,1,false));
        img = editImage.getImage();
        newImg = img.getScaledInstance(150,160, Image.SCALE_SMOOTH);
        editImage = new ImageIcon( newImg );
        edit.setIcon(editImage);
        frame.add(edit);

        editLabel = new JLabel("Edit account");
        editLabel.setBounds(910,390 + extraHeight,130,30);
        editLabel.setFont( new Font("Arial",Font.PLAIN,18));
        editLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(editLabel);

        create.addActionListener(this);
        edit.addActionListener(this);
        delete.addActionListener(this);
        view.addActionListener(this);
        search.addActionListener(this);
        viewTransactions.addActionListener(this);

        goBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);

        goBack.setIcon( new ImageIcon(newImg) );
        goBack.setBounds(10,10,30,25);
        goBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        goBack.setToolTipText("Go back");
        goBack.addActionListener(this);
        frame.add(goBack);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    // ensures that all fields are filled to create an account
    boolean check()
    {
        if(fname.getText().isEmpty() || lname.getText().isEmpty() || phone.getText().isEmpty() || Nic.getText().isEmpty() ||
                Objects.equals( passwordField.getPassword(), "") || addressField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Fill all fields","Incomplete Fields", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == create )
        {
            try {
                createAccount(); // displays create acc window
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //savingsAccount = new SavingsAccount();

        }
        if( e.getSource() == viewTransactions )
        {
            frame.dispose();
            try {
                viewTransactionFunction(); // displays view transactions window
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if( e.getSource() == view )
        {
            frame.dispose();
            try {
                viewAccount(); // displays view acc window
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }

        if( e.getSource() == searchBack )
        {
            searchField.setText("");
            searchFrame.dispose();
            managerMenu();
        }
        if(e.getSource() == search)
        {
            frame.dispose();
            try {
                searchAccount(); // displays search acc window
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }

        if( e.getSource() == viewBack )
        {
            viewFrame.dispose();
            managerMenu();
        }
        if( e.getSource() == goBack )
        {
            frame.dispose();
             new ManagerMenu();
        }

        if( e.getSource() == transactionBack )
        {
            transactionFrame.dispose();
            managerMenu();
        }

        if( e.getSource() == deleteButton )
        {
            int deleteIndex = Bank.accountsData.getSelectedRow();
            String[] data = new String[11];
            try
            {
                if( deleteIndex >=0 ) {

                    File oldFile = new File("Accounts.txt");
                File tempFile = new File("Temp.txt");
                FileWriter fw = new FileWriter( tempFile,true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.flush();
                PrintWriter writer = new PrintWriter( bw );
                Scanner read;
                if( oldFile.exists() )
                {
                    read = new Scanner(oldFile);
                    read.useDelimiter("[,\n]");

                        while( read.hasNext() ) {

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

                            if(!data[0].equals(Bank.selectedCellValue))
                            {
                                writer.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] +
                                        "," + data[7] + "," + data[8] + "," + data[9] + "," + data[10]);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Account Deleted Successfully","Deleted",JOptionPane.INFORMATION_MESSAGE);
                            }
                        }

                        read.close();
                       bw.flush();
                        writer.flush();
                        writer.close();

                        oldFile.delete();
                        tempFile.renameTo( new File("Accounts.txt"));
                        sendDataToTable();

                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please select an account to delete");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


        if( e.getSource() == editButton ) {
            int editIndex = Bank.accountsData.getSelectedRow();
                //model = (DefaultTableModel)(Bank.accountsData.getModel());
                String[] data = new String[11];

                //boolean result = Check();
                try {
                    if (editIndex >= 0) {
                        if( canEdit()) {

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

                                while (read.hasNext()) {
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

                                    if (!(data[0].equals(Bank.selectedCellValue))) {
                                        writer.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] +
                                                "," + data[7] + "," + data[8] + "," + data[9] + "," + data[10]);
                                    } else {
                                        data[1] = editNameField.getText();
                                        data[2] = editPhoneField.getText();
                                        data[6] = editEmailField.getText();
                                        data[7] = editPasswordField.getText();
                                        data[9] = editAddressField.getText();
                                        writer.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] +
                                                "," + data[7] + "," + data[8] + "," + data[9] + "," + data[10]);
                                        JOptionPane.showMessageDialog(null, "Account Updated Successfully", "Update", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                read.close();
                                bw.flush();
                                writer.flush();
                                writer.close();

                                oldFile.delete();
                                tempFile.renameTo(new File("Accounts.txt"));
                                sendDataToTable();
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Fill all fields","Incomplete Form",JOptionPane.WARNING_MESSAGE);
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Please select an account to edit");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }


        if( e.getSource() == delete )
        {
            frame.dispose();
            try {
                deleteAccount();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"Exception: " + ex.getMessage(),"File not Found", ERROR_MESSAGE);
            }
        }

        if( e.getSource() == deleteBack )
        {
            deleteFrame.dispose();
            managerMenu();
        }

        if( e.getSource() == editBack )
        {
            editFrame.dispose();
            managerMenu();
        }
        if( e.getSource() == edit )
        {
            frame.dispose();
            try {
                editAccount(); // displays edit acc window
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == submit) {

            if (check()) {
                bar.setValue(0);
                strength.setText("");
                passwordField.setText("");
            } else {

                // adding data to table
                if(Objects.equals(types.getSelectedItem(), "Savings Account"))
                {
                    try {
                        savingsAccount = new SavingsAccount();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    savingsAccount.setFirstName(fname.getText());
                    savingsAccount.setLastName(lname.getText());
                    if (Male.isSelected()) {
                        savingsAccount.setGender("Male");
                    } else {
                        savingsAccount.setGender("Female");
                    }
                    savingsAccount.setAddress(addressField.getText());
                    savingsAccount.setPhoneNo(phone.getText());

                    savingsAccount.setPassword(String.copyValueOf(passwordField.getPassword()));
                    savingsAccount.setNicNo((Nic.getText()));
                    System.out.println("Savings");

                }
                else
                {
                    try {
                        currentAccount = new CurrentAccount();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        currentAccount = new CurrentAccount();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    currentAccount.setFirstName(fname.getText());
                    currentAccount.setLastName(lname.getText());
                    if (Male.isSelected()) {
                        currentAccount.setGender("Male");
                    } else {
                        currentAccount.setGender("Female");
                    }
                    currentAccount.setAddress(addressField.getText());
                    currentAccount.setPhoneNo(phone.getText());

                    currentAccount.setPassword(String.copyValueOf(passwordField.getPassword()));
                    currentAccount.setNicNo((Nic.getText()));
                    System.out.println("Current");
                }
               

                if(passwordField.getPassword().length < 8)
                {
                    JOptionPane.showMessageDialog(null,"Password length must be greater than 7\n","Weak password", ERROR_MESSAGE);
                    passwordField.setText("");
                }
                else {
                    JOptionPane.showMessageDialog(null,"Account Created Successfully","Account Created",JOptionPane.INFORMATION_MESSAGE);
                    model = (DefaultTableModel)Bank.accountsData.getModel();
                    data = new String[8];
                    data[0] = accountNoField.getText();
                    data[1] = fname.getText() + " " + lname.getText();
                    data[2] = "";
                    if( Male.isSelected() )
                    {
                        data[3] = "Male";
                    }
                    else
                    {
                        data[3] = "Female";
                    }
                    data[4] = phone.getText();
                    data[5] = Nic.getText();
                    data[6] = emailTextField.getText();
                    data[7] = balanceTextField.getText();

                    try {
                        Account.calculateCount();
                        System.out.println("Incremented");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    // inserting record into file(Accounts.txt)
                    try {
                        String g;
                        String t = null;
                        switch (types.getSelectedIndex()) {
                            case 0 -> t = "Savings Account";
                            case 1 -> t = "Current Account";
                        }
                        if( Male.isSelected())
                        {
                            g = "Male";
                        }
                        else
                        {
                            g = "Female";
                        }

                        FileWriter fw = new FileWriter( "Accounts.txt",true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.flush();
                        PrintWriter writer = new PrintWriter(bw);
                        int age = calculateAge();
                        writer.println(accountNoField.getText() + "," + userNameField.getText() + "," + phone.getText() + "," + Nic.getText() + "," + String.valueOf(age) + ","
                                + g + "," + emailTextField.getText() + "," + String.copyValueOf(passwordField.getPassword()) + "," + t + "," +
                                addressField.getText() + "," + balanceTextField.getText());
                       writer.flush();

                        writer.close();

                        FileWriter file = new FileWriter("BillsStatus.txt",true);
                        BufferedWriter bfile = new BufferedWriter(file);
                        bfile.flush();
                        PrintWriter filewriter = new PrintWriter(bfile);

                        filewriter.println(accountNoField.getText() + "," + "Unpaid" + "," + "Unpaid" + "," + "Unpaid" + ",");
                        bfile.flush();
                        filewriter.flush();
                        filewriter.close();

                        file = new FileWriter("LoansStatus.txt",true);
                        bfile = new BufferedWriter(file);
                        bfile.flush();
                        filewriter = new PrintWriter(bfile);

                        filewriter.println(accountNoField.getText() + "," + "-" + ",");
                        filewriter.flush();
                        filewriter.close();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                   // Bank.tableModel.addRow(data);
                    managerMenu();
                    newFrame.dispose();
                }
            }

            bar.setValue(0);
            strength.setText("");

        }
        // used to reset all the fields
        else if( e.getSource() == reset )
        {
            Reset();
        }
        // goBack button of create Acc window
        if( e.getSource() == newgoBack )
        {
            newFrame.dispose();
            managerMenu();
        }

    }

    // function used to display the transactions
    public void viewTransactionFunction() throws FileNotFoundException {
        transactionFrame = new JFrame("View Transactions");
        transactionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        transactionFrame.setLayout(null);
        transactionFrame.setSize(1300,700);
        transactionFrame.setBackground(Color.white);
        transactionFrame.setLocationRelativeTo(null);

        System.out.println("View Transactions");
        JPanel panel = new JPanel();
        panel.setBounds(100,100,1270,600);
        Bank.transactions.setPreferredScrollableViewportSize(new Dimension(1190,500));
        //Bank.transactions.setBounds(110,60,1190,30);

        transactionSearchField = new JTextField("Enter Account # to search transaction");
        searchFieldText = transactionSearchField.getText();
        transactionSearchField.setBounds(500,30,300,40);
        transactionSearchField.setFont( new Font("Arial",Font.PLAIN,15));
        transactionSearchField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true));
        transactionSearchField.addFocusListener(this);
        transactionSearchField.addKeyListener(this);

        panel.add(Bank.transactionScrollPane);//transactionFrame.add(Bank.scrollPane);0
        Bank.transactions.setFillsViewportHeight(true);
        Bank.transactions.setVisible(true);
        //panel.setBorder(BorderFactory.createLineBorder(Color.black,1,false));

        transactionBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);

        transactionBack.setIcon( new ImageIcon(newImg) );
        transactionBack.setBounds(10,10,30,25);
        transactionBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        transactionBack.setToolTipText("Go back");
        transactionBack.addActionListener(this);
        transactionFrame.add(panel);
        transactionFrame.add(transactionSearchField);
        transactionFrame.add(transactionBack);
        transactionDataToTable();
        transactionFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        transactionFrame.setVisible(true);
    }

     // used to send transactions from file to JTable
    public void transactionDataToTable() throws FileNotFoundException {
        File file = new File("Transactions.txt");
        Scanner read;
        Bank.transactionTableModel.setRowCount(0);
        String[] data = new String[7];
        if( file.exists()) {
            read = new Scanner(file);
            read.useDelimiter("[,\n]");

            while (read.hasNext()) {
                data[0] = read.next();
                data[1] = (read.hasNext() ? read.next() : null);
                data[2] = (read.hasNext() ? read.next() : null);
                data[3] = (read.hasNext() ? read.next() : null);
                data[4] = (read.hasNext() ? read.next() : null);
                data[5] = (read.hasNext() ? read.next() : null);
                data[6] = (read.hasNext() ? read.next() : null);
                Bank.transactionTableModel.addRow(data);
            }
            read.close();
        }
    }

    // used to create acc
    public void createAccount() throws IOException {
        frame.dispose();
        newFrame = new JFrame();

        Account account = new Account();
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setLayout(null);
        newFrame.setSize(1350,700);
        newFrame.setTitle("Create an Account");
        newFrame.setLocationRelativeTo(null);
        newFrame.getContentPane().setBackground(Color.white);
        int thickness = 1;

        strength = new JLabel();


        accountNoLabel = new JLabel("Account #");
        accountNoLabel.setBounds(100,100,300,40);
        accountNoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        newFrame.add(accountNoLabel);

        accountNoField = new JTextField(String.valueOf(account.getAccountNo()));
        accountNoField.setBounds(200,100,300,40);
        accountNoField.setEditable(false);
        accountNoField.setBorder(BorderFactory.createLineBorder(Color.darkGray,thickness,true));
        accountNoField.setFont(new Font("Arial", Font.PLAIN, 20));
        accountNoField.addKeyListener(this);
        newFrame.add(accountNoField);

        firstNameLabel = new JLabel("First name");
        firstNameLabel.setBounds(100, 160, 100, 40);
        firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        newFrame.add(firstNameLabel);

        fname = new JTextField();
        fname.setBounds(200, 160, 300, 40);
        fname.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, thickness, true));
        fname.setFont(new Font("Arial", Font.PLAIN, 20));
        fname.addFocusListener(this);
        newFrame.add(fname);

        lastNameLabel = new JLabel("Last name");
        lastNameLabel.setBounds(800, 160, 100, 40);
        lastNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        newFrame.add(lastNameLabel);

        lname = new JTextField();
        lname.setBounds(900, 160, 300, 40);
        lname.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, thickness, true));
        lname.setFont(new Font("Arial", Font.PLAIN, 20));
        lname.addFocusListener(this);
        newFrame.add(lname);



        PhoneLabel = new JLabel("Phone #");
        PhoneLabel.setBounds(100, 220, 100, 40);
        PhoneLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        newFrame.add(PhoneLabel);

        phone = new JTextField();
        phone.setBounds(200, 220, 300, 40);
        phone.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, thickness, true));
        phone.setFont(new Font("Arial", Font.PLAIN, 20));
        phone.addKeyListener(( this ));
        phone.addFocusListener(this);
        newFrame.add(phone);

        // NIC
        NIC = new JLabel("NIC #");
        NIC.setBounds(800, 220, 100, 40);
        NIC.setFont(new Font("Arial", Font.PLAIN, 20));

        newFrame.add(NIC);

        Nic = new JTextField();
        Nic.setBounds(900, 220, 300, 40);
        Nic.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, thickness, true));
        Nic.setFont(new Font("Arial", Font.PLAIN, 20));
        Nic.addKeyListener(this);
        Nic.addFocusListener(this);
        newFrame.add(Nic);

        // UserName

        userNameLabel = new JLabel("User name");
        userNameLabel.setBounds(100, 280, 100, 40);
        userNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        newFrame.add(userNameLabel);

        userNameField = new JTextField();
        userNameField.setBounds(200,280,300,40);
        userNameField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, thickness, true));
        userNameField.setFont(new Font("Arial", Font.PLAIN, 20));
        userNameField.addFocusListener(this);
        newFrame.add(userNameField);

        // Gender
        GenderLabel = new JLabel("Gender");
        GenderLabel.setBounds(800, 280, 100, 40);
        GenderLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        newFrame.add(GenderLabel);

        Male = new JRadioButton("Male");
        Female = new JRadioButton("Female");
        Male.setBounds(900, 285, 100, 30);
        Male.setBackground(Color.white);
        Female.setBounds(1010, 285, 100, 30);
        Female.setBackground(Color.white);
        genderField = new ButtonGroup();
        genderField.add(Male);
        genderField.add(Female);
        newFrame.add(Male);
        newFrame.add(Female);

        // Date of birth

        DOB = new JLabel("Date of Birth");
        DOB.setBounds(800, 280 + 140, 100, 40);
        DOB.setFont(new Font("Arial", Font.BOLD, 17));
        newFrame.add(DOB);


        day = new JComboBox(Register.dates);
        day.setToolTipText("Day");
        day.setBounds(920,280  + 140,60,30);
        day.setBackground(Color.white);
        day.setFont( new Font("Arial",Font.PLAIN,15));
        day.addFocusListener(this);
        newFrame.add(day);

        month = new JComboBox(Register.months);
        month.setToolTipText("Month");
        month.setBackground(Color.white);
        month.setBounds(1020,280 + 140,60,30);
        month.setFont( new Font("Arial",Font.PLAIN,15));
        newFrame.add(month);

        year = new JComboBox(Register.years);
        year.setToolTipText("Year");
        year.setBackground(Color.white);
        year.setBounds(1120,280 + 140,60,30);
        year.setFont( new Font("Arial",Font.PLAIN,15));
        newFrame.add(year);

        
        // Email
        
        emailLabel = new JLabel("Email");
        emailLabel.setBounds(100,350,100,20);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        newFrame.add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setBounds(200,340,300,40);
        emailTextField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, thickness, true));
        emailTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        emailTextField.addFocusListener(this);
        newFrame.add(emailTextField);

        // Password
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(800, 350, 100, 20);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        newFrame.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(900, 340, 300, 40);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, thickness, true));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordField.addFocusListener(this);
        passwordField.addFocusListener(this);
        passwordField.addKeyListener(this);
        newFrame.add(passwordField);

        type = new JLabel("Type");
        type.setBounds(100, 420, 100, 20);
        type.setFont(new Font("Arial", Font.PLAIN, 20));
        newFrame.add(type);

        types = new JComboBox(typeOfAccounts);
        types.addActionListener(this);
        types.setBounds(200,420,250,20);
        types.setBackground(Color.white);
        newFrame.add(types);

        addressLabel = new JLabel("Address");
        addressLabel.setBounds(100, 500, 100, 20);
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        newFrame.add(addressLabel);

        addressField = new JTextArea();
        addressField.setBounds(200, 500, 300, 100);
        addressField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, thickness, true));
        addressField.setFont(new Font("Arial", Font.PLAIN, 20));
        addressField.addFocusListener(this);
        newFrame.add(addressField);
     
        balanceLabel = new JLabel("Balance");
        balanceLabel.setBounds(800, 510, 100, 20);
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        newFrame.add(balanceLabel);

        balanceTextField = new JTextField();
        
        balanceTextField.setBounds(900,500,300,40);
        balanceTextField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, thickness, true));
        balanceTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        balanceTextField.addKeyListener(this);
        balanceTextField.addFocusListener(this);
        newFrame.add(balanceTextField);

        submit = new JButton("Submit");
        reset = new JButton("Reset");
        submit.setBackground(Color.white);
        submit.addActionListener(this);
        reset.setBackground(Color.white);
        reset.addActionListener(this);

        // submit.setBackground(Color);`
        submit.setBounds(500, 640, 150, 40);
        //reset.setBackground(Color.BLACK);
        reset.setBounds(700, 640, 150, 40);

        newgoBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);

        newgoBack.setIcon( new ImageIcon(newImg) );
        newgoBack.setBounds(10,10,30,25);
        newgoBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        newgoBack.setToolTipText("Go back");
        newgoBack.addActionListener(this);
        newFrame.add(newgoBack);

        bar = new JProgressBar(0,100);
        bar.setBounds(920,390,250,10);
        bar.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,true));
        bar.setBackground(Color.white);

        newFrame.add(bar);
        newFrame.add(strength);
        newFrame.add(submit);
        newFrame.add(reset);
        newFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        newFrame.setVisible(true);
    }

    // used to view any account
    public void viewAccount() throws FileNotFoundException {
        viewFrame = new JFrame("View Accounts");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setLayout(null);
        viewFrame.setSize(1300,700);
        viewFrame.setLocationRelativeTo(null);


        System.out.println("View");
        JPanel panel = new JPanel();
        panel.setBounds(100,100,1200,500);
        Bank.accountsData.setPreferredScrollableViewportSize(new Dimension(1190,470));
       // Bank.scrollPane.setBounds(110,60,1190,30);

        try {
            sendDataToTable();
        }catch (NoSuchElementException e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
        panel.add(Bank.scrollPane);
        panel.setBackground(Color.white);
        Bank.accountsData.setFillsViewportHeight(true);
        Bank.accountsData.setVisible(true);

        viewBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);

        viewBack.setIcon( new ImageIcon(newImg) );
        viewBack.setBounds(10,10,30,25);
        viewBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        viewBack.setToolTipText("Go back");
        viewBack.addActionListener(this);
        viewFrame.add(panel);
        viewFrame.getContentPane().setBackground(Color.white);
        viewFrame.add(viewBack);

        viewFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        viewFrame.setVisible(true);
    }

    // used to send data from file to table
    void sendDataToTable() throws FileNotFoundException {
        String[] data = new String[8];
        String extra,extra1,extra2;
        extra = "";
        extra1 = "";
        extra2 = "";

        Bank.tableModel.setRowCount(0);

        File file = new File("Accounts.txt");
        Scanner reader;
        if( file.exists() ) {
            reader = new Scanner(file);
            System.out.println("In Send Data function");
            reader.useDelimiter("[,\n]");
            while (reader.hasNext()) {

                data[0] = reader.next(); // accountNo
                data[1] = (reader.hasNext() ? reader.next() : null); // userName
                data[4] = (reader.hasNext() ? reader.next() : null); // phone
                data[5] = (reader.hasNext() ? reader.next() : null); // nic
                data[2] = (reader.hasNext() ? reader.next() : null); // age
                data[3] = (reader.hasNext() ? reader.next() : null); // gender
                data[6] = (reader.hasNext() ? reader.next() : null); // email
                extra = (reader.hasNext() ? reader.next() : null); // password
                extra1 = (reader.hasNext() ? reader.next() : null); //type
                extra2 = (reader.hasNext() ? reader.next() : null); // address
                data[7] = (reader.hasNext() ? reader.next() : null); // balance
                System.out.println("Balance");
                Bank.tableModel.addRow(data);
            }

            reader.close();
        }
    }

    // used to search an acc
    void searchAccount() throws FileNotFoundException {
        searchFrame = new JFrame("Search Accounts");
        searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchFrame.setLayout(null);
        searchFrame.setSize(1300,700);
        searchFrame.setLocationRelativeTo(null);

        searchField = new JTextField("Enter Account # to search account");
        searchFieldText = searchField.getText();
        searchField.setBounds(500,30,300,40);
        searchField.setFont( new Font("Arial",Font.PLAIN,15));
        searchField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true));
        searchField.addFocusListener(this);
        searchField.addKeyListener(this);
        JPanel panel = new JPanel();
        panel.setBounds(100,100,1200,500);

        sendDataToTable();
        Bank.accountsData.setFillsViewportHeight(true);
        Bank.accountsData.setPreferredScrollableViewportSize(new Dimension(1190,470));
       //Bank.scrollPane.getViewport().setViewPosition(new Point(10,80));
       panel.add(Bank.scrollPane);//viewFrame.add(Bank.scrollPane);

        searchBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);
        searchBack.setIcon( new ImageIcon(newImg) );

        searchBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        searchBack.setToolTipText("Go back");
        searchBack.setBounds(10,10,30,25);
        searchBack.addActionListener(this);

        panel.setBackground(Color.white);


        searchFrame.add(searchBack);
        searchFrame.add(panel);
        searchFrame.getContentPane().setBackground(Color.white);
        searchFrame.add(searchField);
        searchFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        searchFrame.setVisible(true);


    }

    // used to delete an acc
    public void deleteAccount() throws FileNotFoundException {
        deleteFrame = new JFrame("Delete Accounts");
        deleteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        deleteFrame.setLayout(null);
        deleteFrame.setSize(1300,700);
        deleteFrame.setLocationRelativeTo(null);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(900,30,70,40);
        deleteButton.setBackground(Color.white);
        searchField = new JTextField("Enter Account # to delete account");
        searchFieldText = searchField.getText();
        searchField.setBounds(500,30,300,40);
        searchField.setFont( new Font("Arial",Font.PLAIN,15));
        searchField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true));
        searchField.addFocusListener(this);
        searchField.addKeyListener(this);
        deleteButton.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setBounds(100,100,1200,500);
        sendDataToTable();
        Bank.accountsData.setFillsViewportHeight(true);
        Bank.accountsData.setPreferredScrollableViewportSize(new Dimension(1190,470));
        //Bank.scrollPane.getViewport().setViewPosition(new Point(100,100));


        panel.add(Bank.scrollPane);//viewFrame.add(Bank.scrollPane);
        panel.setBackground(Color.white);

        deleteBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);
        deleteBack.setIcon( new ImageIcon(newImg) );
        deleteBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        deleteBack.setToolTipText("Go back");
        deleteBack.setBounds(10,10,30,25);
        deleteBack.addActionListener(this);

        deleteFrame.add(searchField);

        deleteFrame.add(deleteBack);
        deleteFrame.add(panel);
        deleteFrame.add(deleteButton);
        deleteFrame.getContentPane().setBackground(Color.white);
        deleteFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        deleteFrame.setVisible(true);
    }

    boolean canEdit()
    {
        if( editNameField.getText().isEmpty() || editNameField.getText().equals("Enter new Name")
         || editPhoneField.getText().isEmpty() || editPhoneField.getText().equals("Enter new Phone #")
         || editEmailField.getText().isEmpty() || editEmailField.getText().equals("Enter new Email")
         || editAddressField.getText().isEmpty() || editAddressField.getText().equals("Enter new Address")
         || String.copyValueOf(editPasswordField.getPassword()).isEmpty() || String.copyValueOf(editPasswordField.getPassword()).equals("Enter new Password"))
        {
            return false;
        }
        else if(String.copyValueOf(editPasswordField.getPassword()).length() < 8)
        {
                JOptionPane.showMessageDialog(null,"Password length must be greater than 7\n","Weak password", ERROR_MESSAGE);
                passwordField.setText("");
            return false;
        }
        else
        {
            return true;
        }
    }

    // used to edit an acc
    public void editAccount() throws FileNotFoundException {
        editFrame = new JFrame("Edit Accounts");
        editFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editFrame.setLayout(null);
        editFrame.setSize(1300,700);
        editFrame.setLocationRelativeTo(null);

        strength = new JLabel();

        Font font = new Font("Arial",Font.PLAIN,18);
        editNameField = new JTextField("Enter new Name");
        editNameField.setBounds(100,100 + 10,300,40);
        editNameField.setFont(font);
        editNameField.setBorder( BorderFactory.createLineBorder(Color.black,1,true));
        editNameField.addFocusListener(this);
        editFrame.add(editNameField);

        editPhoneField = new JTextField("Enter new Phone #");
        editPhoneField.setBounds(100,200 + 10,300,40);
        editPhoneField.setFont(font);
        editPhoneField.setBorder( BorderFactory.createLineBorder(Color.black,1,true));
        editPhoneField.addFocusListener(this);
        editPhoneField.addKeyListener(this);
        editFrame.add(editPhoneField);

        editEmailField = new JTextField("Enter new Email");
        editEmailField.setBounds(100,300 + 10,300,40);
        editEmailField.setFont(font);
        editEmailField.setBorder( BorderFactory.createLineBorder(Color.black,1,true));
        editEmailField.addFocusListener(this);
        editFrame.add(editEmailField);


        editPasswordField = new JPasswordField("Enter new Password");
        editPasswordField.setEchoChar((char)0);
        editPasswordField.setBounds(100,400 + 10,300,40);
        editPasswordField.setFont(font);
        editPasswordField.setBorder( BorderFactory.createLineBorder(Color.black,1,true));
        editPasswordField.addFocusListener(this);
        editFrame.add(editPasswordField);

        // this bar will indicate the strength of the password by showing (Red->Weak), (Yellow->Moderate) and (Green->Strong) text and colors
        bar = new JProgressBar(0,100);
        bar.setBounds(125,470,250,10);
        bar.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,true));
        bar.setBackground(Color.white);

        editAddressField = new JTextArea("Enter new Address");
        editAddressField.setBounds(100,500 + 10,300,100);
        editAddressField.setFont(font);
        editAddressField.setBorder( BorderFactory.createLineBorder(Color.black,1,true));
        editAddressField.addFocusListener(this);
        editFrame.add(editAddressField);


        editButton = new JButton("Edit");
        editButton.setBounds(895,30,70,40);
        editButton.setBackground(Color.white);

        // accounts are searched in this field
        searchField = new JTextField("Enter Account # to edit account");
        searchFieldText = searchField.getText();
        searchField.setBounds(600,30,300,40);
        searchField.setFont( new Font("Arial",Font.PLAIN,15));
        searchField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true));
        searchField.addFocusListener(this);
        searchField.addKeyListener(this);

        editButton.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setBounds(500,100,850,520);

        sendDataToTable();
        Bank.accountsData.setFillsViewportHeight(true);
        Bank.accountsData.setPreferredScrollableViewportSize(new Dimension(840,490));
        //Bank.scrollPane.getViewport().setViewPosition(new Point(100,100));


        panel.add(Bank.scrollPane);
        panel.setBackground(Color.white);

        editBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);
        editBack.setIcon( new ImageIcon(newImg) );
        editBack.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,false));
        editBack.setToolTipText("Go back");
        editBack.setBounds(10,10,30,25);
        editBack.addActionListener(this);

        editFrame.add(searchField);

        editFrame.add(editBack);
        editFrame.add(panel);
        editFrame.add(editButton);
        editFrame.getContentPane().setBackground(Color.white);
        editFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        editFrame.setVisible(true);

    }
    
    

    void Reset()
    {
        fname.setText("");
        lname.setText("");
        phone.setText("");
        addressField.setText("");
        emailTextField.setText("");
        balanceTextField.setText("");
        Nic.setText("");
        bar.setValue(0);
        userNameField.setText("");
        strength.setText("");
        passwordField.setText("");
        types.setSelectedItem("Savings Account");
        Male.setSelected(false);
        Female.setSelected(false);
    }


    String strengthChecker( char[] pass )
    {
        Set<Character> set = new HashSet<>(
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

    // used to sort the table->transactions based on the text in search text field
    public void searchTransactionRecord(String searchString)
    {
        tableModel = (DefaultTableModel)(Bank.transactions.getModel());
        TableRowSorter <DefaultTableModel> tableRowSorter = new TableRowSorter<>(tableModel);
        Bank.transactions.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchString));   
    }

    // used to sort the table->accountsData based on the text in search text field
    public void searchRecord(String searchString)
    {
        tableModel = (DefaultTableModel)(Bank.accountsData.getModel());
        TableRowSorter <DefaultTableModel> tableRowSorter = new TableRowSorter<>(tableModel);
        Bank.accountsData.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchString));
    }

    public void checker()
    {
            System.out.println("pr");
            strength.setBounds(922, 400, 200, 15);
            strength.setFont(new Font("Arial", Font.PLAIN, 15));
            strength.setForeground(Color.blue);
            strength.setBackground(Color.white);
            strength.setOpaque(true);
            strength.setHorizontalAlignment(SwingConstants.LEFT);
            c = strengthChecker(passwordField.getPassword());

            if (c.equals("Strong")) {
                bar.setValue(100);
                bar.setForeground(Color.green);
                strength.setText("Strong");
                strength.setFont( new Font("Arial",Font.BOLD,15));
                strength.setForeground(Color.green);
            } else if (c.equals("Moderate")) {
                bar.setValue(67);
                bar.setForeground(Color.yellow);
                strength.setText("Moderate");
                strength.setFont( new Font("Arial",Font.BOLD,15));
                strength.setForeground(Color.yellow);
            } else if (passwordField.getPassword().length == 0) {
                bar.setValue(0);
                bar.setForeground(Color.white);
                strength.setText("");
            } else if (c.equals("Weak")) {
                bar.setValue(33);
                bar.setForeground(Color.red);
                strength.setText("Weak");
                strength.setFont( new Font("Arial",Font.BOLD,15));
                strength.setForeground(Color.red);
            }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if( e.getSource() == fname  )
        {
            fname.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }

        if( e.getSource() == passwordField  )
        {
            passwordField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }

        if( e.getSource() == balanceTextField  )
        {
            balanceTextField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }

        if( e.getSource() == lname  )
        {
            lname.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }

        if( e.getSource() == phone  )
        {
            phone.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }

        if( e.getSource() == Nic  )
        {
            Nic.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }

        if( e.getSource() == addressField  )
        {
            addressField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }

        if( e.getSource() == emailTextField  )
        {
            emailTextField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }

        if( e.getSource() == userNameField  )
        {
            userNameField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
        }


        if( e.getSource() == searchField )
        {
            searchField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
            if( searchField.getText().equals(searchFieldText))
            {
                searchField.setText("");
            }
        }

        if( e.getSource() == transactionSearchField )
        {
            transactionSearchField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
            if( transactionSearchField.getText().equals(searchFieldText))
            {
                transactionSearchField.setText("");
            }
        }

        if( e.getSource() == editNameField )
        {
            editNameField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
            if( editNameField.getText().equals("Enter new Name"))
            {
                editNameField.setText("");
            }
        }

        if( e.getSource() == editPhoneField )
        {
            editPhoneField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
            if( editPhoneField.getText().equals("Enter new Phone #"))
            {
                editPhoneField.setText("");
            }
        }

        if( e.getSource() == editEmailField )
        {
            editEmailField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
            if( editEmailField.getText().equals("Enter new Email"))
            {
                editEmailField.setText("");
            }
        }

        if( e.getSource() == editPasswordField )
        {
            editPasswordField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
            if( String.copyValueOf(editPasswordField.getPassword()).equals("Enter new Password"))
            {
                editPasswordField.setEchoChar('•');
                editPasswordField.setText("");

            }
        }

        if( e.getSource() == editAddressField )
        {
            editAddressField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),2,true));
            if( editAddressField.getText().equals("Enter new Address"))
            {
                editAddressField.setText("");
            }
        }


    }

    @Override
    public void focusLost(FocusEvent e) {

        if( e.getSource() == fname  )
        {
            fname.setBorder(BorderFactory.createLineBorder((Color.darkGray),1,false));
        }

        if( e.getSource() == balanceTextField  )
        {
            balanceTextField.setBorder(BorderFactory.createLineBorder(Color.darkGray,1,false));
        }

        if( e.getSource() == lname  )
        {
            lname.setBorder(BorderFactory.createLineBorder( Color.darkGray,1,false));
        }

        if( e.getSource() == phone  )
        {
            phone.setBorder(BorderFactory.createLineBorder( Color.darkGray,1,false));
        }

        if( e.getSource() == Nic  )
        {
            Nic.setBorder(BorderFactory.createLineBorder(Color.darkGray,1,false));
        }

        if( e.getSource() == addressField  )
        {
            addressField.setBorder(BorderFactory.createLineBorder( Color.darkGray,1,false));
        }

        if( e.getSource() == emailTextField  )
        {
            emailTextField.setBorder(BorderFactory.createLineBorder( Color.darkGray,1,false));
        }

        if( e.getSource() == userNameField  )
        {
            userNameField.setBorder(BorderFactory.createLineBorder( Color.darkGray,1,false));
        }

        if( e.getSource() == passwordField  )
        {
            passwordField.setBorder(BorderFactory.createLineBorder( Color.darkGray,1,false));
        }

        if( e.getSource() == searchField )
        {
            searchField.setBorder(BorderFactory.createLineBorder( Color.darkGray,1,false));
            if( searchField.getText().equals(""))
            {
                searchField.setText(searchFieldText);

            }
        }
        if( e.getSource() == editNameField )
        {
            editNameField.setBorder(BorderFactory.createLineBorder( Color.darkGray,1,false));
            if( editNameField.getText().equals(""))
            {
                editNameField.setText("Enter new Name");
            }
        }

        if( e.getSource() == editPhoneField )
        {
            editPhoneField.setBorder(BorderFactory.createLineBorder( Color.darkGray,1,false));
            if( editPhoneField.getText().equals(""))
            {
                editPhoneField.setText("Enter new Phone #");
            }
        }

        if( e.getSource() == editEmailField )
        {
            editEmailField.setBorder(BorderFactory.createLineBorder( Color.darkGray,1,false));
            if( editEmailField.getText().equals(""))
            {
                editEmailField.setText("Enter new Email");
            }
        }

        if( e.getSource() == editPasswordField )
        {
            editPasswordField.setBorder(BorderFactory.createLineBorder( Color.darkGray,1,false));
            if( String.copyValueOf(editPasswordField.getPassword()).equals(""))
            {
                editPasswordField.setEchoChar((char)0);
                editPasswordField.setText("Enter new Password");
            }
        }
        if( e.getSource() == editAddressField )
        {
            editAddressField.setBorder(BorderFactory.createLineBorder( Color.darkGray,1,false));
            if( editAddressField.getText().equals(""))
            {
                editAddressField.setText("Enter new Address");
            }
        }

        if( e.getSource() == transactionSearchField )
        {
            transactionSearchField.setBorder(BorderFactory.createLineBorder( Color.darkGray,1,false));
            if( transactionSearchField.getText().equals(""))
            {
                transactionSearchField.setText(searchFieldText);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

        // make text fields number only
        if( e.getSource() == Nic || e.getSource() == phone || e.getSource() == balanceTextField || e.getSource() == editPhoneField ) {
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

    @Override
    public void keyReleased(KeyEvent e) {
        if( e.getSource() == passwordField )
        {
            checker();
        }
        if( e.getSource() == searchField )
        {
            searchRecord(searchField.getText());
        }

        if( e.getSource() == transactionSearchField )
        {
            searchTransactionRecord(transactionSearchField.getText());
        }
    }

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