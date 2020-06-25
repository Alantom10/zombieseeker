package com.example.zombieseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setupBack();
    }

    public static Intent switchOptions(Context context) {
        return new Intent(context, settings.class);
    }

    private void setupBack() {

        Button back = (Button) findViewById(R.id.optionsBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = mainscreen.skipAnimation(settings.this);
                startActivity(intent);
            }
        });
    }
}