package com.fresh.vsemsushi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fresh.vsemsushi.adapters.FoodAdapter;
import com.fresh.vsemsushi.models.Food;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity implements View.OnClickListener {
    private FoodAdapter adapter;
    private final List<Food> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        fillData();
        adapter = new FoodAdapter(this, list);
        RecyclerView recyclerView = findViewById(R.id.food);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);

        FloatingActionButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(this);
        FloatingActionButton goToCartButton = findViewById(R.id.go_to_cart);
        goToCartButton.setOnClickListener(this);
    }

    private void fillData() {
        Bundle extra = getIntent().getExtras();
        switch (extra.getString("MenuCategory")) {
            case "Роллы":
                list.add(new Food(R.drawable.california, "Калифорния", 200));
                list.add(new Food(R.drawable.canada, "Канада", 250));
                list.add(new Food(R.drawable.philadelphia, "Филадельфия", 220));
                list.add(new Food(R.drawable.ebi, "Эби", 250));
                break;
            case "Суши":
                list.add(new Food(R.drawable.salmon, "Нигири с ласосем", 120));
                list.add(new Food(R.drawable.tuna, "Нигири с тунцом", 100));
                break;
            case "Сеты":
                list.add(new Food(R.drawable.light, "Сет Лайт", 800));
                list.add(new Food(R.drawable.mega, "Сет Мега", 1000));
                break;
            case "Закуски":
                list.add(new Food(R.drawable.fries,"Картофель фри", 80));
                list.add(new Food(R.drawable.wedges,"Картофель по-деревенски", 95));
                list.add(new Food(R.drawable.nuggets,"Наггетсы", 80));
                list.add(new Food(R.drawable.rings,"Луковые кольца", 85));
                list.add(new Food(R.drawable.balls ,"Сырные шарики", 90));
                break;
            case "Напитки":
                list.add(new Food(R.drawable.cola,"Кола", 120));
                break;
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.back_button) {
            finish();
        }
        else if (id == R.id.go_to_cart) {
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
        }
    }
}