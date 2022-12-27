package menuhistory;

import models.Connect4;

public class ActionRedo extends Option {
    private boolean executed;

    ActionRedo() {
        super("Redo");
        this.executed = false;
    }

    @Override
    public void interact(Connect4 connect) {
        connect.getBoard().getHistory().redo(connect);
        this.executed = true;
    }

    protected boolean isExecuted() {
        return this.executed;
    }

    protected void resetRedoOption() {
        this.executed = false;
    }
}
