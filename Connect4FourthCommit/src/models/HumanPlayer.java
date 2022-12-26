package models;

import utils.Error;
import views.HumanPlayerView;
import views.UtilsView;

class HumanPlayer extends Player {
    HumanPlayer(Color color, Board board) {
        super(color, board);
    }

    void play() {
        Coordinate coordinate = new Coordinate(0, 0);
        Error error;
        HumanPlayerView.writeActivePlayer(this.playerColor);
        do {
            coordinate.setCol(HumanPlayerView.chooseColumn());
            error = this.getPlayError(coordinate);
        } while (!error.isNull());
        board.putToken(coordinate.getPositionColumn(), this.playerColor);
    }

    // SUBS FOR EXCEPTIONS
    private Error getPlayError(Coordinate coordinate) {
        Error error = Error.NULL;
        if (Coordinate.isOutOfBounds(coordinate)) {
            error = Error.OUT_OF_BOUNDS;
        } else if (!this.board.columnIsFree(coordinate.getPositionColumn())) {
            error = Error.COLUMN_IS_FULL;
        }
        UtilsView.writeError(error);
        return error;
    }
}