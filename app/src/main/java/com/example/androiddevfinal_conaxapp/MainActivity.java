package com.example.androiddevfinal_conaxapp;

import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.net.URL;

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
        Drawable colour = Drawable.createFromPath(appColour);

        drawer.setBackground(colour);

        //Finds and pulls the users name
//        final String userName = preferences.getString("user_name", "user");
//
//        TextView displayUsersName = findViewById(R.id.usersName);
//
//        if (userName != null){
//            displayUsersName.setText(userName);
//        }else {
//            displayUsersName.setText("user");
//        }

        //Switch based on the item the user chooses

//        switch (appColour) {
//            case "1":
//                drawer.setBackground(null);
//                drawer.setBackground(getDrawable(R.drawable.red_app_colour));
//                System.out.println("Test");
//            case "2":
//                drawer.setBackground(null);
//                drawer.setBackground(getDrawable(R.drawable.blue_app_colour));
//                System.out.println("Test");
//            case "3":
//                drawer.setBackground(null);
//                drawer.setBackground(getDrawable(R.drawable.yellow_app_colour));
//                System.out.println("Test");
//            case "4":
//                drawer.setBackground(null);
//                drawer.setBackground(getDrawable(R.drawable.green_app_colour));
//                System.out.println("Test");
//            default:
//                drawer.setBackground(getDrawable(R.drawable.red_app_colour));
//        }
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
                R.id.homeFragment, R.id.locationsFragment, R.id.gameHost, R.id.jobsFragment, R.id.settingsFragment, R.id.creditsFragment)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //Localizes the preferences and grabs the one needed based on key
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        //Finds and pulls the colour_picker
        String appColour = preferences.getString("colour_picker", "1");

        drawer.setBackground(Drawable.createFromPath("blue_app_colour.xml"));






//        //Finds and pulls the users name
//        //final String userName = preferences.getString("user_name", "user");
//
//        //TextView displayUsersName = findViewById(R.id.usersName);
//
//        if (userName != null){
//            displayUsersName.setText(userName);
//        }else {
//            displayUsersName.setText("user");
//        }

        //Switch based on the item the user chooses

//        switch (appColour) {
//            case "1":
//                drawer.setBackground(null);
//                drawer.setBackground(getDrawable(R.drawable.red_app_colour));
//                System.out.println("Test");
//            case "2":
//                drawer.setBackground(null);
//                drawer.setBackground(getDrawable(R.drawable.blue_app_colour));
//                System.out.println("Test");
//            case "3":
//                drawer.setBackground(null);
//                drawer.setBackground(getDrawable(R.drawable.yellow_app_colour));
//                System.out.println("Test");
//            case "4":
//                drawer.setBackground(null);
//                drawer.setBackground(getDrawable(R.drawable.green_app_colour));
//                System.out.println("Test");
//            default:
//                drawer.setBackground(getDrawable(R.drawable.red_app_colour));
//        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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