package model;

public class Cell {

    private int row;
    private int column;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    private boolean isVisited;
    private int state;

    public void setState(int state) {
        this.state = state;
    }

    public boolean getIsVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

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

    public int getState() {
        return state;
    }

    public Cell(int row, int column, boolean isVisited, int state) {
        this.row = row;
        this.column = column;
        this.isVisited = isVisited;
        this.state = state;
    }

    public Cell(int row, int column, boolean isVisited) {
        this.row = row;
        this.column = column;
        this.isVisited = isVisited;
    }

//    public Cell goUp(Cell oldCell) {
//        return new Cell(oldCell.row - 1, oldCell.column);
//    }
//
//    public Cell goDown(Cell oldCell) {
//        return new Cell(oldCell.row + 1, oldCell.column);
//    }
//
//    public Cell goLeft(Cell oldCell) {
//        return new Cell(oldCell.column - 1, oldCell.column);
//    }
//
//    public Cell goRight(Cell oldCell) {
//        return new Cell(oldCell.column + 1, oldCell.column);
//    }

    public Cell getUp(Cell currentCell) {
        return new Cell(currentCell.row - 1, currentCell.column, false);
    }

    public Cell getDown(Cell currentCell) {
        return new Cell(currentCell.row + 1, currentCell.column, false);
    }

    public Cell getLeft(Cell currentCell) {
        return new Cell(currentCell.row, currentCell.column - 1, false);
    }

    public Cell getRight(Cell currentCell) {
        return new Cell(currentCell.row, currentCell.column + 1, false);
    }

    @Override
    public String toString() {
        return String.valueOf(state);
    }
}
