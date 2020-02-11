package model;

import static model.RecursiveBackTracker.*;

public class MazeRevealer {
    private static char[][] hiddenMaze = new char[ROW][COLUMN];

    public void updateHiddenMaze(Cell mouseCoord){
        Cell upCell = mouseCoord.getUp(mouseCoord);
        hiddenMaze[upCell.getRow()][upCell.getColumn()] = EXPLORED_SPACES;

        Cell downCell = mouseCoord.getDown(mouseCoord);
        hiddenMaze[downCell.getRow()][downCell.getColumn()] = EXPLORED_SPACES;

        Cell leftCell = mouseCoord.getLeft(mouseCoord);
        hiddenMaze[leftCell.getRow()][leftCell.getColumn()] = EXPLORED_SPACES;

        Cell rightCell = mouseCoord.getRight(mouseCoord);
        hiddenMaze[rightCell.getRow()][rightCell.getColumn()] = EXPLORED_SPACES;

        Cell upLeftDiagonal = mouseCoord.getUpLeftDiagonal(mouseCoord);
        hiddenMaze[upLeftDiagonal.getRow()][upLeftDiagonal.getColumn()] = EXPLORED_SPACES;

        Cell downLeftDiagonal = mouseCoord.getDownLeftDiagonal(mouseCoord);
        hiddenMaze[downLeftDiagonal.getRow()][downLeftDiagonal.getColumn()] = EXPLORED_SPACES;

        Cell downRightDiagonal = mouseCoord.getDownRightDiagonal(mouseCoord);
        hiddenMaze[downRightDiagonal.getRow()][downRightDiagonal.getColumn()] = EXPLORED_SPACES;

        Cell upRightDiagonal = mouseCoord.getUpRightDiagonal(mouseCoord);
        hiddenMaze[upRightDiagonal.getRow()][upRightDiagonal.getColumn()] = EXPLORED_SPACES;
    }

    public void setInitialHiddenMaze(){
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                hiddenMaze[i][j] = UNEXPLORED_SPACES;
            }
        }
        for (int i = 0; i < COLUMN; i++) {
            hiddenMaze[0][i] = PERIMETER_WALL;
            hiddenMaze[ROW - 1][i] = PERIMETER_WALL;
        }
        for (int i = 0; i < ROW; i++) {
            hiddenMaze[i][0] = PERIMETER_WALL;
            hiddenMaze[i][COLUMN - 1] = PERIMETER_WALL;
        }
    }
}
