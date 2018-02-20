package com.goo_dev.ncertsolutionsfree;


public class Confidential {
    String uname, pass;
    String id, useemail;


    public Confidential() {
    }

    public Confidential(String id, String uname, String pass, String useemail) {
        this.uname = uname;
        this.pass = pass;
        this.id = id;
        this.useemail = useemail;

    }

    public String getUname() {
        return uname;
    }

    public String getPass() {
        return pass;
    }

    public String getId() {
        return id;
    }

    public String getUseemail() {
        return useemail;
    }

}