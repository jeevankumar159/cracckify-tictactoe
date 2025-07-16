package models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {
    private int rowLength;
    private int columnLength;
    private List<List<Cell>> cells;

    public Board(int rowLength, int columnLength) {
        this.cells = new ArrayList<>();
        this.rowLength = rowLength;
        this.columnLength = columnLength;
        for(int i = 0;i<rowLength;i++){
            this.cells.add(new ArrayList<>());
            for(int j = 0;j<columnLength;j++){
                Cell cell = new Cell(i,j);
                this.cells.get(i).add(cell);
            }
        }
    }
}
