package com.example.androiddevfinal_conaxapp.fragments;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androiddevfinal_conaxapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link homeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public homeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment homeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static homeFragment newInstance(String param1, String param2) {
        homeFragment fragment = new homeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Localizes the preferences and grabs the one needed based on key
        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        final String textSize = preferences.getString("font_size", "18");
        int text_size_value = Integer.parseInt(textSize);

        //Localize the title, description and image of home
        final TextView companyName = view.findViewById(R.id.CompanyName);
        TextView aboutHeader = view.findViewById(R.id.about);
        TextView aboutText = view.findViewById(R.id.aboutText);
        ImageView homeImage = view.findViewById(R.id.homeImage);

        //Set the about set to the size on preferences
        aboutText.setTextSize(text_size_value);


        homeImage.setImageResource(R.drawable.conax_office);

        //Grabs the animation
        final Animation scaleUp = AnimationUtils.loadAnimation(getContext(), R.anim.scale_up);
        final Animation boostUp = AnimationUtils.loadAnimation(getContext(), R.anim.bounce_up);

        //Starts the animation for the scaling up
        companyName.startAnimation(scaleUp);
        aboutHeader.startAnimation(scaleUp);
        aboutText.startAnimation(scaleUp);
        homeImage.startAnimation(scaleUp);

        companyName.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_HOVER_ENTER) {
                    companyName.startAnimation(boostUp);
                }
                return false;
            }
        });

        return view;
    }
}