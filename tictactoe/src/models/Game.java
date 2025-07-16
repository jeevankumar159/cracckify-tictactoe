package models;

import lombok.Getter;
import lombok.Setter;
import strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

@Getter()
@Setter()
public class Game {
    private Board board;
    private List<Player> playersList;
    private GameState gameState;
    private Player winner;
    private int nextMovePlayerIndex;

    private List<WinningStrategy> winningStrategies;


    private Game(GameBuilder gameBuilder) {
        this.playersList = gameBuilder.playersList;
        this.gameState = GameState.INPROGRESS;
        this.nextMovePlayerIndex = 0;
        this.board = gameBuilder.board;
        this.winningStrategies = gameBuilder.winningStrategies;
    }

    public static class GameBuilder  {
        private Board board;
        private List<Player> playersList;
        private List<WinningStrategy> winningStrategies;
        private List<String> rewards;

        public GameBuilder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public GameBuilder setPlayersList(List<Player> playersList) {
            this.playersList = playersList;
            return this;
        }

        public GameBuilder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
        public GameBuilder setRewards(List<String> rewards) {
            this.rewards = rewards;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }

}
