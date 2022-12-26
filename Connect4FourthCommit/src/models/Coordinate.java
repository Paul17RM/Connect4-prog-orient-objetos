package models;

public class Coordinate {
    public final static int ROWS = 6;
    public final static int COLS = 7;
    private int row, col;

    Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static boolean isOutOfBounds(Coordinate coordinate) {
        return coordinate.row < 0 || coordinate.row >= Coordinate.ROWS
                || coordinate.col < 0 || coordinate.col >= Coordinate.COLS;
    }

    int getPositionRow() {
        return this.row;
    }

    int getPositionColumn() {
        return this.col;
    }

    void setRow(int row) {
        this.row = row;
    }

    void setCol(int col) {
        this.col = col;
    }
}