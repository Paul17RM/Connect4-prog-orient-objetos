package menuhistory;

import models.Connect4;
// import views.BoardView;

public class QuitOption extends Option {
    private boolean executed;

    QuitOption() {
        super("No action");
        this.executed = false;
    }

    @Override
    public void interact(Connect4 connect) {
        // connect.getBoard().getHistory().clearRedoStack();
        // BoardView.showBoard(connect.getBoard().getColors());
        this.executed = true;
    }

    protected boolean isExecuted() {
        return this.executed;
    }
}