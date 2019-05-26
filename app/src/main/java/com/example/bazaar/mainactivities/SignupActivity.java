package com.example.bazaar.mainactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bazaar.R;
import com.example.bazaar.mainactivities.api.ApiInterfaceForUser;
import com.example.bazaar.pojos.user.LoginRequest;
import com.example.bazaar.pojos.user.ResponseFromUser;
import com.example.bazaar.pojos.user.SignUpForm;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    private EditText name;
    private EditText userName;
    private EditText eMail;
    private EditText password;
    private Button signUpBtn;

    ApiInterfaceForUser apiInterface;
    ResponseFromUser responseFromUser2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=findViewById(R.id.supEName);
        userName=findViewById(R.id.supUname);
        eMail=findViewById(R.id.supEEMail);
        password=findViewById(R.id.password_first);
        signUpBtn=findViewById(R.id.signUpBtnFirst);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(name.getText())){
                    Toast toast=Toast.makeText(SignupActivity.this,"Enter Name",Toast.LENGTH_LONG);
                    toast.show();
                }else if(TextUtils.isEmpty(userName.getText())){
                    Toast toast=Toast.makeText(SignupActivity.this,"Enter UserName",Toast.LENGTH_LONG);
                    toast.show();
                }else if(TextUtils.isEmpty(eMail.getText())){
                    Toast toast=Toast.makeText(SignupActivity.this,"Enter Email",Toast.LENGTH_LONG);
                    toast.show();
                }else if(TextUtils.isEmpty(password.getText())){
                    Toast toast=Toast.makeText(SignupActivity.this,"Enter Phone Number",Toast.LENGTH_LONG);
                    toast.show();
                }else{

                    signUp(name.getText().toString(),
                            userName.getText().toString(),
                            eMail.getText().toString(),
                            password.getText().toString());
                }
            }
        });
    }
    private void signUp(String name,String uName,String email,String password){

        SignUpForm s=new SignUpForm();
        s.setEmail(email);
        s.setName(name);
        s.setPassword(password);
        s.setUname(uName);
        getRetrofitUser retrofitObject_user=new getRetrofitUser("http://172.16.20.81:8080");

        apiInterface =retrofitObject_user.getclient().create(ApiInterfaceForUser.class);
        Call<ResponseFromUser> call2=apiInterface.signup(s);
        call2.enqueue(new Callback<ResponseFromUser>() {
            @Override
            public void onResponse(Call<ResponseFromUser> call, Response<ResponseFromUser> response) {
                responseFromUser2=response.body();
                Log.d("hii",responseFromUser2.getStatus());
            }

            @Override
            public void onFailure(Call<ResponseFromUser> call, Throwable t) {

                Log.d("failll","failure");

            }
        });



        Intent intent=new Intent(SignupActivity.this,Home.class);
        Bundle bundle=new Bundle();
        bundle.putString("Source","signup_activity");
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
