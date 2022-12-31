package menuhistory;

import models.Connect4;
import views.UtilsView;

public class ActionUndo extends Option {
    private boolean executed;

    ActionUndo() {
        super("Undo");
        this.executed = false;
    }

    @Override
    public void interact(Connect4 connect){
        try {
            connect.getBoard().getHistory().undo(connect);
        } catch (IndexOutOfBoundsException e) {
            UtilsView.writeMessageStr(e.getMessage());
        }
        this.executed = true;
    }

    protected boolean isExecuted() {
        return this.executed;
    }

    protected void resetUndoOption() {
        this.executed = false;
    }
}