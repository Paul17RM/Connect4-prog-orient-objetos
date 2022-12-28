package models;

public enum Color {
    R,
    Y,
    NULL;

    public static Color getColor(int ordinal) {
        assert ordinal >= 0 && ordinal < Color.NULL.ordinal();
        return Color.values()[ordinal];
    }

    public static Color oppositeColor(Color prevColor) {
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