package com.example.smartkisanapp;

public class cowhelperclass {

    String cowtype,name,age,milk,medicalinfo,ownernumber;

    public cowhelperclass(){

    }

    public cowhelperclass(String cowtype, String name, String age, String milk, String medicalinfo, String ownernumber) {
        this.cowtype = cowtype;
        this.name = name;
        this.age = age;
        this.milk = milk;
        this.medicalinfo = medicalinfo;
        this.ownernumber= ownernumber;
    }

    public String getCowtype() {
        return cowtype;
    }

    public void setCowtype(String cowtype) {
        this.cowtype = cowtype;
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

    public String getMilk() {
        return milk;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    public String getMedicalinfo() {
        return medicalinfo;
    }

    public void setMedicalinfo(String medicalinfo) {
        this.medicalinfo = medicalinfo;
    }
}
