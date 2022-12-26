package models;

import utils.Console;

class StartAnotherGame {
    private static final char AFFIRMATIVE = 'y';
    private static final char NEGATIVE = 'n';
    private static final String SUFFIX = "? (" +
            StartAnotherGame.AFFIRMATIVE + "/" +
            StartAnotherGame.NEGATIVE + "): ";
    private static final String MESSAGE = "The value must be '" +
            StartAnotherGame.AFFIRMATIVE + "' or '" +
            StartAnotherGame.NEGATIVE + "'";
    private String answer;

    void readChoice(String message) {
        assert message != null;
        Console console = Console.getInstance();
        boolean ok;
        do {
            console.writeStr(message);
            this.answer = console.readString(StartAnotherGame.SUFFIX);
            ok = this.isAffirmative() || this.isNegative();
            if (!ok) {
                console.writeStr(StartAnotherGame.MESSAGE);
            }
        } while (!ok);
    }

    boolean isAffirmative() {
        return this.getAnswer() == StartAnotherGame.AFFIRMATIVE;
    }

    private char getAnswer() {
        return Character.toLowerCase(this.answer.charAt(0));
    }

    boolean isNegative() {
        return this.getAnswer() == StartAnotherGame.NEGATIVE;
    }
}