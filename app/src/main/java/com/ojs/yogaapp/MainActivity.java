package com.ojs.yogaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yoga.R;
import com.ojs.yogaapp.model.DataBaseHelper;

public class MainActivity extends AppCompatActivity {

    Button add;
    EditText user_name, user_password, user_repassword;
    Button loginBtn;
    DataBaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.add_button);
        user_name = findViewById(R.id.username);
        user_password = findViewById(R.id.password);
        user_repassword = findViewById(R.id.repassword);

        loginBtn = findViewById(R.id.login_button);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this , login.class);
                startActivity(intent);
            }
        });

        dbHelper = new DataBaseHelper(MainActivity.this); // Create a new instance of the DataBaseHelper

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name_str = user_name.getText().toString();
                String user_password_str = user_password.getText().toString();
                String user_repassword_str = user_repassword.getText().toString();

//                Log.d("TAG", user_name_str);
//                Log.d("TAG", user_password_str);
//                Log.d("TAG", user_repassword_str);



                if (user_name_str.isEmpty() || user_password_str.isEmpty() || user_repassword_str.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fill all the fields", Toast.LENGTH_LONG).show();
                } else if (user_password_str.equals(user_repassword_str)) {
                    boolean isInserted = dbHelper.insertData(user_name_str, user_password_str);

                    if (isInserted) {
                        Toast.makeText(MainActivity.this, "Registration successful", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Passwords do not match", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
