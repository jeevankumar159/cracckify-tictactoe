import controllers.GameController;
import models.*;
import strategy.DiagonalWinningStrategy;
import strategy.RowWinningStrategy;
import strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Machine Coding
    // Tic Tac Toe Game
    // 1 DSA

    //Start --> dimensions, players

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowLength = 3;
        int columnLength = 3;
        Player player1 = new HumanPlayer("Player 1", 'X',PlayerType.HUMAN);
        Player player2 = new HumanPlayer("Player 2", 'O',PlayerType.HUMAN);
        WinningStrategy rowWinningStrategy = new RowWinningStrategy(rowLength);
        WinningStrategy columnWinningStrategy = new RowWinningStrategy(columnLength);
        WinningStrategy diagonalWinningStrategy = new DiagonalWinningStrategy(rowLength);
        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(rowWinningStrategy);
        winningStrategies.add(columnWinningStrategy);
        winningStrategies.add(diagonalWinningStrategy);
        GameController gameController = new GameController();
        Game game = gameController.startGame(
                rowLength,
                columnLength,
                List.of(player1, player2),
                List.of(rowWinningStrategy)
        );
        System.out.println(game.getGameState());
        while(game.getGameState() == GameState.INPROGRESS) {

            System.out.println("Next Move Player: " + game.getPlayersList().get(game.getNextMovePlayerIndex()).getName());
            // Simulate a move
            for(int i = 0;i< game.getPlayersList().size(); i++) {
                System.out.println("Player " + (i + 1) + " (" + game.getPlayersList().get(i).getSymbol() + "), enter your move (row and column): ");
                    displayBoard(game);
                    int row = scanner.nextInt();
                    int column = scanner.nextInt();
                    gameController.makeMove(game, row, column, game.getPlayersList().get(i));


            }

        }
        System.out.println("Game Over! Winner: " + game.getWinner().getName() + " with symbol: " + game.getWinner().getSymbol());
    }



























    public static void displayBoard(Game game) {
        if(game.getGameState()== GameState.COMPLETED) {
            System.out.println("Game is already completed. Winner: " + game.getWinner().getName());
            return;
        } else if (game.getGameState().equals(GameState.DRAW)) {
            System.out.println("Game is a draw. No more moves can be made.");
            return;
        }
        Board board = game.getBoard();
        List<List<Cell>> cells = board.getCells();
        int size = cells.size();

        for (int i = 0; i < size; i++) {
            // Print each row
            for (int j = 0; j < size; j++) {
                Cell cell = cells.get(i).get(j);
                if (cell.getPlayer() != null) {
                    System.out.print(" " + cell.getPlayer().getSymbol() + " ");
                } else {
                    System.out.print("   ");
                }

                if (j < size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();

            // Print separator after each row except the last
            if (i < size - 1) {
                for (int j = 0; j < size; j++) {
                    System.out.print("---");
                    if (j < size - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();

            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }


}