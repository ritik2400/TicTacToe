package models;

public class Board {

    char[][] board;

    public Board() {
        board = new char[3][3];
    }

    public void initBoard() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                board[i][j] = '_';
            }
        }
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
