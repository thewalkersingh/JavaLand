package week_3.b_OOPS_IV.Tictaktoe;

public class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        setName(name);
        setSymbol(symbol);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void setSymbol(char symbol) {
        if (symbol != '\0') {
            this.symbol = symbol;
        }
    }
}
