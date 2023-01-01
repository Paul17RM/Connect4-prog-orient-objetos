package menuhistory;

import models.Connect4;
import views.UtilsView;

public class ActionUndo extends Option {
    ActionUndo() {
        super("Undo");
    }

    @Override
    public void interact(Connect4 connect){
        try {
            connect.getBoard().getHistory().undo(connect);
        } catch (IndexOutOfBoundsException e) {
            UtilsView.writeMessageStr(e.getMessage());
        }
    }
}