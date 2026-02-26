package com.example.banqueproject.entity;

public class Users {

    private int id;
    private String email;
    private String name;
    private String address;
    private String zip;
    private String city;
    private String tel;
    private String password;

    // Constructor with id
    public Users(int id, String email, String name, String address, String zip, String city, String tel, String password){
        this.id = id;
        this.email = email;
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.tel = tel;
        this.password = password;
    }

    // Constructor without id
    public Users(String email, String name, String address, String zip, String city, String tel, String password){
        this.email = email;
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.tel = tel;
        this.password = password;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip){
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}