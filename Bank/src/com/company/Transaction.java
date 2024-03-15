package com.company;

public abstract class Transaction {
    private String Id;
    private String accNo;
    private String name;
    private String timeOfTransaction;
    private String amount;
    protected String transactionType; // Deposit or withdrawal
    protected String purpose;


    Transaction()
    {

    }

    Transaction(String id,String accNo,String name,String timeOfTransaction,String amount)
    {
        this.Id = id;
        this.accNo = accNo;
        this.name = name;
        this.timeOfTransaction = timeOfTransaction;
        this.amount = amount;
    }


    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getId() {
        return Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTimeOfTransaction(String timeOfTransaction) {
        this.timeOfTransaction = timeOfTransaction;
    }

    public String getTimeOfTransaction() {
        return timeOfTransaction;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public abstract void setPurpose();
    public abstract void setTransactionType();
    public abstract void transactionToFile();

    public String getTransactionType() {
        return transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "Id='" + Id + '\'' +
                ", accNo='" + accNo + '\'' +
                ", name='" + name + '\'' +
                ", timeOfTransaction='" + timeOfTransaction + '\'' +
                ", amount='" + amount + '\'' +
                ", purpose='" + purpose + '\'' +
                '}';
    }

    public String getPurpose() {
        return purpose;
    }
}
