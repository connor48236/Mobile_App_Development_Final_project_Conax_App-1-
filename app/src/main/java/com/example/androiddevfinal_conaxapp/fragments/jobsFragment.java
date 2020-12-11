package com.example.androiddevfinal_conaxapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.androiddevfinal_conaxapp.R;
import com.example.androiddevfinal_conaxapp.items.JobItem;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link jobsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class jobsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public jobsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment jobsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static jobsFragment newInstance(String param1, String param2) {
        jobsFragment fragment = new jobsFragment();
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
        View view = inflater.inflate(R.layout.fragment_jobs, container, false);

        //Connects this listView to the ListView in Layouts
        final ListView listView = view.findViewById(R.id.JobListView);

        //Creates a array list of job items
        ArrayList<JobItem> jobItemArrayList = new ArrayList<>();
        jobItemArrayList.add(new JobItem("Lead Programmer", "As a lead Programmer you will take charge of the team and lead them to success. You will" +
                "be one of the most skilled and knowledgeable programmers at conax and therefore will have the task of managing other programmers and lead the team",
                "* At least 7+ years in C++ programming \n" +
                        "* A good understanding in bother Unity and Unreal \n" +
                        "* Amazing energy and team leading experience \n" +
                        "* A good understanding in conax development tactics"));
        jobItemArrayList.add(new JobItem("Graphic Designer", "As a Graphic designer at Conax you will be creating all the art for the games we create. You will be " +
                "Designing this such as characters, scenery, map design and more!",
                "* Expertise in Adobe PhotoShop \n" +
                        "* Expertise in Adobe Illustrator \n" +
                        "* 3+ years in relevant industry experience \n" +
                        "* Self-Motivation and a good team player"));
        jobItemArrayList.add(new JobItem("programmer", "As a programmer at conax you will work on the core game play mechanics and create most of the game with your" +
                "team through code. you will work on things such as character movement, game play mechanics, physics, UI elements and much more",
                "* At least 3+ years of c++ programming \n " +
                        "* At least 1+ years in java programming \n" +
                        "* A good understanding of code concepts \n " +
                        "* A good altitude and motivation \n" +
                        "* A good team player"));

        listView.setAdapter(new CustomJobListAdapter(getContext(), jobItemArrayList));
        //This will show on click of the job item in the list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("test", "Test" + position);


            }
        });

        //This will find and set up the email button for the job
        final Button emailButton = view.findViewById(R.id.jobEmail);
        //On click of the button it will bring you to email about the job
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] emailAddresses = {"w0741233@myscc.ca"};
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, emailAddresses);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Job application for ___");
                intent.putExtra(Intent.EXTRA_TEXT, "Hello Conax management, My name is ___ And this is my resume:");
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Snackbar.make(getView(), "No Email App Found", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        Animation scaleUp = AnimationUtils.loadAnimation(getContext(), R.anim.scale_up);

        listView.startAnimation(scaleUp);
        emailButton.startAnimation(scaleUp);


        return view;
    }

    // A custom view Adapter for the ListView of jobs
    public class CustomJobListAdapter extends ArrayAdapter<JobItem> {


        public CustomJobListAdapter(@NonNull Context context, ArrayList<JobItem> items) {
            super(context, 0, items);
        }

        @NonNull
        @Override
        public View getView(final int position, @NonNull View convertView, @NonNull final ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext())
                        .inflate(R.layout.job_info, parent, false);
                //This will find the job name and set it to the name for that job based on position
                TextView jobName = convertView.findViewById(R.id.jobTitle);
                jobName.setText(getItem(position).getJobName());

                //This sets the description to the description for that job based on position
                TextView jobDesc = convertView.findViewById(R.id.jobDesc);
                jobDesc.setText(getItem(position).getDescription());

                //This sets the requirements to the requirements for that job based on position
                TextView jobReq = convertView.findViewById(R.id.jobReq);
                jobReq.setText(getItem(position).getExperience());

                //Localizes the preferences and grabs the one needed based on key
                final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                final String textSize = preferences.getString("font_size", "18");
                int text_size_value = Integer.parseInt(textSize);

                //Sets the jobDesc and Req to the text size from preferences
                jobDesc.setTextSize(text_size_value);
                jobReq.setTextSize(text_size_value);



            }
            return convertView;
        }

    }
}