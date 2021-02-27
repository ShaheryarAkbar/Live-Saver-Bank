package com.example.lifesaverbank1;

public class Model {
    String name, fname, contact, address, bgroup;
//
//    public Model(String name, String fname, String contact, String address, String bgroup) {
//        this.name = name;
//        this.fname = fname;
//        this.contact = contact;
//        this.address = address;
//        this.bgroup = bgroup;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBgroup() {
        return bgroup;
    }

    public void setBgroup(String bgroup) {
        this.bgroup = bgroup;
    }
}
