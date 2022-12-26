package models;

class Turn {
    private Player[] players;
    private int activePlayer;

    Turn(Player[] players) {
        this.players = new Player[Connect4.NUMBER_PLAYERS];
        this.reset(players);
    }

    void play() {
        this.players[this.activePlayer].play();
        // turn change (moved to main)
    }

    void writeWinner() {
        this.players[this.activePlayer].writeWinner();
    }

    Color getActiveColor() {
        return this.players[this.activePlayer].getPlayerColor();
    }

    // uses?
    int getActivePlayer() {
        return this.activePlayer;
    }

    // @TODO
    void updateActivePlayer(int count) {
        this.activePlayer = (this.activePlayer + count) % Connect4.NUMBER_PLAYERS;
    }

    void reset(Player[] players) {
        this.players = players.clone();
        this.activePlayer = 0;
    }
}