package com.example.bazaar.pojos.search;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class Payload{

	@SerializedName("prodlist")
	private List<ProdlistItem> prodlist;

	public void setProdlist(List<ProdlistItem> prodlist){
		this.prodlist = prodlist;
	}

	public List<ProdlistItem> getProdlist(){
		return prodlist;
	}

	@Override
 	public String toString(){
		return 
			"Payload{" + 
			"prodlist = '" + prodlist + '\'' + 
			"}";
		}
}