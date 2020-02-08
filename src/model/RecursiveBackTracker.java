package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class RecursiveBackTracker {

    private final int MOUSE = 0;
    private final int CHEESE = 1;
    private final int CAT = 2;
    private final int WALL_NOT_SHOWN = 3;
    private final int WALL_SHOWN = 4;
    private final int SPACE_NOT_SHOWN = 6;
    private static Cell[][] maze = new Cell[20][15];
    private Stack<Cell> exploredSpaces = new Stack<>();
    private ArrayList<Cell> neighbours = new ArrayList<>();

    public static void main(String[] args) {
        RecursiveBackTracker m = new RecursiveBackTracker();
        m.makeMaze();
//        m.setInitialMaze();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    public void makeMaze(){
        RecursiveBackTracker m = new RecursiveBackTracker();
        m.setInitialMaze();

        Cell currentCell = new Cell(1,1, true, SPACE_NOT_SHOWN);
        maze[1][1] = currentCell;

        while(hasUnexploredSpaces()) {
            if(hasValidNeighbour(currentCell)) {
                findNeighbours(currentCell);
                Cell randomCell = chooseRandomNeighbour(neighbours);
                exploredSpaces.push(currentCell);
                deleteNeighbour(randomCell);
                currentCell = randomCell;
                currentCell.setVisited(true);
            } else if(!exploredSpaces.empty()){
                Cell poppedCell = exploredSpaces.pop();
                currentCell = poppedCell;
            }
        }
    }

    public boolean hasUnexploredSpaces() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 15; j++) {
                if(!maze[i][j].getIsVisited()) {
                    return true;
                }
            }
        }
        return false;
    }


    public void setInitialMaze() {

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 15; j++) {
                maze[i][j] = new Cell(i, j, false, WALL_NOT_SHOWN);
            }
        }

        for (int i = 0; i < 15; i++) {
            maze[0][i] = new Cell(0, i, false, WALL_SHOWN);
            maze[19][i] = new Cell(19, i, false, WALL_SHOWN);
        }
        for (int i = 0; i < 20; i++) {
            maze[i][0] = new Cell(i, 0, false, WALL_SHOWN);
            maze[i][14] = new Cell(i, 14, false, WALL_SHOWN);
        }

        maze[18][1] = new Cell(18, 1, false, SPACE_NOT_SHOWN);
        maze[18][13] = new Cell(18, 13, false, SPACE_NOT_SHOWN);
        maze[1][13] = new Cell(1, 13, false, SPACE_NOT_SHOWN);
    }

    public boolean hasValidNeighbour(Cell cell) {
        //up
        Cell upCell = cell.getUp(cell);
        if(upCell.getState() == WALL_NOT_SHOWN && !upCell.getIsVisited()){
            return true;
        }
        //down
        Cell downCell = cell.getDown(cell);
        if (downCell.getState() == WALL_NOT_SHOWN && !downCell.getIsVisited()){
            return true;
        }
        //left
        Cell leftCell = cell.getLeft(cell);
        if(leftCell.getState() == WALL_NOT_SHOWN && !leftCell.getIsVisited()){
            return true;
        }
        //right
        Cell rightCell = cell.getRight(cell);
        if(rightCell.getState() == WALL_NOT_SHOWN && !rightCell.getIsVisited()){
            return true;
        }
        return false;
    }

    public void findNeighbours(Cell cell) {
        neighbours.clear();

        //up
        Cell upCell = cell.getUp(cell);
        if(upCell.getState() == WALL_NOT_SHOWN && !upCell.getIsVisited()){
            neighbours.add(upCell);
        }
        //down
        Cell downCell = cell.getDown(cell);
        if (downCell.getState() == WALL_NOT_SHOWN && !downCell.getIsVisited()){
            neighbours.add(downCell);
        }
        //left
        Cell leftCell = cell.getLeft(cell);
        if(leftCell.getState() == WALL_NOT_SHOWN && !leftCell.getIsVisited()){
            neighbours.add(leftCell);
        }
        //right
        Cell rightCell = cell.getRight(cell);
        if(rightCell.getState() == WALL_NOT_SHOWN && !rightCell.getIsVisited()){
            neighbours.add(rightCell);
        }

    }

//    public boolean isValidToDelete(Cell coord) {
//        if(!isVisited(coord)) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public Cell chooseRandomNeighbour(ArrayList<Cell> neighbours) {
        Random random = new Random();
        return neighbours.get(random.nextInt(neighbours.size()));
    }

    public void deleteNeighbour(Cell coord) {
        coord.setState(SPACE_NOT_SHOWN);
    }

    public void makeIsland() {
    }

    public void getMaze() {
    }


}



//if(hasValidNeighbour(currentCell)){
//            findNeighbours(currentCell);
//            System.out.println();
//            System.out.println("NEIGHBOURS");
//            System.out.println(neighbours);
//
//            Cell randomCell = chooseRandomNeighbour(neighbours);
//            System.out.println();
//            System.out.println("RANDOM CELL");
//            System.out.println(randomCell);
//
//            deleteNeighbour(randomCell);
//            exploredSpaces.push(randomCell);
//            currentCell = new Cell(randomCell);
//            System.out.println();
//            System.out.println("CURRENT CELL");
//            System.out.println(currentCell);
//        }
//
//        System.out.println();
//        System.out.println("RANDOMS NEIGHBOURS");
//        findNeighbours(currentCell);
//        System.out.println(neighbours);
