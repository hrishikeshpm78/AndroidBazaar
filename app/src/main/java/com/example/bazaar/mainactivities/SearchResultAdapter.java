package com.example.bazaar.mainactivities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bazaar.R;
import com.example.bazaar.pojos.product.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    List<SearchObject> list = Collections.emptyList();
    Context context;

    public SearchResultAdapter(List<SearchObject> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the layout

        View photoView = inflater.inflate(R.layout.search_item,
                viewGroup, false);

        return new SearchViewHolder(photoView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder searchViewHolder, int i) {
        searchViewHolder.pName.setText(list.get(i).getProductName());
    }

    @Override
    public int getItemCount() {
        return list.size();
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