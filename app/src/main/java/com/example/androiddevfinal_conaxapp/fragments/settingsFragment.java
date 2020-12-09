package com.example.androiddevfinal_conaxapp.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.androiddevfinal_conaxapp.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link settingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class settingsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public settingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment settingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static settingsFragment newInstance(String param1, String param2) {
        settingsFragment fragment = new settingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         final View view = inflater.inflate(R.layout.fragment_settings, container, false);
         //Localizes the seek bar to change the size of text
        SeekBar textSizeBar = view.findViewById(R.id.fontSizeBar);

        //All the textView for smallText text
        final TextView seekBarText = view.findViewById(R.id.Font_Size_Text);
        final TextView aboutText = view.findViewById(R.id.aboutText);
        final TextView descriptionOfLocationText = view.findViewById(R.id.Description);
        final TextView jobDescText = view.findViewById(R.id.jobDesc);
        final TextView jobReqText = view.findViewById(R.id.jobReq);



        textSizeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarText.setTextSize(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                aboutText.setTextSize(seekBar.getScrollBarSize());
                descriptionOfLocationText.setTextSize(seekBar.getScrollBarSize());
                jobDescText.setTextSize(seekBar.getScrollBarSize());
                jobReqText.setTextSize(seekBar.getScrollBarSize());
            }
        });

        //Localizes the buttons to change the app colour
        Button redButton = view.findViewById(R.id.RedButton);
        Button blueButton = view.findViewById(R.id.BlueButton);
        Button yellowButton = view.findViewById(R.id.YellowButton);
        Button greenButton = view.findViewById(R.id.GreenButton);

        //grabs all the background to change
        final LinearLayout navLinerLayout = view.findViewById(R.id.nav_liner_layout);
        final NavigationView navigationView = view.findViewById(R.id.nav_view);
        final AppBarLayout appBarLayout = view.findViewById(R.id.appBarLayout);

        //When the red button is pressed
        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sets the backgrounds to the red_app_colour.xml
                navLinerLayout.setBackgroundColor(R.drawable.red_app_colour);
                navigationView.setBackgroundColor(R.drawable.red_app_colour);
                appBarLayout.setBackgroundColor(R.drawable.red_app_colour);
            }
        });

        //When the blue button is pressed
        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sets the backgrounds to the blue_app_colour.xml
                navLinerLayout.setBackgroundColor(R.drawable.blue_app_colour);
                navigationView.setBackgroundColor(R.drawable.blue_app_colour);
                appBarLayout.setBackgroundColor(R.drawable.blue_app_colour);
            }
        });

        //When the yellow button is pressed
        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sets the backgrounds to the yellow_app_colour.xml
                navLinerLayout.setBackgroundColor(R.drawable.yellow_app_colour);
                navigationView.setBackgroundColor(R.drawable.yellow_app_colour);
                appBarLayout.setBackgroundColor(R.drawable.yellow_app_colour);
            }
        });

        //When the green button is pressed
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sets all the backgrounds to the green_app_colour.xml
                navLinerLayout.setBackgroundColor(R.drawable.green_app_colour);
                navigationView.setBackgroundColor(R.drawable.green_app_colour);
                appBarLayout.setBackgroundColor(R.drawable.green_app_colour);
            }
        });

        //Localize the userName and password
        final EditText userName = view.findViewById(R.id.enterUserName);
        EditText password = view.findViewById(R.id.TextUnputPassword);

        //grabs the textView under Welcome to change to the users name
        final TextView welcomeUserName = view.findViewById(R.id.usersName);

        userName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                welcomeUserName.setText(userName.getText());
                return true;
            }
        });

         return view;
    }
}