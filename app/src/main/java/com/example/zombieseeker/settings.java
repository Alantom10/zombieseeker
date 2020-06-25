package com.example.zombieseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

//        setupBack();
//        createBoardSizeRadioButtons();
        createNumPlanetsRadioButtons();
    }

    private void createNumPlanetsRadioButtons() {
        RadioGroup group = (RadioGroup) findViewById(R.id.numPlanetsRadioGroup);

        int[] numPlanets = getResources().getIntArray(R.array.num_of_planets);

        for (int i = 0; i < numPlanets.length; i++) {
            int numPlanet = numPlanets[i];

            RadioButton button = new RadioButton(this);
            button.setText(numPlanet + " planets");

            group.addView(button);
        }
    }

//    private void createBoardSizeRadioButtons() {
//    }

    public static Intent switchOptions(Context context) {
        return new Intent(context, settings.class);
    }

//    private void setupBack() {
//
//        Button back = (Button) findViewById(R.id.optionsBtn);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = mainscreen.skipAnimation(settings.this);
//                startActivity(intent);
//            }
//        });
//    }
}