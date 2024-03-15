package com.company;

public class HomeLoan {
    private String city;
    private String address;
    private String ownerName;

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public String toString() {
        return "HomeLoan{}";
    }
}
