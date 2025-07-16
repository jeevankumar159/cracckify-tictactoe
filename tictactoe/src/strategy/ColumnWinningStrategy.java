package strategy;

import models.Player;

import java.util.HashMap;

public class ColumnWinningStrategy implements WinningStrategy{
    HashMap<Integer, HashMap<Character,Integer>> colMap;
    int columnLength;

    public ColumnWinningStrategy(int columnLength) {
        colMap = new HashMap<>();
        for(int i = 0; i < columnLength; i++) {
            colMap.put(i, new HashMap<>());
        }
        this.columnLength = columnLength;
    }


    @Override
    public void registerMove(Player player, int row, int col) {
        char symbol = player.getSymbol();
        colMap.get(col).putIfAbsent(symbol, 0);
        colMap.get(col).put(symbol, colMap.get(col).get(symbol) + 1);
    }

    @Override
    public boolean isWinningMove(Player player, int row, int col) {
        char symbol = player.getSymbol();
        HashMap<Character, Integer> colCounts = colMap.get(col);
        return colCounts.getOrDefault(symbol, 0) == columnLength; // Assuming a win requires all cells in the column filled
    }
}
