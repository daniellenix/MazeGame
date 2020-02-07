package model;

import java.util.ArrayList;
import java.util.Stack;

public class RecursiveBacktracker {

    private final int WALL_NOT_SHOWN = 3;
    private final int SPACE_NOT_SHOWN = 6;
    private int[][] maze = new int[20][15];
    private Stack exploredSpaces;
    private int[][] initialCell = new int[0][0];
    private ArrayList<Cell> neighbours = new ArrayList<>();
    private final int SPACENOTSHOWN = 6;

    public boolean isNeighbour() {
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
