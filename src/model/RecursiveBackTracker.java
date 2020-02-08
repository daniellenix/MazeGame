package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class RecursiveBackTracker {

    private final int UNEXPLORED_SPACE = 0;
    private final int CHEESE = 1;
    private final int CAT = 2;
    private final int WALL_NOT_SHOWN = 3;
    private final int WALL_SHOWN = 4;
    private final int SPACE_NOT_SHOWN = 6;
    private final int MOUSE = 7;
    private static final int ROW = 20;
    private static final int COLUMN = 15;
    private static int[][] maze = new int[ROW][COLUMN];
    private Stack<Cell> exploredSpaces = new Stack<>();
    private ArrayList<Cell> neighbours = new ArrayList<>();

    public static void main(String[] args) {
        RecursiveBackTracker m = new RecursiveBackTracker();
        m.makeMaze();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    public void makeMaze() {
        RecursiveBackTracker m = new RecursiveBackTracker();
        m.setInitialMaze();

        Cell currentCell = new Cell(1, 1);
        maze[1][1] = SPACE_NOT_SHOWN;
//        exploredSpaces.push(currentCell);

        while (hasUnexploredSpaces()) {
            if (hasValidNeighbour(currentCell)) {
                findNeighbours(currentCell);
                Cell randomCell = chooseRandomNeighbour(neighbours);
                addSpace(randomCell);
                currentCell = randomCell;
                exploredSpaces.push(randomCell);
                neighbours.remove(randomCell);
                addWall();
            } else if (!exploredSpaces.empty()) {
                Cell poppedCell = exploredSpaces.pop();
                currentCell = poppedCell;
            } else {
                currentCell = getUnexploredSpaces();
            }
        }

    }

    public boolean hasUnexploredSpaces() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 15; j++) {
                if(maze[i][j] == UNEXPLORED_SPACE) {
                    return true;
                }
            }
        }

        return false;
    }

    public Cell getUnexploredSpaces() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 15; j++) {
                if(maze[i][j] == UNEXPLORED_SPACE) {
                    return new Cell(i, j);
                }
            }
        }
        return null;
    }

    public void setInitialMaze() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 15; j++) {
                maze[i][j] = UNEXPLORED_SPACE;
            }
        }
        for (int i = 0; i < 15; i++) {
            maze[0][i] = WALL_SHOWN;
            maze[ROW - 1][i] = WALL_SHOWN;
        }
        for (int i = 0; i < 20; i++) {
            maze[i][0] = WALL_SHOWN;
            maze[i][COLUMN - 1] = WALL_SHOWN;
        }

        maze[18][1] = SPACE_NOT_SHOWN;
        maze[18][13] = SPACE_NOT_SHOWN;
        maze[1][13] = SPACE_NOT_SHOWN;
    }

    public boolean hasValidNeighbour(Cell cell) {
        //up
        Cell upCell = cell.getUp(cell);
        if(maze[upCell.getRow()][upCell.getColumn()] == UNEXPLORED_SPACE){
            return true;
        }
        //down
        Cell downCell = cell.getDown(cell);
        if (maze[downCell.getRow()][downCell.getColumn()] == UNEXPLORED_SPACE){
            return true;
        }
        //left
        Cell leftCell = cell.getLeft(cell);
        if(maze[leftCell.getRow()][leftCell.getColumn()] == UNEXPLORED_SPACE){
            return true;
        }
        //right
        Cell rightCell = cell.getRight(cell);
        if(maze[rightCell.getRow()][rightCell.getColumn()] == UNEXPLORED_SPACE){
            return true;
        }
        return false;
    }

    public boolean isVisited(Cell coord) {
        if(coord.getRow() == SPACE_NOT_SHOWN && coord.getColumn() == SPACE_NOT_SHOWN) {
            return true;
        } else {
            return false;
        }
    }

    public void findNeighbours(Cell cell) {
        neighbours.clear();

        //up
        Cell upCell = cell.getUp(cell);
        if(maze[upCell.getRow()][upCell.getColumn()] == UNEXPLORED_SPACE){
            neighbours.add(upCell);
        }
        //down
        Cell downCell = cell.getDown(cell);
        if (maze[downCell.getRow()][downCell.getColumn()] == UNEXPLORED_SPACE){
            neighbours.add(downCell);
        }
        //left
        Cell leftCell = cell.getLeft(cell);
        if(maze[leftCell.getRow()][leftCell.getColumn()] == UNEXPLORED_SPACE){
            neighbours.add(leftCell);
        }
        //right
        Cell rightCell = cell.getRight(cell);
        if(maze[rightCell.getRow()][rightCell.getColumn()] == UNEXPLORED_SPACE){
            neighbours.add(rightCell);
        }

    }

    public Cell chooseRandomNeighbour(ArrayList<Cell> neighbours) {
        Random random = new Random();
        return neighbours.get(random.nextInt(neighbours.size()));
    }

    public void addSpace(Cell coord) {
        maze[coord.getRow()][coord.getColumn()] = SPACE_NOT_SHOWN;
    }

    public void addWall(Cell coord) {
        maze[coord.getRow()][coord.getColumn()] = WALL_NOT_SHOWN;
    }

    public void addWall() {
        for (Cell neighbour : neighbours) {
            addWall(neighbour);
        }
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
