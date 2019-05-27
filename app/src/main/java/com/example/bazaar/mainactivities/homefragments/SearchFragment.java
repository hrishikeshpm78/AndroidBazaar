package com.example.bazaar.mainactivities.homefragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bazaar.R;
import com.example.bazaar.mainactivities.SearchObject;
import com.example.bazaar.mainactivities.SearchResultAdapter;
import com.example.bazaar.mainactivities.SortPage;
import com.example.bazaar.mainactivities.api.ApiInterfaceForSearch;
import com.example.bazaar.mainactivities.getRetrofitUser;
import com.example.bazaar.pojos.search.Payload;
import com.example.bazaar.pojos.search.ProdlistItem;
import com.example.bazaar.pojos.search.SearchResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment  {
    SearchResultAdapter adapter;
    RecyclerView recyclerView;
    private Button goToSort;
    private String searchKey;
    View myView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView =inflater.inflate(R.layout.search_layout,container,false);

        searchKey = getArguments().getString("searchKey");
        Log.e("search",searchKey);
        getRetrofitUser retrofitUser=new getRetrofitUser("http://172.16.20.70:8080");
        ApiInterfaceForSearch apiInterfaceForSearch=retrofitUser.getclient().create(ApiInterfaceForSearch.class);
        if(searchKey!=null) {
            Call<SearchResponse> call = apiInterfaceForSearch.getProducts(searchKey);
            call.enqueue(new Callback<SearchResponse>() {
                @Override
                public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                    SearchResponse searchResponseObject;

                    searchResponseObject = response.body();
                    Log.e("searchresponse", searchResponseObject.getStatus());
                    Payload payload = searchResponseObject.getPayload();

                    String status =searchResponseObject.getStatus();


                    if(status.equals("success")) {
                        List<ProdlistItem> productList = payload.getProdlist();
//                        Log.e("searchresponse", productList.get(0).toString());

                        List<SearchObject> list = new ArrayList<>();
                        for (ProdlistItem product : productList) {
                            String pName = product.getName();
                            String category = product.getSubCategory();
                            String imageUrl = product.getImageUrl().get("1");
//                            String pName = product.getName();
                            Log.e("imageeeeee",imageUrl);
                            SearchObject object = new SearchObject(pName,imageUrl,category);
                            list.add(object);
                        }


                        recyclerView = (RecyclerView) myView.findViewById(R.id.recyclerSearch);
                        adapter = new SearchResultAdapter(list, getContext());
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                        goToSort = (Button) myView.findViewById(R.id.sr_gotoSort);
                        goToSort.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                goToSortPage();
                            }
                        });
                    }


                }

                @Override
                public void onFailure(Call<SearchResponse> call, Throwable t) {
                    Log.e("searchresponse", "Connection failure");
                }
            });

        }


        return myView;
    }


    private void goToSortPage() {

        Intent intent=new Intent(getContext(), SortPage.class);
        startActivity(intent);
    }

    private List<SearchObject> getData()
    {
        List<SearchObject> list = new ArrayList<>();
        SearchObject p=new SearchObject("hihihihihihihih");
        list.add(p);
        list.add(p);
        list.add(p);
        list.add(p);
        list.add(p);
        list.add(p);
        return list;
    }
}
