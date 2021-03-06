package com.example.bazaar.pojos.user;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class ResponseFromUser{

	@SerializedName("payload")
	private Payload payload;

	@SerializedName("accesstoken")
	private String accesstoken;

	@SerializedName("status")
	private String status;

	public void setPayload(Payload payload){
		this.payload = payload;
	}

	public Payload getPayload(){
		return payload;
	}

	public void setAccesstoken(String accesstoken){
		this.accesstoken = accesstoken;
	}

	public String getAccesstoken(){
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
			"ResponseFromUser{" + 
			"payload = '" + payload + '\'' + 
			",accesstoken = '" + accesstoken + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}