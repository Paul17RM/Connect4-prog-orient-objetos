package models;

import views.BoardView;

public class Board {
    private Color[][] colors;
    private History history;
    private Coordinate latestToken;

    Board(History history) {
        this.colors = new Color[Coordinate.ROWS][Coordinate.COLS];
        this.latestToken = new Coordinate(0, 0);
        this.history = history;
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Coordinate.ROWS; i++) {
            for (int j = 0; j < Coordinate.COLS; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    public Color[][] getColors() {
        return colors;
    }

    public History getHistory() {
        return this.history;
    }

    void putToken(int chosenColumn, Color tokenColor) {
        Coordinate coordinate = new Coordinate(0, chosenColumn);
        while (this.occupiedPosition(coordinate)) {
            coordinate.setRow(coordinate.getPositionRow() + 1);
        }
        this.setToken(coordinate, tokenColor);
        this.latestToken.setRow(coordinate.getPositionRow());
        this.latestToken.setCol(coordinate.getPositionColumn());
        this.history.updateHistory(new Coordinate(coordinate.getPositionRow(), chosenColumn));
        BoardView.showBoard(this.colors);
    }

    void undo(Coordinate coordinate) {
        this.colors[coordinate.getPositionRow()][coordinate.getPositionColumn()] = Color.NULL;
        BoardView.showBoard(this.colors);
    }
    
    void redo(Coordinate coordinate, Color previousPlayerColor) {
        this.colors[coordinate.getPositionRow()][coordinate.getPositionColumn()] = previousPlayerColor;
        BoardView.showBoard(this.colors);
    }

    private void setToken(Coordinate coordinate, Color color) {
        this.colors[coordinate.getPositionRow()][coordinate.getPositionColumn()] = color;
    }

    private boolean occupiedPosition(Coordinate coordinate) {
        return !this.colors[coordinate.getPositionRow()][coordinate.getPositionColumn()].isNull();
    }

    boolean columnIsFree(int column) {
        return this.colors[Coordinate.ROWS - 1][column].isNull();
    }

    boolean boardNotFull() {
        int emptyPositions = Coordinate.COLS;
        for (int i = 0; i < Coordinate.COLS; i++) {
            if (!this.columnIsFree(i)) {
                emptyPositions--;
            }
        }
        return emptyPositions > 0;
    }

    boolean isConnectFour(Color activeColor) {
        return this.isConnectHorizontal(activeColor)
                || this.isConnectVertical(activeColor)
                || this.isConnectDiagonal(activeColor)
                || this.isConnectReverseDiagonal(activeColor);
    }

    private boolean isConnectHorizontal(Color activeColor) {
        int connectedTokens = 0;
        Coordinate auxCoordinate = new Coordinate(this.latestToken.getPositionRow(), 0);
        while (!Coordinate.isOutOfBounds(auxCoordinate) && connectedTokens < 4) {
            if (this.colors[auxCoordinate.getPositionRow()][auxCoordinate.getPositionColumn()] == activeColor) {
                connectedTokens++;
            } else {
                connectedTokens = 0;
            }
            auxCoordinate.setCol(auxCoordinate.getPositionColumn() + 1);
        }
        return connectedTokens >= 4;
    }

    private boolean isConnectVertical(Color activeColor) {
        int connectedTokens = 0;
        Coordinate auxCoordinate = new Coordinate(0, this.latestToken.getPositionColumn());
        while (!Coordinate.isOutOfBounds(auxCoordinate)
                && this.occupiedPosition(auxCoordinate) && connectedTokens < 4) {
            if (this.colors[auxCoordinate.getPositionRow()][auxCoordinate.getPositionColumn()] == activeColor) {
                connectedTokens++;
            } else {
                connectedTokens = 0;
            }
            auxCoordinate.setRow(auxCoordinate.getPositionRow() + 1);
        }
        return connectedTokens >= 4;
    }

    private boolean isConnectDiagonal(Color activeColor) {
        int connectedTokens = 0;
        Coordinate auxCoordinate = this.latestToken;
        while (auxCoordinate.getPositionRow() > 0 && auxCoordinate.getPositionColumn() < Coordinate.COLS - 1) {
            auxCoordinate.setRow(auxCoordinate.getPositionRow() - 1);
            auxCoordinate.setCol(auxCoordinate.getPositionColumn() + 1);
        }
        while (!Coordinate.isOutOfBounds(auxCoordinate) && connectedTokens < 4) {
            if (this.colors[auxCoordinate.getPositionRow()][auxCoordinate.getPositionColumn()] == activeColor) {
                connectedTokens++;
            } else {
                connectedTokens = 0;
            }
            auxCoordinate.setRow(auxCoordinate.getPositionRow() + 1);
            auxCoordinate.setCol(auxCoordinate.getPositionColumn() - 1);
        }
        return connectedTokens >= 4;
    }

    private boolean isConnectReverseDiagonal(Color activeColor) {
        int connectedTokens = 0;
        Coordinate auxCoordinate = this.latestToken;
        while (auxCoordinate.getPositionRow() > 0 && auxCoordinate.getPositionColumn() > 0) {
            auxCoordinate.setRow(auxCoordinate.getPositionRow() - 1);
            auxCoordinate.setCol(auxCoordinate.getPositionColumn() - 1);
        }
        while (!Coordinate.isOutOfBounds(auxCoordinate) && connectedTokens < 4) {
            if (this.colors[auxCoordinate.getPositionRow()][auxCoordinate.getPositionColumn()] == activeColor) {
                connectedTokens++;
            } else {
                connectedTokens = 0;
            }
            auxCoordinate.setRow(auxCoordinate.getPositionRow() + 1);
            auxCoordinate.setCol(auxCoordinate.getPositionColumn() + 1);
        }
        return connectedTokens >= 4;
    }
}