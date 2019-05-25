package com.example.bazaar.pojos.product;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

//@Generated("com.robohorse.robopojogenerator")
public class Product{

	@SerializedName("subCategory")
	private String subCategory;

	@SerializedName("productId")
	private String productId;

	@SerializedName("imageUrl")
	private ImageUrl imageUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("rating")
	private double rating;

	@SerializedName("company")
	private String company;

	@SerializedName("availability")
	private boolean availability;

	@SerializedName("productAttribute")
	private Map<String,String> productAttribute;

	public void setSubCategory(String subCategory){
		this.subCategory = subCategory;
	}

	public String getSubCategory(){
		return subCategory;
	}

	public void setProductId(String productId){
		this.productId = productId;
	}

	public String getProductId(){
		return productId;
	}

	public void setImageUrl(ImageUrl imageUrl){
		this.imageUrl = imageUrl;
	}

	public ImageUrl getImageUrl(){
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

	public void setAvailability(boolean availability){
		this.availability = availability;
	}

	public boolean isAvailability(){
		return availability;
	}

	public void setProductAttribute(Map<String,String> productAttribute){
		this.productAttribute = productAttribute;
	}

	public Map<String, String> getProductAttribute(){
		return productAttribute;
	}

	public Product(String name) {
		this.name = name;
	}

	@Override
	public String toString(){
		return
				"Product{" +
						"subCategory = '" + subCategory + '\'' +
						",productId = '" + productId + '\'' +
						",imageUrl = '" + imageUrl + '\'' +
						",name = '" + name + '\'' +
						",rating = '" + rating + '\'' +
						",company = '" + company + '\'' +
						",availability = '" + availability + '\'' +
						",productAttribute = '" + productAttribute + '\'' +
						"}";
	}
}