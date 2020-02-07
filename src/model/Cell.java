package model;

public class Cell {

    private int row;
    private int column;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Cell goUp(Cell oldCell) {
        return new Cell(oldCell.row - 1, oldCell.column);
    }

    public Cell goDown(Cell oldCell) {
        return new Cell(oldCell.row + 1, oldCell.column);
    }

    public Cell goLeft(Cell oldCell) {
        return new Cell(oldCell.column - 1, oldCell.column);
    }

    public Cell goRight(Cell oldCell) {
        return new Cell(oldCell.column + 1, oldCell.column);
    }
}
