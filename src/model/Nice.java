package model;

import java.util.ArrayList;
import java.util.Random;

public class Nice implements IStrategy {
    public Nice() {
        super();
    }
    
    
    private Room PeredeTous;
    private int roomCreated = 0;
    private boolean cheminSortant = false;

    @Override
    public void CreationRoom(Room roomPere) {
    OptionData opdataCurrent = OptionData.getInstance();
    
    Cell cellCreated;
    Cell cellChosen;
    
    roomPere.setContenus(new ArrayList<Cell>());
    Random rand = new Random();
    int randX;
    int randY;
    
    roomPere.setTailleX(opdataCurrent.getTailleXRoom());
    roomPere.setTailleY(opdataCurrent.getTailleYRoom());
    
    randX = rand.nextInt(roomPere.getTailleX());
    randY = rand.nextInt(roomPere.getTailleY());
    //Construction du chemin gagnant
    if(!this.cheminSortant) {
        
    }
    
    
    
    //Creation de la salle selon sa taille
    for( int x = 0 ; x < roomPere.getTailleX() ;x++) {
        for(int y = 0 ; y < roomPere.getTailleY(); y++){
            
            cellCreated = CreationCell(roomPere);
            cellCreated.setPositionX(x);
            cellCreated.setPositionY(y);
            cellCreated.setConteneur(roomPere);
            roomPere.AjoutCell(cellCreated);
            System.out.println(x+" , "+y);
            
        }
                        
    }
    
    
    //Creation d'un escalier descendant  vers le pere si la Room est un fils
        while(!roomPere.aCheminVersPere()) { 
             randX=  rand.nextInt( roomPere.getTailleX()) ;
            randY =  rand.nextInt( roomPere.getTailleY());
            
             cellChosen = roomPere.getCell(randX, randY);
              
              if( !(cellChosen instanceof Room) ) {
                  
                  CellUnit cC = (CellUnit) cellChosen;                      
                      Stair st = new Stair(roomPere);
                      cC.setItem(st);
                      System.out.println("Chemin vers pere crée");
                    

        }
        
    
    }
        
    
    

    
    System.out.println("Room terminé etage" +roomPere.numeroEtage() +" et a un chemin vers pere");
                
            
     
    }

    @Override
    public Cell CreationCell(Room r) {
        // TODO Implement this method
        return null;
    }

    @Override
    public ArrayList<Room> CreateArborescence() {
       
       roomCreated = 0;
       cheminSortant = false;
       
       
       PeredeTous = new Room(this);
       
       
       
       
       
        return null;
    }

    
    
    public String toString(){
        return "Nice (NON FAIT !)";
    }
}
