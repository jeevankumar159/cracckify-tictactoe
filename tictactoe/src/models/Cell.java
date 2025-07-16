package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private  int row;
    private int column;
    private Player player;
    private CellState cellState;

    Cell(int row, int column){
        this.row = row;
        this.column = column;
        this.cellState = CellState.EMPTY;
    }

}
