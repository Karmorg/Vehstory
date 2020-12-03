package com.example.demo;

public class Client {
    private String name;
    private String eMail;
    private String password;

    public Client(String name, String eMail, String password) {
        this.name = name;
        this.eMail = eMail;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public Client setName(String name) {
        this.name = name;
        return this;
    }

    public String geteMail() {
        return eMail;
    }

    public Client seteMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Client setPassword(String password) {
        this.password = password;
        return this;
    }
}
