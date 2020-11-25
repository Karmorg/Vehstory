package com.example.demo;

public class Client {
    private String name;
    private String eMail;


    public Client(String name, String eMail) {
        this.name = name;
        this.eMail = eMail;
            }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
