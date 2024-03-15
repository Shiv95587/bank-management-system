package com.company;

public abstract class Loan {


    private long principalAmount;
    static private float rateOfInterest;
    private int noOfYears;

    public void setPrincipalAmount(long principalAmount) {
        this.principalAmount = principalAmount;
    }

    public long getPrincipalAmount() {
        return principalAmount;
    }

    public static float getRateOfInterest() {
        return rateOfInterest;
    }

    public static void setRateOfInterest(float rateOfInterest) {
        Loan.rateOfInterest = rateOfInterest;
    }

    public void setNoOfYears(int noOfYears) {
        this.noOfYears = noOfYears;
    }

    public int getNoOfYears() {
        return noOfYears;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "principalAmount=" + principalAmount +
                ", noOfYears=" + noOfYears +
                '}';
    }
}
