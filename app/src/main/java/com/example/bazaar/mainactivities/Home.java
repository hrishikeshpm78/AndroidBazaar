package com.example.bazaar.mainactivities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bazaar.R;
import com.example.bazaar.mainactivities.api.ApiInterfaceForUser;
import com.example.bazaar.mainactivities.homefragments.FirstFragment;
import com.example.bazaar.mainactivities.homefragments.SearchFragment;
import com.example.bazaar.mainactivities.homefragments.SecondFragment;
import com.example.bazaar.mainactivities.homefragments.ThirdFragment;
import com.example.bazaar.pojos.user.ResponseFromUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String uName;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        Bundle b = getIntent().getExtras();
        String s1 = b.getString("Source", "");
        String uname = b.getString("UserName", "");
        Log.e("HIIIII", s1);
        if (s1.equals("search")) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new SearchFragment())
                    .addToBackStack(null)
                    .commit();
        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new FirstFragment())
                    .addToBackStack(null)
                    .commit();

        }


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        ImageView cart = (ImageView) findViewById(R.id.cartimg);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CartPage.class);
                startActivity(intent);
            }
        });

        final ImageView searchButton = (ImageView) findViewById(R.id.search_button2);
        final EditText searchKey = (EditText) findViewById(R.id.search_value);
        if (searchButton != null)
            searchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String searchval = searchKey.getText().toString();
                    if (searchval != null) {
                        Log.e("search", "value not null");
                    }
                    Fragment fr = new SearchFragment();
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();

                    Bundle args = new Bundle();
                    args.putString("searchKey", searchval);
                    fr.setArguments(args);
                    ft.replace(R.id.content_frame, fr);
                    ft.commit();
                }
            });
        ((TextView) navigationView.getHeaderView(0).findViewById(R.id.nav_uName)).setText( "Hi "+uname);

    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getSupportFragmentManager().popBackStack();
        }
//        super.onBackPressed();
    }

    @Override
    protected void onResume() {

        TextView user = (TextView) findViewById(R.id.nav_uName);
        if (user != null) {
            user.setText("Hi " + MainActivity.appUser);
        }
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.aboutUs) {
            Intent intent = new Intent(Home.this, AboutUs.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.contactUs) {

            Intent intent = new Intent(Home.this, ContactUs.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (id == R.id.nav_first_layout) {
            // Handle the camera action
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new FirstFragment())
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_second_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new SecondFragment())
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_third_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new ThirdFragment())
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_my_profile) {
            if (MainActivity.isGuest == false) {
                Intent intent = new Intent(Home.this, ProfilePage.class);
                startActivity(intent);
            } else {
                Toast toast = Toast.makeText(Home.this, " Please signin/signup to access Profile Page", Toast.LENGTH_LONG);
                toast.show();
            }


        } else if (id == R.id.nav_logout) {
            SharedPreferences sharedpreferences = getSharedPreferences(MainActivity.MyPREFERENCES, 0);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.clear();
            editor.commit();

            getRetrofitUser retrofitObject_user=new getRetrofitUser("http://172.16.20.81:8080");
            ApiInterfaceForUser apiInterface =retrofitObject_user.getclient().create(ApiInterfaceForUser.class);
            Call<ResponseFromUser> call=apiInterface.logout(MainActivity.accesstoken);
            call.enqueue(new Callback<ResponseFromUser>() {
                @Override
                public void onResponse(Call<ResponseFromUser> call, Response<ResponseFromUser> response) {
                    ResponseFromUser responseFromUser=response.body();
                    Log.e("logout",responseFromUser.getStatus());
                }

                @Override
                public void onFailure(Call<ResponseFromUser> call, Throwable t) {
                    Log.e("fail_to_logout","fail logout");

                }
            });


            Intent intent = new Intent(Home.this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_my_cart) {
            Intent intent = new Intent(Home.this, CartPage.class);
            startActivity(intent);
        } else if (id == R.id.nav_my_order) {
            Intent intent = new Intent(Home.this, MyOrders.class);
            startActivity(intent);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
