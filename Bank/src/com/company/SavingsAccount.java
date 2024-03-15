package com.company;

import java.io.IOException;

public class SavingsAccount extends Account {
    private static final float rate = 2.0f;
    private static int fee;
    private static float interest;

    SavingsAccount() throws IOException {
        super();
        SavingsAccount.fee = 10;
    }

    SavingsAccount(String f,String l,String u,String p,String password,String e,String n,String a,String gender,Double b) throws IOException {
       super(f,l,u,p,password,e,n,a,gender,b); // calling super class constructor;
    }

    public static void setType() {
        type = "Savings Account";
    }
    public static String getType()
    {
        return type;
    }


    public float calculateInterest()
    {
        interest = (float) (super.getBalance() * (rate / 100.0f));
        return (interest);
    }
    public static void setTransactionFee()
    {
        SavingsAccount.fee = 10;
    }
    public static int getTransactionFee() {
    return fee;
    }
}
