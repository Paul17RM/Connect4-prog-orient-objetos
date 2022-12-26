package models;

import java.util.LinkedList;

public class History {
    private LinkedList<Coordinate> movesHistory;
    private int currentIndex;
    private Coordinate currentToken;
    private Color tokenColor;

    History() {
        this.movesHistory = new LinkedList<>();
        this.currentIndex = 0;
        this.tokenColor = Color.getColor(0);
    }

    int getCurrentIndex() {
        return this.currentIndex;
    }

    Coordinate getCurrentToken() {
        return this.currentToken;
    }

    void setTokenColor(Color tokenColor) {
        this.tokenColor = tokenColor;
    }

    void updateHistory(Coordinate latestToken) {
        this.currentToken = latestToken;
        this.movesHistory.add(this.currentIndex++, latestToken);
    }

    // revise
    void changeTokenColor() {
        this.tokenColor = Color
                .getColor((this.tokenColor.ordinal() + 1) % Connect4.NUMBER_PLAYERS);
    }

    public void undo(Connect4 connect) {
        this.currentToken = this.movesHistory.get(--this.currentIndex);
        connect.board.undo(this.currentToken);
    }

    public void redo(Connect4 connect) {
        this.currentToken = this.movesHistory.get(++this.currentIndex);
        // connect.board.redo(this.currentToken, COLOR);
    }
}