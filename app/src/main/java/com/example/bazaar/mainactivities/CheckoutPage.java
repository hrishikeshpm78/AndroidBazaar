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
    EditText checkoutAddress;
    EditText emailfield;
    int tlPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_page);
//        Spinner mySpinner= (Spinner)findViewById(R.id.spinner1);
//        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(CheckoutPage.this,
//                R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.addresses));
//        myAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        mySpinner.setAdapter(myAdapter);

        checkoutAddress =(EditText) findViewById(R.id.checkoutAddress);
        emailfield=(EditText) findViewById(R.id.checkoutEmail);
        final String email=emailfield.getText().toString();
        tlPrice=Integer.parseInt(getIntent().getExtras().getString("tl_price"));


        checkoutBtn=(Button)findViewById(R.id.checkOutButton);
        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CheckoutPage.this,FinalPage.class);
                EditText email=(EditText) findViewById(R.id.checkoutEmail);
                EditText address=(EditText)findViewById(R.id.checkoutAddress);
                String emailText=email.getText().toString();
                String addressText=address.getText().toString();
                intent.putExtra("email",emailText);
                intent.putExtra("address",addressText);
                //intent.putExtra("mailfield",email);
                startActivity(intent);
            }
        });

    }
}
