package models;

public class GameModeDemo implements GameMode {
    public Player[] initialize(Board board) {
        Player[] players = new Player[Connect4.NUMBER_PLAYERS];
        for (int i = 0; i < Connect4.NUMBER_PLAYERS; i++) {
            players[i] = new MachinePlayer(Color.getColor(i), board);
        }
        return players;
    }
}