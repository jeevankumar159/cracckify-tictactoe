package controllers;

import models.Game;
import models.GameState;
import models.Player;
import services.GameService;
import strategy.WinningStrategy;

import java.util.List;

public class GameController {

    GameService gameService;

    public GameController(){
        this.gameService = new GameService();
    }

    public Game startGame(int rowLength, int columnLength, List<Player> playerList, List<WinningStrategy> winningStrategies) {
        if (rowLength <= 0 || columnLength <= 0) {
            throw new IllegalArgumentException("Row and column lengths must be greater than zero.");
        }
        if (playerList == null || playerList.size() < 2) {
            throw new IllegalArgumentException("At least two players are required to start the game.");
        }
        return gameService.startGame(rowLength, columnLength, playerList, winningStrategies);
    }

    public void makeMove(Game game, int row, int column, Player player) {
        if (game == null || player == null) {
            throw new IllegalArgumentException("Game and player cannot be null.");
        }
        if (row < 0 || column < 0 || row >= game.getBoard().getRowLength() || column >= game.getBoard().getColumnLength()) {
            throw new IllegalArgumentException("Move is out of bounds.");
        }
        gameService.makeMove(game, row, column, player);
    }
}
