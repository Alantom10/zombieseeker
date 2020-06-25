package com.example.zombieseeker;

import android.util.Log;

public class gamelogic {
    private int rows;
    private int cols;
    private int num_planets;
    private int[][] board;

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getCols() {
        return cols;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getRows() {
        return rows;
    }

    public void setNum_planets(int num_planets) {
        this.num_planets = num_planets;
    }

    public int getNum_planets() {
        return num_planets;
    }

    public void initializeBoard() {
        int max;
        int min;
        int arr[] = new int[rows*cols];
        int pos[] = new int[num_planets];
        board = new int[rows][cols];
        int i = 0;
        for (i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                board[i][j] = -1;
            }
        for(i = 0; i < rows*cols;i++) {
            arr[i] = i;
        }
        for(i = 0; i < num_planets; i++) {
            min = 0;
            max = rows * cols - i - 1;
            int random_int = (int) (Math.random() * (max - min + 1) + min);
            Log.i("app", Integer.toString(random_int));
            pos[i] = arr[random_int];
            Log.i("app", Integer.toString(pos[i]) + "\n");
            arr[random_int] = arr[max - 1];
            arr[max - 1] = 0;
        }
        i = 0;
        while(i < num_planets) {
            int row_index = pos[i]/cols;
            board[row_index][pos[i]%cols] = 1;
            i = i + 1;
        }
    }

    public boolean checkPlanet(int row_index, int col_index){
        return (1 == board[row_index][col_index]);
    }


    public int checkCol(int col_index){
        int count = 0;
        for(int i = 0; i < rows; i++){
            if(board[i][col_index] == 1 || board[i][col_index] == 0){
                count = count + 1;
            }
        }
        return count;
    }

    public int checkRow(int row_index){
        int count = 0;
        for(int i = 0; i < cols; i++){
            if(board[row_index][i] == 1 || board[row_index][i] == 0){
                count = count + 1;
            }
        }
        return count;
    }

    public int totalPlanets(int row_index, int col_index){
        return checkCol(col_index) + checkRow(row_index);
    }

    public boolean checkRevealedPlanet(int row_index, int col_index) {
        return (0 == board[row_index][col_index]);
    }

    public void revealPlanet(int row_index, int col_index){
        board[row_index][col_index] = 0;
    }
}
