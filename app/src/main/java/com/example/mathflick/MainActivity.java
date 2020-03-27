package com.example.mathflick;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import classActivities.class10Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnClass1,btnClass10;

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;

        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.show();

        btnClass1 = findViewById(R.id.class1);
        btnClass1.setOnClickListener(this);

        btnClass10 = findViewById(R.id.class10);
        btnClass10.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.class10) {
            Intent class10Intent = new Intent(MainActivity.this, class10Activity.class);
            startActivity(class10Intent);
        }
    }
}
