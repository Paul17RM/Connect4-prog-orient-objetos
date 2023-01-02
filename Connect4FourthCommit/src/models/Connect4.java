package models;

import menugamemodes.MenuGameMode;
import menuhistory.MenuHistory;
import utils.Message;
import views.BoardView;
import views.UtilsView;

public class Connect4 {
    static final int NUMBER_PLAYERS = 2;
    private History history = new History();
    private MenuGameMode menuGM = new MenuGameMode("CODE-21: CONNECT 4");
    private MenuHistory menuUR = new MenuHistory("Undo/Redo");
    private Turn turn;
    private GameMode gameMode;
    Board board = new Board(this.history);

    public static void main(String[] args) {
        new Connect4().play();
    }

    private void play() {
        this.menuGM.addOptions();
        do {
            this.gameMode = this.menuGM.interact();
            if (this.gameMode != null) {
                this.turn = new Turn(this.board, gameMode.initialize(this.board));
                this.playGame();
                this.board.getHistory().resetHistory();
            }
        } while (!this.menuGM.isExecutedQuitOption() && this.startAnotherGame());
    }

    private void playGame() {
        UtilsView.writeMessageMsg(Message.TITLE);
        BoardView.showBoard(this.board.getColors());
        do {
            this.turn.play();
            do {
                this.history = this.board.getHistory();
                this.menuUR.interact(this);
            } while (!this.menuUR.isExecutedQuitOption());
        } while (!this.isConnectFour() && this.board.boardNotFull());

        if (this.isConnectFour()) {
            this.turn.writeWinner();
        } else if (!this.board.boardNotFull()) {
            UtilsView.writeMessageMsg(Message.TIE);
        }
    }

    private boolean isConnectFour() {
        return this.board.isConnectFour(this.turn.getActiveColor());
    }

    private boolean startAnotherGame() {
        StartAnotherGame isAnotherGame = new StartAnotherGame();
        isAnotherGame.readChoice(Message.RESUME.toString());
        if (isAnotherGame.isAffirmative()) {
            this.board.reset();
            this.turn.reset(gameMode.initialize(this.board));
        }
        return isAnotherGame.isAffirmative();
    }

    public Board getBoard() {
        return this.board;
    }
}