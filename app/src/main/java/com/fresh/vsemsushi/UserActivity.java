package com.fresh.vsemsushi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fresh.vsemsushi.R;
import com.fresh.vsemsushi.models.User;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        User user = User.getInstance();

        TextView id = findViewById(R.id.id_field);
        id.setText(Integer.toString(user.getId()));
        TextView phone = findViewById(R.id.phone_field);
        phone.setText(user.getPhone());

        Button backButton = findViewById(R.id.user_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}