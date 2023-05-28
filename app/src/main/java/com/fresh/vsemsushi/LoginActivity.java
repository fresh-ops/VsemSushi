package com.fresh.vsemsushi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fresh.vsemsushi.models.User;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText phone;
    private EditText password;
    private Button enter;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        phone = findViewById(R.id.enter_phone_input);
        password = findViewById(R.id.enter_password_input);
        enter = findViewById(R.id.enter_user);
        register = findViewById(R.id.register_user);
        enter.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.enter_user) {
            String phoneText = phone.getText().toString();
            if (phoneText.equals("")) {
                Toast.makeText(this, "Введите логин", Toast.LENGTH_SHORT).show();
                return;
            }
            String passwordText = password.getText().toString();
            if (passwordText.equals("")) {
                Toast.makeText(this, "Введите пароль", Toast.LENGTH_SHORT).show();
                return;
            }

            User user = User.getInstance();
            user.setPhone(phoneText);
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.register_user) {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }
    }
}