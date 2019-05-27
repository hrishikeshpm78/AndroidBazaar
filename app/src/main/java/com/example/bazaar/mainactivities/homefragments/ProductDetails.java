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
    ApiInterfaceMerchant apiInterfaceMerchant;
    Product product;
    List<MerchantResponse> merchantResponse;
    ArrayList<String> productDetails = new ArrayList<String>();
    ArrayList<String> merchant = new ArrayList<String>();
    String pid;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView =inflater.inflate(R.layout.product_details,container,false);
        return myView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        pid = getArguments().getString("PID");



        Api apiMerchant=new Api("http://172.16.20.24:8080");
        apiInterfaceMerchant=apiMerchant.getclient().create(ApiInterfaceMerchant.class);
        Call<List<MerchantResponse>> callMerchant=apiInterfaceMerchant.getOrder(Integer.parseInt(pid));
        Log.e("PID:::",pid);
        callMerchant.enqueue(new Callback<List<MerchantResponse>>() {
            LinearLayout merchLayout = (LinearLayout) myView.findViewById(R.id.pd_merchants);
            @Override
            public void onResponse(Call<List<MerchantResponse>> callMerchant, Response<List<MerchantResponse>> response) {
                merchantResponse=response.body();
                Log.e("mer",merchantResponse.get(0).toString());
//                Log.e("mer",merchantResponse.get(1).toString());
                ListIterator<MerchantResponse> merchantIterator = merchantResponse.listIterator();

                for(MerchantResponse merchresp:merchantResponse)
                {
                    System.out.println(merchresp.getPrice());
                    merchant.add(merchresp.getMname()+" Rs-"+merchresp.getPrice());
                }


                for (String text :
                        merchant) {
                    TextView textView = new TextView(getContext());
                    textView.setText(text);
                    textView.setTextSize(30);
                    textView.setGravity(View.TEXT_ALIGNMENT_CENTER);

                    merchLayout.addView(textView);
                }
            }

            @Override
            public void onFailure(Call<List<MerchantResponse>> callMerchant, Throwable t) {
                Log.e("server_merchant","failure");
            }
        });

        Api api=new Api("http://172.16.20.53:8080");
        apiInterface=api.getclient().create(ApiInterfaceProduct.class);
        Call<Product> call=apiInterface.getProduct(pid);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                product = response.body();

                Map<String,String> productAttributes;
                Set<String> keySet= product.getProductAttribute().keySet();
                for(Object key:keySet)
                {
                    productDetails.add(key+"   "+product.getProductAttribute().get(key));
                }

                Log.d("productafjiad", productDetails.toString());

                final TextView P1=(TextView) myView.findViewById(R.id.pd_name);
                final TextView P2=(TextView) myView.findViewById(R.id.pd_category);
                final TextView P3=(TextView) myView.findViewById(R.id.pd_price);
                final TextView P4=(TextView) myView.findViewById(R.id.pd_rating);
                final ImageView Img=(ImageView) myView.findViewById(R.id.pd_image);
                P1.setText(product.getName());
                P2.setText("Company -"+product.getCompany());
                P3.setText("Rating -"+Double.toString(product.getRating()));
                P4.setText("Category-"+product.getSubCategory());
                Glide.with(Img.getContext())
                        .load(product.getImageUrl().getJsonMember1())
                        .into(Img);

                LinearLayout attrLayout = (LinearLayout) myView.findViewById(R.id.pd_attributes);



                Log.d("detailofproduct",productDetails.toString());
                for (String text : productDetails) {
                    TextView textView = new TextView(getContext());
                    textView.setText(text);
                    textView.setTextSize(30);
                    Log.d("afojfklajds",text);

                    textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
                    attrLayout.addView(textView);
                }


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





        super.onViewCreated(view, savedInstanceState);
    }

    private void buyNow() {
        //add the item to cart and go to cart page
        Intent intent = new Intent(getContext(), CartPage.class);
        startActivity(intent);
    }

    private void addToCart() {
        // integrate with  cart here.
        CartDTO cart1=new CartDTO();
        cart1.setUserId(0);
        cart1.setProductname(product.getName());
        cart1.setProductId(Integer.parseInt(pid));
        cart1.setImgurl(product.getImageUrl().toString());
        cart1.setAccesstoken(MainActivity.accesstoken);
        cart1.setQuantity(1);
        cart1.setMerchantId(merchantResponse.get(0).getMId());
        cart1.setPrice(merchantResponse.get(0).getPrice());

        Call<CartResponse> call=MainActivity.apiInterface.addToCart(cart1);
        call.enqueue(new Callback<CartResponse>() {
            @Override
            public void onResponse(Call<CartResponse> call, Response<CartResponse> response) {
                CartResponse response2=response.body();
                Log.e("add_to_cart",response2.getStatus());
            }

            @Override
            public void onFailure(Call<CartResponse> call, Throwable t) {

            }
        });


        Toast toast = Toast.makeText(getContext(), " item added to cart", Toast.LENGTH_LONG);
        toast.show();
    }
}