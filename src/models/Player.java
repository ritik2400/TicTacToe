package models;

public class Player {

    private String name;
    private char symbol;

    private Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }
    public char getSymbol() {
        return symbol;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Player {");
        output.append("name= '").append(name).append("'");
        output.append(", symbol= '").append(symbol).append("'}");
        return output.toString();
    }

    public static class PlayerBuilder {
        private String name;
        private char symbol;

        public PlayerBuilder name(String name) {
            this.name = name;
            return this;
        }
        public PlayerBuilder symbol(char symbol) {
            this.symbol = symbol;
            return this;
        }
        public Player build() {
            return new Player(name, symbol);
        }
    }
}
