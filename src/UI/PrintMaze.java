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

    public void userDirection(){

    }

    public void displayMenu(){

    }

    public void displayApplication(){

    }

}
