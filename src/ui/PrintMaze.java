package ui;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

import static model.RecursiveBackTracker.*;

public class PrintMaze {

    private int currentCheese = 0;
    private int totalCheese = 5;

    private static char[][] hiddenMaze = new char[ROW][COLUMN];

    Mouse mouse = new Mouse();
    InputTokens inputTokens = new InputTokens();
//    Cell cell = new Cell(1, 1);
    Cat cat = new Cat();

    public void displayMaze(char[][] hiddenMaze, char[][] maze){
        System.out.println("Maze:");

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (maze[i][j] == PERIMETER_WALL || maze[i][j] == MOUSE || maze[i][j] == CHEESE ||
                        maze[i][j] == CAT || hiddenMaze[i][j] == EXPLORED_SPACES){
                    System.out.print(maze[i][j]);
                } else {
                    System.out.println(hiddenMaze[i][j]);
                }
            }
            System.out.println();
        }
    }

    public void testDisplay(char[][] maze) {
        System.out.println("Maze:");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    public void userDirection(){
        while(currentCheese != totalCheese) {
            GamePlay gamePlay = new GamePlay();
            gamePlay.setInitialMaze();
            char[][] maze = GamePlay.getMaze();

            title();
            displayMenu();
            System.out.println();
            testDisplay(maze);

            Cell cheesePosition = inputTokens.getCheesePosition(maze);
            while(!gamePlay.didCatGetMouse(cat.getCatPositions(maze), mouse.findMousePosition(maze)) &&
                    !gamePlay.didMouseGetCheese(cheesePosition, mouse.findMousePosition(maze))) {

                ArrayList<Cell> catPositions = cat.getCatPositions(maze);
                Cell mousePosition = mouse.findMousePosition(maze);

                cheeseCounterDisplay();
                Scanner userInput = new Scanner(System.in);
                char choice = userInput.next().charAt(0);

                switch(choice) {
                    case 'w':
                    case 'W':
                        // move up
                        if(mouse.isValidMove(mousePosition.getUp(mousePosition), maze)) {
                            inputTokens.updateMouseAndMaze(mousePosition.getUp(mousePosition), maze);
                            if (gamePlay.didCatGetMouse(catPositions, mousePosition.getUp(mousePosition))){
                                System.out.println("I'm sorry, you have been eaten!");
                                currentCheese = totalCheese;
                            } else {
                                inputTokens.updateCatsAndMaze(maze);
                                mousePosition = mousePosition.getUp(mousePosition);
                                testDisplay(maze);
                            }
                        } else {
                            System.out.println("Invalid move: you cannot move through walls!");
                        }
                        break;
                    case 'd':
                    case 'D':
                        // move right
                        if(mouse.isValidMove(mousePosition.getRight(mousePosition), maze)) {
                            inputTokens.updateMouseAndMaze(mousePosition.getRight(mousePosition), maze);
                            if (gamePlay.didCatGetMouse(catPositions, mousePosition.getRight(mousePosition))){
                                System.out.println("I'm sorry, you have been eaten!");
                                currentCheese = totalCheese;
                            } else {
                                inputTokens.updateCatsAndMaze(maze);
                                mousePosition = mousePosition.getRight(mousePosition);
                                testDisplay(maze);
                            }
                        } else {
                            System.out.println("Invalid move: you cannot move through walls!");
                        }
                        break;
                    case 's':
                    case 'S':
                        // move down
                        if(mouse.isValidMove(mousePosition.getDown(mousePosition), maze)) {
                            inputTokens.updateMouseAndMaze(mousePosition.getDown(mousePosition), maze);
                            if (gamePlay.didCatGetMouse(catPositions, mousePosition.getDown(mousePosition))){
                                System.out.println("I'm sorry, you have been eaten!");
                                currentCheese = totalCheese;
                            } else {
                                inputTokens.updateCatsAndMaze(maze);
                                mousePosition = mousePosition.getDown(mousePosition);
                                testDisplay(maze);
                            }
                        } else {
                            System.out.println("Invalid move: you cannot move through walls!");
                        }
                        break;
                    case 'a':
                    case 'A':
                        // move left
                        if(mouse.isValidMove(mousePosition.getLeft(mousePosition), maze)) {
                            inputTokens.updateMouseAndMaze(mousePosition.getLeft(mousePosition), maze);
                            if (gamePlay.didCatGetMouse(catPositions, mousePosition.getLeft(mousePosition))){
                                System.out.println("I'm sorry, you have been eaten!");
                                currentCheese = totalCheese;
                            } else {
                                inputTokens.updateCatsAndMaze(maze);
                                mousePosition = mousePosition.getLeft(mousePosition);
                                testDisplay(maze);
                            }
                        } else {
                            System.out.println("Invalid move: you cannot move through walls!");
                        }
                        break;
                    case '?':
                        displayMenu();
                        break;
                    case 'm':
                    case 'M':
                        testDisplay(maze);
                        cheeseCounterDisplay();
                        break;
                    case 'c':
                    case 'C':
                        totalCheese = 1;
                        break;
                    default:
                        System.out.println("Invalid move. Please enter just A (left), S (down), D (right), or W (up).");
                }
            }

            if (gamePlay.didCatGetMouse(cat.getCatPositions(maze), mouse.findMousePosition(maze))) {
                System.out.println("I'm sorry, you have been eaten!");
                currentCheese = totalCheese;
            } else if (gamePlay.didMouseGetCheese(cheesePosition, mouse.findMousePosition(maze))) {
                currentCheese++;
                System.out.println("Congratulations! You won!");
                testDisplay(maze);
            }
        }
    }

    private void cheeseCounterDisplay() {
        String cheeseLine = "Cheese collected: " + currentCheese + " of " + totalCheese;
        System.out.println(cheeseLine);
        String userEntry = "Enter your move [WASD?]: ";
        System.out.print(userEntry);
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
