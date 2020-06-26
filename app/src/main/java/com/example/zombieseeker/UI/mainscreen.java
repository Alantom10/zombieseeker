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

    public static Intent skipAnimation(Context context){       // Intent to skip animation and move to mainscreen
        return new Intent(context, mainscreen.class);
    }

    private void setupPlayBtn(){        // setting up button for playing the game
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

    private void setupHelpBtn() {       // setting up button to move to Help page
        Button helpActivityBtn = (Button) findViewById(R.id.helpBtn);
        helpActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = helpactivity.helpActivity(mainscreen.this);
                startActivity(i);
            }
        });
    }

    private void setupOptionsBtn() {        // setting up button to move to options page

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