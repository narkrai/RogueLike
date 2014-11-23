package model;

import controller.Game;

import java.util.ArrayList;
import java.util.List;
/**
 * La Room contient un emsemble de Cell (y compris des autres Rooms)
 * elle regroupe tous les operations sur ces objets 
 */
public class Room extends Cell{


    /**
     * Le caracter de la Room
     */
    final char CHARACTER = '>';
    /**
     * les contenus 
     */
    private ArrayList<Cell> Contenus = new ArrayList<Cell>();
 
    private  int tailleX;
    private int tailleY;



    /**
     * Constructeur de Room ( a utilisé uniquement pour la création de la Room pere)
     * @param IStrategy stratégie de création de room et d'arboreance  
     */
    public Room(IStrategy strat) {
        
        
        
        strat.CreationRoom(this);

        
    }
    /**
     * Constructeur de Room ( a utilisé uniquement pour la création des Rooms fils)
     * @param IStrategy stratégie de création de room et d'arboresance  
     * @param Room room contenant cette Room
     * 
     */
    public Room(IStrategy strat,Room conteneur ) {
        
        this.setConteneur(conteneur);
        
        strat.CreationRoom(this);
    
    }
    
    
     /**
     *Fonction permettant d'obtenir une Cell à l'interieur de la Room 
     * @param x coordonnées X
     * @param y coordonnées Y
     * @return Cell ayant ces cordonnées (NULL si inexistant)
     */
    public Cell getCell(int x,int y) {
        
        Cell res = null;
        boolean estTrouve = false;
        if( x < tailleX && y < tailleY)
        {
            for(int i =0 ; i < this.Contenus.size() && !estTrouve ;i++ ){
                                                                       
                 Cell c = this.Contenus.get(i);                                                   
                
                if( c.getPositionX() == x && c.getPositionY() == y ) 
                {
                    res = c;
                    estTrouve = true;
            
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
            for(int posX = 0 ; posX <= 2 ; posX++) {
                for(int posY = 0 ; posY <= 2 ; posY++) {
                    if(!(posY == 1 && posX == 1))
                    {
                        
                        if(this.getCell(x+posX-1, y+posY-1) != null) {
                            Cell c = this.getCell(x+posX-1, y+posY-1);
                            res.add(c);
                        }
                    }
                }
            }
        
       
        
        }
        
        return res;
        
    }
    
    public char getCHARACTER(){
        
        char res;
        
        if(this.isDiscovered()) {
            
           res = this.CHARACTER;
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
    
    /**
     * 
     * @return le nombre de Cell contenus
     */
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

    /**
     *L'etage de la Room
     * @return le numero d'etage
     */
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

    /**
     * Fonction abstraite permettant de savoir le nombre de gold de la Cell
     * @return le total de Gold que la Cell contient (lors Gold des Monsters)
     */
    @Override
    public int GetTotalGold() {
        
        int res = 0 ;
        for( Cell c :  Contenus) {
            
            res += c.GetTotalGold();
        }
        
        return res;
    }
    /**
     *Fonction abstraite permettant de savoir le nombre de Monster de la Cell
     * @return le total de Monster que la Cell contient
     */
    @Override
    public int GetTotalMonster() {
        
        int res = 0 ;
        for( Cell c :  Contenus) {
            
            res += c.GetTotalMonster();
        }
        
        return res;
        
    }
    /**
     *  Permet de connaitre le nombre de Rooms indirect (non recursive)
     * @return le nombre de rooms 
     */
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
    /**
     * Permet de savoir si la Room est relié au pere (conteneur) 
     * vrai si le conteneur est null.
     * @return est relie au pere
     */
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
    
     /**
     *Permet de connaitre si la Room a une Cell contenant une Sortie
     * @return le nombre de sortie
     */
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
    /**
     * Permet de connaitre toutes les Rooms fils de cette Room (Recursivité)
     * @return la liste des Rooms fils
     */
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
    /**
     *Permet d'ajouter une Cell
     * @param c la Cell
     */
    public void AjoutCell(Cell c) {
        this.Contenus.add(c);
        
    }
    
    /**
     *Permet à une Room pere de connaitre l'etage minimun de ces fils
     * @return
     */
    public int AvoirLeNiveauMinDesFils() {
        
        int res = this.numeroEtage();
        ArrayList<Room> listRoom = this.avoirLesRoomsFils();
        
        for( Room r : listRoom ) {
            
            if(r.AvoirLeNiveauMinDesFils() > res) {
                res = r.AvoirLeNiveauMinDesFils();
            }
        }
        
     return res;   
        
    }
        

}
