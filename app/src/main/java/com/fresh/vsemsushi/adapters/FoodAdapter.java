package com.fresh.vsemsushi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fresh.vsemsushi.R;
import com.fresh.vsemsushi.models.Cart;
import com.fresh.vsemsushi.models.Food;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private final Context context;
    private final List<Food> list;
    private final Cart cart;

    public FoodAdapter(Context context, List<Food> list) {
        this.context = context;
        this.list = list;
        cart = Cart.getInstance();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food currentFood = list.get(position);
        holder.image.setImageResource(currentFood.getImageId());
        holder.name.setText(currentFood.getName());
        holder.buy.setText("Купить за " + currentFood.getCost());
        holder.buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart.add(currentFood);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image;
        private final TextView name;
        private final Button buy;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.food_image);
            name = itemView.findViewById(R.id.food_name);
            buy = itemView.findViewById(R.id.food_buy);
        }
    }
}
