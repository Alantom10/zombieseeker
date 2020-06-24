package com.example.zombieseeker;

public class gamelogic {
    private int rows;
    private int cols;
    private int num_planets;
    private boolean[][] board;

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

    public void initializeBoard(){
        int max = cols*rows;
        int min = 0;
        int arr[];
        board = new boolean[rows][cols];
        for (int i = 0; i < num_planets; i++) {
            int random_int = (int) (Math.random() * (max - min + 1) + min);
            int row_index = random_int/cols;
            board[row_index][random_int%cols] = true;
        }
    }

    public boolean checkPlanet(int row_index, int col_index){
        return board[row_index][col_index];
    }


    public int checkCol(int col_index){
        int count = 0;
        for(int i = 0; i < rows; i++){
            if(board[i][col_index]){
                count = count + 1;
            }
        }
        return count;
    }

    public int checkRow(int row_index){
        int count = 0;
        for(int i = 0; i < cols; i++){
            if(board[row_index][i]){
                count = count + 1;
            }
        }
        return count;
    }

    public int totalPlanets(int row_index, int col_index){
        return checkCol(col_index) + checkRow(row_index);
    }



}
