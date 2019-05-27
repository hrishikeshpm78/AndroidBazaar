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
import com.example.bazaar.pojos.cart.CartDTO;
import com.example.bazaar.pojos.cart.CartResponse;
import com.example.bazaar.pojos.cart.ListItem;
import com.example.bazaar.pojos.cart.Payload;
import com.example.bazaar.pojos.product.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartPage extends AppCompatActivity {
    private Button button;
    CartPageAdapter adapter;
    RecyclerView recyclerView;
    private CartResponse cartResponse;
    int tlprice=0;
    Payload payload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_page);
        button=findViewById(R.id.buyNow);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(CartPage.this, CheckoutPage.class);
                intent.putExtra("tl_price",Integer.toString(tlprice));
                startActivity(intent);
            }
        });


        Call<CartResponse> call=MainActivity.apiInterface.getCart(MainActivity.accesstoken);
        call.enqueue(new Callback<CartResponse>() {
            @Override
            public void onResponse(Call<CartResponse> call, Response<CartResponse> response) {
                cartResponse=response.body();
                payload=cartResponse.getPayload();

                String response2=cartResponse.getStatus();
                if(response2.equals("success")){

                    List<CartObject> cartItems = new ArrayList<CartObject>();
                    List<ListItem> list=payload.getList();
                    for (ListItem item:list) {
                        int price=item.getPrice();
                        tlprice+=price;
                        int quantity=item.getQuantity();
                        String prodName=item.getProductname();
                        String imageUrl=item.getImgurl();
                        Log.e("imgurl",imageUrl);
                        CartObject cart=new CartObject(imageUrl,prodName,price,quantity);
                        cartItems.add(cart);

                    }
                    TextView tlPrice=(TextView) findViewById(R.id.price);
                    Log.e("price",Integer.toString(tlprice));
                    tlPrice.setText(Integer.toString(tlprice));
                    recyclerView = (RecyclerView)findViewById(R.id.recyclerCart);
                    adapter = new CartPageAdapter(cartItems, getApplication());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(CartPage.this));
                }
            }

            @Override
            public void onFailure(Call<CartResponse> call, Throwable t) {
                Log.e("status","connection failure");
            }
        });



    }
//    private List<Product> getData()
//    {
//        List<Product> list = new ArrayList<>();
//        Product p=new Product("hihihihihihihih");
//        list.add(p);
//        list.add(p);
//        list.add(p);
//        list.add(p);
//        list.add(p);
//        list.add(p);
//        return list;
//    }
}
