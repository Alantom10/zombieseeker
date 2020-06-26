package com.example.zombieseeker.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.zombieseeker.model.GameConfigurations;
import com.example.zombieseeker.R;

public class settings extends AppCompatActivity {

    private GameConfigurations configurations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setupErase();
        configurations = GameConfigurations.getInstance();
        createBoardSizeRadioButtons();
        createNumPlanetsRadioButtons();
   }

    private void setupErase() {     // Button to erase games played
        Button back = (Button) findViewById(R.id.eraseGames);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                configurations.setGamesPlayed(0);
            }
        });
    }

    // Creating Radio buttons for setting the number of planets
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
                    configurations.setGameTargets(numPlanet);
                }
            });

            numPlanet_group.addView(button);
        }
    }

    // Creating Radio buttons for setting the board size for the game
    private void createBoardSizeRadioButtons() {
        RadioGroup boardSize_group = (RadioGroup) findViewById(R.id.boardSizeRadioGroup);

        int[] rows = getResources().getIntArray(R.array.board_size_rows);
        int[] cols = getResources().getIntArray(R.array.board_size_cols);

        for (int i = 0; i < rows.length; i++) {
            final int board_row = rows[i];  // number of rows
            final int board_col = cols[i];  // number of columns

            RadioButton button = new RadioButton(this);
            button.setText(board_row + " x " + board_col);
            button.setTextColor(Color.WHITE);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    configurations.setGameCols(board_col);
                    configurations.setGameRows(board_row);
                }
            });
            boardSize_group.addView(button);
        }
    }

    public static Intent switchOptions(Context context) {   // Intent to switch to options page
        return new Intent(context, settings.class);
    }

}