package model;

import java.util.ArrayList;
import java.util.Random;

import static model.Maze.*;

public class InputTokens {

    private Cell mousePosition;
    private Cell cheesePosition;
    private ArrayList<Cell> catPositions;
    private ArrayList<Cell> emptyPositions;

    public void setInitialTokens(char[][] maze){
        maze[ROW - 2][1] = CAT;
        maze[ROW - 2][COLUMN - 2] = CAT;
        maze[1][COLUMN - 2] = CAT;
        maze[1][1] = MOUSE;
        Cell cheeseCell = putCheese(maze);
        maze[cheeseCell.getRow()][cheeseCell.getColumn()] = CHEESE;
    }

    public Cell putCheese(char[][] maze) {
        findSpaces(EMPTY_SPACE, maze, emptyPositions);
        Random random = new Random();
        return emptyPositions.get(random.nextInt(emptyPositions.size()));
    }

    public void updateCatAndMaze(char[][] maze) {
        Cat cat = new Cat();
        ArrayList<Cell> catPositions = cat.getCatPositions(maze);
        ArrayList<Cell> newCatPositions = cat.getNewCatPositions(maze);

        for (int i = 0; i < newCatPositions.size(); i++) {
            maze[newCatPositions.get(i).getRow()][newCatPositions.get(i).getColumn()] = CAT;
            maze[catPositions.get(i).getRow()][catPositions.get(i).getColumn()] = EMPTY_SPACE;
        }
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
