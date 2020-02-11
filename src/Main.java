import model.GamePlay;
import model.RecursiveBackTracker;

import static model.RecursiveBackTracker.COLUMN;
import static model.RecursiveBackTracker.ROW;

public class Main {
//while loop here ?
    // if "c" - then loop once becuase 1 cheese
    // if "m" - dont use hidden maze

    public static void main(String[] args) {

        GamePlay gamePlay = new GamePlay();
        gamePlay.setIntialMaze();
        char[][] maze = gamePlay.getMaze();

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }

    }
}
