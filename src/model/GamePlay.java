package model;

import java.util.ArrayList;
//need to make a maze in here so we keep changing this private field, and not generate new ones
    //pass this maze to functions

public class GamePlay {
    public boolean didMouseGetCheese(Cell cheesePosition, Cell mousePosition){
        return cheesePosition == mousePosition;
    }

    public boolean didCatGetMouse(ArrayList<Cell> catPositions, Cell mousePosition){
        for (Cell catPosition : catPositions) {
            if (catPosition == mousePosition) {
                return true;
            }
        }
        return false;
    }

    GamePlay(){
    }
}
