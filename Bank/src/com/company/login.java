package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class login extends JFrame  implements FocusListener,ActionListener, MouseListener {

    // This class is used for admin / manager login
    JPanel loginPanel;
    JLabel fullname;
    JLabel password;
    JTextField fullnameField;
    JPasswordField passwordField;
    JButton signIn;
    ImageIcon eyeIcon;
    JLabel accountLabel;
    JButton show = new JButton();
    public static JButton goBack;
    public Manager manager;
    login()
    {


        accountLabel = new JLabel();
        accountLabel.setBorder( BorderFactory.createLineBorder(Color.lightGray,1,false));
        accountLabel.setBounds(543,75,250,220);

        Image img = (new ImageIcon("images/loginAccountImage.png")).getImage();
        Image newImg = img.getScaledInstance(280,280, Image.SCALE_SMOOTH);
        ImageIcon accIcon = new ImageIcon( newImg );
        accountLabel.setIcon(accIcon);
        accountLabel.setHorizontalAlignment(JLabel.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(1350,750);
        this.setTitle("Login");
        this.setLocationRelativeTo(null);

        loginPanel = new JPanel();
        loginPanel.setSize(800,500);
        loginPanel.setBorder( BorderFactory.createLineBorder(Color.gray,2,true));
        loginPanel.setLayout(null);
        fullname = new JLabel("Full name");
        fullname.setBounds(400 + 20, 280 + 60, 100, 40);
        fullname.setFont(new Font("Arial", Font.PLAIN, 20));
        loginPanel.add(fullname);
        loginPanel.setBackground(Color.WHITE);
        loginPanel.setOpaque(true);

        loginPanel.add(accountLabel);
        eyeIcon = new ImageIcon("images/showPass.png");

        img = eyeIcon.getImage();
        newImg = img.getScaledInstance(32,27, Image.SCALE_SMOOTH);
        eyeIcon = new ImageIcon( newImg );

        signIn = new JButton("Sign in");
        signIn.setBounds(585,410 + 80,170,40);
        signIn.setHorizontalTextPosition(SwingConstants.CENTER);
        signIn.setBackground(Color.WHITE);
        fullnameField = new JTextField("Enter Fullname");
        fullnameField.setBounds(500 + 20,280 + 60,300,40);
        fullnameField.setBorder(BorderFactory.createLineBorder(Color.darkGray,2,true));
        fullnameField.setFont( new Font("Arial",Font.PLAIN,18));
        loginPanel.add(fullnameField);



        password = new JLabel("Password");
        password.setBounds(400 + 20, 340 + 60, 100, 40);
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        loginPanel.add(password);


        passwordField = new JPasswordField("Enter Password");
        passwordField.setEchoChar( (char)0 );
        passwordField.setBounds(500 + 20,340 + 60,300,40);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.darkGray,2,true));
        passwordField.setFont( new Font("Arial",Font.PLAIN,18));
        loginPanel.add(passwordField);

        show.setIcon(eyeIcon);


        show.setBounds(810 + 20,347 + 60,35,27);
        show.setToolTipText("view password");
        show.addMouseListener(this);
        loginPanel.add(signIn);
        loginPanel.add(show);
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

        fullnameField.addFocusListener(this);
        passwordField.addFocusListener(this);
        signIn.addActionListener(this);
        this.add(loginPanel);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == signIn ) {
            File file = new File("ManagerDetails.txt");
            Scanner reader;
            String[] data = new String[7];

            try {
                reader = new Scanner(file);
                reader.useDelimiter("[,\n]");
                data[0] = reader.next();
                data[1] = reader.next();
                data[2] = reader.next();
                data[3] = reader.next();
                data[4] = reader.next();
                data[5] = reader.next();
                data[6] = reader.next();

                if ((fullnameField.getText()).equals(data[0])) {
                    System.out.println(data[0]);
                    if (String.copyValueOf(passwordField.getPassword()).equals(data[5])) {
                        System.out.println(data[5]);
                        JOptionPane.showMessageDialog(null, "Signed In Successfully", "Successful", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        manager = new Manager();
                        manager.managerMenu();
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong Password", "Wrong", JOptionPane.ERROR_MESSAGE);
                    }
                }

                reader.close();

            } catch (FileNotFoundException | NoSuchElementException ex) {
                ex.printStackTrace();
            }
        }
        if( e.getSource() == goBack )
        {
           this.dispose();
           new ManagerMenu();
            System.out.println("clicked");
        }

    }

    @Override
    public void focusGained(FocusEvent e) {

        if( e.getSource() == fullnameField )
        {
            fullnameField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),3,true));
            if( fullnameField.getText().equals("Enter Fullname") )
            fullnameField.setText("");
        }
        else if( e.getSource() == passwordField )
        {
            passwordField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),3,true));
            if( String.copyValueOf( passwordField.getPassword()).equals("Enter Password") )
            {
                passwordField.setEchoChar('•');
                passwordField.setText("");
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

        if( e.getSource() == fullnameField)
        {
            fullnameField.setBorder(BorderFactory.createLineBorder((Color.darkGray),2,false));
            if( fullnameField.getText().isEmpty() )
            {
                fullnameField.setText("Enter Fullname");
            }
        }
        else if( e.getSource() == passwordField)
        {
            passwordField.setBorder(BorderFactory.createLineBorder((Color.darkGray),2,false));
            if( String.copyValueOf(passwordField.getPassword()).isEmpty() )
            {
                passwordField.setEchoChar((char) 0);
                passwordField.setText("Enter Password");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if( e.getSource() == show )
        {
            passwordField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),3,true));
            passwordField.setEchoChar((char)0);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if( !String.copyValueOf(passwordField.getPassword()).equals("Enter Password"))
        passwordField.setEchoChar('•');
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
