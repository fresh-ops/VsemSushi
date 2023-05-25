package com.fresh.vsemsushi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    private MenuAdapter adapter;
    private final List<MenuItem> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        fillData();
        adapter = new MenuAdapter(this, list);
        RecyclerView recyclerView = findViewById(R.id.menu);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }

    private void fillData() {
        list.add(new MenuItem(R.drawable.rolls, "Роллы"));
        list.add(new MenuItem(R.drawable.sushi, "Суши"));
        list.add(new MenuItem(R.drawable.set, "Сеты"));
        list.add(new MenuItem(R.drawable.snacks, "Закуски"));
        list.add(new MenuItem(R.drawable.drinks, "Напитки"));
    }
}