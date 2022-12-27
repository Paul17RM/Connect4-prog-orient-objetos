package menuhistory;

import models.Connect4;

public class ActionUndo extends Option {
    private boolean executed;

    ActionUndo() {
        super("Undo");
        this.executed = false;
    }

    @Override
    public void interact(Connect4 connect){
        connect.getBoard().getHistory().undo(connect);
        this.executed = true;
    }

    protected boolean isExecuted() {
        return this.executed;
    }

    protected void resetUndoOption() {
        this.executed = false;
    }
}