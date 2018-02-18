package model;

import java.awt.*;

public class Game {
    private int gameId;
    private String wPlayer, bPlayer;
    private Board board;

    public Game(int gameId, String wPlayer, String bPlayer) {
        this.gameId = gameId;
        this.wPlayer = wPlayer;
        this.bPlayer = bPlayer;
        this.board = new Board();
    }

    public boolean makeMove(Integer from, Integer to) {
        return getBoard().makeMove(from, to);
    }

    public String getwPlayer() {
        return wPlayer;
    }

    public void setwPlayer(String wPlayer) {
        this.wPlayer = wPlayer;
    }

    public String getbPlayer() {
        return bPlayer;
    }

    public void setbPlayer(String bPlayer) {
        this.bPlayer = bPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}
