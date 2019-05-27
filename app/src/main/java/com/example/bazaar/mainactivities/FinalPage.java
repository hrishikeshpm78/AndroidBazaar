package com.example.bazaar.mainactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bazaar.R;
import com.example.bazaar.mainactivities.api.ApiInterfaceForUser;
import com.example.bazaar.pojos.cart.CartDTO;
import com.example.bazaar.pojos.cart.CartResponse;
import com.example.bazaar.pojos.cart.ListItem;
import com.example.bazaar.pojos.cart.Payload;
import com.example.bazaar.pojos.order.OrderDTO;
import com.example.bazaar.pojos.user.ResponseFromUser;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinalPage extends AppCompatActivity {


    private Button button;
    private CartResponse cartResponse;
    int totalprice=0;
    Payload payload;
    List<ListItem> list;
    List<CartDTO> cartItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);
        button=findViewById(R.id.continueShopping);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FinalPage.this,Home.class);
                Bundle bundle=new Bundle();
                bundle.putString("Source","finalpage");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        Call<CartResponse> call2=MainActivity.apiInterface.getCart(MainActivity.accesstoken);
        call2.enqueue(new Callback<CartResponse>() {
            @Override
            public void onResponse(Call<CartResponse> call2, Response<CartResponse> response) {
                cartResponse=response.body();
                payload=cartResponse.getPayload();

                String response2=cartResponse.getStatus();
                if(response2.equals("success")){
                    list=payload.getList();
                }
            }

            @Override
            public void onFailure(Call<CartResponse> call, Throwable t) {
                Log.e("status","connection failure");
            }
        });

        cartItems=new ArrayList<CartDTO>();
        for (ListItem item:list) {
            cartItems.add(new CartDTO(item.getImgurl(),
                    item.getQuantity(),
                    item.getProductId(),
                    item.getMerchantId(),
                    item.getPrice(),
                    item.getProductname(),
                    item.getUserId(),
                    MainActivity.accesstoken));
        }


        OrderDTO order=new OrderDTO();
       // SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        order.setOrderdate(null);
        order.setUserid(0002);
        Bundle b = getIntent().getExtras();
        String email=b.getString("email");
        String address=b.getString("address");
        order.setEmailid(email);
        order.setPaymentoption("COD");
        order.setBillingaddress(address);
        order.setShippingaddress(address);
        order.setAccesstoken(MainActivity.accesstoken);

        CartDTO[] cart11=new CartDTO[cartItems.size()];
        cart11=(CartDTO[]) cartItems.toArray();

        order.setProductlist(cart11);
        Call<ResponseFromUser> call=MainActivity.apiInterface.buyNow(order);
        call.enqueue(new Callback<ResponseFromUser>() {
            @Override
            public void onResponse(Call<ResponseFromUser> call, Response<ResponseFromUser> response) {
                ResponseFromUser responseFromUser=response.body();
                Log.e("resp_user",responseFromUser.getStatus());
            }

            @Override
            public void onFailure(Call<ResponseFromUser> call, Throwable t) {

            }
        });
    }
}
