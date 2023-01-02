package models;

import java.util.LinkedList;

import utils.Error;
import views.UtilsView;

public class History {
    private LinkedList<Coordinate> gameHistory;
    private int currentIndex;
    private Coordinate currentToken;
    private Color currentColor;

    History() {
        this.gameHistory = new LinkedList<Coordinate>();
        this.currentIndex = 0;
        this.currentToken = new Coordinate(0, 0);
        this.currentColor = Color.NULL;
    }

    void updateHistory(Coordinate latestToken, Color latestColor) {
        this.currentToken = latestToken;
        this.currentColor = latestColor;
        this.gameHistory.add(this.currentIndex++, latestToken);
    }

    void resetHistory() {
        this.gameHistory.clear();
        this.currentIndex = 0;
    }

    void changeTokenColor() {
        try {
            this.currentColor = Color.oppositeColor(this.currentColor);
        } catch (IllegalArgumentException e) {
            UtilsView.writeMessageStr(e.getMessage());
        }
    }

    public void undo(Connect4 connect) {
        if (currentIndex <= 0) {
            throw new IndexOutOfBoundsException(Error.UNVIABLE_UNDO.getMessage());
        }
        this.currentToken = this.gameHistory.get(--this.currentIndex);
        this.changeTokenColor();
        connect.board.undo(this.currentToken);
    }

    public void redo(Connect4 connect) {
        if (currentIndex >= this.gameHistory.size()) {
            throw new IndexOutOfBoundsException(Error.UNVIABLE_REDO.getMessage());
        }
        this.currentToken = this.gameHistory.get(this.currentIndex++);
        this.changeTokenColor();
        connect.board.redo(this.currentToken, this.currentColor);
    }
}