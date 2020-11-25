package com.example.androiddevfinal_conaxapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomLocationViewAdapter extends RecyclerView.Adapter<CustomLocationViewAdapter.CustomViewHolder> {

    private ArrayList<LocationItem> locationItems;

    public CustomLocationViewAdapter(ArrayList<LocationItem> locationItems){
        this.locationItems = locationItems;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_location_info, null);
        return new CustomViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull CustomLocationViewAdapter.CustomViewHolder holder, int position) {
        LocationItem locationItem = locationItems.get(position);
        holder.city.setText(locationItem.getCity());
        holder.address.setText(locationItem.getAddress());
        holder.description.setText(locationItem.getDescription());
    }

    @Override
    public int getItemCount() {
        if (locationItems != null){
            return locationItems.size();
        }
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        protected TextView city;
        protected TextView address;
        protected TextView description;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.city = itemView.findViewById(R.id.City);
            this.address = itemView.findViewById(R.id.Address);
            this.description = itemView.findViewById(R.id.Description);
        }
    }
}
