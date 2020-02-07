package model;

public class Cell {

    private int row;
    private int column;

    public Cell (Cell cell) {
        this.row = cell.row;
        this.column = cell.column;
    }

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

    public Cell getUp(Cell currentCell) {
        return new Cell(currentCell.row - 1, currentCell.column);
    }

    public Cell getDown(Cell currentCell) {
        return new Cell(currentCell.row + 1, currentCell.column);
    }

    public Cell getLeft(Cell currentCell) {
        return new Cell(currentCell.row, currentCell.column - 1);
    }

    public Cell getRight(Cell currentCell) {
        return new Cell(currentCell.row, currentCell.column + 1);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
