package models;

public class Board {

    private char[][] cells;

    public Board() {
        cells = new char[3][3];
    }

    public Board initBoard() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                cells[i][j] = (char)('0' + (3*i + j+1));
            }
        }
        return this;
    }

    public Board markCell(int x, int y, char symbol) {
        this.cells[x][y] = symbol;
        return this;
    }

    public char getCell(int x, int y) {
        return cells[x][y];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Board \n");
        for(int i=0;i<3;i++) {
            sb.append("|| ").append(cells[i][0])
                    .append(" | ").append(cells[i][1])
                    .append(" | ").append(cells[i][2])
                    .append(" ||\n");
        }
        return sb.toString();
    }
}
