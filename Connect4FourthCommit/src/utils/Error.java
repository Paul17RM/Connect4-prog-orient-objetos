package utils;

public enum Error {
    OUT_OF_BOUNDS("Coordinate is out of bounds."),
    COLUMN_IS_FULL("Column has no empty squares left."),
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