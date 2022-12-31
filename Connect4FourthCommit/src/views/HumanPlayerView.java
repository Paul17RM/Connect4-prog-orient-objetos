package views;

import models.Color;
import utils.Console;

public class HumanPlayerView {
    public static int chooseColumn() {
        return Console.getInstance().readInt("\nIntroduce a column (0 to 6): ");
    }

    public static void writeActivePlayer(Color playerColor) {
        switch (playerColor) {
            case R -> Console.getInstance().writeStr("\nIt's Red's turn.\n");
            case Y -> Console.getInstance().writeStr("\nIt's Yellow's turn.\n");
            default -> throw new IllegalArgumentException("Unexpected value: " + playerColor);
        }
    }
}