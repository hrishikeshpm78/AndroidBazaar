package com.example.bazaar.pojos.cart;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class CartResponse{

	@SerializedName("payload")
	private Payload payload;

	@SerializedName("accesstoken")
	private Object accesstoken;

	@SerializedName("status")
	private String status;

	public void setPayload(Payload payload){
		this.payload = payload;
	}

	public Payload getPayload(){
		return payload;
	}

	public void setAccesstoken(Object accesstoken){
		this.accesstoken = accesstoken;
	}

	public Object getAccesstoken(){
		return accesstoken;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"CartResponse{" + 
			"payload = '" + payload + '\'' + 
			",accesstoken = '" + accesstoken + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}