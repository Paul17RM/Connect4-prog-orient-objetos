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

    private void play() {
        this.menuGM.addOptions();
        do {
            this.gameMode = this.menuGM.interact();
            if (this.gameMode != null) {
                this.turn = new Turn(gameMode.initialize(this.board));
                this.playGame();
            }
        } while (!this.menuGM.isExecutedQuitOption() && this.startAnotherGame());
    }

    private void playGame() {
        UtilsView.writeMessage(Message.TITLE);
        BoardView.showBoard(this.board.getColors());
        int count = 1;
        do {
            this.turn.play(); // updateHistory IN turn.play -> player.play -> putToken
            do {
                this.history = this.board.getHistory();
                this.menuUR.interact(this);
                if (this.menuUR.isExecutedUndo()) {
                    ++count;
                } else if (this.menuUR.isExecutedRedo()) {
                    --count;
                }
            } while (!this.menuUR.isExecutedQuitOption());
            if (!this.isConnectFour()) {
                this.turn.updateActivePlayer(count);
            }
        } while (!this.isConnectFour() && this.board.boardNotFull());
        if (this.isConnectFour()) {
            this.turn.writeWinner();
        } else if (!this.board.boardNotFull()) {
            UtilsView.writeMessage(Message.TIE);
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

    public static void main(String[] args) {
        new Connect4().play();
    }
}