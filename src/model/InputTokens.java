package model;

import java.util.ArrayList;
import java.util.Random;
import static model.RecursiveBackTracker.*;

public class InputTokens {

    private Cell mousePosition = new Cell(1,1);
    private Cell cheesePosition;
    private ArrayList<Cell> emptyPositions = new ArrayList<>();

    public void setInitialTokens(char[][] maze){
        maze[ROW - 2][1] = CAT;
        maze[ROW - 2][COLUMN - 2] = CAT;
        maze[1][COLUMN - 2] = CAT;
        maze[1][1] = MOUSE;
        Cell cheeseCell = putCheese(maze);
        cheesePosition = cheeseCell;
        maze[cheeseCell.getRow()][cheeseCell.getColumn()] = CHEESE;
    }

    public Cell getCheesePosition() {
        return cheesePosition;
    }

    public Cell putCheese(char[][] maze) {
        findSpaces(EMPTY_SPACE, maze, emptyPositions);
        Random random = new Random();
        return emptyPositions.get(random.nextInt(emptyPositions.size()));
    }

    public void updateMouseAndMaze(Cell userInput, char[][] maze) {
        Mouse mouse = new Mouse();
        Cell oldMousePosition = mouse.findMousePosition(maze);
        maze[userInput.getRow()][userInput.getColumn()] = MOUSE;
        //wrong - how are we going to remember the piece the cat moves to
        maze[oldMousePosition.getRow()][oldMousePosition.getColumn()] = EMPTY_SPACE;
        mousePosition = userInput;
    }

    public void updateCatsAndMaze(char[][] maze) {
        Cat cat = new Cat();
        ArrayList<Cell> catPositions = cat.getCatPositions(maze);
        ArrayList<Cell> newCatPositions = cat.getNewCatPositions(maze, catPositions);

        for (int i = 0; i < newCatPositions.size(); i++) {
            maze[newCatPositions.get(i).getRow()][newCatPositions.get(i).getColumn()] = CAT;
            maze[catPositions.get(i).getRow()][catPositions.get(i).getColumn()] = EMPTY_SPACE;
        }
    }
}
