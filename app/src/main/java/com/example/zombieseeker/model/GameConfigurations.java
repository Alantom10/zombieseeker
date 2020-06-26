package com.example.zombieseeker.model;

public class GameConfigurations {
    private int gameRows = 6;
    private int gameCols = 15;
    private int gameTargets = 8;
    private int gamesPlayed = 0;

    private static GameConfigurations instance;

    private GameConfigurations() {
        //prevents duplicate initialization
    }


    public static GameConfigurations getInstance() {
        if(instance == null){
            instance = new GameConfigurations();
        }
        return instance;
    }


    public int getGameRows() {
        return gameRows;
    }

    public void setGameRows(int gameRows) {
        this.gameRows = gameRows;
    }

    public int getGameCols() {
        return gameCols;
    }

    public void setGameCols(int gameCols) {
        this.gameCols = gameCols;
    }

    public int getGameTargets() {
        return gameTargets;
    }

    public void setGameTargets(int gameTargets) {
        this.gameTargets = gameTargets;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }
}
