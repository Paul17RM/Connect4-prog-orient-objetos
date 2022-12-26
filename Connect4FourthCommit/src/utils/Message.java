package utils;

public enum Message {
    TITLE("----- Connect 4 -----"),
    HORIZONTAL_LINE("----------------------------------------------------------------------------------"),
    TIE("It's a tie, neither player has won :("),
    VICTORY("Player #player you win!!!!!!"),
    RESUME("Do you want to play again");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}