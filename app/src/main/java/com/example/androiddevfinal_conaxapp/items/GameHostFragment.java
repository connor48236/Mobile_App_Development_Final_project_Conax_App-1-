package com.example.androiddevfinal_conaxapp.items;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androiddevfinal_conaxapp.R;
import com.example.androiddevfinal_conaxapp.fragments.gamesFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GameHostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameHostFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GameHostFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GameHostFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GameHostFragment newInstance(String param1, String param2) {
        GameHostFragment fragment = new GameHostFragment();
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
        View view = inflater.inflate(R.layout.fragment_game_host, container, false);

        CustomGameViewPagerAdapter adapter = new CustomGameViewPagerAdapter(getChildFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.gameHost);
        viewPager.setAdapter(adapter);

        return view;
    }

    //Creates the customViewPagerAdater
    public class CustomGameViewPagerAdapter extends FragmentPagerAdapter{
        public CustomGameViewPagerAdapter(@NonNull FragmentManager fm){
            super(fm);
        }

        @NonNull
        @Override
        //This is what goes inside each view
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new gamesFragment().newInstance("Universe Wars", R.drawable.universe_wars);
                case 1: return new gamesFragment().newInstance("The Land Of Asuke", R.drawable.the_land_of_asuke);
                case 2: return new gamesFragment().newInstance("The Legend of the Wise One", R.drawable.wise_one);
                case 3: return new gamesFragment().newInstance("Pirates Of Cuba", R.drawable.pirates_of_cuba);
                default: return new gamesFragment().newInstance("Game Not Found", R.drawable.ic_baseline_error_24);
            }
        }

        @Override
        //This shows how many views there are
        public int getCount() {
            return 4;
        }
    }
}