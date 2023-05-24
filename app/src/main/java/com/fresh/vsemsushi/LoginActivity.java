package com.fresh.vsemsushi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText login;
    private EditText password;
    private Button enter;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.enter_login_input);
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
            String loginText = login.getText().toString();
            if (loginText.equals("")) {
                Toast.makeText(this, "Введите логин", Toast.LENGTH_SHORT).show();
                return;
            }
            String passwordText = password.getText().toString();
            if (passwordText.equals("")) {
                Toast.makeText(this, "Введите пароль", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        else if (id == R.id.register_user) {
            return;
        }
    }
}