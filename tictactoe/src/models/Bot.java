package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bot implements Player {
    private Long id;
    private String name;
    private char symbol;
    private PlayerType playerType;

    public Bot( char symbol, PlayerType playerType) {
        this.name = "BOT";
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
