package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.Bank.mainMenu;

public class ManagerMenu extends JFrame implements ActionListener {

    private final JButton signUp;
    private final JButton Login;
    private final JButton Back;

    static Image img;
    static Image newImg;
    ManagerMenu()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout( null );
        this.setSize(1350,700);
        this.setLocationRelativeTo(null);

        signUp = new JButton();
        Login = new JButton();
        Back = new JButton();

        signUp.setBounds(150,200,250,200);
        Login.setBounds(550,200,250,200);
        Back.setBounds(950,200,250,200);


        // setting image icons for buttons


        ImageIcon signUpIcon = new ImageIcon("images/signup.png");
        ImageIcon loginIcon = new ImageIcon("images/signin.png");
        ImageIcon backIcon = new ImageIcon("images/back.png");

        // Setting borders for each button

        Border border = BorderFactory.createLineBorder(Color.BLACK,2,true);
        signUp.setBorder( border );
        Login.setBorder( border );
        Back.setBorder( border );
        Back.setToolTipText("Go Back");

        //setting backgrounds of buttons

//        signUp.setBackground(Color.white);
//        Login.setBackground(Color.white);
//        Back.setBackground(Color.white);

        // setting fonts of buttons

        img = signUpIcon.getImage();
        newImg = img.getScaledInstance(250,230,Image.SCALE_SMOOTH);
        signUp.setIcon( new ImageIcon(newImg) );

        img = loginIcon.getImage();
        newImg = img.getScaledInstance(250,200,Image.SCALE_SMOOTH);
        Login.setIcon( new ImageIcon(newImg) );

        img = backIcon.getImage();
        newImg = img.getScaledInstance(250,220,Image.SCALE_SMOOTH);
        Back.setIcon( new ImageIcon(newImg) );



        signUp.addActionListener(this);
        Login.addActionListener(this);
        Back.addActionListener(this);

        this.getContentPane().setBackground(Color.white);
        this.add(signUp);
        this.add(Login);
        this.add(Back);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if( e.getSource() == signUp )
        {
            new Register();
            this.dispose();
        }
        else if( e.getSource() == Login )
        {
            new login();
            this.dispose();
        }
        else if( e.getSource() == Back )
        {
            this.dispose();
            mainMenu.setVisible(true);
        }

    }
}