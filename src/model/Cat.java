package model;

import java.util.ArrayList;
import java.util.Random;

public class Cat {
    private ArrayList<Cell> emptySpaces = new ArrayList<>();
    private ArrayList<Cell> newCatPositions = new ArrayList<>();
    private final char EMPTY_SPACE = ' ';
    private final char CAT = '!';
    private static final int ROW = 20;
    private static final int COLUMN = 15;

    public void updateCatAndMaze(ArrayList<Cell> catPositions, char[][] maze) {
        for (int i = 0; i < newCatPositions.size(); i++) {
            maze[newCatPositions.get(i).getRow()][newCatPositions.get(i).getColumn()] = CAT;
            maze[catPositions.get(i).getRow()][catPositions.get(i).getColumn()] = EMPTY_SPACE;
        }
    }

    public void pickRandomSpace (ArrayList<Cell> catPositions, char[][] maze) {
        newCatPositions.clear();

        for (Cell catPosition : catPositions) {
            findEmptySpaces(catPosition, maze);
            Random random = new Random();
            newCatPositions.add(emptySpaces.get(random.nextInt(emptySpaces.size())));
        }
    }

    private boolean doesCellEqualTo(Cell cell, char typeOfWall, char[][] maze){
        return maze[cell.getRow()][cell.getColumn()] == typeOfWall;
    }

    private void findEmptySpaces(Cell catCoord, char[][] maze) {
        emptySpaces.clear();

        Cell upCell = catCoord.getUp(catCoord);
        if(doesCellEqualTo(upCell, EMPTY_SPACE, maze)){
            emptySpaces.add(upCell);
        }
        //down
        Cell downCell = catCoord.getDown(catCoord);
        if (doesCellEqualTo(downCell, EMPTY_SPACE, maze)){
            emptySpaces.add(downCell);
        }
        //left
        Cell leftCell = catCoord.getLeft(catCoord);
        if(doesCellEqualTo(leftCell, EMPTY_SPACE, maze)){
            emptySpaces.add(leftCell);
        }
        //right
        Cell rightCell = catCoord.getRight(catCoord);
        if(doesCellEqualTo(rightCell, EMPTY_SPACE, maze)){
            emptySpaces.add(rightCell);
        }
    }
}
