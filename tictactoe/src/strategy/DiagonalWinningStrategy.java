package strategy;

import models.Player;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy{
    HashMap<Character,Integer> diagonal1Map;
    HashMap<Character,Integer> diagonal2Map;

    int diagonalLength;
    public DiagonalWinningStrategy(int diagonalLength) {
        diagonal1Map = new HashMap<>();
        diagonal2Map = new HashMap<>();
        this.diagonalLength = diagonalLength;
    }

    @Override
    public void registerMove(Player player, int row, int col) {

        // 0 0 0
        // 0 1 0
        // 0 0 2

        char symbol = player.getSymbol();

        // Check which diagonal the move belongs to
        if (row == col) { // Primary diagonal
            diagonal1Map.putIfAbsent(symbol, 0);
            diagonal1Map.put(symbol, diagonal1Map.get(symbol) + 1);
        }

        if (row + col == diagonalLength - 1) { // Secondary diagonal
            diagonal2Map.putIfAbsent(symbol, 0);
            diagonal2Map.put(symbol, diagonal2Map.get(symbol) + 1);
        }
    }

    @Override
    public boolean isWinningMove(Player player, int row, int col) {
        char symbol = player.getSymbol();

        // Check if the move is on the primary diagonal
        if (row == col) {
            if (diagonal1Map.getOrDefault(symbol, 0) == diagonalLength) {
                return true;
            }
        }

        // Check if the move is on the secondary diagonal
        if (row + col == diagonalLength - 1) {
            if (diagonal2Map.getOrDefault(symbol, 0) == diagonalLength) {
                return true;
            }
        }

        return false; // No winning move found
    }
}
