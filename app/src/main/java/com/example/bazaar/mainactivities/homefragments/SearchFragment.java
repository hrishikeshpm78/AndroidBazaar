package com.example.bazaar.mainactivities.homefragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bazaar.R;
import com.example.bazaar.mainactivities.SearchObject;
import com.example.bazaar.mainactivities.SearchResultAdapter;
import com.example.bazaar.mainactivities.SortPage;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment  {
    SearchResultAdapter adapter;
    RecyclerView recyclerView;
    private Button goToSort;
    View myView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView =inflater.inflate(R.layout.search_layout,container,false);
        List<SearchObject> list = new ArrayList<>();
        list = getData();

        recyclerView =(RecyclerView) myView.findViewById(R.id.recyclerSearch);
        adapter = new SearchResultAdapter(list, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        goToSort=(Button) myView.findViewById(R.id.sr_gotoSort);
        goToSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSortPage();
            }
        });

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
