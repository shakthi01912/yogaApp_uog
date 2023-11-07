package com.ojs.yogaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.util.Log;

import com.example.yoga.R;
import com.ojs.yogaapp.model.DataBaseHelper;


public class login extends AppCompatActivity {
    EditText usernameEditText, passwordEditText;
    Button loginButton;
    DataBaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        usernameEditText = findViewById(R.id.login_name);
        passwordEditText = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button2);

        dbHelper = new DataBaseHelper(this);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (dbHelper.checkLogin(username, password)) {
                    Log.d("DataBaseHelper", "Checking login for Username: " + username + " Password: " + password);

                    Intent intent = new Intent(login.this, Home_activity.class);

                    startActivity(intent);
                    Toast.makeText(login.this, "Login successful!", Toast.LENGTH_SHORT).show();
                    Log.d("DataBaseHelper", "SADCDACDS: " + username + " Password: " + password);
                } else {
                    // Failed login
                    Toast.makeText(login.this, "Login failed. Invalid username or password.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}