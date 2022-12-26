package models;

import utils.Message;
import views.UtilsView;

public abstract class Player {
    protected Color playerColor;
    protected Board board;

    public Player(Color color, Board board) {
        // EXCEPTION HERE!!
        // assert !color.isNull();

        // assert board != null;
        this.playerColor = color;
        this.board = board;
    }

    void writeWinner() {
        UtilsView.writeWinner(Message.VICTORY, this.playerColor.name());
    }

    Color getPlayerColor() {
        return playerColor;
    }

    abstract void play();
}