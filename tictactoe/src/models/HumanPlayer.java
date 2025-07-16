package models;

import lombok.Getter;
import lombok.Setter;

public class HumanPlayer implements Player{
    private Long id;
    private String name;
    private char symbol;
    private PlayerType playerType;

    public HumanPlayer(String name, char symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    @Override
    public Character getSymbol() {
        return this.symbol;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
