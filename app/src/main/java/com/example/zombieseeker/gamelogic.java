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
    }
}
