package utils;

public enum Error {
    OUT_OF_BOUNDS("Coordinate is out of bounds."),
    COLUMN_IS_FULL("Column has no empty squares left."),
    UNVIABLE_UNDO("Undo action was not possible."),
    UNVIABLE_REDO("Redo action was not possible."),
    COLOR_NULL("Color is null."),
    ILLEGAL_COLOR("Unaccounted color."),
    NO_WINNER("There is no winner as of yet."),
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