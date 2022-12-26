package models;

import java.util.Random;

class MachinePlayer extends Player {
    MachinePlayer(Color color, Board board) {
        super(color, board);
    }

    void play() {
        Coordinate coordinate = new Coordinate(0, 0);
        Random random = new Random();
        do {
            coordinate.setCol(random.nextInt(7));
        } while (!this.board.columnIsFree(coordinate.getPositionColumn()));
        board.putToken(coordinate.getPositionColumn(), this.playerColor);
    }
}