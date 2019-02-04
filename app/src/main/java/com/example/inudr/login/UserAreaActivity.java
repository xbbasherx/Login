package com.example.inudr.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class UserAreaActivity extends AppCompatActivity {
    TextView firstName, lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        setTitle("User Profile");

        final TextView firstName = findViewById(R.id.firstName);
        final TextView lastName = findViewById(R.id.lastName);
        final Button bLogout = findViewById(R.id.bLogout);

        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent loginIntent = new Intent(UserAreaActivity.this, LoginActivity.class);
                UserAreaActivity.this.startActivity(loginIntent);
            }
        });


    }
}
