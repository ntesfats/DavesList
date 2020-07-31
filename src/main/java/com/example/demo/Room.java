package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private boolean isRented;

    private String address;

    private String city;

    private String state;

    private double price;



//    Details
    private String description;

    private String rules;

    private String cable;

    private boolean wifi;

    private boolean privateBathroom;

    public Room() {}

    public Room(boolean isRented, String address, String city, String state, double price,
                String description, String rules, String cable, boolean wifi, boolean privateBathroom) {
        this.isRented = isRented;
        this.address = address;
        this.city = city;
        this.state = state;
        this.price = price;
        this.description = description;
        this.rules = rules;
        this.cable = cable;
        this.wifi = wifi;
        this.privateBathroom = privateBathroom;
    }

    public long getId() { return id;}

    public void setId(long id) {this.id = id;}

    public boolean getIsRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getCable() {
        return cable;
    }

    public void setCable(String cable) {
        this.cable = cable;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isPrivateBathroom() {
        return privateBathroom;
    }

    public void setPrivateBathroom(boolean privateBathroom) {
        this.privateBathroom = privateBathroom;
    }
    //        address, city, state, price, description, rules, wifi (yes/no), cable (none/basic/premium), private bathroom (yes/no).

}
