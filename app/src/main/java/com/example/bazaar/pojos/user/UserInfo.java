package com.example.bazaar.pojos.user;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class UserInfo{

	@SerializedName("uid")
	private Object uid;

	@SerializedName("password")
	private Object password;

	@SerializedName("uname")
	private String uname;

	@SerializedName("name")
	private String name;

	@SerializedName("email")
	private String email;

	public void setUid(Object uid){
		this.uid = uid;
	}

	public Object getUid(){
		return uid;
	}

	public void setPassword(Object password){
		this.password = password;
	}

	public Object getPassword(){
		return password;
	}

	public void setUname(String uname){
		this.uname = uname;
	}

	public String getUname(){
		return uname;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"UserInfo{" + 
			"uid = '" + uid + '\'' + 
			",password = '" + password + '\'' + 
			",uname = '" + uname + '\'' + 
			",name = '" + name + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}