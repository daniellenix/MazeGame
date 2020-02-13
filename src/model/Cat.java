package model;

import java.util.ArrayList;
import java.util.Random;
import static model.RecursiveBackTracker.*;

public class Cat {
    private ArrayList<Cell> validMoves = new ArrayList<>();
    private ArrayList<Cell> newCatPositions = new ArrayList<>();
    private ArrayList<Cell> catPositions = new ArrayList<>();
    private ArrayList<Cell> oldCatPositions = new ArrayList<>();

    public void updateOldCatPositions(ArrayList<Cell> catPositions){
        oldCatPositions.clear();
        oldCatPositions.addAll(catPositions);
    }

    public ArrayList<Cell> getCatPositions(char[][] maze){
        catPositions.clear();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (maze[i][j] == CAT){
                    catPositions.add(new Cell(i, j));
                }
            }
        }
        return catPositions;
    }

    public ArrayList<Cell> getNewCatPositions(char[][] maze, ArrayList<Cell> catPositions){
        newCatPositions.clear();
        System.out.println("current cat position");
        System.out.println(catPositions);
        System.out.println("old cat position:");
        System.out.println(oldCatPositions);

        for (Cell catPosition : catPositions) {
            findValidMoves(catPosition, maze);
            if (validMoves.size() != 1){
                for (Cell oldCatPosition : oldCatPositions) {
                    validMoves.remove(oldCatPosition);
                }
            }
            Random random = new Random();
            newCatPositions.add(validMoves.get(random.nextInt(validMoves.size())));
        }
        System.out.println("new cat position");
        System.out.println(newCatPositions);
        updateOldCatPositions(catPositions);
        System.out.println("old cat position:");
        System.out.println(oldCatPositions);
        return newCatPositions;
    }

    private boolean doesCellEqualTo(Cell cell, char typeOfWall, char[][] maze){
        return maze[cell.getRow()][cell.getColumn()] == typeOfWall;
    }

    private void findValidMoves(Cell catCoord, char[][] maze) {
        validMoves.clear();
        //up
        Cell upCell = catCoord.getUp(catCoord);
        if(doesCellEqualTo(upCell, EMPTY_SPACE, maze) || doesCellEqualTo(upCell, MOUSE, maze) ||
                doesCellEqualTo(upCell, CHEESE, maze)){
            validMoves.add(upCell);
        }
        //down
        Cell downCell = catCoord.getDown(catCoord);
        if (doesCellEqualTo(downCell, EMPTY_SPACE, maze) || doesCellEqualTo(downCell, MOUSE, maze) ||
                doesCellEqualTo(downCell, CHEESE, maze)){
            validMoves.add(downCell);
        }
        //left
        Cell leftCell = catCoord.getLeft(catCoord);
        if(doesCellEqualTo(leftCell, EMPTY_SPACE, maze) || doesCellEqualTo(leftCell, MOUSE, maze) ||
                doesCellEqualTo(leftCell, CHEESE, maze)){
            validMoves.add(leftCell);
        }
        //right
        Cell rightCell = catCoord.getRight(catCoord);
        if(doesCellEqualTo(rightCell, EMPTY_SPACE, maze) || doesCellEqualTo(rightCell, MOUSE, maze) ||
                doesCellEqualTo(rightCell, CHEESE, maze)){
            validMoves.add(rightCell);
        }
    }
}
