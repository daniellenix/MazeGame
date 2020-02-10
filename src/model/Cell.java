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

    public boolean hasUpCell(Cell currentCell, char typeOfWall, char[][] maze){
        Cell upCell = getUp(currentCell);
        return maze[upCell.row][upCell.column] == typeOfWall;
    }

    public boolean hasDownCell(Cell currentCell, char typeOfWall, char[][] maze){
        Cell downCell = getDown(currentCell);
        return maze[downCell.row][downCell.column] == typeOfWall;
    }

    public boolean hasLeftCell(Cell currentCell, char typeOfWall, char[][] maze){
        Cell leftCell = getLeft(currentCell);
        return maze[leftCell.row][leftCell.column] == typeOfWall;
    }

    public boolean hasRightCell(Cell currentCell, char typeOfWall, char[][] maze){
        Cell rightCell = getRight(currentCell);
        return maze[rightCell.row][rightCell.column] == typeOfWall;
    }

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
}
