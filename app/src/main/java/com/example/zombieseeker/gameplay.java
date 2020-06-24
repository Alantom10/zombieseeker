package com.example.zombieseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class gameplay extends AppCompatActivity {
    private int rows = 5;
    private int cols = 4;
    Button buttons[][] = new Button[rows][cols];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        populateButtons();
    }

    private void populateButtons() {
        TableLayout table = (TableLayout) findViewById(R.id.tableforButtons);
        for(int i = 0; i < rows; i++){
            TableRow tablerow = new TableRow(this);
            tablerow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f));
            table.addView(tablerow);
            for(int j = 0; j < cols; j ++){
                final int final_row = i;
                final int final_col = j;
                Button btn = new Button(this);
                btn.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f));

                btn.setPadding(0,0,0,0);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gridButtonClicked( final_row, final_col);
                    }
                });

                tablerow.addView(btn);
                buttons[i][j] = btn;
            }
        }
    }

    private void gridButtonClicked(int i, int j) {
        Button button = buttons[i][j];
        button.setBackgroundResource(R.drawable.rocket);
        int newHeight = button.getHeight();
        int newWidth= button.getWidth();

        Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.rocket);
        Bitmap scaled = Bitmap.createScaledBitmap(original, newWidth, newHeight,true);
    }

    public static Intent startGame(Context context){
        return new Intent(context, gameplay.class);
    }
}