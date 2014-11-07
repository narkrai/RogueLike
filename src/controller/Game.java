package controller;

import java.util.ArrayList;
import java.util.List;

import model.Cell;
import model.CellUnit;
import model.IStrategy;
import model.Idiot;
import model.OptionData;
import model.Player;
import model.Room;

public class Game {
    
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private IStrategy strategie;
    private Player player;
    
    private final int NORMAL = 0 ;
    private final int VICTORY = 1;
    private final int LOSE = 2;
    
    private final int RIGHT = 0;
    private final int LEFT = 1;
    private final int UP = 2;
    private final int DOWN = 3;

    
    /**
     * @aggregation composite
     */
    private static Game uniqueInstance = null;


    public static Game getInstance(){
        if (uniqueInstance == null) {
            try {
            uniqueInstance = new Game();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        return uniqueInstance;
    }

    private Game() {
        
        this.strategie = new Idiot() ;
       
    }
    
    public void setStrategie(IStrategy strategie) {
        this.strategie = strategie;
    }
    public IStrategy getStrategie() {
        return strategie;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void restart() {
        
        uniqueInstance = new Game() ;
    }
    //
    public void addRoom() {
    
        
    }
    
    private void makeStep(int direction)
    {
        int repAction = 0;
            
        int posPlayX = 0;
        int posPlayY = 0;
        Room r = this.getCurrentRoom();
        
        switch (direction)
        {
            
            //droite (X-1,0)
        case RIGHT :
            
            
            
            for (Cell c : r.getContenus()) 
            {
                if( c instanceof CellUnit) {
                   
                   CellUnit cU = (CellUnit) c ;
                   if(cU.getItem() == player) {
                       
                       posPlayX = cU.getPositionX();
                       posPlayY = cU.getPositionY();
                      
                   }
                }
            }
            
            if(posPlayX - 1 >= 0) {
                
                
                CellUnit Cdepart = (CellUnit)  r.getCell(posPlayX, posPlayY);
                Cell Carrive = r.getCell(posPlayX -1, posPlayY);
                
                
               
                if( Carrive instanceof Room)                
                {
                           //TODO afficher la boite de dialogue et proceder à la teleportation         
                }
                else 
                {
                    CellUnit cA = (CellUnit) Carrive ;
                    
                    if(cA.getItem() != null) {
                      repAction  =  cA.getItem().Action(player);
                      
                      if(repAction == 0) {
                          cA.setItem(player);
                          Cdepart.setItem(null);
                          
                      }
                    }
                    
                }
                r.lightNear(posPlayX -1, posPlayY);
                
            }
        break;
            //left (X,0)    
        case LEFT :
        break;
            //UP (0,Y)
        case UP :
            
        break;
            //DOWN(0,-Y)
        case DOWN:
        
        break;
            //erreur
        default:
            
        }
        
        
        if(repAction == 1) {
            playerWin();
        }
        else if( repAction == 2) {
            gameOver();
        }
        
    }
    
    
    public void gameOver() {
        
    }
    
    public void playerWin(){
        
    }
    
    
    
    public Room getCurrentRoom() {
        Room res = null;
        
        for( Room r : rooms) {
            
            for (Cell c : r.getContenus()) 
            {
                if( c instanceof CellUnit) {
                   
                   CellUnit cU = (CellUnit) c ;
                   if(cU.getItem() == player) {
                       
                       res = cU.getConteneur();
                   }
                   
                    
                }
            }
           
        }
        
        return res ;
        
        
    }
    
    
    public int getCurrentLevel() {
        
        int resultat = -1;
        Room res = getCurrentRoom();
        
       
        
        if(res != null) {
                
                resultat = res.numeroEtage();
                
            }
        
         return resultat;
        
    }

    
    
    
    

    
}
