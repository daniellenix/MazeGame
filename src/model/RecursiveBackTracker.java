package model;

import java.util.ArrayList;
import java.util.Stack;

public class RecursiveBackTracker {

    private final int WALL_NOT_SHOWN = 3;
    private final int WALL_SHOWN = 4;
    private final int SPACE_NOT_SHOWN = 6;
    private static int[][] maze = new int[20][15];
    private Stack<Cell> exploredSpaces = new Stack<>();
    private Cell initialCell = new Cell(0,0);
    private ArrayList<Cell> neighbours = new ArrayList<>();

    public static void main(String[] args) {
        RecursiveBackTracker m = new RecursiveBackTracker();
        m.setOutsideWalls();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    public void makeMaze(){
        exploredSpaces.push(initialCell);

    }

    public void setOutsideWalls() {
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
