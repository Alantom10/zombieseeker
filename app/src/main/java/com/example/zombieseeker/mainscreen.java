package com.example.zombieseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        setupPlayBtn();
    }

    public static Intent skipAnimation(Context context){
        return new Intent(context, mainscreen.class);
    }

    private void setupPlayBtn() {

        Button playBtn = (Button) findViewById(R.id.playGameBtn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = gameplay.startGame(mainscreen.this);
                startActivity(i);
            }
        });
    }

}