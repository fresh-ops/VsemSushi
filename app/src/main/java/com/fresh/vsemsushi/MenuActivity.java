package com.fresh.vsemsushi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.fresh.vsemsushi.adapters.MenuAdapter;
import com.fresh.vsemsushi.models.MenuItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
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

        FloatingActionButton openCart = findViewById(R.id.open_cart);
        openCart.setOnClickListener(this);
        ImageView user = findViewById(R.id.menu_user);
        user.setOnClickListener(this);
    }

    private void fillData() {
        list.add(new MenuItem(R.drawable.rolls, "Роллы"));
        list.add(new MenuItem(R.drawable.sushi, "Суши"));
        list.add(new MenuItem(R.drawable.set, "Сеты"));
        list.add(new MenuItem(R.drawable.snacks, "Закуски"));
        list.add(new MenuItem(R.drawable.drinks, "Напитки"));
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.open_cart) {
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.menu_user) {
            Intent intent = new Intent(this, UserActivity.class);
            startActivity(intent);
        }
    }
}