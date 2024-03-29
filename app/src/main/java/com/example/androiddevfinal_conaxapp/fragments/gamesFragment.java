package com.example.androiddevfinal_conaxapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androiddevfinal_conaxapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link gamesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class gamesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private Integer mParam2;

    public gamesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment gamesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static gamesFragment newInstance(String param1, Integer param2) {
        gamesFragment fragment = new gamesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_games, container, false);

        //This connects the pram to the title of the game in the layout
        if (mParam1 != null){
            TextView gameTitle = view.findViewById(R.id.gameTitle);
            gameTitle.setText(mParam1);
        }
        //This connects the pram to the image in the layout
        if (mParam2 != null){
            ImageView gameImage = view.findViewById(R.id.gameImage);
            gameImage.setImageDrawable(getContext().getDrawable(mParam2));
        }

        return view;
    }
}