package model;

import java.util.ArrayList;

public class Idiot implements IStrategy {

    OptionData op = OptionData.getDataInstance();
    
    public Idiot() {
        super();
        
    }

    @Override
    public void CreationRoom(Room r) {
        
        Cell c;
        ArrayList<Cell> listCell = new ArrayList<Cell>();
        
        r.setTailleX(op.getTailleXRoom());
        r.setTailleY(op.getTailleYRoom());
        
        for( int x = 0 ; x < op.getTailleXRoom() ;x++) {
            for(int y = 0 ; y < op.getTailleYRoom(); y++){
                
                //c = CreationCell(r,c);
                
                
                
            }
                            
        }
      
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
