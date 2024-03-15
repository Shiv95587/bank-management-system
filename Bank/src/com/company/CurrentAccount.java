package com.company;

import java.io.IOException;

public class CurrentAccount extends Account{
    private static int  transactionFee;

    CurrentAccount() throws IOException
    {
        super();
        setType();
        CurrentAccount.transactionFee = 20;
    }

     CurrentAccount(String f,String l,String u,String p,String password,String e,String n,String a,String gender,Double b) throws IOException {
        super(f,l,u,p,password,e,n,a,gender,b); // calling super class constructor;
    }
    public static void setType() {
        type = "Current Account";
    }
    public static String getType()
    {
        return type;
    }

    //    public void setTransactionFee()
//    {
//        transactionFee = 20;
//    }
//    public int getTransactionFee()
//    {
//        return transactionFee;
//    }
}
