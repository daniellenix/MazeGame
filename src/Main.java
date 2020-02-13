import model.Cell;
import model.GamePlay;
import model.InputTokens;
import model.Mouse;
import ui.PrintMaze;
import ui.PrintMaze2;

import static model.RecursiveBackTracker.COLUMN;
import static model.RecursiveBackTracker.ROW;

public class Main {

    public static void main(String[] args) {

//        GamePlay gamePlay = new GamePlay();
//        gamePlay.setInitialMaze();
//        char[][] maze = gamePlay.getMaze();
//
//        for (int i = 0; i < ROW; i++) {
//            for (int j = 0; j < COLUMN; j++) {
//                System.out.print(maze[i][j]);
//            }
//            System.out.println();
//        }

        PrintMaze2 printMaze = new PrintMaze2();
        printMaze.playGame();
    }
}



