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

    // revise
    void changeTokenColor() {
        this.currentColor = Color
                .getColor((this.currentColor.ordinal() + 1) % Connect4.NUMBER_PLAYERS);
    }

    public void undo(Connect4 connect) {
        if (this.currentIndex > 0) {
            --this.currentIndex;
            this.currentToken = this.movesHistory.get(this.currentIndex);
            connect.board.undo(this.currentToken);
        }
    }

    public void redo(Connect4 connect) {
        if (this.currentIndex < this.movesHistory.size()) {
            ++this.currentIndex;
            this.currentToken = this.movesHistory.get(this.currentIndex);
            this.changeTokenColor();
            connect.board.redo(this.currentToken, this.currentColor);
        }
    }
}