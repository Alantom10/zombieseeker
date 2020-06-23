package com.example.zombieseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupSkipBtn();

    }

    private void setupSkipBtn() {

        Button skipBtn = (Button) findViewById(R.id.skipButton);
        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = mainscreen.skipAnimation(MainActivity.this);
                startActivity(intent);
            }
        });
    }
}