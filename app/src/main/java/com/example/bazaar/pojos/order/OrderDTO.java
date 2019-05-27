package com.example.bazaar.pojos.order;

import com.example.bazaar.pojos.cart.CartDTO;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class OrderDTO {
    @SerializedName("orderdate")
    private Date orderdate;
    @SerializedName("userid")
    private Integer userid;
    @SerializedName("emailid")
    private String emailid;
    @SerializedName("paymentoption")
    private String paymentoption;
    @SerializedName("billingaddress")
    private String billingaddress;
    @SerializedName("shippingaddress")
    private String shippingaddress;
    @SerializedName("productlist")
    private CartDTO[] productlist;
    @SerializedName("accesstoken")
    private String accesstoken;

    public String getAccesstoken() {
        return accesstoken;
    }

    public OrderDTO() {
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public OrderDTO(Date orderdate, Integer userid, String emailid, String paymentoption, String billingaddress, String shippingaddress, CartDTO[] productlist, String accesstoken) {
        this.orderdate = orderdate;
        this.userid = userid;
        this.emailid = emailid;
        this.paymentoption = paymentoption;
        this.billingaddress = billingaddress;
        this.shippingaddress = shippingaddress;
        this.productlist = productlist;
        this.accesstoken = accesstoken;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPaymentoption() {
        return paymentoption;
    }

    public void setPaymentoption(String paymentoption) {
        this.paymentoption = paymentoption;
    }

    public String getBillingaddress() {
        return billingaddress;
    }

    public void setBillingaddress(String billingaddress) {
        this.billingaddress = billingaddress;
    }

    public String getShippingaddress() {
        return shippingaddress;
    }

    public void setShippingaddress(String shippingaddress) {
        this.shippingaddress = shippingaddress;
    }

    public CartDTO[] getProductlist() {
        return productlist;
    }

    public void setProductlist(CartDTO[] productlist) {
        this.productlist = productlist;
    }
}
