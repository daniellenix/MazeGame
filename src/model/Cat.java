package model;

import java.util.ArrayList;
import java.util.Random;
import static model.RecursiveBackTracker.*;

//is this where we keep track of the position the cat is on?

public class Cat {
    private ArrayList<Cell> emptySpaces = new ArrayList<>();
    private ArrayList<Cell> newCatPositions = new ArrayList<>();
    private ArrayList<Cell> catPositions = new ArrayList<>();

    public ArrayList<Cell> getCatPositions(char[][] maze){
        catPositions.clear();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (maze[i][j] == CAT){
                    catPositions.add(new Cell(i, j));
                }
            }
        }
        return catPositions;
    }

    public ArrayList<Cell> getNewCatPositions(char[][] maze, ArrayList<Cell> catPositions){
        newCatPositions.clear();

        for (Cell catPosition : catPositions) {
            findEmptySpaces(catPosition, maze);
            Random random = new Random();
            newCatPositions.add(emptySpaces.get(random.nextInt(emptySpaces.size())));
        }
        return newCatPositions;
    }

    private boolean doesCellEqualTo(Cell cell, char typeOfWall, char[][] maze){
        return maze[cell.getRow()][cell.getColumn()] == typeOfWall;
    }

    private void findEmptySpaces(Cell catCoord, char[][] maze) {
        emptySpaces.clear();
        //up
        Cell upCell = catCoord.getUp(catCoord);
        if(doesCellEqualTo(upCell, EMPTY_SPACE, maze) || doesCellEqualTo(upCell, MOUSE, maze) ||
                doesCellEqualTo(upCell, CHEESE, maze)){
            emptySpaces.add(upCell);
        }
        //down
        Cell downCell = catCoord.getDown(catCoord);
        if (doesCellEqualTo(downCell, EMPTY_SPACE, maze) || doesCellEqualTo(upCell, MOUSE, maze) ||
                doesCellEqualTo(upCell, CHEESE, maze)){
            emptySpaces.add(downCell);
        }
        //left
        Cell leftCell = catCoord.getLeft(catCoord);
        if(doesCellEqualTo(leftCell, EMPTY_SPACE, maze) || doesCellEqualTo(upCell, MOUSE, maze) ||
                doesCellEqualTo(upCell, CHEESE, maze)){
            emptySpaces.add(leftCell);
        }
        //right
        Cell rightCell = catCoord.getRight(catCoord);
        if(doesCellEqualTo(rightCell, EMPTY_SPACE, maze) || doesCellEqualTo(upCell, MOUSE, maze) ||
                doesCellEqualTo(upCell, CHEESE, maze)){
            emptySpaces.add(rightCell);
        }
    }
}
