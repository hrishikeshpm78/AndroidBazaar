package com.example.bazaar.pojos.product;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class Product{

	@SerializedName("subCategory")
	private String subCategory;

	@SerializedName("price")
	private int price;

	@SerializedName("imageUrl")
	private ImageUrl imageUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("rating")
	private int rating;

	@SerializedName("company")
	private String company;

	@SerializedName("mrp")
	private int mrp;

	@SerializedName("id")
	private int id;

	@SerializedName("avilable")
	private boolean avilable;

	@SerializedName("productAttribute")
	private ProductAttribute productAttribute;

	public void setSubCategory(String subCategory){
		this.subCategory = subCategory;
	}

	public String getSubCategory(){
		return subCategory;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
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

	public void setRating(int rating){
		this.rating = rating;
	}

	public int getRating(){
		return rating;
	}

	public void setCompany(String company){
		this.company = company;
	}

	public String getCompany(){
		return company;
	}

	public void setMrp(int mrp){
		this.mrp = mrp;
	}

	public int getMrp(){
		return mrp;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAvilable(boolean avilable){
		this.avilable = avilable;
	}

	public boolean isAvilable(){
		return avilable;
	}

	public void setProductAttribute(ProductAttribute productAttribute){
		this.productAttribute = productAttribute;
	}

	public Product() {
	}

	public Product(String name) {
		this.name = name;
	}

	public ProductAttribute getProductAttribute(){
		return productAttribute;
	}

	@Override
 	public String toString(){
		return 
			"Product{" + 
			"subCategory = '" + subCategory + '\'' + 
			",price = '" + price + '\'' + 
			",imageUrl = '" + imageUrl + '\'' + 
			",name = '" + name + '\'' + 
			",rating = '" + rating + '\'' + 
			",company = '" + company + '\'' + 
			",mrp = '" + mrp + '\'' + 
			",id = '" + id + '\'' + 
			",avilable = '" + avilable + '\'' + 
			",productAttribute = '" + productAttribute + '\'' + 
			"}";
		}
}