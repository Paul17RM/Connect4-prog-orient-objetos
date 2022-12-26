package menuhistory;

import models.Connect4;

public class ActionUndo extends Option {
    ActionUndo() {
        super("Undo");
    }

    @Override
    public void interact(Connect4 connect){
        connect.getBoard().getHistory().undo(connect);
    }
}