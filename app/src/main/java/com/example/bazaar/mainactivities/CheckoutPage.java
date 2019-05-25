package com.example.bazaar.mainactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.bazaar.R;

public class CheckoutPage extends AppCompatActivity {
    Button checkoutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_page);
        Spinner mySpinner= (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(CheckoutPage.this,
                R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.addresses));
        myAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        EditText emailfield=(EditText) findViewById(R.id.checkoutEmail);
        final String email=emailfield.getText().toString();

        checkoutBtn=(Button)findViewById(R.id.checkOutButton);
        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CheckoutPage.this,FinalPage.class);
                intent.putExtra("mailfield",email);
                startActivity(intent);
            }
        });

    }
}
