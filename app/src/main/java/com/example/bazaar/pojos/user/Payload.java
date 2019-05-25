package com.example.bazaar.pojos.user;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorseorse.robopojogenerator")
public class Payload{

	@SerializedName("userInfo")
	private UserInfo userInfo;

	@SerializedName("orderHistory")
	private List<OrderHistoryItem> orderHistory;

	public void setUserInfo(UserInfo userInfo){
		this.userInfo = userInfo;
	}

	public UserInfo getUserInfo(){
		return userInfo;
	}

	public void setOrderHistory(List<OrderHistoryItem> orderHistory){
		this.orderHistory = orderHistory;
	}

	public List<OrderHistoryItem> getOrderHistory(){
		return orderHistory;
	}

	@Override
 	public String toString(){
		return 
			"Payload{" + 
			"userInfo = '" + userInfo + '\'' + 
			",orderHistory = '" + orderHistory + '\'' + 
			"}";
		}
}