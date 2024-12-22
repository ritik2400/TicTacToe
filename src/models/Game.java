package models;

import enums.GameStatus;

public class Game {
    private Board board;
    private Player[] players;
    private int totalPlayers;
    private Player winner;

    private Game(Board board, Player[] players, int totalPlayers) {
        this.board = board;
        this.players = players;
        this.totalPlayers = totalPlayers;
    }

    public boolean markAndCheck(int x, int y, int player) {
        this.board.markCell(x, y, players[player].getSymbol());
        return checkWinner(x, y);
    }

    public boolean checkWinner(int x, int y) {
        return (board.getCell(x,y)==board.getCell((x+1)%3,y) && board.getCell(x,y)==board.getCell((x+2)%3,y))
                || (board.getCell(x,y)==board.getCell(x, (y+1)%3) && board.getCell(x, y)==board.getCell(x,(y+2)%3))
                || (board.getCell(x,y)==board.getCell((x+1)%3, (y+1)%3) && board.getCell(x,y)==board.getCell((x+2)%3,(y+2)%3))
                || (board.getCell(x,y)==board.getCell((x+1)%3, (y+2)%3) && board.getCell(x,y)==board.getCell((x+2)%3, (y+1)%3));
    }

    public Player getPlayer(int pos) {
        return players[pos];
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void printBoard() {
        System.out.println(board);
    }

    public static class GameBuilder {
        private int totalPlayers;
        private Player[] players;

        public GameBuilder totalPlayers(int totalPlayers) {
            this.totalPlayers = totalPlayers;
            return this;
        }
        public GameBuilder players(Player[] players) {
            this.players = players;
            return this;
        }
        public Game build() {
            return new Game(new Board().initBoard(), players, totalPlayers);
        }
    }
}
