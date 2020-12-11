package com.example.androiddevfinal_conaxapp;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    public void onResume() {
        super.onResume();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        //Localizes the preferences and grabs the one needed based on key
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        //Finds and pulls the colour_picker
        String appColour = preferences.getString("colour_picker", "red_app_colour");
        String colour = appColour;

        //gets the id of the drawable
        int drawId = this.getResources().getIdentifier(colour, "drawable", this.getPackageName());
        //sets the background of drawer to drawId
        drawer.setBackground(getDrawable(drawId));


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment, R.id.locationsFragment, R.id.gameHost, R.id.jobsFragment, R.id.creditsFragment)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

//        //Localizes the preferences and grabs the one needed based on key
//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//
//        //Checks for mailing list sub
//        final Boolean mailingList = preferences.getBoolean("subToMailingList", false);
//        Boolean checkIfInMailingList = mailingList;
//
//        if (checkIfInMailingList.equals(true)){
//            Snackbar.make(getCurrentFocus(),"You have subscribed to the mailing list", Snackbar.LENGTH_LONG).show();
//        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        //Localizes the preferences and grabs the one needed based on key
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        //Finds and pulls the users name
        final String userName = preferences.getString("user_name", "user");
        String nameOfUser = userName;


        TextView displayUsersName = findViewById(R.id.usersName);
        displayUsersName.setText(nameOfUser);

        //Finds and pulls the users image
        String usersImage = preferences.getString("ImageOfUser", "ic_baseline_tag_faces_24");
        String stringOfUsersImage = usersImage;

        //Gets the id of the image entered
        int imgId = this.getResources().getIdentifier(stringOfUsersImage, "drawable", this.getPackageName());

        //Grabs the placement for the users image
        ImageView imageUser = findViewById(R.id.usersImage);
        imageUser.setImageResource(imgId);

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings){
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}