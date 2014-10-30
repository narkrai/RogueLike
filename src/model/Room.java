package model;

import controller.Game;

import java.util.ArrayList;
import java.util.List;

public class Room extends Cell{


    /**
     * @associates <{rogue.cell}>
     * @aggregation shared
     */
    private ArrayList<Cell> Contenus;
 
    private  int tailleX;
    private int tailleY;


    public Room(IStrategy strat) {
        
    }
    
    
    
    


    public ArrayList<Cell> getContenus() {
        return Contenus;
    }

    public int getTailleX() {
        return tailleX;
    }


    public int getTailleY() {
        return tailleY;
    }
    
    
    public int GetSizeContenus() {
        return Contenus.size();
    }


    @Override
    public int numeroEtage() {
        // TODO Implement this method
        return 0;
    }

    @Override
    public int GetTotalGold() {
        // TODO Implement this method
        return 0;
    }

    @Override
    public int GetTotalMonster() {
        // TODO Implement this method
        return 0;
    }
}
