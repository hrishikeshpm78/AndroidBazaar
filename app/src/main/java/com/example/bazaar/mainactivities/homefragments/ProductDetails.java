package com.example.bazaar.mainactivities.homefragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.bazaar.R;
import com.example.bazaar.mainactivities.CartPage;
import com.example.bazaar.mainactivities.MainActivity;
import com.example.bazaar.mainactivities.api.Api;
import com.example.bazaar.mainactivities.api.ApiInterfaceMerchant;
import com.example.bazaar.mainactivities.api.ApiInterfaceProduct;
import com.example.bazaar.pojos.cart.CartDTO;
import com.example.bazaar.pojos.cart.CartResponse;
import com.example.bazaar.pojos.merchant.MerchantResponse;
import com.example.bazaar.pojos.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetails extends Fragment {
    View myView;
    private Button addToCartBtn;
    private Button buyNowBtn;
    ApiInterfaceProduct apiInterface;
    Product product;
    private CartResponse cartResponse;
    private ApiInterfaceMerchant apiInterfaceMerchant;
    private List<MerchantResponse> merchantResponse;
    private TextView pdPrice;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView =inflater.inflate(R.layout.product_details,container,false);
        String pid = getArguments().getString("PID");

        Api apiMerchant=new Api("http:172.16.20.24:8080");
        apiInterfaceMerchant=apiMerchant.getclient().create(ApiInterfaceMerchant.class);
        Call<List<MerchantResponse>> callMerchant=apiInterfaceMerchant.getOrder(5);
        callMerchant.enqueue(new Callback<List<MerchantResponse>>() {
            @Override
            public void onResponse(Call<List<MerchantResponse>> callMerchant, Response<List<MerchantResponse>> response) {
                merchantResponse=response.body();
                Log.e("mer",merchantResponse.get(0).toString());


            }

            @Override
            public void onFailure(Call<List<MerchantResponse>> callMerchant, Throwable t) {

            }
        });

        Api api=new Api("http:172.16.20.53:8080");
        apiInterface=api.getclient().create(ApiInterfaceProduct.class);
        Call<Product> call=apiInterface.getProduct(pid);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                product = response.body();
                System.out.println(product);
                ArrayList<String> productDetails = new ArrayList<String>();
                ArrayList<String> merchant = new ArrayList<String>();
                Map<String,String> productAttributes;
                Set<String> keySet= product.getProductAttribute().keySet();
                for(Object key:keySet)
                {
                    productDetails.add("->"+key+":"+product.getProductAttribute().get(key));
                }
                final TextView P1=(TextView) myView.findViewById(R.id.pd_name);
                final TextView P2=(TextView) myView.findViewById(R.id.pd_category);
                final TextView P3=(TextView) myView.findViewById(R.id.pd_price);
                final TextView P4=(TextView) myView.findViewById(R.id.pd_rating);
                final ImageView Img=(ImageView) myView.findViewById(R.id.pd_image);

                P1.setText(product.getName());
                P2.setText(product.getCompany());
                int Price=merchantResponse.get(0).getPrice();
                P3.setText(product.getSubCategory());
                P4.setText(Double.toString(product.getRating()));


                Glide.with(Img.getContext())
                        .load(product.getImageUrl().getJsonMember1())
                        .into(Img);
                LinearLayout attrLayout = (LinearLayout) myView.findViewById(R.id.pd_attributes);
                LinearLayout merchLayout = (LinearLayout) myView.findViewById(R.id.pd_merchants);

                for (String text :
                        productDetails) {
                    TextView textView = new TextView(getContext());
                    textView.setText(text);
                    textView.setTextSize(30);
                    //   textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    attrLayout.addView(textView);
                }
//                for (String text :
//                        productDetails) {
//                    TextView textView = new TextView(getContext());
//                    textView.setText(text);
//                    textView.setTextSize(30);
//                    textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
//
//                    merchLayout.addView(textView);
//                }

                addToCartBtn = (Button) myView.findViewById(R.id.pd_addToCart);
                buyNowBtn = (Button) myView.findViewById(R.id.pd_buyNow);

                addToCartBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addToCart();
                    }
                });
                buyNowBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buyNow();
                    }
                });
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Log.e("fail","failure", t);

            }
        });

        return myView;
    }

    private void buyNow() {
        //add the item to cart and go to cart page
        Intent intent = new Intent(getContext(), CartPage.class);
        startActivity(intent);
    }

    private void addToCart() {
        CartDTO cart=new CartDTO();
        cart.setAccesstoken(MainActivity.accesstoken);
        cart.setImgurl("hsbahsacasxa");
        cart.setMerchantId(123);
        cart.setPrice(2222);
        cart.setProductId(12);
        cart.setProductname("apex");
        cart.setUserId(111);

        Call<CartResponse> call=MainActivity.apiInterface.addToCart(cart);
        call.enqueue(new Callback<CartResponse>() {
            @Override
            public void onResponse(Call<CartResponse> call, Response<CartResponse> response) {
                cartResponse=response.body();
                Log.e("cart received",cartResponse.getStatus());
            }

            @Override
            public void onFailure(Call<CartResponse> call, Throwable t) {

            }
        });

        Toast toast = Toast.makeText(getContext(), " item added to cart", Toast.LENGTH_LONG);
        toast.show();
    }
}

