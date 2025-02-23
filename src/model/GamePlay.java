package model;

import java.util.ArrayList;

import static model.RecursiveBackTracker.*;

/**
 * Handles game play, and initializes the maze.
 */
public class GamePlay {
    private static char[][] maze = new char[ROW][COLUMN];

    public static char[][] getMaze() {
        return maze;
    }

    public void setInitialMaze(){
        initializeMaze();
        InputTokens inputTokens = new InputTokens();
        inputTokens.setInitialTokens(maze);
    }

    private void initializeMaze(){
        RecursiveBackTracker mazeMaker = new RecursiveBackTracker();

        boolean isMazeValid = false;
        while(!isMazeValid){
            mazeMaker.makeMaze();
            if (mazeMaker.isMazeValid()){
                maze = mazeMaker.getMaze();
                isMazeValid = true;
            }
        }
    }

    public boolean didMouseGetCheese(Cell cheesePosition, Cell mousePosition){
        return cheesePosition.equals(mousePosition);
    }

    public boolean didCatGetCheese(ArrayList<Cell> catPositions, Cell cheesePosition){
        for (Cell catPosition : catPositions) {
            if (catPosition.equals(cheesePosition)) {
                return true;
            }
        }
        return false;
    }

    public boolean didCatGetMouse(ArrayList<Cell> catPositions, Cell mousePosition){
        for (Cell catPosition : catPositions) {
            if (catPosition.equals(mousePosition)) {
                return true;
            }
        }
        return false;
    }
}