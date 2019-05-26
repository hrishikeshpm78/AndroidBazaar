package com.example.bazaar.mainactivities;

import android.content.Intent;
import android.content.SharedPreferences;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private Button signInButton;
    private Button signUpButton;
    private EditText userName,password;
    private Button skipButton;
    public static final String MyPREFERENCES = "MyPrefs" ;

    public static ApiInterfaceForUser apiInterface;
    ResponseFromUser responseFromUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        signInButton=(Button) findViewById(R.id.signInBtn);
        signUpButton=(Button) findViewById(R.id.signUpBtn);
        userName=(EditText) findViewById(R.id.userName);
        password=(EditText) findViewById(R.id.password);
        skipButton=(Button) findViewById(R.id.skipBtn);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(userName.getText())){
                    Toast toast=Toast.makeText(MainActivity.this,"Enter Username",Toast.LENGTH_LONG);
                    toast.show();
                }else if(TextUtils.isEmpty(password.getText())){
                    Toast toast=Toast.makeText(MainActivity.this,"Enter password",Toast.LENGTH_LONG);
                    toast.show();
                }else{
                    signInUser(userName.getText().toString(),password.getText().toString());
                }
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Home.class);
                Bundle bundle=new Bundle();
                bundle.putString("Source","main_activity");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private void signInUser(String uName, String upass) {
        //fetch user details
        sharedPreferences = getSharedPreferences(MyPREFERENCES,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isSignedIn",true);
        editor.apply();


        LoginRequest l=new LoginRequest();
        l.setUname(uName);
        l.setPassword(upass);
        getRetrofitUser retrofitObject_user=new getRetrofitUser("http://172.16.20.81:8080");
        apiInterface =retrofitObject_user.getclient().create(ApiInterfaceForUser.class);
        Call<ResponseFromUser> call3=apiInterface.login(l);

        call3.enqueue(new Callback<ResponseFromUser>() {
            @Override
            public void onResponse(Call<ResponseFromUser> call, Response<ResponseFromUser> response) {

                responseFromUser=response.body();
                Log.e("hii",responseFromUser.getStatus());
                if(responseFromUser.getStatus().equals("success")){
                    Intent intent = new Intent(MainActivity.this, Home.class);
                    if(userName!=null){
                        intent.putExtra("UserName",R.id.userName);
                    }
                    startActivity(intent);
                }else{
                    Toast toast=Toast.makeText(MainActivity.this,"Wrong credentials",Toast.LENGTH_LONG);
                    toast.show();
                }
            }

            @Override
            public void onFailure(Call<ResponseFromUser> call, Throwable t) {
                Log.e("failll","failure");
                Toast toast=Toast.makeText(MainActivity.this,"Server not responding",Toast.LENGTH_LONG);
                toast.show();
            }
        });



    }

}
