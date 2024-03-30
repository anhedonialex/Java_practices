package com.example.p2_12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TelephoneAdapter extends RecyclerView.Adapter<TelephoneAdapter.ViewHolder> {
    private ArrayList<Telephone> telephones;
    public TelephoneAdapter(ArrayList<Telephone> telephones){
        this.telephones = telephones;
    }
    public TelephoneAdapter(ArrayList<Telephone> telephones, onTelephoneClickListener onTelephoneClickListener){
        this.telephones = telephones;
        this.onTelephoneClickListener = onTelephoneClickListener;
    }
    interface onTelephoneClickListener{
        void onTelephoneClick(Telephone Telephone, int position);
    }
    private onTelephoneClickListener onTelephoneClickListener;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView nameView;
        private final TextView ageView;
        ViewHolder(View view){
            super(view);
            nameView = view.findViewById(R.id.tvPersonName);
            ageView = view.findViewById(R.id.tvPersonAge);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Telephone Telephone = telephones.get(position);
        holder.nameView.setText(String.format("%s %s", Telephone.getModel(), Telephone.getSerial()));
        holder.ageView.setText(String.format("%d денег", Telephone.getPrice()));
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onTelephoneClickListener.onTelephoneClick(Telephone, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return telephones.size();
    }
}
