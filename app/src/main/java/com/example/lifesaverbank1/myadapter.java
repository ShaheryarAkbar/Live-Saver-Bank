package com.example.lifesaverbank1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>
{
    Activity activity;
    Context context;
    ArrayList<Model> dataholder;

    public myadapter(Context context, Activity activity, ArrayList<Model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull


    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, null);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.dname.setText(dataholder.get(position).getName());
        holder.dfname.setText(dataholder.get(position).getFname());
        holder.dcontact.setText(dataholder.get(position).getContact());
        holder.daddress.setText(dataholder.get(position).getAddress());
        holder.dbgroup.setText(dataholder.get(position).getBgroup());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView dname, dfname, dcontact, daddress, dbgroup;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            dname = itemView.findViewById(R.id.displayname);
            dfname =itemView.findViewById(R.id.displayfname);
            dcontact =itemView.findViewById(R.id.displaycontact);
            daddress = itemView.findViewById(R.id.displayaddress);
            dbgroup = itemView.findViewById(R.id.displaybgroup);
        }
    }
}
