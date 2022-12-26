package views;

import utils.Error;
import utils.Message;

public class UtilsView {
    public static void writeError(Error error) {
        if (!error.isNull()) {
            System.out.println(error.getMessage());
        }
    }

    public static void writeMessage(Message message) {
        System.out.println(message.getMessage());
    }

    public static void writeWinner(Message message, String player) {
        assert message == Message.VICTORY;
        System.out.println(message.getMessage().replaceAll("#player", "" + player));
    }
}