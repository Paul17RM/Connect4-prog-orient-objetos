package menuhistory;

import models.Connect4;
import views.UtilsView;

public class ActionRedo extends Option {
    private boolean executed;

    ActionRedo() {
        super("Redo");
        this.executed = false;
    }

    @Override
    public void interact(Connect4 connect) {
        try {
            connect.getBoard().getHistory().redo(connect);
        } catch (IndexOutOfBoundsException e) {
            UtilsView.writeMessageStr(e.getMessage());
        }
        this.executed = true;
    }

    protected boolean isExecuted() {
        return this.executed;
    }

    protected void resetRedoOption() {
        this.executed = false;
    }
}
