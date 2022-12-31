package models;

import utils.Error;

public enum Color {
    R,
    Y,
    NULL;

    public static Color getColor(int ordinal) {
        if (ordinal < 0 || ordinal > Color.NULL.ordinal()) {
            throw new IllegalArgumentException(Error.ILLEGAL_COLOR.getMessage());
        }
        return Color.values()[ordinal];
    }

    public static Color oppositeColor(Color prevColor) {
        if (prevColor.isNull()) {
            throw new IllegalArgumentException(Error.COLOR_NULL.getMessage());
        }
        if (prevColor == R) {
            return Y;
        } else {
            return R;
        }
    }

    public boolean isNull() {
        return this == Color.NULL;
    }
}