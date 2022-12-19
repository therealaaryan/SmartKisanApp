package com.example.smartkisanapp;

public class UserHelperClass {

    String name,age,address,username,phoneno,password,confirmpass;

    public UserHelperClass()
    {}

    public UserHelperClass(String name, String age, String address, String username, String phoneno, String password, String confirmpass) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.username = username;
        this.phoneno = phoneno;
        this.password = password;
        this.confirmpass = confirmpass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = username;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpass() {
        return confirmpass;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }
}
