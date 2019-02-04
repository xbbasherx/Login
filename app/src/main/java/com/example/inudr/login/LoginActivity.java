package com.example.inudr.login;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView tx1;
    TextView tx2;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final Button bCancel = (Button) findViewById(R.id.bCancel);
        tx1 = (TextView) findViewById(R.id.tvAttemptAmount);
        tx1.setVisibility(View.GONE);
        tx2 = (TextView) findViewById(R.id.tvAttempts);
        tx2.setVisibility(View.GONE);

        //"Registration Here" link to send you to registration page
        //final TextView registerLink = (TextView) findViewById(R.id.tvRegisterHere);

        /*registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });*/


        bLogin.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View V) {

                String userName = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                /*if (userName == null || userName.equals("") && password == null || password.equals("")) {
                    Toast.makeText((getApplicationContext()), "Please enter Username and/or Password", Toast.LENGTH_SHORT).show();
                }
                if (userName.equals("bbasher") && password.equals("1234")) {
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent loginIntent = new Intent(LoginActivity.this, UserAreaActivity.class);
                    LoginActivity.this.startActivity(loginIntent);
                } else if(!userName.equals("") && !password.equals("") && !userName.equals("bbasher") && !password.equals("1234")) {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();

                    tx1.setVisibility(View.VISIBLE);
                    tx2.setVisibility(View.VISIBLE);
                    counter--;
                    tx1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        bLogin.setEnabled(false);
                    }
                }*/

                if (userName == null || userName.equals("") && password == null || password.equals("")) {
                    Toast.makeText((getApplicationContext()), "Please enter Username and/or Password", Toast.LENGTH_SHORT).show();
                }
                String strCode = userName.trim();
                String strCode2 = password.trim();
                if (checkCode(strCode)){
                        if(checkCode(strCode2)) {
                            Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                            Intent loginIntent = new Intent(LoginActivity.this, UserAreaActivity.class);
                            LoginActivity.this.startActivity(loginIntent);
                        }
                }else if (!checkCode(strCode) && !checkCode(strCode2) && !userName.equals("") && !password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();

                    tx1.setVisibility(View.VISIBLE);
                    tx2.setVisibility(View.VISIBLE);
                    counter--;
                    tx1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        bLogin.setEnabled(false);
                    }
                }
            }
        });

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
        public boolean checkCode (String code) {
            String temp = null;
            InputStream file = null;
            try {
                file = getAssets().open("users.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedReader reader;
            reader = new BufferedReader(new InputStreamReader(file));
            try {
                temp = reader.readLine();
                while (temp != null) {
                    if (code.equals(temp)) {
                        // Match was found
                        // Clean up and return true
                        reader.close();
                        return true;
                    }
                        reader.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                    e.printStackTrace();
            }
            return false;
    }
}


