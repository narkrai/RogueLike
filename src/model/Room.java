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



    /**
     * Constructeur de Room ( a utilisé uniquement pour la création de la Room pere)
     * @param IStrategy stratégie de création de room et d'arboreance  
     * 
     * 
     */
    public Room(IStrategy strat) {
        
        
        
        strat.CreationRoom(this);
        this.setCHARACTER('>');

        
    }
    /**
     * Constructeur de Room ( a utilisé uniquement pour la création des Rooms fils)
     * @param IStrategy stratégie de création de room et d'arboreance  
     * @param Room room contenant cette Room
     * 
     */
    public Room(IStrategy strat,Room conteneur ) {
        
        this.setConteneur(conteneur);
        
        strat.CreationRoom(this);
        this.setCHARACTER('>');

        
    }

    public Cell getCell(int x,int y) {
        
        Cell res = null;
        
        if( x < tailleX && y < tailleY)
        {
        
            for(Cell c : Contenus) {
                
                if( c.getPositionX() == x && c.getPositionY() == y ) 
                {
                    res = c;
                    
                }
            
            }
        }
        
        return res;
        
    }
    
    public void lightNear(int x,int y) {
        
        ArrayList<Cell> tabCell = CellNear(x,y);
        
        for(Cell c : tabCell) {
         
            c.setDiscovered(true);
        
        }
    }
    
    public int nbMonsterNear(int x,int y) {
      
      int res =0 ;
      
      ArrayList<Cell> tabCell = CellNear(x,y);
      
      for(Cell c : tabCell) {
          
          if(c instanceof CellUnit) {
              CellUnit cC = (CellUnit) c;
              if(cC.getItem() instanceof Monster ) {
                  res++;
              }
          }
      }
      
      return res;
        
    }
    
    public ArrayList<Cell> CellNear(int x,int y){
        
        ArrayList<Cell> res = new ArrayList<Cell>();
        Cell center = this.getCell(x, y);
        
        if(center != null ) {
            res.add(center);
            
            if(this.getCell(x-1, y) != null) {
                res.add(this.getCell(x-1, y));
            }
            if(this.getCell(x-1, y -1) != null) {
                res.add(this.getCell(x-1, y-1));
            }
            if(this.getCell(x, y-1) != null) {
                res.add(getCell(x, y-1));
            }
            if(this.getCell(x+1, y-1) != null) {
                res.add(this.getCell(x+1, y-1));
            }
            if(this.getCell(x+1, y) != null) {
                res.add(this.getCell(x+1, y));
            }
            if(this.getCell(x+1, y+1) != null) {
                res.add(this.getCell(x+1, y+1));
            }
            if(this.getCell(x+1, y-1) != null) {
                res.add(this.getCell(x+1, y-1));
            }
        
       
        
        }
        
        return res;
        
    }
    
    public char setCHARACTER(){
        
        char res;
        
        if(this.isDiscovered()) {
            
           res = '>';
            
            
        }
        else {
            res = super.getCHARACTER();
        }
        
        return res;
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
    
    


    public void setContenus(ArrayList<Cell> Contenus) {
        this.Contenus = Contenus;
    }

    public void setTailleX(int tailleX) {
        this.tailleX = tailleX;
    }

    public void setTailleY(int tailleY) {
        this.tailleY = tailleY;
    }


    @Override
    public int numeroEtage() {
        
        int res  ;
        
        if(super.getConteneur() == null){
            res = 0 - OptionData.getDataInstance().getDepthmax();
            
        }
        else {
            res = super.getConteneur().numeroEtage() + 1 - OptionData.getDataInstance().getDepthmax();
        }
        
        
        return res;
    }

    @Override
    public int GetTotalGold() {
        
        int res = 0 ;
        for( Cell c :  Contenus) {
            
            res += c.GetTotalGold();
        }
        
        return res;
    }

    @Override
    public int GetTotalMonster() {
        
        int res = 0 ;
        for( Cell c :  Contenus) {
            
            res += c.GetTotalMonster();
        }
        
        return res;
        
    }
    
    public int numberofRoom() {
        
        int res = 0;
        for( Cell c : this.Contenus) {
            if(c instanceof Room) {
                res++;
            }
        }
        
        return res ;
    }
    
    public boolean aCheminVersPere() {
        
        boolean oK =false;
        if(super.getConteneur() == null) {
            oK = true;
        }
        else {
            for(Cell c : this.Contenus) {
                if( c instanceof CellUnit) {
                    CellUnit ce = (CellUnit) c;
                    if(!oK && ce.getItem() instanceof Stair) {
                        oK = true ;
                    }
                }
            }
        }
        
        return oK ;
    }
    
    public boolean aUneSortie() {
        
        boolean oK =false;

    
            for(Cell c : this.Contenus) {
                if( c instanceof CellUnit) {
                    CellUnit ce = (CellUnit) c;
                    if(!oK && ce.getItem() instanceof Exit) {
                        oK = true ;
                    }
                }
            }
            
            return oK ;
        }
    
    
    public ArrayList<Room> avoirLesRoomsFils() {
        
        ArrayList<Room> res = new ArrayList<Room>();
        
        for(Cell c : this.getContenus()) {
            
            if( c instanceof Room) {
                Room r = (Room) c ;
                
                res.addAll(r.avoirLesRoomsFils());
            }
            
        }
        
        return res ;
    }
        
        
    
    
}
