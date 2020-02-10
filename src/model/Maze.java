package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Maze {
    private final char EMPTY_SPACE = '.';
    private final char WALL = '+';
    private final char PERIMETER_WALL = '?';
    private static final int ROW = 20;
    private static final int COLUMN = 15;

    private static char[][] maze = new char[ROW][COLUMN];
    private Stack<Cell> exploredSpaces = new Stack<>();
    private ArrayList<Cell> neighbours = new ArrayList<>();

    public static void main(String[] args) {
        Maze m = new Maze();

        boolean isMazeValid = false;
        while(!isMazeValid){
            m.makeMaze();
            if (m.isMazeValid()){
                isMazeValid = true;
                for (int i = 0; i < ROW; i++) {
                    for (int j = 0; j < COLUMN; j++) {
                        System.out.print(maze[i][j]);
                    }
                    System.out.println();
                }
            }
        }
    }

    private boolean isMazeValid() {
        return (areCornersEmpty() && !hasWallSquare(WALL) && !hasWallSquare(EMPTY_SPACE));
    }

    private boolean hasWallSquare(char typeOfWall) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (maze[i][j] == typeOfWall){
                    Cell currentCell = new Cell(i, j);
                    if (numberOfAdjacentWalls(currentCell, typeOfWall) == 2) {
                        if(cellHasDiagonal(currentCell, typeOfWall)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean cellHasDiagonal(Cell currentCell, char typeOfWall) {
        if (currentCell.hasUpCell(currentCell, typeOfWall, maze) && currentCell.hasRightCell(currentCell, typeOfWall, maze)){
            if (maze[currentCell.getRow() - 1][currentCell.getColumn() + 1] == typeOfWall){
                return true;
            }
        }
        if (currentCell.hasUpCell(currentCell, typeOfWall, maze) && currentCell.hasLeftCell(currentCell, typeOfWall, maze)){
            if (maze[currentCell.getRow() - 1][currentCell.getColumn() - 1] == typeOfWall){
                return true;
            }
        }
        if (currentCell.hasDownCell(currentCell, typeOfWall, maze) && currentCell.hasRightCell(currentCell, typeOfWall, maze)){
            if (maze[currentCell.getRow() + 1][currentCell.getColumn() + 1] == typeOfWall){
                return true;
            }
        }
        if (currentCell.hasDownCell(currentCell, typeOfWall, maze) && currentCell.hasLeftCell(currentCell, typeOfWall, maze)){
            if (maze[currentCell.getRow() + 1][currentCell.getColumn() - 1] == typeOfWall){
                return true;
            }
        }
        return false;
    }

    private boolean areCornersEmpty() {
        return  maze[ROW - 2][1] == EMPTY_SPACE &&
                maze[ROW - 2][COLUMN - 2] == EMPTY_SPACE &&
                maze[1][COLUMN - 2] == EMPTY_SPACE &&
                maze[1][1] == EMPTY_SPACE;
    }


    public void setInitialMaze() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                maze[i][j] = WALL;
            }
        }
        for (int i = 0; i < COLUMN; i++) {
            maze[0][i] = PERIMETER_WALL;
            maze[ROW - 1][i] = PERIMETER_WALL;
        }
        for (int i = 0; i < ROW; i++) {
            maze[i][0] = PERIMETER_WALL;
            maze[i][COLUMN - 1] = PERIMETER_WALL;
        }
    }

    public void makeMaze(){
        setInitialMaze();

        Cell startPoint = new Cell(1, 1);
        exploredSpaces.push(startPoint);
        maze[startPoint.getRow()][startPoint.getColumn()] = EMPTY_SPACE;

        while (!exploredSpaces.empty()){
            findNeighbours(startPoint);
            if (neighbours.isEmpty()){
                if (!exploredSpaces.empty()){
                    startPoint = exploredSpaces.pop();
                }
            } else {
                startPoint = chooseRandomNeighbour();
                maze[startPoint.getRow()][startPoint.getColumn()] = EMPTY_SPACE;
                exploredSpaces.push(startPoint);
            }
        }

        int numberOfIslands = 0;
        while (numberOfIslands != 2){
            numberOfIslands++;
            makeIsland();
        }
    }

    public void makeIsland() {

    }

    private Cell chooseRandomNeighbour() {
        Random random = new Random();
        return neighbours.get(random.nextInt(neighbours.size()));
    }

    private boolean doesCellEqualTo(Cell cell, int typeOfWall){
        return maze[cell.getRow()][cell.getColumn()] == typeOfWall;
    }

    private void findNeighbours(Cell cell) {
        neighbours.clear();

        Cell upCell = cell.getUp(cell);
        if(doesCellEqualTo(upCell, WALL) && numberOfAdjacentWalls(upCell, EMPTY_SPACE) == 1){
            neighbours.add(upCell);
        }
        //down
        Cell downCell = cell.getDown(cell);
        if (doesCellEqualTo(downCell, WALL) && numberOfAdjacentWalls(downCell, EMPTY_SPACE) == 1){
            neighbours.add(downCell);
        }
        //left
        Cell leftCell = cell.getLeft(cell);
        if(doesCellEqualTo(leftCell, WALL) && numberOfAdjacentWalls(leftCell, EMPTY_SPACE) == 1){
            neighbours.add(leftCell);
        }
        //right
        Cell rightCell = cell.getRight(cell);
        if(doesCellEqualTo(rightCell, WALL) && numberOfAdjacentWalls(rightCell, EMPTY_SPACE) == 1){
            neighbours.add(rightCell);
        }
    }

    private int numberOfAdjacentWalls(Cell cell, char typeOfWall) {
        int counter = 0;
        Cell upCell = cell.getUp(cell);
        if(doesCellEqualTo(upCell, typeOfWall)){
            counter++;
        }
        //down
        Cell downCell = cell.getDown(cell);
        if (doesCellEqualTo(downCell, typeOfWall)){
            counter++;
        }
        //left
        Cell leftCell = cell.getLeft(cell);
        if(doesCellEqualTo(leftCell, typeOfWall)){
            counter++;
        }
        //right
        Cell rightCell = cell.getRight(cell);
        if(doesCellEqualTo(rightCell, typeOfWall)){
            counter++;
        }
        return counter;
    }
}
