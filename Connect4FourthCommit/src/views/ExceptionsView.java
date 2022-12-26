package views;

import utils.Console;

public class ExceptionsView {
    public static void writeNullPlayerBoardException() {

    }

    public static void writeNullPlayerColorException() {

    }

    public static void writeUndoNotPossibleException() {
        Console.getInstance().writeStr("There was nothing to 'undo'.\n");
    }

    public static void writeRedoNotPossibleException() {
        Console.getInstance().writeStr("There was nothing to 'redo'.\n");
    }

    public static void writeCoordinateOutOfBounds() {
        Console.getInstance().writeStr("Coordinate is out of bounds.\n");
    }

    public static void writeColumnIsFull() {
        Console.getInstance().writeStr("Column has no empty squares left.\n");
    }
}