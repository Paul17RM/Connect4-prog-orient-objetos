package menugamemodes;

import models.GameMode;
import utils.Console;

public abstract class Option {
    public static Console console = new Console();
    private String title;

    public Option(String title) {
        this.title = title;
    }

    public abstract GameMode interact();

    public void showTitle(int index) {
        console.writeln(index + ". " + this.getTitle());
    }

    protected String getTitle() {
        return this.title;
    }
}