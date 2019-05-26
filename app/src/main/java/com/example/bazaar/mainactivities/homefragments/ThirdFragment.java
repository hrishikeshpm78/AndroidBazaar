package com.example.bazaar.mainactivities.homefragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bazaar.R;
import com.example.bazaar.mainactivities.api.Api;
import com.example.bazaar.mainactivities.api.ApiInterfaceProduct;
import com.example.bazaar.pojos.product.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThirdFragment extends Fragment  {
    ApiInterfaceProduct apiInterface;
    List<Product> products;
    View myView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView =inflater.inflate(R.layout.third_layout,container,false);
        final TextView P1=(TextView) myView.findViewById(R.id.p13);
        final TextView P2=(TextView) myView.findViewById(R.id.p23);
        final TextView P3=(TextView) myView.findViewById(R.id.p33);
        final TextView P4=(TextView) myView.findViewById(R.id.p43);
        final TextView P5=(TextView) myView.findViewById(R.id.p53);
        final TextView P6=(TextView) myView.findViewById(R.id.p63);
        final TextView P7=(TextView) myView.findViewById(R.id.p73);
        final TextView P8=(TextView) myView.findViewById(R.id.p83);
        final TextView P9=(TextView) myView.findViewById(R.id.p93);
        final TextView P10=(TextView) myView.findViewById(R.id.p103);
        final TextView P11=(TextView) myView.findViewById(R.id.p113);
        final TextView P12=(TextView) myView.findViewById(R.id.p123);
        final TextView P13=(TextView) myView.findViewById(R.id.p133);
        final TextView P14=(TextView) myView.findViewById(R.id.p143);
        final TextView P15=(TextView) myView.findViewById(R.id.p153);

        final TextView P1c=(TextView) myView.findViewById(R.id.p1c3);
        final TextView P2c=(TextView) myView.findViewById(R.id.p2c3);
        final TextView P3c=(TextView) myView.findViewById(R.id.p3c3);
        final TextView P4c=(TextView) myView.findViewById(R.id.p4c3);
        final TextView P5c=(TextView) myView.findViewById(R.id.p5c3);
        final TextView P6c=(TextView) myView.findViewById(R.id.p6c3);
        final TextView P7c=(TextView) myView.findViewById(R.id.p7c3);
        final TextView P8c=(TextView) myView.findViewById(R.id.p8c3);
        final TextView P9c=(TextView) myView.findViewById(R.id.p9c3);
        final TextView P10c=(TextView) myView.findViewById(R.id.p10c3);
        final TextView P11c=(TextView) myView.findViewById(R.id.p11c3);
        final TextView P12c=(TextView) myView.findViewById(R.id.p12c3);
        final TextView P13c=(TextView) myView.findViewById(R.id.p133);
        final TextView P14c=(TextView) myView.findViewById(R.id.p14c3);
        final TextView P15c=(TextView) myView.findViewById(R.id.p15c3);

        final ImageView Img1=(ImageView) myView.findViewById(R.id.img13);
        final ImageView Img2=(ImageView) myView.findViewById(R.id.img23);
        final ImageView Img3=(ImageView) myView.findViewById(R.id.img33);
        final ImageView Img4=(ImageView) myView.findViewById(R.id.img43);
        final ImageView Img5=(ImageView) myView.findViewById(R.id.img53);
        final ImageView Img6=(ImageView) myView.findViewById(R.id.img63);
        final ImageView Img7=(ImageView) myView.findViewById(R.id.img73);
        final ImageView Img8=(ImageView) myView.findViewById(R.id.img83);
        final ImageView Img9=(ImageView) myView.findViewById(R.id.img93);
        final ImageView Img10=(ImageView) myView.findViewById(R.id.img103);
        final ImageView Img11=(ImageView) myView.findViewById(R.id.img113);
        final ImageView Img12=(ImageView) myView.findViewById(R.id.img123);
        final ImageView Img13=(ImageView) myView.findViewById(R.id.img133);
        final ImageView Img14=(ImageView) myView.findViewById(R.id.img143);
        final ImageView Img15=(ImageView) myView.findViewById(R.id.img153);
        Api api=new Api("http:172.16.20.53:8080");
        apiInterface=api.getclient().create(ApiInterfaceProduct.class);
        Call<List<Product>> call=apiInterface.getSubcategoryfaishon();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                products= response.body();
                System.out.println(products);

                ////Log.e("hii",products.get(0).getName());


                P1.setText(products.get(0).getName());
                P2.setText(products.get(1).getName());
                P3.setText(products.get(2).getName());
                P4.setText(products.get(3).getName());
                P5.setText(products.get(4).getName());
                P6.setText(products.get(5).getName());
                P7.setText(products.get(6).getName());
                P8.setText(products.get(7).getName());
                P9.setText(products.get(8).getName());
                P10.setText(products.get(9).getName());
                P11.setText(products.get(10).getName());
                P12.setText(products.get(11).getName());
                P13.setText(products.get(12).getName());
                P14.setText(products.get(13).getName());
                P15.setText(products.get(14).getName());

                P1c.setText(products.get(0).getCompany());
                P2c.setText(products.get(1).getCompany());
                P3c.setText(products.get(2).getCompany());
                P4c.setText(products.get(3).getCompany());
                P5c.setText(products.get(4).getCompany());
                P6c.setText(products.get(5).getCompany());
                P7c.setText(products.get(6).getCompany());
                P8c.setText(products.get(7).getCompany());
                P9c.setText(products.get(8).getCompany());
                P10c.setText(products.get(9).getCompany());
                P11c.setText(products.get(10).getCompany());
                P12c.setText(products.get(11).getCompany());
                P13c.setText(products.get(12).getCompany());
                P14c.setText(products.get(13).getCompany());
                P15c.setText(products.get(14).getCompany());

                Glide.with(Img1.getContext())
                        .load(products.get(0).getImageUrl().getJsonMember1())
                        .into(Img1);
                Glide.with(Img2.getContext())
                        .load(products.get(1).getImageUrl().getJsonMember1())
                        .into(Img2);
                Glide.with(Img3.getContext())
                        .load(products.get(2).getImageUrl().getJsonMember1())
                        .into(Img3);
                Glide.with(Img4.getContext())
                        .load(products.get(3).getImageUrl().getJsonMember1())
                        .into(Img4);
                Glide.with(Img5.getContext())
                        .load(products.get(4).getImageUrl().getJsonMember1())
                        .into(Img5);
                Glide.with(Img6.getContext())
                        .load(products.get(5).getImageUrl().getJsonMember1())
                        .into(Img6);
                Glide.with(Img7.getContext())
                        .load(products.get(6).getImageUrl().getJsonMember1())
                        .into(Img7);
                Glide.with(Img8.getContext())
                        .load(products.get(7).getImageUrl().getJsonMember1())
                        .into(Img8);
                Glide.with(Img9.getContext())
                        .load(products.get(8).getImageUrl().getJsonMember1())
                        .into(Img9);
                Glide.with(Img10.getContext())
                        .load(products.get(9).getImageUrl().getJsonMember1())
                        .into(Img10);
                Glide.with(Img11.getContext())
                        .load(products.get(10).getImageUrl().getJsonMember1())
                        .into(Img11);
                Glide.with(Img12.getContext())
                        .load(products.get(11).getImageUrl().getJsonMember1())
                        .into(Img12);
                Glide.with(Img13.getContext())
                        .load(products.get(12).getImageUrl().getJsonMember1())
                        .into(Img13);
                Glide.with(Img14.getContext())
                        .load(products.get(13).getImageUrl().getJsonMember1())
                        .into(Img14);
                Glide.with(Img15.getContext())
                        .load(products.get(14).getImageUrl().getJsonMember1())
                        .into(Img15);

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e("fail","failure", t);

            }
        });
        return myView;
    }
}
