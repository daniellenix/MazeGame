package ui;

import java.util.Scanner;

import static model.Maze.*;

public class PrintMaze {
    private Scanner userInput;

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

    //you can use .equalsToLower()
    public void userDirection(){
        userInput = new Scanner(System.in);
        char choice = userInput.next().charAt(0);

        switch(choice) {
            case 'w':
            case 'W':
                // move up
                break;
            case 'd':
            case 'D':
                // move right
                break;
            case 's':
            case 'S':
               // move down
                break;
            case 'a':
            case 'A':
                // move left
                break;
            default:
                System.out.println("Error: Please enter a selection between 1 and 6");
                break;
        }
    }

    public void displayMenu(){

    }

    public void displayApplication(){

    }

}
