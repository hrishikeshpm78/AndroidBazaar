package com.example.bazaar.mainactivities;


import android.widget.ImageView;
import android.widget.TextView;

public class SearchObject {
    private String productName;
    private String productImage;
    private String category;

    public SearchObject(String productName, String productImage) {
        this.productName = productName;
        this.productImage = productImage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public SearchObject(String productName, String productImage, String category) {
        this.productName = productName;
        this.productImage = productImage;
        this.category = category;
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

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
