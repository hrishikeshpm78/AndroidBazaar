package com.example.bazaar.mainactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bazaar.R;
import com.example.bazaar.pojos.user.Payload;
import com.example.bazaar.pojos.user.ProfileResponse;
import com.example.bazaar.pojos.user.UserInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckoutPage extends AppCompatActivity {
    Button checkoutBtn;
    EditText checkoutAddress;
    EditText emailfield;
    EditText name;
    EditText phone;
    int tlPrice;
    TextView checkoutPrice;
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
        name=(EditText) findViewById(R.id.checkoutName);
        phone=(EditText) findViewById(R.id.checkoutMobile);
        checkoutBtn=(Button)findViewById(R.id.checkOutButton);

        final String email=emailfield.getText().toString();
        tlPrice=Integer.parseInt(getIntent().getExtras().getString("tl_price"));

        checkoutPrice=(TextView) findViewById(R.id.priceCheckout);
        checkoutPrice.setText(Integer.toString(tlPrice));


        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(name.getText())||TextUtils.isEmpty(emailfield.getText())||TextUtils.isEmpty(phone.getText())   ){
                    Toast toast=Toast.makeText(CheckoutPage.this,"Enter all details",Toast.LENGTH_LONG);
                    toast.show();
                }else{
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

            }
        });
        Call<ProfileResponse> call3=MainActivity.apiInterface.profile(MainActivity.accesstoken);

        call3.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                ProfileResponse responseFromUser;
                responseFromUser=response.body();
                Log.e("auto_fill", responseFromUser.getStatus());
                Payload p=responseFromUser.getPayload();
                UserInfo u= p.getUserInfo();
                checkoutAddress.setText(p.getAddressList().get(0).toString());
                name.setText(u.getName());
                phone.setText(u.getPhoneno().toString());
                emailfield.setText(u.getEmail());

            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Log.e("failll","failure");
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
