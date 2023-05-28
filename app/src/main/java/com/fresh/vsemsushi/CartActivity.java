package com.fresh.vsemsushi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fresh.vsemsushi.adapters.CartAdapter;
import com.fresh.vsemsushi.models.Cart;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {
    private Cart cart;
    private CartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        cart = Cart.getInstance();
        adapter = new CartAdapter(this, cart.getList());
        RecyclerView recyclerView = findViewById(R.id.cart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        FloatingActionButton backButton = findViewById(R.id.cart_back_button);
        backButton.setOnClickListener(this);
        Button buyAll = findViewById(R.id.buy_all);
        if (cart.isEmpty()) {
            buyAll.setEnabled(false);
            buyAll.setText("Корзина пуста");
        }
        else {
            buyAll.setEnabled(true);
            buyAll.setText(String.format("Купить всё за %d", cart.getCost()));
        }
        buyAll.setOnClickListener(this);
        Button clearCart = findViewById(R.id.clear_all);
        clearCart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.cart_back_button) {
            finish();
        }
        else if (id == R.id.buy_all) {
            cart.clearCart();
            Intent intent = new Intent(this, LoadingActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.clear_all) {
            cart.clearCart();
            adapter.notifyDataSetChanged();
            Button buyAll = findViewById(R.id.buy_all);
            buyAll.setEnabled(false);
            buyAll.setText("Корзина пуста");
        }
    }
}