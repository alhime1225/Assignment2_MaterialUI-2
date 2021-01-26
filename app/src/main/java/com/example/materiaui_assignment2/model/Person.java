package com.example.materiaui_assignment2.model;

import android.widget.AutoCompleteTextView;

import androidx.lifecycle.LiveData;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.materiaui_assignment2.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

//Room framework
@Entity
public class Person {
    @PrimaryKey(autoGenerate = true)
    private int uid;
    private String name;
    private String phone;
    private String area;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String birthday;

    public Person(){}

    @Ignore
    public Person(String name, String phone, String area, String address, String city, String state, String zip, String email, String birthday) {
        this.name = name;
        this.phone = phone;
        this.area = area;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.birthday = birthday;
    }
    @Ignore
    public Person(int uid, String name, String phone, String area, String address, String city, String state, String zip, String email, String birthday) {
        this.uid = uid;
        this.name = name;
        this.phone = phone;
        this.area = area;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.birthday = birthday;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


//    @Override
//    public String toString() {
//        return name;
//    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
