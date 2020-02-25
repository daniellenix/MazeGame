package model;

import java.util.ArrayList;
import java.util.Random;
import static model.RecursiveBackTracker.*;

/**
 * Places all the tokens in the maze.
 */
public class InputTokens {

    Cat cat = new Cat();

    // set mouse position to top left corner
    private Cell mousePosition = new Cell(1,1);
    private ArrayList<Cell> emptyPositions = new ArrayList<>();

    // Places initial tokens on maze
    public void setInitialTokens(char[][] maze){
        maze[ROW - 2][1] = CAT;
        maze[ROW - 2][COLUMN - 2] = CAT;
        maze[1][COLUMN - 2] = CAT;
        maze[1][1] = MOUSE;
        Cell cheeseCell = putCheese(maze);
        maze[cheeseCell.getRow()][cheeseCell.getColumn()] = CHEESE;
    }

    public Cell getCheesePosition(char[][] maze) {
        return getToken(maze, CHEESE);
    }

    public static Cell getToken(char[][] maze, char token) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (maze[i][j] == token){
                    return new Cell(i, j);
                }
            }
        }
        return null;
    }

    public Cell putCheese(char[][] maze) {
        findSpaces(EMPTY_SPACE, maze, emptyPositions);
        Random random = new Random();
        return emptyPositions.get(random.nextInt(emptyPositions.size()));
    }

    // Updates the maze when mouse is moved
    public void updateMouseAndMaze(Cell userInput, char[][] maze) {
        Mouse mouse = new Mouse();
        Cell oldMousePosition = mouse.findMousePosition(maze);
        maze[userInput.getRow()][userInput.getColumn()] = MOUSE;
        maze[oldMousePosition.getRow()][oldMousePosition.getColumn()] = EMPTY_SPACE;
        mousePosition = userInput;
    }

    // Updates the maze when cat is moved
    public void updateCatsAndMaze(char[][] maze) {
        ArrayList<Cell> catPositions = cat.getCatPositions(maze);
        ArrayList<Cell> newCatPositions = cat.getNewCatPositions(maze, catPositions);

        for (int i = 0; i < newCatPositions.size(); i++) {
            maze[newCatPositions.get(i).getRow()][newCatPositions.get(i).getColumn()] = CAT;
            maze[catPositions.get(i).getRow()][catPositions.get(i).getColumn()] = EMPTY_SPACE;
        }
    }
}
