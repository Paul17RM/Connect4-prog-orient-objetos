package models;

public class GameModeTraining implements GameMode {
    public Player[] initialize(Board board) {
        Player[] players = new Player[Connect4.NUMBER_PLAYERS];
        players[0] = new HumanPlayer(Color.getColor(0), board);
        players[1] = new MachinePlayer(Color.getColor(1), board);
        return players;
    }
}