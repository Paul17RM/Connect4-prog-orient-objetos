package menugamemodes;

import models.GameMode;

public class QuitOption extends Option {
    private boolean executed;

    QuitOption() {
        super("Exit");
        this.executed = false;
    }

    @Override
    public GameMode interact() {
        this.executed = true;
        return null;
    }

    protected boolean isExecuted() {
        return this.executed;
    }
}