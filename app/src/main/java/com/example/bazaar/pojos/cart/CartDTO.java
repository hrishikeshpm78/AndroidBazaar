package com.example.bazaar.pojos.cart;

import com.google.gson.annotations.SerializedName;

public class CartDTO {

    @SerializedName("imgurl")
    private String imgurl;

    @SerializedName("quantity")
    private int quantity;

    @SerializedName("productId")
    private int productId;

    @SerializedName("merchantId")
    private int merchantId;

    @SerializedName("price")
    private int price;

    @SerializedName("productname")
    private String productname;

    @SerializedName("userId")
    private int userId;

    @SerializedName("accesstoken")
    private Object accesstoken;

    public Object getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(Object accesstoken) {
        this.accesstoken = accesstoken;
    }

    public void setImgurl(String imgurl){
        this.imgurl = imgurl;
    }

    public String getImgurl(){
        return imgurl;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setProductId(int productId){
        this.productId = productId;
    }

    public int getProductId(){
        return productId;
    }

    public void setMerchantId(int merchantId){
        this.merchantId = merchantId;
    }

    public int getMerchantId(){
        return merchantId;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public void setProductname(String productname){
        this.productname = productname;
    }

    public String getProductname(){
        return productname;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public int getUserId(){
        return userId;
    }

    @Override
    public String toString(){
        return
                "ListItem{" +
                        "imgurl = '" + imgurl + '\'' +
                        ",quantity = '" + quantity + '\'' +
                        ",productId = '" + productId + '\'' +
                        ",merchantId = '" + merchantId + '\'' +
                        ",price = '" + price + '\'' +
                        ",productname = '" + productname + '\'' +
                        ",userId = '" + userId + '\'' +
                        "}";
    }
}
