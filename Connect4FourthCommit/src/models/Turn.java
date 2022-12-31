package models;

class Turn {
    private Player[] players;
    private int activePlayer;

    Turn(Player[] players) {
        this.players = new Player[Connect4.NUMBER_PLAYERS];
        this.reset(players);
    }

    void reset(Player[] players) {
        this.players = players.clone();
        this.activePlayer = 0;
    }

    void play() {
        this.players[this.activePlayer].play();
    }

    void writeWinner() {
        this.players[this.activePlayer].writeWinner();
    }

    Color getActiveColor() {
        return this.players[this.activePlayer].getPlayerColor();
    }

    void updateActivePlayer(int count) {
        this.activePlayer = (this.activePlayer + count) % Connect4.NUMBER_PLAYERS;
    }
}