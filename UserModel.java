package com.example.registrationapp;

public class UserModel {
    private String name;
    private String dob;
    private String email;

    public UserModel() {}

    public UserModel(String name, String dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
