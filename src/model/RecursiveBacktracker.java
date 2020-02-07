package model;

import java.util.ArrayList;
import java.util.Stack;

public class RecursiveBacktracker {

    private final int WALL_NOT_SHOWN = 3;
    private final int SPACE_NOT_SHOWN = 6;
    private int[][] maze = new int[20][15];
    private Stack exploredSpaces;
    private int[][] initialCell = new int[0][0];
    private ArrayList<String> neighbours = new ArrayList<>();

    public boolean isNeighbour() {
        return true;
    }

    public boolean isVisited(String coord) {
        return true;
    }

    public void findNeighbours(String coord) {
    }

    public boolean isValidToDelete(String coord) {
        return true;
    }

    public void deleteWall(String coord) {
    }

    public void chooseRandomSpace(ArrayList neighbours) {
    }

    public void makeIsland() {
    }

    public void getMaze() {
    }


}
