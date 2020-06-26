package com.example.zombieseeker;

public class GameConfigurations {
    private int gameRows;
    private int gameCols;
    private int gameTargets;
    private int gamesPlayed;

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
