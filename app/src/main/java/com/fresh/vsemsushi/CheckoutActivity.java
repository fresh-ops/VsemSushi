package com.fresh.vsemsushi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fresh.vsemsushi.models.Cart;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CheckoutActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        address = findViewById(R.id.address);

        FloatingActionButton backButton = findViewById(R.id.checkout_back_button);
        backButton.setOnClickListener(this);
        Button makeOrder = findViewById(R.id.make_order);
        makeOrder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.checkout_back_button) {
            finish();
        }
        else if (id == R.id.make_order) {
            if (address.getText().toString().isEmpty()) {
                Toast.makeText(this, "Введите адрес", Toast.LENGTH_SHORT).show();
                return;
            }
            Cart.getInstance().clearCart();
            Intent intent = new Intent(this, ThankActivity.class);
            startActivity(intent);
        }
    }
}