package com.example.zombieseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

//        setupBack();
        createBoardSizeRadioButtons();
        createNumPlanetsRadioButtons();
   }

    private void createNumPlanetsRadioButtons() {
        RadioGroup numPlanet_group = (RadioGroup) findViewById(R.id.numPlanetsRadioGroup);

        int[] numPlanets = getResources().getIntArray(R.array.num_of_planets);

        for (int i = 0; i < numPlanets.length; i++) {
            final int numPlanet = numPlanets[i];

            RadioButton button = new RadioButton(this);
            button.setText(Integer.toString(numPlanet));
            button.setTextColor(Color.WHITE);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(settings.this, "You clicked " + numPlanet, Toast.LENGTH_SHORT)
                            .show();
                }
            });

            numPlanet_group.addView(button);
        }
    }

    private void createBoardSizeRadioButtons() {
        RadioGroup boardSize_group = (RadioGroup) findViewById(R.id.boardSizeRadioGroup);

        int[] rows = getResources().getIntArray(R.array.board_size_rows);
        int[] cols = getResources().getIntArray(R.array.board_size_cols);

        for (int i = 0; i < rows.length; i++) {
            final int board_row = rows[i];
            final int board_col = cols[i];

            RadioButton button = new RadioButton(this);
            button.setText(board_row + " x " + board_col);
            button.setTextColor(Color.WHITE);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(settings.this, "You clicked " + Integer.toString(board_row) + " x " + Integer.toString(board_col), Toast.LENGTH_SHORT)
                            .show();
                }
            });
            boardSize_group.addView(button);
        }
    }

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