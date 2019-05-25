package com.example.bazaar.mainactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bazaar.R;
import com.example.bazaar.pojos.user.Payload;
import com.example.bazaar.pojos.user.ProfileResponse;
import com.example.bazaar.pojos.user.ResponseFromUser;
import com.example.bazaar.pojos.user.UserInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.bazaar.mainactivities.MainActivity.apiInterface;

public class ProfilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        Call<ProfileResponse> call3=apiInterface.profile();

        call3.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                ProfileResponse responseFromUser;
                responseFromUser=response.body();
                Log.e("hii", responseFromUser.getStatus());
                Payload p=responseFromUser.getPayload();
              UserInfo u= p.getUserInfo();
              Log.e("hii",u.getName());
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Log.e("failll","failure");
            }
        });
    }
}
