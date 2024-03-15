package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WaterBill extends Transaction{


    WaterBill()
    {}

    WaterBill(String id,String accNo,String name,String timeOfTransaction,String amount)
    {
        super(id,accNo,name,timeOfTransaction,amount);
        this.purpose = "Water Bill";
        this.transactionType = "Withdraw";
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
        purpose = "Water bill";
    }

    @Override
    public void setTransactionType() {
        transactionType = "Withdraw";
    }
}
