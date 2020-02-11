package model;

import java.util.ArrayList;

import static model.RecursiveBackTracker.COLUMN;
import static model.RecursiveBackTracker.ROW;
//need to make a maze in here so we keep changing this private field, and not generate new ones
    //pass this maze to functions

public class GamePlay {
    public static char[][] getMaze() {
        return maze;
    }

    private static char[][] maze = new char[ROW][COLUMN];

    public void setIntialMaze(){
        initializeMaze();
        InputTokens inputTokens = new InputTokens();
        inputTokens.setInitialTokens(maze);
    }

    public void initializeMaze(){
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

    public boolean didCatGetMouse(ArrayList<Cell> catPositions, Cell mousePosition){
        for (Cell catPosition : catPositions) {
            if (catPosition.equals(mousePosition)) {
                return true;
            }
        }
        return false;
    }

}
