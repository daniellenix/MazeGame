package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class RecursiveBackTracker {

    private final int MOUSE = 0;
    private final int CHEESE = 1;
    private final int CAT = 2;
    private final int WALL_NOT_SHOWN = 3;
    private final int WALL_SHOWN = 4;
    private final int SPACE_NOT_SHOWN = 6;
    private static int[][] maze = new int[20][15];
    private Stack<Cell> exploredSpaces = new Stack<>();
    private ArrayList<Cell> neighbours = new ArrayList<>();

    public static void main(String[] args) {
        RecursiveBackTracker m = new RecursiveBackTracker();
        m.makeMaze();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    public void makeMaze(){
        RecursiveBackTracker m = new RecursiveBackTracker();
        m.setInitialMaze();

        Cell currentCell = new Cell(1,1);
        maze[1][1] = SPACE_NOT_SHOWN;
        exploredSpaces.push(currentCell);

        while(!exploredSpaces.empty()) {
            while(hasValidNeighbour(currentCell)) {
                findNeighbours(currentCell);
                Cell randomCell = chooseRandomNeighbour(neighbours);
                if(isValidToDelete(randomCell)) {
                    deleteNeighbour(randomCell);
                    exploredSpaces.push(randomCell);
                    currentCell = new Cell(randomCell);
                }
            }
            exploredSpaces.pop();
        }
    }

    public void setInitialMaze() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 15; j++) {
                maze[i][j] = WALL_NOT_SHOWN;
            }
        }
        for (int i = 0; i < 15; i++) {
            maze[0][i] = WALL_SHOWN;
            maze[19][i] = WALL_SHOWN;
        }
        for (int i = 0; i < 20; i++) {
            maze[i][0] = WALL_SHOWN;
            maze[i][14] = WALL_SHOWN;
        }
    }

    public boolean hasValidNeighbour(Cell cell) {
        //up
        Cell upCell = cell.getUp(cell);
        if(maze[upCell.getRow()][upCell.getColumn()] == WALL_NOT_SHOWN){
            return true;
        }
        //down
        Cell downCell = cell.getDown(cell);
        if (maze[downCell.getRow()][downCell.getColumn()] == WALL_NOT_SHOWN){
            return true;
        }
        //left
        Cell leftCell = cell.getLeft(cell);
        if(maze[leftCell.getRow()][leftCell.getColumn()] == WALL_NOT_SHOWN){
            return true;
        }
        //right
        Cell rightCell = cell.getRight(cell);
        if(maze[rightCell.getRow()][rightCell.getColumn()] == WALL_NOT_SHOWN){
            return true;
        }
        return false;
    }

    public boolean isVisited(Cell coord) {
        if(coord.getRow() == SPACE_NOT_SHOWN && coord.getColumn() == SPACE_NOT_SHOWN) {
            return true;
        } else {
            return false;
        }
    }

    public void findNeighbours(Cell cell) {
        neighbours.clear();

        //up
        Cell upCell = cell.getUp(cell);
        if(maze[upCell.getRow()][upCell.getColumn()] == WALL_NOT_SHOWN){
            neighbours.add(upCell);
        }
        //down
        Cell downCell = cell.getDown(cell);
        if (maze[downCell.getRow()][downCell.getColumn()] == WALL_NOT_SHOWN){
            neighbours.add(downCell);
        }
        //left
        Cell leftCell = cell.getLeft(cell);
        if(maze[leftCell.getRow()][leftCell.getColumn()] == WALL_NOT_SHOWN){
            neighbours.add(leftCell);
        }
        //right
        Cell rightCell = cell.getRight(cell);
        if(maze[rightCell.getRow()][rightCell.getColumn()] == WALL_NOT_SHOWN){
            neighbours.add(rightCell);
        }

    }

    public boolean isValidToDelete(Cell coord) {
        if(!isVisited(coord)) {
            return true;
        } else {
            return false;
        }
    }

    public Cell chooseRandomNeighbour(ArrayList<Cell> neighbours) {
        Random random = new Random();
        return neighbours.get(random.nextInt(neighbours.size()));
    }

    public void deleteNeighbour(Cell coord) {
        maze[coord.getRow()][coord.getColumn()] = SPACE_NOT_SHOWN;
    }

    public void makeIsland() {
    }

    public void getMaze() {
    }


}
