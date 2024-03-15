package com.company;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Account extends Person {

    private final long accountNo;
    private String email;
    private Double balance;
    private String password;
    protected static String type;
    private static int count = 0;
    Account() throws IOException {
        super();
        accountNo = 1000 + getCount();
        password = "";
        email = "";
        balance = 0.0;
    }

    Account(String f,String l,String u,String p,String password,String e,String n,String a,String gender,Double b) throws IOException {
        super(f,l,u,p,n,gender,a); // calling super class constructor;
        accountNo = 1000 + getCount();
        this.password = password;
        this.email = e;
        this.balance = b;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getCount() throws IOException{

        FileReader fr = new FileReader("NumberOfAccounts.txt");
        Scanner reader = new Scanner(fr);

        count = Integer.parseInt(reader.next());
        reader.close();
        return count;
    }

    public static void calculateCount() throws IOException {
        FileReader read = new FileReader("C:\\Users\\ROOPCHANDANI  22\\Bank\\NumberOfAccounts.txt");
        Scanner reader = new Scanner(read);
        count = Integer.parseInt(reader.next());
        System.out.println("Value of Count = " + count);
        reader.close();

        FileWriter fw = new FileWriter("C:\\Users\\ROOPCHANDANI  22\\Bank\\NumberOfAccounts.txt");
        BufferedWriter bw = new BufferedWriter( fw );
        PrintWriter writer = new PrintWriter( bw );
        writer.println(count + 1);
        writer.flush();
        writer.close();
    }

    public static void decrementCount()
    {
        --count;
    }


    public long getAccountNo() {
        return accountNo;
    }


    @Override
    protected void finalize()
    {

    }
}
