package com.example.crudapi.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudapi.Pojomodels.RecordModel;
import com.example.crudapi.R;
import com.example.crudapi.Activities.RecordDetails;

import java.util.ArrayList;
import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder>{
   Context context;
   List<RecordModel> modelList= new ArrayList<>();

    public RecordAdapter(Context context, List<RecordModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.appheaditem,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(modelList.get(position).getRcid());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView =itemView.findViewById(R.id.rcid);
            cardView= itemView.findViewById(R.id.cardview);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Get the clicked item
                    RecordModel clickedItem = modelList.get(getAdapterPosition());

                    // Create an Intent to navigate to the new activity
                    Intent intent = new Intent(context, RecordDetails.class);

                    // Pass data to the new activity if needed
                    intent.putExtra("recordId", clickedItem.getId());
                    intent.putExtra("rcid",clickedItem.getRcid());

                    // Start the new activity
                    context.startActivity(intent);
                }
            });
        }
    }
}

