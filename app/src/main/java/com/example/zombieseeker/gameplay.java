package com.example.zombieseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class gameplay extends AppCompatActivity {
    private int rows = 4;
    private int cols = 6;
    Button buttons[][] = new Button[rows][cols];
    gamelogic obj = new gamelogic();
    private int scans = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        obj.setCols(cols);
        obj.setRows(rows);
        obj.setNum_planets(8);
        obj.initializeBoard();
        final TextView count = (TextView) findViewById(R.id.textViewforCount);
        String s = "Found " + Integer.toString(obj.getplanets_Found()) + " of " + Integer.toString(obj.getNum_planets()) + " planets";
        count.setText(s);
        final TextView x = (TextView) findViewById(R.id.Scans);
        s = "Scans: " +  Integer.toString(scans);
        x.setText(s);
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
        lockButtonSizes();
        if(obj.checkPlanet(i, j)){
            obj.revealPlanet(i,j);
            for (int a = 0; a < rows; a++){
                for(int b = 0; b < cols; b++){
                    Button bt = buttons[a][b];
                    if(bt.getText() != "") {
                        bt.setText(Integer.toString(obj.totalPlanets(a, b)));
                    }
                }
            }
            final TextView count = (TextView) findViewById(R.id.textViewforCount);
            String s = "Found " + Integer.toString(obj.getplanets_Found()) + " of " + Integer.toString(obj.getNum_planets()) + " planets";
            count.setText(s);
            setButtonBackground(button);
        }
        else if(obj.checkRevealedPlanet(i,j)){
            button.setText(Integer.toString(obj.totalPlanets(i, j)));
            button.setEnabled(false);
            scans = scans + 1;
            final TextView x= (TextView) findViewById(R.id.Scans);
            String s = "Scans: " +  Integer.toString(scans);
            x.setText(s);
        }
        else {
            button.setText(Integer.toString(obj.totalPlanets(i, j)));
            button.setEnabled(false);
            scans = scans + 1;
            final TextView x = (TextView) findViewById(R.id.Scans);
            String s = "Scans: " +  Integer.toString(scans);
            x.setText(s);
        }
        if(obj.getplanets_Found() == obj.getNum_planets()){
            //code for alert box
        }
    }

    private void setButtonBackground(Button button) {
        int newHeight = button.getHeight();
        int newWidth= button.getWidth();
        int max = 7;
        int min = 1;
        int random_int = (int) (Math.random() * (max - min + 1) + min);
        if(random_int == 1){
            Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.planet1);
            Bitmap scaled = Bitmap.createScaledBitmap(original, newWidth, newHeight,true);
            Resources resource = getResources();
            button.setBackground(new BitmapDrawable(resource, scaled));
        }
        else if(random_int == 2){
            Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.planet2);
            Bitmap scaled = Bitmap.createScaledBitmap(original, newWidth, newHeight,true);
            Resources resource = getResources();
            button.setBackground(new BitmapDrawable(resource, scaled));
        }
        else if(random_int == 3){
            Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.planet3);
            Bitmap scaled = Bitmap.createScaledBitmap(original, newWidth, newHeight,true);
            Resources resource = getResources();
            button.setBackground(new BitmapDrawable(resource, scaled));
        }
        else if(random_int == 4){
            Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.planet4);
            Bitmap scaled = Bitmap.createScaledBitmap(original, newWidth, newHeight,true);
            Resources resource = getResources();
            button.setBackground(new BitmapDrawable(resource, scaled));
        }
        else if(random_int == 5){
            Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.planet5);
            Bitmap scaled = Bitmap.createScaledBitmap(original, newWidth, newHeight,true);
            Resources resource = getResources();
            button.setBackground(new BitmapDrawable(resource, scaled));
        }
        else {
            Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.planet6);
            Bitmap scaled = Bitmap.createScaledBitmap(original, newWidth, newHeight,true);
            Resources resource = getResources();
            button.setBackground(new BitmapDrawable(resource, scaled));
        }
    }

    private void lockButtonSizes() {
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                Button button = buttons[i][j];
                button.setMinWidth(button.getWidth());
                button.setMaxWidth(button.getWidth());
                button.setMinHeight(button.getHeight());
                button.setMaxHeight(button.getHeight());
            }
        }
    }

    public static Intent startGame(Context context){
        return new Intent(context, gameplay.class);
    }
}