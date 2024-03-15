package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Other extends Transaction{

    // used to store all other transactions except utility bills transactions
    Other()
    {}

    Other(String id,String accNo,String name,String timeOfTransaction,String amount,String tType)
    {
        super(id,accNo,name,timeOfTransaction,amount);
        this.purpose = "Other";
        this.transactionType = tType;
    }

    public void transactionToFile() {
        try {
            FileWriter fw = new FileWriter("Transactions.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.flush();
            PrintWriter writer = new PrintWriter(bw);
            writer.println(this.getId() + "," + this.getAccNo() + "," + this.getName() + "," + this.getAmount() + "," + this.getTimeOfTransaction() + "," + this.getTransactionType()
                    + "," + this.getPurpose());
            writer.flush();
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void setPurpose() {
        purpose = "Other";
    }

    @Override
    public void setTransactionType() {

    }

    public void setTransactionType(String type)
    {
        this.transactionType = type;
    }
    
}
