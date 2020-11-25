package com.example.androiddevfinal_conaxapp;

public class LocationItem {
    private String city;
    private String address;
    private String description;

    public LocationItem(String city, String address, String description) {
        this.city = city;
        this.address = address;
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.city;
    }
}
