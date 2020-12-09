package com.example.androiddevfinal_conaxapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.androiddevfinal_conaxapp.Adapters.CustomLocationViewAdapter;
import com.example.androiddevfinal_conaxapp.R;
import com.example.androiddevfinal_conaxapp.items.LocationItem;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link locationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class locationsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public locationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment locationsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static locationsFragment newInstance(String param1, String param2) {
        locationsFragment fragment = new locationsFragment();
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
        View view = inflater.inflate(R.layout.fragment_locations, container, false);

        //connect This view to the recyclerView in the fragment
        RecyclerView recyclerView = view.findViewById(R.id.recycler);

        //Creates a arrayList of locations that populates the recyclerView
        ArrayList<LocationItem> locationItems = new ArrayList<>();

        //Adding add the items to the array
        locationItems.add(new LocationItem("Montreal", R.drawable.conax_office_montreal, "2849 Oakridge Lane", "This is our Montreal location"));
        locationItems.add(new LocationItem("Los Angeles", R.drawable.conax_office_los_angles,"2663 Hilltop Street", "This is our Los Angeles location"));
        locationItems.add(new LocationItem("London", R.drawable.conax_office_london,"1669 Despard Street", "This is our London location"));
        locationItems.add(new LocationItem("Tokyo", R.drawable.conax_office_tokyo,"3382 Irving Road", "This is our tokyo location"));

        //Adds a layout manager to the recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        //Sets the adapter for the recyclerView
        recyclerView.setAdapter(new CustomLocationViewAdapter(locationItems));

        Animation scaleUp = AnimationUtils.loadAnimation(getContext(), R.anim.scale_up);

        recyclerView.startAnimation(scaleUp);
        return view;
    }
}