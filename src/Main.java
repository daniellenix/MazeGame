import ui.PrintMaze;

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

        PrintMaze printMaze = new PrintMaze();
        printMaze.playGame();
    }
}



