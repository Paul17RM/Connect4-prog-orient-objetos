package models;

import java.util.InputMismatchException;

import utils.Message;
import views.UtilsView;

public abstract class Player {
    protected Color playerColor;
    protected Board board;

    public Player(Color color, Board board) {
        this.playerColor = color;
        this.board = board;
    }

    void writeWinner() {
        try {
            UtilsView.writeWinner(Message.VICTORY, this.playerColor.name());
        } catch (InputMismatchException e) {
            UtilsView.writeMessageStr(e.getMessage());
        }
    }

    Color getPlayerColor() {
        return playerColor;
    }

    abstract void play();
}