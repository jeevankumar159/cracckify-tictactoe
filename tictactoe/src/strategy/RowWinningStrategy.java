package strategy;

import models.Player;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy {

    HashMap<Integer, HashMap<Character,Integer>> rowMap;
    int rowLength;

    public RowWinningStrategy(int rowLength) {
        rowMap = new HashMap<>();
        for(int i = 0; i < rowLength; i++) {
            rowMap.put(i, new HashMap<>());
        }
        this.rowLength = rowLength;
    }


    @Override
    public void registerMove(Player player, int row, int col) {
        char symbol = player.getSymbol();
        rowMap.get(row).putIfAbsent(symbol, 0);
        rowMap.get(row).put(symbol, rowMap.get(row).get(symbol) + 1);

    }

    @Override
    public boolean isWinningMove(Player player, int row, int col) {
        char symbol = player.getSymbol();
        HashMap<Character, Integer> rowCounts = rowMap.get(row);
        return rowCounts.getOrDefault(symbol, 0) == rowLength; // Assuming a win requires 3 in a row
    }
}
