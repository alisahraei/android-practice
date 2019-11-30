package com.ermile.first;

import androidx.annotation.NonNull;

public class MyContact {
    private String name;
    private String phonenumber;
    private  int id;

    public MyContact(String name, String phonenumber, int id){
        this.name = name;
        this.phonenumber = phonenumber;
        this.id = id;
    }





    public void setName(String name){
        this.name = name;
    }

    public void setPhonenumber(String phonenumber){
        this.phonenumber = phonenumber;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public  String getPhonenumber(){
        return phonenumber;
    }

    public int getId(){
        return id;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
