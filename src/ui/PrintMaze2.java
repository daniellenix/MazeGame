package ui;

import model.*;

import java.util.ArrayList;

import static model.GamePlay.didCatGetCheese;
import static model.RecursiveBackTracker.COLUMN;
import static model.RecursiveBackTracker.ROW;

public class PrintMaze2 {
    private int currentCheese = 0;
    private int totalCheese = 5;

    private static char[][] hiddenMaze = new char[ROW][COLUMN];

    Mouse mouse = new Mouse();
    InputTokens inputTokens = new InputTokens();
    Cat cat = new Cat();


    public void testDisplay(char[][] maze) {
        System.out.println("Maze:");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    public void playGame() {
        initialMenu();

        boolean playerIsNotDead = true;

        while(currentCheese != totalCheese && playerIsNotDead) {
            GamePlay gamePlay = new GamePlay();
            gamePlay.setInitialMaze();
            char[][] maze = GamePlay.getMaze();

            testDisplay(maze);

            Cell cheesePosition = inputTokens.getCheesePosition(maze);


        }

    }

    public void setCheese(char[][] maze, Cell cheesePosition, ArrayList<Cell> catPositions, Cell mousePosition) {
        GamePlay gamePlay = 
        if (!didCatGetCheese(catPositions, cheesePosition) && !didMouseGetCheese(cheesePosition, mousePosition)) {

        }
    }

    public void initialMenu() {
        title();
        displayMenu();
        System.out.println();
    }

    public void title() {
        String dashes = "----------------------------------------";
        String firstTitle = "Welcome to Cat and Mouse Maze Adventure!";
        String secondTitle = "by Riya Dhariwal and Danielle Nix.";
        System.out.println(dashes);
        System.out.println(firstTitle);
        System.out.println(secondTitle);
        System.out.println(dashes);
    }

    public void displayMenu(){
        String menu = "DIRECTIONS:\n" +
                "\tFind 5 cheese before a cat eats you!\n" +
                "LEGEND:\n" +
                "\t#: Wall\n" +
                "\t@: You (a mouse)\n" +
                "\t!: Cat\n" +
                "\t$: Cheese\n" +
                "\t.: Unexplored space\n" +
                "MOVES:\n" +
                "\tUse W (up), A (left), S (down) and D (right) to move.\n" +
                "\t(You must press enter after each move).";

        System.out.println(menu);
    }

}
