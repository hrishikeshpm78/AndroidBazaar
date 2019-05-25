package com.example.bazaar.mainactivities;

import android.widget.ImageView;

public class OrderObject {
    private ImageView image;
    private String pName;
    private double price;
    private String date;
    private String paymentOption;

    public OrderObject(String pName, double price, String date, String paymentOption) {
        this.pName = pName;
        this.price = price;
        this.date = date;
        this.paymentOption = paymentOption;
    }

    public OrderObject(ImageView image, String pName, double price, String date, String paymentOption) {
        this.image = image;
        this.pName = pName;
        this.price = price;
        this.date = date;
        this.paymentOption = paymentOption;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(String paymentOption) {
        this.paymentOption = paymentOption;
    }
}
