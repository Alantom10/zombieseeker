package com.example.zombieseeker.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zombieseeker.R;

public class mainscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        setupPlayBtn();
        setupHelpBtn();
        setupOptionsBtn();
    }

    public static Intent skipAnimation(Context context){
        return new Intent(context, mainscreen.class);
    }

    private void setupPlayBtn(){
        Button playBtn = (Button) findViewById(R.id.playGameBtn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = gameplay.startGame(mainscreen.this);
                startActivity(intent);
            }
        });
    }

    public static Intent returnHelpActivity(Context c){
        return new Intent(c, mainscreen.class);
    }

    private void setupHelpBtn() {
        Button helpActivityBtn = (Button) findViewById(R.id.helpBtn);
        helpActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = helpactivity.helpActivity(mainscreen.this);
                startActivity(i);
            }
        });
    }

    private void setupOptionsBtn() {

        Button options = (Button) findViewById(R.id.optionsBtn);
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = settings.switchOptions(mainscreen.this);
                startActivity(intent);
            }
        });
    }

}