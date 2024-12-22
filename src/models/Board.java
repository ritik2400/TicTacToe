package models;

public class Board {

    char[][] board;

    public Board() {
        board = new char[3][3];
    }

    public Board initBoard() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                board[i][j] = (char)('0' + (i + j));
            }
        }
        return this;
    }

    public Board markCell(int x, int y, char symbol) {
        this.board[x][y] = symbol;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Board \n");
        for(int i=0;i<3;i++) {
            sb.append("|| ").append(board[i][0])
                    .append(" | ").append(board[i][1])
                    .append(" | ").append(board[i][2])
                    .append(" ||\n");
        }
        return sb.toString();
    }
}
