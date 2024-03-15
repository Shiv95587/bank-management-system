package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CustomerLogin extends JFrame implements FocusListener,ActionListener,MouseListener,KeyListener {

    JPanel loginPanel;
    JLabel accountNoLabel;
    JLabel password;
    JTextField accountNoField;
    JPasswordField passwordField;
    JButton signIn;
    ImageIcon eyeIcon;
    JLabel accountLabel;
    JButton show = new JButton();
    public static JButton goBack;

    CustomerLogin() {
        accountLabel = new JLabel();
        accountLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, false));
        accountLabel.setBounds(543, 75, 250, 220);

        Image img = (new ImageIcon("images/loginAccountImage.png")).getImage();
        Image newImg = img.getScaledInstance(280, 280, Image.SCALE_SMOOTH);
        ImageIcon accIcon = new ImageIcon(newImg);

        accountLabel.setIcon(accIcon);
        accountLabel.setHorizontalAlignment(JLabel.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(1350, 750);
        this.setTitle("Login");
        this.setLocationRelativeTo(null);

        loginPanel = new JPanel();
        loginPanel.setSize(800, 500);
        loginPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 2, true));
        loginPanel.setLayout(null);
        accountNoLabel = new JLabel("Account # ");
        accountNoLabel.setBounds(400 + 20, 280 + 60, 100, 40);
        accountNoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        loginPanel.add(accountNoLabel);
        loginPanel.setBackground(Color.WHITE);
        loginPanel.setOpaque(true);

        loginPanel.add(accountLabel);
        eyeIcon = new ImageIcon("images/showPass.png");


        img = eyeIcon.getImage();
        newImg = img.getScaledInstance(32, 27, Image.SCALE_SMOOTH);
        eyeIcon = new ImageIcon(newImg);

        signIn = new JButton("Sign in");
        signIn.setBounds(585, 410 + 80, 170, 40);
        signIn.setHorizontalTextPosition(SwingConstants.CENTER);
        signIn.setBackground(Color.WHITE);
        accountNoField = new JTextField("Enter Account #");
        accountNoField.setBounds(500 + 20, 280 + 60, 300, 40);
        accountNoField.setBorder(BorderFactory.createLineBorder(Color.darkGray, 2, true));
        accountNoField.setFont(new Font("Arial", Font.PLAIN, 18));
        accountNoField.addFocusListener(this);
        accountNoField.addKeyListener(this);
        loginPanel.add(accountNoField);

        password = new JLabel("Password");
        password.setBounds(400 + 20, 340 + 60, 100, 40);
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        loginPanel.add(password);


        passwordField = new JPasswordField("Enter Password");
        passwordField.setEchoChar((char) 0);
        passwordField.setBounds(500 + 20, 340 + 60, 300, 40);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.darkGray, 2, true));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
        loginPanel.add(passwordField);

        show.setIcon(eyeIcon);

        show.setBounds(810 + 20, 347 + 60, 35, 27);
        show.setToolTipText("view password");
        show.addMouseListener(this);
        loginPanel.add(signIn);
        loginPanel.add(show);
        // Go back button

        goBack = new JButton();
        img = (new ImageIcon("images/leftArrow.png")).getImage();
        newImg = img.getScaledInstance(30, 25, Image.SCALE_SMOOTH);

        goBack.setIcon(new ImageIcon(newImg));
        goBack.setBounds(10, 10, 30, 25);
        goBack.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
        goBack.setToolTipText("Go back");
        goBack.addActionListener(this);
        this.add(goBack);


        passwordField.addFocusListener(this);
        signIn.addActionListener(this);
        this.add(loginPanel);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == signIn ) {

            boolean found= false;
            if (accountNoField.getText().equals("Enter Account #")) {
                JOptionPane.showMessageDialog(null, "Enter Account #", "Incomplete", JOptionPane.ERROR_MESSAGE);
            } else if (String.copyValueOf(passwordField.getPassword()).equals("Enter Password")) {
                JOptionPane.showMessageDialog(null, "Enter Password", "Incomplete", JOptionPane.ERROR_MESSAGE);
            } else {
                File file = new File("Accounts.txt");
                Scanner read;
                String[] data = new String[11];
                try {
                    read = new Scanner(file);
                    read.useDelimiter("[,\n]");

                    if (file.exists()) {
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

                            if (accountNoField.getText().equals(data[0]))
                            {
                                found = true;
                                if( String.copyValueOf(passwordField.getPassword()).equals(data[7]))
                                {
                                    CustomerInterface.accno = data[0];
                                    CustomerInterface.name = data[1];
                                    CustomerInterface.signedInemail = data[6];
                                    CustomerInterface.balance = data[10];
                                    CustomerInterface.type = data[8];
                                    JOptionPane.showMessageDialog(null, "Signed In Successfully", "Successful", JOptionPane.INFORMATION_MESSAGE);
                                    read.close();
                                    this.dispose();
                                    new CustomerInterface();
                                    break;
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"Wrong Password","Wrong",JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                        if( !found )
                        {
                            JOptionPane.showMessageDialog(null,"Account not Found","Invalid",JOptionPane.ERROR_MESSAGE);
                            read.close();
                        }

                    }
                } catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        }
        if( e.getSource() == goBack )
        {
            this.dispose();
            new MainMenu();
            System.out.println("clicked");
        }

    }

    @Override
    public void focusGained(FocusEvent e) {

        if( e.getSource() == accountNoField )
        {
            accountNoField.setBorder(BorderFactory.createLineBorder( new Color(51,120,255),3,true));
            if( accountNoField.getText().equals("Enter Account #") )
                accountNoField.setText("");
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

        if( e.getSource() == accountNoField)
        {
            accountNoField.setBorder(BorderFactory.createLineBorder((Color.darkGray),2,false));
            if( accountNoField.getText().isEmpty() )
            {
                accountNoField.setText("Enter Account #");
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

    // used to show password
    @Override
    public void mouseReleased(MouseEvent e) {
        //passwordField.setBorder(BorderFactory.createLineBorder((Color.darkGray),2,false));
        if( !String.copyValueOf(passwordField.getPassword()).equals("Enter Password"))
            passwordField.setEchoChar('•');
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    // makes text fields number only
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
}