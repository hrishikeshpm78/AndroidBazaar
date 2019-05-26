package com.example.bazaar.pojos.user;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class UserInfo{

	@SerializedName("uid")
	private int uid;

	@SerializedName("password")
	private String password;

	@SerializedName("uname")
	private String uname;

	@SerializedName("name")
	private String name;

	@SerializedName("email")
	private String email;

	@SerializedName("phoneno")
	private Object phoneno;

	public void setUid(int uid){
		this.uid = uid;
	}

	public int getUid(){
		return uid;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
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

	public void setPhoneno(Object phoneno){
		this.phoneno = phoneno;
	}

	public Object getPhoneno(){
		return phoneno;
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
			",phoneno = '" + phoneno + '\'' + 
			"}";
		}
}