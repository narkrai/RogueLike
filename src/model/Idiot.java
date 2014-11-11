package model;

import java.util.ArrayList;

public class Idiot implements IStrategy {

    OptionData op = OptionData.getDataInstance();
    
    public Idiot() {
        super();
        
    }

    @Override
    public void CreationRoom(Room r) {
        // TODO Implement this method
      
    }

    @Override
    public Cell CreationCell(Room r, Cell c) {
        int stage = r.numeroEtage();
        Room conteneur = r.getConteneur();
        int numberDoor = r.numberofRoom();
        boolean AEscalier  = r.aCheminVersPere();
        
        
        
        
        return null;
    }

    /*@Override
    public ArrayList<Room> CreateArborescence() {
        // TODO Implement this method
        return null;
    }*/
}
