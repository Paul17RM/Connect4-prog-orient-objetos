package utils;

public enum Error {
    OUT_OF_BOUNDS("\nCoordinate is out of bounds.\n"),
    COLUMN_IS_FULL("\nColumn has no empty squares left.\n"),
    UNVIABLE_UNDO("\nUndo action was not possible.\n"),
    UNVIABLE_REDO("\nRedo action was not possible.\n"),
    COLOR_NULL("\nColor is null.\n"),
    ILLEGAL_COLOR("\nUnaccounted color.\n"),
    NO_WINNER("\nThere is no winner as of yet.\n"),
    NULL;

    private String message;

    Error() {
    }

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public boolean isNull() {
        return this == Error.NULL;
    }
}