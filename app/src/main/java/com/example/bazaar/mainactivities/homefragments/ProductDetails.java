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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView =inflater.inflate(R.layout.product_details,container,false);
        return myView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        String pid = getArguments().getString("PID");

        Api api=new Api("http:172.16.20.53:8080");
        apiInterface=api.getclient().create(ApiInterfaceProduct.class);
        Call<Product> call=apiInterface.getProduct(pid);
        Api apiMerchant=new Api("http:172.16.20.24:8080");
        apiInterfaceMerchant=apiMerchant.getclient().create(ApiInterfaceMerchant.class);
        Call<List<MerchantResponse>> callMerchant=apiInterfaceMerchant.getOrder(5);
        callMerchant.enqueue(new Callback<List<MerchantResponse>>() {
            @Override
            public void onResponse(Call<List<MerchantResponse>> callMerchant, Response<List<MerchantResponse>> response) {
                merchantResponse=response.body();
                Log.e("mer",merchantResponse.get(0).toString());
                ListIterator<MerchantResponse> merchantIterator = merchantResponse.listIterator();
                while (merchantIterator.hasNext()){
                    merchant.add(merchantIterator.next().getMname());
                }

                System.out.println(merchant);
            }

            @Override
            public void onFailure(Call<List<MerchantResponse>> callMerchant, Throwable t) {

            }
        });
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                product = response.body();




                productDetails.add(product.getName());
                productDetails.add(product.getCompany());
                productDetails.add(product.getSubCategory());
                productDetails.add(Double.toString(product.getRating()));
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
                P2.setText(product.getCompany());
                P3.setText(Double.toString(product.getRating()));
                P4.setText(product.getSubCategory());
                Glide.with(Img.getContext())
                        .load(product.getImageUrl().getJsonMember1())
                        .into(Img);






                LinearLayout attrLayout = (LinearLayout) myView.findViewById(R.id.pd_attributes);
                LinearLayout merchLayout = (LinearLayout) myView.findViewById(R.id.pd_merchants);


                Log.d("detailofproduct",productDetails.toString());
                for (String text : productDetails) {
                    TextView textView = new TextView(getContext());
                    textView.setText(text);
                    textView.setTextSize(30);
                    Log.d("afojfklajds",text);

                    //textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    merchLayout.addView(textView);
                }

                for (String text :
                        merchant) {
                    TextView textView = new TextView(getContext());
                    textView.setText(text);
                    textView.setTextSize(30);
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
        Toast toast = Toast.makeText(getContext(), " item added to cart", Toast.LENGTH_LONG);
        toast.show();
    }
}