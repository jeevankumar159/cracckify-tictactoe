package strategy;

import models.Player;

public interface WinningStrategy {

    void registerMove(Player player, int row, int col);
    boolean isWinningMove(Player player, int row, int col);
}
