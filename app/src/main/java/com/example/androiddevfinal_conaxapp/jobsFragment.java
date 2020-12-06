package com.example.androiddevfinal_conaxapp;

import android.app.job.JobInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

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


        //This will find and set up the email button for the job
        Button emailButton = view.findViewById(R.id.email);
        //On click of the button it will bring you to email about the job
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] emailAddresses = {"w0741233@myscc.ca"};
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, emailAddresses);
                intent.putExtra(Intent.EXTRA_SUBJECT, "");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Snackbar.make(getView(), "No Email App Found", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

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

            }
            return convertView;
        }

    }
}