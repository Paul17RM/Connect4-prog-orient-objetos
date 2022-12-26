package views;

import utils.Console;

public class MenusView {
    public static int chooseMenuOption(int optionsSize) {
        return Console.getInstance().readInt("Choose option (1-" + optionsSize + "): ");
    }
}