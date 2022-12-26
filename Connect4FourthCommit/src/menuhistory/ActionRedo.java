package menuhistory;

import models.Connect4;

public class ActionRedo extends Option {
    ActionRedo() {
        super("Redo");
    }

    @Override
    public void interact(Connect4 connect){
        connect.getBoard().getHistory().redo(connect);
    }
}
