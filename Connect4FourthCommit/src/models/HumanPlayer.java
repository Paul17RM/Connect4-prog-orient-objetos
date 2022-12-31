package models;

// import views.ExceptionsView;
import views.HumanPlayerView;
import views.UtilsView;

class HumanPlayer extends Player {
    HumanPlayer(Color color, Board board) {
        super(color, board);
    }

    void play() {
        Coordinate coordinate = new Coordinate(0, 0);
        boolean caught = true;
        HumanPlayerView.writeActivePlayer(this.playerColor);
        do {
            try {
                coordinate.setCol(HumanPlayerView.chooseColumn());
                board.putToken(coordinate.getPositionColumn(), this.playerColor);
                caught = false;
            } catch (IllegalArgumentException e) {
                UtilsView.writeMessageStr(e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                UtilsView.writeMessageStr(e.getMessage());
            }
        } while (caught);
    }
}