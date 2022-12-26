package views;

import models.Color;
import utils.Console;

public class HumanPlayerView {
    public static int chooseColumn() {
        return Console.getInstance().readInt("Introduce a column (0 to 6): ");
    }

    public static void writeActivePlayer(Color playerColor) {
        switch (playerColor) {
            case R -> Console.getInstance().writeStr("It's Red's turn.\n");
            case Y -> Console.getInstance().writeStr("It's Yellow's turn.\n");
            default -> throw new IllegalArgumentException("Unexpected value: " + playerColor);
        }
    }
}