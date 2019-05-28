package com.example.bazaar.mainactivities;

import com.example.bazaar.pojos.cart.CartDTO;

public class CartObject {
    private String imgUrl;
    private String prodName;
    private int prodPrice;
    private int quantity;

    private CartDTO cartItem;

    public CartObject(String imgUrl, String prodName, int prodPrice, int quantity, CartDTO cartItem) {
        this.imgUrl = imgUrl;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.quantity = quantity;
        this.cartItem = cartItem;
    }

    public CartObject(String imgUrl, String prodName, int prodPrice, int quantity) {
        this.imgUrl = imgUrl;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.quantity = quantity;
    }

    public CartObject(CartDTO cartItem) {
        this.cartItem = cartItem;
    }

    public CartDTO getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartDTO cartItem) {
        this.cartItem = cartItem;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
