package models;

import java.util.LinkedList;

public class History {
    private LinkedList<Coordinate> movesHistory;
    private int currentIndex;
    private Coordinate currentToken;
    private Color currentColor;

    History() {
        this.movesHistory = new LinkedList<>();
        this.currentIndex = 0;
        this.currentToken = new Coordinate(0, 0);
        this.currentColor = Color.NULL;
    }

    int getCurrentIndex() {
        return this.currentIndex;
    }

    Coordinate getCurrentToken() {
        return this.currentToken;
    }

    void updateHistory(Coordinate latestToken, Color latestColor) {
        this.currentToken = latestToken;
        this.currentColor = latestColor;
        this.movesHistory.add(this.currentIndex++, latestToken);
    }

    void changeTokenColor() {
        this.currentColor = Color.oppositeColor(this.currentColor);
    }

    public void undo(Connect4 connect) {
        // throw undo not possible exception
        --this.currentIndex;
        this.currentToken = this.movesHistory.get(this.currentIndex);
        this.changeTokenColor();
        connect.board.undo(this.currentToken);
    }

    public void redo(Connect4 connect) {
        // throw redo not possible exception
        this.currentToken = this.movesHistory.get(this.currentIndex++);
        this.changeTokenColor();
        connect.board.redo(this.currentToken, this.currentColor);
    }
}