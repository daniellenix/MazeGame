package model;

import java.util.ArrayList;

import static model.RecursiveBackTracker.*;
import static model.RecursiveBackTracker.CAT;

public class Mouse {
    private ArrayList<Cell> emptySpaces = new ArrayList<>();

    private boolean doesCellEqualTo(Cell cell, char typeOfWall, char[][] maze){
        return maze[cell.getRow()][cell.getColumn()] == typeOfWall;
    }

    private void findEmptySpaces(Cell mouseCoord, char[][] maze) {
        emptySpaces.clear();
        //up
        Cell upCell = mouseCoord.getUp(mouseCoord);
        if(doesCellEqualTo(upCell, EMPTY_SPACE, maze) || doesCellEqualTo(upCell, CAT, maze) ||
                doesCellEqualTo(upCell, MOUSE, maze)){
            emptySpaces.add(upCell);
        }
        //down
        Cell downCell = mouseCoord.getDown(mouseCoord);
        if (doesCellEqualTo(downCell, EMPTY_SPACE, maze) || doesCellEqualTo(downCell, CAT, maze) ||
                doesCellEqualTo(downCell, CHEESE, maze)){
            emptySpaces.add(downCell);
        }
        //left
        Cell leftCell = mouseCoord.getLeft(mouseCoord);
        if(doesCellEqualTo(leftCell, EMPTY_SPACE, maze) || doesCellEqualTo(leftCell, CAT, maze) ||
                doesCellEqualTo(leftCell, CHEESE, maze)){
            emptySpaces.add(leftCell);
        }
        //right
        Cell rightCell = mouseCoord.getRight(mouseCoord);
        if(doesCellEqualTo(rightCell, EMPTY_SPACE, maze) || doesCellEqualTo(rightCell, CAT, maze) ||
                doesCellEqualTo(rightCell, CHEESE, maze)){
            emptySpaces.add(rightCell);
        }
    }

    public Cell findMousePosition(char[][] maze){
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (maze[i][j] == MOUSE){
                    return new Cell(i, j);
                }
            }
        }
        //not sure about this
        return null;
    }

    public boolean isValidMove (Cell userInput, char[][] maze) {
        Cell currentMouseCoord = findMousePosition(maze);
        findEmptySpaces(currentMouseCoord, maze);
        for (int i = 0; i < emptySpaces.size(); i++) {
            if (userInput.equals(currentMouseCoord)){
                return true;
            }
        }
        return false;
    }
}
