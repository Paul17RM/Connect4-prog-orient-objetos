package menuhistory;

import models.Connect4;
import utils.Console;

public abstract class Option {
    public static Console console = new Console();
    private String title;

    protected Option(String title) {
        this.title = title;
    }

    public abstract void interact(Connect4 connect);

    public void showTitle(int index) {
        console.writeln(index + ". " + this.getTitle());
    }

    protected String getTitle() {
        return this.title;
    }
}