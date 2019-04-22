package com.example.weatherdetails.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherdetails.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private ArrayList<String>mdataset=new ArrayList<String>();
    private ArrayList<String>variabletype= new ArrayList<String>();

    public RecyclerViewAdapter(ArrayList<String> variableType, ArrayList<String> myDataset) {
        mdataset = myDataset;
        variabletype = variableType;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String variable = variabletype.get(position);
        String data= mdataset.get(position);
        holder.title_data.setText(data);
        holder.title_variable.setText(variable);


    }

    @Override
    public int getItemCount() {

        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title_variable,title_data;



        public MyViewHolder(View itemView) {
            super(itemView);
           title_variable=(TextView)itemView.findViewById(R.id.textview_variable);
           title_data=(TextView)itemView.findViewById(R.id.textview_name);
        }
    }



}
