package com.company;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class Bank extends JFrame implements ActionListener {
    static Image backGroundImage;
    private static JButton loginPageButton;
    private static JLabel Welcome;
    private static ImageIcon forwardIcon;
    private static ImageIcon bIcon;
    public static DefaultTableModel tableModel; // table model for accountsData table
    public static JScrollPane scrollPane; // scrollPane of accountsData table
    public static DefaultTableModel transactionTableModel;
    public static JScrollPane transactionScrollPane;
    static String selectedCellValue;

    String[] coloumns = {"Account #","Name","Age","Gender","Phone #","Nic #","Email","Balance"};
    String[][] data= {{"","","","","","","",""}};
    String[] transactionColoumns = {"ID","Account #","Name","Amount","Time","Transaction type","Purpose"};
    String[][] transactionData = {{"","","","","","",""}};

    public static JTable accountsData;
    public static JTable transactions; // Table used for transactions
    public static MainMenu mainMenu;
    Clip clip;
    Bank() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1350,740);
        this.setLocationRelativeTo(null);
        this.setTitle("Sky Bank");
        bIcon = new ImageIcon("images/bankIcon.png");
        this.setIconImage(bIcon.getImage());

        File file = new File("IntroAudio.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();


        loginPageButton = new JButton();
        Welcome = new JLabel("Welcome to Sky Bank");

        Welcome.setBounds(400,110,600,100);
        Welcome.setFont( new Font("Times new Roman",Font.BOLD,35));
        Welcome.setHorizontalTextPosition(JLabel.CENTER);
        Welcome.setHorizontalAlignment(JLabel.CENTER);
        loginPageButton.addActionListener(this);
        //Welcome.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        accountsData = new JTable(data,coloumns)
        {
            public boolean isCellEditable(int data,int coloumns)
            {
                return false;
            }
        };

        accountsData.addMouseListener(new MouseListener() {

                                public void mouseReleased(MouseEvent e) {

                                }
                                public void mousePressed(MouseEvent e) {
                                    try {
                                        if( accountsData.getSelectedRow() >= 0 ) {
                                            selectedCellValue = (String) accountsData.getValueAt(accountsData.getSelectedRow(), 0);
                                            System.out.println(selectedCellValue);
                                        }
                                    }
                                    catch(ArrayIndexOutOfBoundsException ex)
                                    {
                                        ex.printStackTrace();
                                    }
                                }

                                public void mouseExited(MouseEvent e) {
                                }
                                public void mouseEntered(MouseEvent e) {
                                }
                                public void mouseClicked(MouseEvent e) {
                                }
                            });


        transactions = new JTable(data,coloumns)
        {
            // makes cells of table uneditable
            public boolean isCellEditable(int transactionData,int transactionColoumns)
            {
                return false;
            }
        };

        transactionTableModel = new DefaultTableModel();
        transactions.setModel(transactionTableModel);
        transactionTableModel.setColumnIdentifiers(transactionColoumns);


        // setting backGround image
        //backGroundImage = Toolkit.getDefaultToolkit().createImage("BankBackground.png");


        tableModel = new DefaultTableModel();
        accountsData.setModel(tableModel);
        tableModel.setColumnIdentifiers(coloumns);

        //accountsData.setVisible(true);
        scrollPane = new JScrollPane(accountsData);
        transactionScrollPane = new JScrollPane(transactions);


        forwardIcon = new ImageIcon("images/rightarrow.png");

        Image img = forwardIcon.getImage();
        Image newImg = img.getScaledInstance(106,70,java.awt.Image.SCALE_SMOOTH);
        forwardIcon = new ImageIcon( newImg );

        backGroundImage = new ImageIcon("images/bankImage.png").getImage();
        loginPageButton.setIcon(forwardIcon);
        loginPageButton.setBounds(600,600,110,70);
        loginPageButton.setToolTipText("Continue");
        loginPageButton.setBackground(Color.white);
        this.add(Welcome);
        this.add(loginPageButton);


        System.out.println(this.getWidth());
        System.out.println(this.getHeight());
        this.getContentPane().setBackground(Color.white);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        System.out.println(this.getWidth());
        System.out.println(this.getHeight());
        this.setVisible(true);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(backGroundImage,200,0,null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginPageButton) {
            clip.close();
            System.out.println("Button");
           mainMenu =  new MainMenu();
            this.dispose();
        }
    }

}
