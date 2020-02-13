package model;

import java.util.ArrayList;

import static model.InputTokens.getToken;
import static model.RecursiveBackTracker.*;

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
        return getToken(maze, MOUSE);
    }

    public boolean isValidMove (Cell userInput, char[][] maze) {
        Cell currentMouseCoord = findMousePosition(maze);
//        System.out.println("current mouse position = " + currentMouseCoord);
//        System.out.println("userInput position = " + userInput);
        findEmptySpaces(currentMouseCoord, maze);
//        System.out.println("list of empty spaces = " + emptySpaces);
        for (Cell emptySpace : emptySpaces) {
            if (userInput.equals(emptySpace)) {
//                System.out.println("in true");
                return true;
            }
        }
//        System.out.println("in false");
        return false;
    }
}
