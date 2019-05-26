package com.example.bazaar.pojos.user;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class Payload{

	@SerializedName("userInfo")
	private UserInfo userInfo;

	@SerializedName("addressList")
	private List<Object> addressList;

	@SerializedName("orderHistory")
	private List<Object> orderHistory;

	public void setUserInfo(UserInfo userInfo){
		this.userInfo = userInfo;
	}

	public UserInfo getUserInfo(){
		return userInfo;
	}

	public void setAddressList(List<Object> addressList){
		this.addressList = addressList;
	}

	public List<Object> getAddressList(){
		return addressList;
	}

	public void setOrderHistory(List<Object> orderHistory){
		this.orderHistory = orderHistory;
	}

	public List<Object> getOrderHistory(){
		return orderHistory;
	}

	@Override
 	public String toString(){
		return 
			"Payload{" + 
			"userInfo = '" + userInfo + '\'' + 
			",addressList = '" + addressList + '\'' + 
			",orderHistory = '" + orderHistory + '\'' + 
			"}";
		}
}