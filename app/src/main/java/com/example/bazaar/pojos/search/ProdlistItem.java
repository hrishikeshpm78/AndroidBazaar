package com.example.bazaar.pojos.search;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

//@Generated("com.robohorse.robopojogenerator")
public class ProdlistItem{

	@SerializedName("subCategory")
	private String subCategory;

	@SerializedName("imageUrl")
	private HashMap<String,String> imageUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("rating")
	private double rating;

	@SerializedName("company")
	private String company;

	@SerializedName("id")
	private int id;

	@SerializedName("availability")
	private boolean availability;

	@SerializedName("productAttribute")
	private HashMap<String,String> productAttribute;

	public void setSubCategory(String subCategory){
		this.subCategory = subCategory;
	}

	public String getSubCategory(){
		return subCategory;
	}

	public void setImageUrl(HashMap<String,String> imageUrl){
		this.imageUrl = imageUrl;
	}

	public HashMap<String,String> getImageUrl(){
		return imageUrl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setRating(double rating){
		this.rating = rating;
	}

	public double getRating(){
		return rating;
	}

	public void setCompany(String company){
		this.company = company;
	}

	public String getCompany(){
		return company;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAvailability(boolean availability){
		this.availability = availability;
	}

	public boolean isAvailability(){
		return availability;
	}

	public void setProductAttribute(HashMap<String,String> productAttribute){
		this.productAttribute = productAttribute;
	}

	public HashMap<String,String> getProductAttribute(){
		return productAttribute;
	}

	@Override
 	public String toString(){
		return 
			"ProdlistItem{" + 
			"subCategory = '" + subCategory + '\'' + 
			",imageUrl = '" + imageUrl + '\'' + 
			",name = '" + name + '\'' + 
			",rating = '" + rating + '\'' + 
			",company = '" + company + '\'' + 
			",id = '" + id + '\'' + 
			",availability = '" + availability + '\'' + 
			",productAttribute = '" + productAttribute + '\'' + 
			"}";
		}
}