package model;

import java.util.ArrayList;

public class Mouse {
    private ArrayList<Cell> emptySpaces = new ArrayList<>();
    private final char EMPTY_SPACE = ' ';

    private boolean doesCellEqualTo(Cell cell, char typeOfWall, char[][] maze){
        return maze[cell.getRow()][cell.getColumn()] == typeOfWall;
    }

    private void findEmptySpaces(Cell mouseCoord, char[][] maze) {
        emptySpaces.clear();

        Cell upCell = mouseCoord.getUp(mouseCoord);
        if(doesCellEqualTo(upCell, EMPTY_SPACE, maze)){
            emptySpaces.add(upCell);
        }
        //down
        Cell downCell = mouseCoord.getDown(mouseCoord);
        if (doesCellEqualTo(downCell, EMPTY_SPACE, maze)){
            emptySpaces.add(downCell);
        }
        //left
        Cell leftCell = mouseCoord.getLeft(mouseCoord);
        if(doesCellEqualTo(leftCell, EMPTY_SPACE, maze)){
            emptySpaces.add(leftCell);
        }
        //right
        Cell rightCell = mouseCoord.getRight(mouseCoord);
        if(doesCellEqualTo(rightCell, EMPTY_SPACE, maze)){
            emptySpaces.add(rightCell);
        }
    }

    public boolean isValidMove (Cell userInput, Cell mouseCoord) {
        for (int i = 0; i < emptySpaces.size(); i++) {
            if (userInput.equals(mouseCoord)){
                return true;
            }
        }
        return false;
    }
    public void moveMouse() {

    }
}
