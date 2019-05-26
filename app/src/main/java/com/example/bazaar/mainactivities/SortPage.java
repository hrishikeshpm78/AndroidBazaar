package com.example.bazaar.mainactivities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bazaar.R;
import com.example.bazaar.mainactivities.homefragments.SearchFragment;

public class SortPage extends AppCompatActivity {
    private Button applyChanges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_page);
        final FragmentManager fragmentManager2 = getSupportFragmentManager();
        applyChanges=(Button) findViewById(R.id.applyChanges);
        applyChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent=new Intent(SortPage.this, Home.class);
                Bundle bundle=new Bundle();
                bundle.putString("Source","search");
                intent.putExtras(bundle);
                startActivity(intent);

//                fragmentManager2.beginTransaction()
//                        .replace(R.id.content_frame, new SearchFragment())
//                        .commit();
            }
        });

    }
}
