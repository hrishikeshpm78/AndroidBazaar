package com.example.bazaar.pojos.order;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class Order{

	@SerializedName("billingaddress")
	private String billingaddress;

	@SerializedName("shipingaddress")
	private String shipingaddress;

	@SerializedName("total")
	private int total;

	@SerializedName("productid")
	private int productid;

	@SerializedName("merchantid")
	private int merchantid;

	@SerializedName("paymentoption")
	private String paymentoption;

	@SerializedName("productnumber")
	private int productnumber;

	@SerializedName("price")
	private int price;

	@SerializedName("ordernumber")
	private int ordernumber;

	@SerializedName("tax")
	private int tax;

	@SerializedName("orderdate")
	private String orderdate;

	@SerializedName("userid")
	private int userid;

	public void setBillingaddress(String billingaddress){
		this.billingaddress = billingaddress;
	}

	public String getBillingaddress(){
		return billingaddress;
	}

	public void setShipingaddress(String shipingaddress){
		this.shipingaddress = shipingaddress;
	}

	public String getShipingaddress(){
		return shipingaddress;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setProductid(int productid){
		this.productid = productid;
	}

	public int getProductid(){
		return productid;
	}

	public void setMerchantid(int merchantid){
		this.merchantid = merchantid;
	}

	public int getMerchantid(){
		return merchantid;
	}

	public void setPaymentoption(String paymentoption){
		this.paymentoption = paymentoption;
	}

	public String getPaymentoption(){
		return paymentoption;
	}

	public void setProductnumber(int productnumber){
		this.productnumber = productnumber;
	}

	public int getProductnumber(){
		return productnumber;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setOrdernumber(int ordernumber){
		this.ordernumber = ordernumber;
	}

	public int getOrdernumber(){
		return ordernumber;
	}

	public void setTax(int tax){
		this.tax = tax;
	}

	public int getTax(){
		return tax;
	}

	public void setOrderdate(String orderdate){
		this.orderdate = orderdate;
	}

	public String getOrderdate(){
		return orderdate;
	}

	public void setUserid(int userid){
		this.userid = userid;
	}

	public int getUserid(){
		return userid;
	}

	@Override
 	public String toString(){
		return 
			"Order{" + 
			"billingaddress = '" + billingaddress + '\'' + 
			",shipingaddress = '" + shipingaddress + '\'' + 
			",total = '" + total + '\'' + 
			",productid = '" + productid + '\'' + 
			",merchantid = '" + merchantid + '\'' + 
			",paymentoption = '" + paymentoption + '\'' + 
			",productnumber = '" + productnumber + '\'' + 
			",price = '" + price + '\'' + 
			",ordernumber = '" + ordernumber + '\'' + 
			",tax = '" + tax + '\'' + 
			",orderdate = '" + orderdate + '\'' + 
			",userid = '" + userid + '\'' + 
			"}";
		}
}