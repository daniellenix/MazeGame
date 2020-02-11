package ui;

import java.util.Scanner;

import static model.Maze.*;

public class PrintMaze {

    private Scanner userInput;
    private int currentCheese;
    private int totalCheese = 0;

    public void displayMaze(char[][] hiddenMaze, char[][] maze){
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

    public void userDirection(){

        userInput = new Scanner(System.in);
        char choice = userInput.next().charAt(0);

        title();
        displayMenu();

        while(totalCheese < 5) {
            switch(choice) {
                case 'w':
                case 'W':
                    // move up
//                    displayMaze();
                    cheeseCounterDisplay();
                    break;
                case 'd':
                case 'D':
                    // move right
//                    displayMaze();
                    cheeseCounterDisplay();
                    break;
                case 's':
                case 'S':
                    // move down
//                    displayMaze();
                    cheeseCounterDisplay();
                    break;
                case 'a':
                case 'A':
                    // move left
//                    displayMaze();
                    cheeseCounterDisplay();
                    break;
                case '?':
//                    displayMaze();
                    cheeseCounterDisplay();
                    break;
                case 'm':
                case 'M':
//                    displayMaze();
                    cheeseCounterDisplay();
                    break;
                case 'c':
                case 'C':
                    totalCheese = 1;
                    System.out.print("Enter your move [WASD?]: ");
                    break;
                default:
                    System.out.println("Invalid move. Please enter just A (left), S (down), D (right), or W (up).");
                    break;
            }
        }

        if(currentCheese == 5) {
            System.out.println("Congratulations! You won!");
//            displayMaze();
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

    public void displayAsPlaying(){
        System.out.println("Maze:");
        // current state of maze
    }

}
