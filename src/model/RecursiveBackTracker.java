package model;

import java.util.ArrayList;
import java.util.Stack;

public class RecursiveBackTracker {

    private final int WALL_NOT_SHOWN = 3;
    private final int WALL_SHOWN = 4;
    private final int SPACE_NOT_SHOWN = 6;
    private int[][] maze = new int[20][15];
    private Stack<Cell> exploredSpaces = new Stack<>();
    private Cell initialCell = new Cell(0,0);
    private ArrayList<Cell> neighbours = new ArrayList<>();

    public void makeMaze(){
        exploredSpaces.push(initialCell);
    }

    public void setOutsideWalls() {

    }

    public boolean hasValidNeighbour(Cell cell) {
    return true;
    }

    public boolean isVisited(Cell coord) {
        return true;
    }

    public void findNeighbours(Cell coord) {
    }

    public boolean isValidToDelete(Cell coord) {
        return true;
    }

    public void deleteWall(Cell coord) {
    }

    public void chooseRandomSpace(ArrayList<Cell> neighbours) {
    }

    public void makeIsland() {
    }

    public void getMaze() {
    }


}
