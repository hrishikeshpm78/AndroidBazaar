package com.example.bazaar.pojos.user;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class ProfileResponse{

	@SerializedName("payload")
	private Payload payload;

	@SerializedName("status")
	private String status;

	public void setPayload(Payload payload){
		this.payload = payload;
	}

	public Payload getPayload(){
		return payload;
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
			"ProfileResponse{" + 
			"payload = '" + payload + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}