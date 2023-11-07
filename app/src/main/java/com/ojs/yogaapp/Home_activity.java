package com.ojs.yogaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;

import android.os.Bundle;

import com.example.yoga.R;

public class Home_activity extends AppCompatActivity {


    Button scheduleButton = findViewById(R.id.schedule_button);
    Button viewScheduleButton = findViewById(R.id.view_schedule_button);
    Button classButton = findViewById(R.id.class_button);
    Button viewClassButton = findViewById(R.id.view_class_button);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    }
}