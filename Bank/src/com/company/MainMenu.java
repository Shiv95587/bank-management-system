package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {
    
    private final JButton managerButton;
    private final JButton customerButton;
    private final JButton exitButton;
    private final JLabel managerLabel;
    private final JLabel customerLabel;
    private final JLabel exitLabel;
    private static Image img;
    private static Image newImg;
    Font font;

    MainMenu()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout( null );
        this.setSize(1350,740);
        this.setLocationRelativeTo(null);

        managerButton = new JButton( new ImageIcon("images/manager.png"));
        customerButton = new JButton(new ImageIcon("images/customerr.png"));
        exitButton = new JButton( new ImageIcon("images/exit.png"));
        managerButton.setBounds(150,210,240,200);
        customerButton.setBounds(550,210,240,200);
        exitButton.setBounds(950,210,240,200);

        img = new ImageIcon("images/manager.png").getImage();
        newImg = img.getScaledInstance(240,210,Image.SCALE_SMOOTH);
        managerButton.setIcon( new ImageIcon(newImg) );

        img = new ImageIcon("images/customerr.png").getImage();
        newImg = img.getScaledInstance(240,200,Image.SCALE_SMOOTH);
        customerButton.setIcon( new ImageIcon(newImg) );

        img = new ImageIcon("images/exit.png").getImage();
        newImg = img.getScaledInstance(240,200,Image.SCALE_SMOOTH);
        exitButton.setIcon( new ImageIcon(newImg) );
        // Setting borders for each button

        Border border = BorderFactory.createLineBorder(Color.BLACK,2,true);
        managerButton.setBorder( border );
        customerButton.setBorder( border );
        exitButton.setBorder( border );

        //setting backgrounds of buttons

        managerButton.setBackground(Color.WHITE);
        customerButton.setBackground(Color.white);
        exitButton.setBackground(Color.white);

        // setting fonts of buttons

        font = new Font("Arial",Font.PLAIN,20);

        managerLabel = new JLabel("Manager");
        customerLabel = new JLabel("Customer");
        exitLabel = new JLabel("Exit");
        managerLabel.setFont(font);
        customerLabel.setFont(font);
        exitLabel.setFont(font);


        managerLabel.setHorizontalTextPosition(JLabel.CENTER);
        customerLabel.setHorizontalTextPosition(JLabel.CENTER);
        exitLabel.setHorizontalTextPosition(JLabel.CENTER);

        managerLabel.setVerticalTextPosition(JLabel.CENTER);
        managerLabel.setVerticalTextPosition((JLabel.CENTER));
        managerLabel.setVerticalTextPosition(JLabel.CENTER);


        managerLabel.setBounds(230,440,90,30);
        customerLabel.setBounds(620,440,90,30);
        exitLabel.setBounds(1050,440,90,30);

    
        
        managerButton.addActionListener(this);
        customerButton.addActionListener(this);
        exitButton.addActionListener(this);
        this.add(managerButton);
        this.add(customerButton);
        this.add(exitButton);
        this.add(managerLabel);
        this.add(customerLabel);
        this.add(exitLabel);
        this.getContentPane().setBackground(Color.white);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setResizable(false);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == managerButton)
        {
            new ManagerMenu();
            this.dispose();
        }
        else if( e.getSource() == customerButton )
        {
            new CustomerLogin();
            this.dispose();
        }
        else if( e.getSource() == exitButton ) {
            byte answer = (byte) JOptionPane.showConfirmDialog(null, "Are you sure you want to close the application", "Exit", JOptionPane.YES_NO_OPTION);
            if (answer == 0) {
                System.exit(0);
            }
        }
    }
}
