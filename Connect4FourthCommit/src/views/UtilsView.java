package views;

import utils.Message;

import java.util.InputMismatchException;

import utils.Console;
import utils.Error;

public class UtilsView {
    public static void writeMessageMsg(Message message) {
        Console.getInstance().writeStr(message.getMessage());
    }

    public static void writeMessageStr(String string) {
        Console.getInstance().writeStr(string);
    }

    public static void writeWinner(Message message, String player) {
        if (message == Message.VICTORY) {
            throw new InputMismatchException(Error.NO_WINNER.getMessage());
        }
        System.out.println(message.getMessage().replaceAll("#player", "" + player));
    }
}