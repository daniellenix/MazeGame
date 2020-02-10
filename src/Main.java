import model.Maze;

import static model.Maze.COLUMN;
import static model.Maze.ROW;

public class Main {


    public static void main(String[] args) {
        Maze m = new Maze();
        char[][] maze = m.getMaze();

        boolean isMazeValid = false;
        while(!isMazeValid){
            m.makeMaze();
            if (m.isMazeValid()){
                isMazeValid = true;
                for (int i = 0; i < ROW; i++) {
                    for (int j = 0; j < COLUMN; j++) {
                        System.out.print(maze[i][j]);
                    }
                    System.out.println();
                }
            }
        }
    }
}
