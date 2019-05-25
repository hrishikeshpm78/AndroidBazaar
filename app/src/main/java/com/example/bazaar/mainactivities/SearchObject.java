package com.example.bazaar.mainactivities;


import android.widget.ImageView;
import android.widget.TextView;

public class SearchObject {
    private String productName;
    private ImageView productImage;

    public SearchObject(String productName, ImageView productImage) {
        this.productName = productName;
        this.productImage = productImage;
    }

    public SearchObject(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ImageView getProductImage() {
        return productImage;
    }

    public void setProductImage(ImageView productImage) {
        this.productImage = productImage;
    }
}
