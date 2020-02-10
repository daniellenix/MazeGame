package model;

import java.util.ArrayList;

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
