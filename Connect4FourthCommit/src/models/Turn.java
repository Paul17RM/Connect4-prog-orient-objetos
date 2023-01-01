package models;

class Turn {
    private Board board;
    private Player[] players;
    private int activePlayer;

    Turn(Board board, Player[] players) {
        this.board = board;
        this.players = new Player[Connect4.NUMBER_PLAYERS];
        this.reset(players);
    }

    void reset(Player[] players) {
        this.players = players.clone();
        this.activePlayer = 0;
    }

    void play() {
        this.players[this.activePlayer].play();
        if (!this.board.isConnectFour(this.getActiveColor())) {
            this.activePlayer = (this.activePlayer + 1) % Connect4.NUMBER_PLAYERS;
        }
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