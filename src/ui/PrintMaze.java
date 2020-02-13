package ui;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;
import static model.RecursiveBackTracker.*;

public class PrintMaze {
    private int currentCheese = 0;
    private int totalCheese = 5;

    Mouse mouse = new Mouse();
    InputTokens inputTokens = new InputTokens();
    Cat cat = new Cat();


    public void revealedMazeDisplay(char[][] maze) {
        System.out.println("Maze:");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    public void hiddenMazeDisplay(char[][] hiddenMaze, char[][] maze){
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (maze[i][j] == MOUSE || maze[i][j] == CHEESE ||
                        maze[i][j] == CAT || hiddenMaze[i][j] == EXPLORED_SPACES){
                    System.out.print(maze[i][j]);
                } else {
                    System.out.print(hiddenMaze[i][j]);
                }
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

            MazeRevealer mazeRevealer = new MazeRevealer();
            mazeRevealer.setInitialHiddenMaze();

            char[][] hiddenMaze = mazeRevealer.getHiddenMaze();

            System.out.println();
//            revealedMazeDisplay(maze);
            mazeRevealer.updateHiddenMaze(mouse.findMousePosition(maze));
            hiddenMazeDisplay(hiddenMaze, maze);

            Cell cheesePosition = inputTokens.getCheesePosition(maze);

            while(playerIsNotDead && !gamePlay.didMouseGetCheese(cheesePosition, mouse.findMousePosition(maze))) {
                ArrayList<Cell> catPositions = cat.getCatPositions(maze);
                Cell mousePosition = mouse.findMousePosition(maze);

                cheeseCounterDisplay();
                enterMoveDisplay();

                Scanner userInput = new Scanner(System.in);
                char choice = userInput.next().charAt(0);
                System.out.println();

                switch (choice) {
                    case 'w':
                    case 'W':
                        // move up
                        playerIsNotDead = isPlayerIsNotDead(playerIsNotDead, gamePlay, maze, catPositions, mousePosition.getUp(mousePosition));
                        setCheese(maze, cheesePosition, catPositions, mouse.findMousePosition(maze));
                        break;
                    case 'd':
                    case 'D':
                        // move right
                        playerIsNotDead = isPlayerIsNotDead(playerIsNotDead, gamePlay, maze, catPositions, mousePosition.getRight(mousePosition));
                        setCheese(maze, cheesePosition, catPositions, mouse.findMousePosition(maze));
                        break;
                    case 's':
                    case 'S':
                        // move down
                        playerIsNotDead = isPlayerIsNotDead(playerIsNotDead, gamePlay, maze, catPositions, mousePosition.getDown(mousePosition));
                        setCheese(maze, cheesePosition, catPositions, mouse.findMousePosition(maze));
                        break;
                    case 'a':
                    case 'A':
                        // move left
                        playerIsNotDead = isPlayerIsNotDead(playerIsNotDead, gamePlay, maze, catPositions, mousePosition.getLeft(mousePosition));
                        setCheese(maze, cheesePosition, catPositions, mouse.findMousePosition(maze));
                        break;
                    case '?':
                        displayMenu();
                        break;
                    case 'm':
                    case 'M':
                        revealedMazeDisplay(maze);
                        cheeseCounterDisplay();
                        enterMoveDisplay();
                        break;
                    case 'c':
                    case 'C':
                        totalCheese = 1;
                        break;
                    default:
                        System.out.println("Invalid move. Please enter just A (left), S (down), D (right), or W (up).");
                }
            }

            if (playerIsNotDead) {
                currentCheese++;
                System.out.println("Congratulations! You won!");
                cheeseCounterDisplay();
                System.out.println();
                revealedMazeDisplay(maze);
            }
        }

        if (!playerIsNotDead) {
            System.out.println("Cheese collected: " + currentCheese + " of " + totalCheese);
            System.out.println("GAME OVER; please try again.");
        }
    }


    public boolean isPlayerIsNotDead(boolean playerIsNotDead, GamePlay gamePlay, char[][] maze, ArrayList<Cell> catPositions, Cell cell) {
        if (mouse.isValidMove(cell, maze)) {
            inputTokens.updateMouseAndMaze(cell, maze);
            if (gamePlay.didCatGetMouse(catPositions, cell)) {
                System.out.println("I'm sorry, you have been eaten!");
                playerIsNotDead = false;
            } else {
                inputTokens.updateCatsAndMaze(maze);
                if (mouse.findMousePosition(maze) == null || gamePlay.didCatGetMouse(cat.getCatPositions(maze), mouse.findMousePosition(maze))) {
                    System.out.println("I'm sorry, you have been eaten!");
                    playerIsNotDead = false;
                }
                revealedMazeDisplay(maze);
            }
        } else {
            System.out.println("Invalid move: you cannot move through walls!");
        }
        return playerIsNotDead;
    }

    private void cheeseCounterDisplay() {
        String cheeseLine = "Cheese collected: " + currentCheese + " of " + totalCheese;
        System.out.println(cheeseLine);
    }

    private void enterMoveDisplay() {
        String userEntry = "Enter your move [WASD?]: ";
        System.out.print(userEntry);
    }

    public void setCheese(char[][] maze, Cell cheesePosition, ArrayList<Cell> catPositions, Cell mousePosition) {
        GamePlay gamePlay = new GamePlay();
        if (!gamePlay.didCatGetCheese(catPositions, cheesePosition) && !gamePlay.didMouseGetCheese(cheesePosition, mousePosition)) {
            maze[cheesePosition.getRow()][cheesePosition.getColumn()] = CHEESE;
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
