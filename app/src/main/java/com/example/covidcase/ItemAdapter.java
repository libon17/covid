package com.example.covidcase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidcase.Model.CovidCaseItem;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private ArrayList<CovidCaseItem> covidCases;
    public ItemAdapter(ArrayList<CovidCaseItem> covidCases) {
        this.covidCases = covidCases;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CovidCaseItem covidCase = covidCases.get(position);
        holder.tvItemCountry.setText(covidCase.getCountry());
        holder.tvItemCase.setText(String.valueOf(covidCase.getCases()));
    }

    @Override
    public int getItemCount() {
        return covidCases.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvItemCountry;
        TextView tvItemCase;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemCountry = itemView.findViewById(R.id.tv_item_country);
            tvItemCase = itemView.findViewById(R.id.tv_item_case);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            int position = getAbsoluteAdapterPosition();
//            String text = tvItemCountry.getText() +"\n"+ tvItemCase.getText() +"-"+ tvSelesai.getText();
//            if (position != RecyclerView.NO_POSITION) {
//                CovidCaseItem covidCase = covidCases.get(position);
//                Log.d("testqwe", ""+v.getContext());
//                Toast.makeText(v.getContext(), text, Toast.LENGTH_SHORT).show();
//            }
        }
    }
}
