package com.company;

public abstract class Person {

    private String firstName;
    private String lastName;
    private String userName;
    private String phoneNo;
    private String nicNo;
    private String gender;
    private String address;

    Person()
    {
        firstName = "";
        lastName = "";
        userName = "";
        phoneNo = "";
        nicNo = "";
        gender = "";
        address = "";
    }

    Person(String f, String l, String u, String p, String n, String g, String a)
    {
        this.firstName = f;
        this.lastName = l;
        this.address = a;
        this.userName = u;
        this.phoneNo = p;
        this.nicNo = n;
        this.gender = g;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
