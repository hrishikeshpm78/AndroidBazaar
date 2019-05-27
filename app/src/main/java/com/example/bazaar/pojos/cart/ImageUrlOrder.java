package com.example.bazaar.pojos.cart;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class ImageUrlOrder {

	@SerializedName("1")
	private String jsonMember1;

	@SerializedName("2")
	private String jsonMember2;

	public void setJsonMember1(String jsonMember1){
		this.jsonMember1 = jsonMember1;
	}

	public String getJsonMember1(){
		return jsonMember1;
	}

	public void setJsonMember2(String jsonMember2){
		this.jsonMember2 = jsonMember2;
	}

	public String getJsonMember2(){
		return jsonMember2;
	}

	@Override
	public String toString(){
		return
				"ImageUrl{" +
						"1 = '" + jsonMember1 + '\'' +
						",2 = '" + jsonMember2 + '\'' +
						"}";
	}
}