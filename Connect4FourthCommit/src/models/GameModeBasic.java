package models;

public class GameModeBasic implements GameMode {
    public Player[] initialize(Board board) {
        Player[] players = new HumanPlayer[Connect4.NUMBER_PLAYERS];
        for (int i = 0; i < Connect4.NUMBER_PLAYERS; i++) {
            players[i] = new HumanPlayer(Color.getColor(i), board);
        }
        return players;
    }
}