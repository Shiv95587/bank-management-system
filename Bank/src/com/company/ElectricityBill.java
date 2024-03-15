package com.company;

import javax.xml.crypto.dsig.TransformService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ElectricityBill extends Transaction {


    ElectricityBill()
    {

    }

    ElectricityBill(String id,String accNo,String name,String timeOfTransaction,String amount)
    {
        super(id,accNo,name,timeOfTransaction,amount);
        this.purpose = "Electricity Bill";
        this.transactionType = "Withdraw";
    }

    @Override
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
        purpose = "Electricity bill";
    }

    @Override
    public void setTransactionType() {
        transactionType = "Withdraw";
    }

}
