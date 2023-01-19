package com.example.unix_03;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    List<Model> modelList;
    Context context;
    public OrderAdapter(Context context, List<Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    public void setFilteredList(List<Model> filteredList){

        this.modelList = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

        String nameofShirt = modelList.get(position).getmDrinkName();
        String descriptionofshirt = modelList.get(position).getmDrinkDetail();
        int images = modelList.get(position).getmDrinkPhoto();

        holder.mShirtName.setText(nameofShirt);
        holder.mShirtDescription.setText(descriptionofshirt);
        holder.imageView.setImageResource(images);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mShirtName, mShirtDescription;
        ImageView imageView;

        public ViewHolder( View itemView) {
            super(itemView);
            mShirtName = itemView.findViewById(R.id.shirtName);
            mShirtDescription = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.shirtImage);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();

            if (position == 0) {
                Intent intent = new Intent(context, infoActivity.class);
                context.startActivity(intent);
            }
            if (position == 1) {
                Intent intent1 = new Intent(context, shirt1.class);
                context.startActivity(intent1);
            }
            if (position == 2) {
                Intent intent1 = new Intent(context, shirt2.class);
                context.startActivity(intent1);
            }
            if (position == 3) {
                Intent intent1 = new Intent(context, shirt3.class);
                context.startActivity(intent1);
            }
            if (position == 4) {
                Intent intent1 = new Intent(context, shirt4.class);
                context.startActivity(intent1);
            }
            if (position == 5) {
                Intent intent1 = new Intent(context, shirt5.class);
                context.startActivity(intent1);
            }

            if (position == 6) {
                Intent intent1 = new Intent(context, shirt6.class);
                context.startActivity(intent1);
            }
            if (position == 7) {
                Intent intent1 = new Intent(context, shirt7.class);
                context.startActivity(intent1);
            }
            if (position == 8) {
                Intent intent1 = new Intent(context, shirt8.class);
                context.startActivity(intent1);
            }


        }
    }
}
