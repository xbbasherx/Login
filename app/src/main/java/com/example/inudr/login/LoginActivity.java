package com.example.inudr.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bLogin = (Button) findViewById(R.id.bLogin);
        //final TextView registerLink = (TextView) findViewById(R.id.tvRegisterHere);

        /*registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });*/
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent loginIntent = new Intent(LoginActivity.this, UserAreaActivity.class);
                LoginActivity.this.startActivity(loginIntent);
            }
        });


        setTitle("Login");
    }
}
