package com.example.bazaar.pojos.merchant;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class MerchantResponse{

	@SerializedName("noOfProductsSold")
	private int noOfProductsSold;

	@SerializedName("price")
	private int price;

	@SerializedName("mrating")
	private double mrating;

	@SerializedName("mId")
	private int mId;

	@SerializedName("pId")
	private int pId;

	@SerializedName("mname")
	private String mname;

	@SerializedName("stock")
	private int stock;

	@SerializedName("productRating")
	private int productRating;

	public void setNoOfProductsSold(int noOfProductsSold){
		this.noOfProductsSold = noOfProductsSold;
	}

	public int getNoOfProductsSold(){
		return noOfProductsSold;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setMrating(double mrating){
		this.mrating = mrating;
	}

	public double getMrating(){
		return mrating;
	}

	public void setMId(int mId){
		this.mId = mId;
	}

	public int getMId(){
		return mId;
	}

	public void setPId(int pId){
		this.pId = pId;
	}

	public int getPId(){
		return pId;
	}

	public void setMname(String mname){
		this.mname = mname;
	}

	public String getMname(){
		return mname;
	}

	public void setStock(int stock){
		this.stock = stock;
	}

	public int getStock(){
		return stock;
	}

	public void setProductRating(int productRating){
		this.productRating = productRating;
	}

	public int getProductRating(){
		return productRating;
	}

	@Override
 	public String toString(){
		return 
			"MerchantResponse{" + 
			"noOfProductsSold = '" + noOfProductsSold + '\'' + 
			",price = '" + price + '\'' + 
			",mrating = '" + mrating + '\'' + 
			",mId = '" + mId + '\'' + 
			",pId = '" + pId + '\'' + 
			",mname = '" + mname + '\'' + 
			",stock = '" + stock + '\'' + 
			",productRating = '" + productRating + '\'' + 
			"}";
		}
}