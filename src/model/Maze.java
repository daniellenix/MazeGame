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
        m.makeMaze();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    public void setInitialMaze() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                maze[i][j] = WALL;
            }
        }
        for (int i = 0; i < 15; i++) {
            maze[0][i] = PERIMETER_WALL;
            maze[ROW - 1][i] = PERIMETER_WALL;
        }
        for (int i = 0; i < 20; i++) {
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
        if(doesCellEqualTo(upCell, WALL) && hasOnlyOneAdjacentSpace(upCell)){
            neighbours.add(upCell);
        }
        //down
        Cell downCell = cell.getDown(cell);
        if (doesCellEqualTo(downCell, WALL) && hasOnlyOneAdjacentSpace(downCell)){
            neighbours.add(downCell);
        }
        //left
        Cell leftCell = cell.getLeft(cell);
        if(doesCellEqualTo(leftCell, WALL) && hasOnlyOneAdjacentSpace(leftCell)){
            neighbours.add(leftCell);
        }
        //right
        Cell rightCell = cell.getRight(cell);
        if(doesCellEqualTo(rightCell, WALL) && hasOnlyOneAdjacentSpace(rightCell)){
            neighbours.add(rightCell);
        }
    }

    private boolean hasOnlyOneAdjacentSpace(Cell cell) {
        int counter = 0;
        Cell upCell = cell.getUp(cell);
        if(maze[upCell.getRow()][upCell.getColumn()] == EMPTY_SPACE){
            counter++;
        }
        //down
        Cell downCell = cell.getDown(cell);
        if (maze[downCell.getRow()][downCell.getColumn()] == EMPTY_SPACE){
            counter++;
        }
        //left
        Cell leftCell = cell.getLeft(cell);
        if(maze[leftCell.getRow()][leftCell.getColumn()] == EMPTY_SPACE){
            counter++;
        }
        //right
        Cell rightCell = cell.getRight(cell);
        if(maze[rightCell.getRow()][rightCell.getColumn()] == EMPTY_SPACE){
            counter++;
        }
        return counter == 1;
    }
}
