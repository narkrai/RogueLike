package model;

import controller.Game;

import java.util.ArrayList;
import java.util.List;

public class Room extends Cell{


    /**
     * @associates <{rogue.cell}>
     * @aggregation shared
     */
    private ArrayList<Cell> Contenus = new ArrayList<Cell>();
 
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
    
    
     /**
     *Fonction permettant d'obtenir une Cell à l'interieur de la Room 
     * @param x coordonnées X
     * @param y coordonnées Y
     * @return Cell ayant ces cordonnées (NULL si inexistant)
     */
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
    
    
    /**
     *Fonction permettant d'éclairer la Cell désignée par les coordonnées ainsi que les Cells environnantes  
     * @param x coordonnées x
     * @param y coordonnées y
     */
    public void lightNear(int x,int y) {
        
        ArrayList<Cell> tabCell = CellNear(x,y);
        
        for(Cell c : tabCell) {
         
            c.setDiscovered(true);
        
        }
    }
    /**
     *Fonction permettant de connaitre les monstres dans  les Cells environnantes de la coordonnée  
     * @param x coordonnées x
     * @param y coordonnées y
     * @return nombre de monstre envirronnants
     */
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
    /**Fonction permettant de connaitre les  Cells environnantes de la coordonnée  
    * @param x coordonnées x
    * @param y coordonnées y
    * @return Cells environnantes
    */
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
        OptionData op = OptionData.getDataInstance();
        int res  = 0 ;
        
        if(super.getConteneur() == null){
            
            
            res = 0 - op.getDepthmax();
            
        }
        else {
            res = this.getConteneur().numeroEtage() + 1;
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
        if(this.Contenus != null){
        for( Cell c : this.Contenus) {
            if(c instanceof Room) {
                res++;
            }
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
    
     
   public int aUneSortie() {
        
    int res = 0;

    if(Contenus != null)
    {
            for(Cell c : this.Contenus) {
                
                res += c.aUneSortie();
                    
                }
            
            
            
        }
       return res ;
   }
    
    public ArrayList<Room> avoirLesRoomsFils() {
        
        ArrayList<Room> res = new ArrayList<Room>();
        
        for(Cell c : this.getContenus()) {
            
            if( c instanceof Room) {
                Room r = (Room) c ;
                res.add(r);
                res.addAll(r.avoirLesRoomsFils());
            }
            
        }
        
        return res ;
    }
    
    public void AjoutCell(Cell c) {
        this.Contenus.add(c);
        
    }
    
    
    public int AvoirLeNiveauMinDesFils() {
        
        int res = this.numeroEtage();
        ArrayList<Room> listRoom = this.avoirLesRoomsFils();
        
        for( Room r : listRoom ) {
            
            if(r.AvoirLeNiveauMinDesFils() < res) {
                res = r.AvoirLeNiveauMinDesFils();
            }
        }
        
     return res;   
        
    }
        

}
