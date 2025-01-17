package menuhistory;

import models.Connect4;
import views.UtilsView;

public class ActionRedo extends Option {
    ActionRedo() {
        super("Redo");
    }

    @Override
    public void interact(Connect4 connect) {
        try {
            connect.getBoard().getHistory().redo(connect);
        } catch (IndexOutOfBoundsException e) {
            UtilsView.writeMessageStr(e.getMessage());
        }
    }
}