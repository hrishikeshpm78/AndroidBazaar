package com.example.bazaar.mainactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.bazaar.R;
import com.example.bazaar.mainactivities.api.ApiInterfaceForUser;
import com.example.bazaar.pojos.user.Payload;
import com.example.bazaar.pojos.user.ProfileResponse;
import com.example.bazaar.pojos.user.UserInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilePage extends AppCompatActivity {
    private TextView uName;
    private TextView Name;
    private TextView email;
    private TextView homeAddress;
    private TextView workAddress;
    private TextView phoneNumber;
    private TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        logout=(TextView)findViewById(R.id.up_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProfilePage.this,MainActivity.class);
                startActivity(intent);
            }
        });
        apiCallForProfile();

    }

    private void apiCallForProfile() {
        Call<ProfileResponse> call3=MainActivity.apiInterface.profile(MainActivity.accesstoken);

        uName=(TextView) findViewById(R.id.up_uname);
        Name=(TextView)findViewById(R.id.up_name);
        email=(TextView)findViewById(R.id.up_email);
        homeAddress=(TextView)findViewById(R.id.up_homeAddress);
        workAddress=(TextView)findViewById(R.id.up_workAddress);
        phoneNumber=(TextView)findViewById(R.id.up_phoneNumber);

        call3.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                ProfileResponse responseFromUser;
                responseFromUser=response.body();
                Log.e("hii", responseFromUser.getStatus());
                Payload p=responseFromUser.getPayload();
                UserInfo u= p.getUserInfo();
                uName.setText(u.getUname());
                Name.setText(u.getName());
                email.setText(u.getEmail());
                if(!p.getAddressList().isEmpty()) {
                    if (p.getAddressList().get(0) != null) {
                        homeAddress.setText(p.getAddressList().get(0).toString());
                    }
                    if (p.getAddressList().get(1) != null) {
                        workAddress.setText(p.getAddressList().get(1).toString());
                    }
                    if (u.getPhoneno() != null) {
                        phoneNumber.setText(u.getPhoneno().toString());
                    }
                }

            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Log.e("failll","failure");
            }
        });
    }
}
