package services;

import models.Board;
import models.Game;
import models.GameState;
import models.Player;
import strategy.WinningStrategy;

import java.util.List;

public class GameService {

    public Game startGame(int rowLength, int columnLength, List<Player> playerList, List<WinningStrategy> winningStrategies){

        Board board = new Board(rowLength, columnLength);
        Game.GameBuilder gameBuilder = new Game.GameBuilder()
                .setBoard(board)
                .setPlayersList(playerList)
                .setWinningStrategies(winningStrategies);
        return gameBuilder.build();
    }

    public void makeMove(Game game, int row, int column, Player player) {
        final Board board = game.getBoard();
        board.getCells().get(row).get(column).setPlayer(player);
        List<WinningStrategy> winningStrategies = game.getWinningStrategies();
        for (WinningStrategy strategy : winningStrategies) {
            strategy.registerMove(player, row, column);
            if (strategy.isWinningMove(player, row, column)) {
                game.setGameState(GameState.COMPLETED);
                game.setWinner(player);
                return;
            }
        }
    }
}
