package model;

import java.util.ArrayList;

import static model.Maze.*;

public class InputTokens {
    private final char MOUSE = '@';
    private final char CHEESE = '$';
    private final char CAT = '!';

    private Cell mousePosition;
    private Cell cheesePosition;
    private ArrayList<Cell> catPositions;

    public void setInitialTokens(char[][] maze){
        maze[ROW - 2][1] = CAT;
        maze[ROW - 2][COLUMN - 2] = CAT;
        maze[1][COLUMN - 2] = CAT;
        maze[1][1] = MOUSE;
    }

    public void putCheese(char[][] maze) {
    }

    public Cell putCat(char[][] maze){
        return null;
    }


    public void updateCatPositions(){

    }

    public void getCatPositions(){

    }

    public void getMousePosition(){

    }

    public void getCheesePositions(){

    }
}
