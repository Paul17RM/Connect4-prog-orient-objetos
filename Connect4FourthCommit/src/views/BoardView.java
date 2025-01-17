package views;

import models.Color;
import models.Coordinate;
import utils.Message;

public class BoardView {
    public static void showBoard(Color[][] colors) {
        UtilsView.writeMessageMsg(Message.HORIZONTAL_LINE);
        UtilsView.writeMessageStr("\n");
        for (int i = Coordinate.ROWS - 1; i >= 0; i--) {
            for (int j = 0; j < Coordinate.COLS; j++) {
                if (colors[i][j].isNull()) {
                    System.out.print("|\t \t");
                } else {
                    System.out.print("|\t" + colors[i][j] + "\t");
                }
            }
            UtilsView.writeMessageStr("|\n");
        }
        UtilsView.writeMessageMsg(Message.HORIZONTAL_LINE);
        UtilsView.writeMessageStr("\n");
    }
}