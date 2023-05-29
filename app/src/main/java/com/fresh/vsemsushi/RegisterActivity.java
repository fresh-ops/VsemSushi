package com.fresh.vsemsushi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fresh.vsemsushi.models.User;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText phone;
    private EditText password;
    private EditText passwordRepeat;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        phone = findViewById(R.id.register_phone_input);
        password = findViewById(R.id.register_password_input);
        passwordRepeat = findViewById(R.id.register_password_repeat);
        save = findViewById(R.id.save_user);
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.save_user) {
            String phoneText = phone.getText().toString();
            if (phoneText.equals("")) {
                Toast.makeText(this, "Введите номер телефона", Toast.LENGTH_SHORT).show();
                return;
            }
            String passwordText = password.getText().toString();
            if (passwordText.equals("")) {
                Toast.makeText(this, "Введите пароль", Toast.LENGTH_SHORT).show();
                return;
            }
            String passwordRepeatText = passwordRepeat.getText().toString();
            if (passwordRepeatText.equals("")) {
                Toast.makeText(this, "Повторите пароль", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!passwordText.equals(passwordRepeatText)) {
                Toast.makeText(this, "Пароли не совподают", Toast.LENGTH_SHORT).show();
                return;
            }


            User user = User.getInstance();
            user.setPhone(phoneText);
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
    }
}