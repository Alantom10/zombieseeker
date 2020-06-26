package com.example.zombieseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageView logo;
    ImageView shuttle;
    boolean isSkipped = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = (ImageView) findViewById(R.id.logoImage);
        Animation logoAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.lefttoright);
        logo.startAnimation(logoAnimation);

        shuttle = (ImageView) findViewById(R.id.shuttleImage);
        Animation shuttleAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.downtoup);
        shuttle.startAnimation(shuttleAnimation);

        setupSkipBtn();

        shuttleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (isSkipped == false) {
                    Timer timer;
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Intent intent = mainscreen.skipAnimation(MainActivity.this);
                            startActivity(intent);
                        }
                    }, 4000);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void setupSkipBtn() {

        Button skipBtn = (Button) findViewById(R.id.skipButton);
        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSkipped = true;
                Intent intent = mainscreen.skipAnimation(MainActivity.this);
                startActivity(intent);
            }
        });
    }
}