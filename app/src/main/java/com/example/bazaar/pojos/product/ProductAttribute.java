package com.example.bazaar.pojos.product;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class ProductAttribute{

	@SerializedName("color")
	private String color;

	@SerializedName("Memory")
	private String memory;

	@SerializedName("Screen")
	private String screen;

	@SerializedName("ram")
	private String ram;

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public void setMemory(String memory){
		this.memory = memory;
	}

	public String getMemory(){
		return memory;
	}

	public void setScreen(String screen){
		this.screen = screen;
	}

	public String getScreen(){
		return screen;
	}

	public void setRam(String ram){
		this.ram = ram;
	}

	public String getRam(){
		return ram;
	}

	@Override
 	public String toString(){
		return 
			"ProductAttribute{" + 
			"color = '" + color + '\'' + 
			",memory = '" + memory + '\'' + 
			",screen = '" + screen + '\'' + 
			",ram = '" + ram + '\'' + 
			"}";
		}
}