package com.example.bazaar.pojos.user;

import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class ResponseFromUser{

    @SerializedName("data")
    private Object data;

    @SerializedName("status")
    private String status;

    public void setData(Object data){
        this.data = data;
    }

    public Object getData(){
        return data;
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
                        "data = '" + data + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
