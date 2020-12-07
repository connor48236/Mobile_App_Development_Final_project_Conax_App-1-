package com.example.androiddevfinal_conaxapp.items;

import android.media.Image;

public class LocationItem {
    private String city;
    private int imageURL;
    private String address;
    private String description;

    public LocationItem(String city,int imageURL, String address, String description) {
        this.city = city;
        this.imageURL = imageURL;
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

    public int getImage() {
        return imageURL;
    }

    public void setImage(int image) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return this.city;
    }
}
