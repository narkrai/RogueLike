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
        
        strat.CreationRoom(this);
        
        for( Cell c : Contenus) {
            c = strat.CreationCell(this);
        }
        
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
        
        Cell center = this.getCell(x, y);
        
        if(center != null ) {
            center.setDiscovered(true);
            
            if(this.getCell(x-1, y) != null) {
                this.getCell(x-1, y).setDiscovered(true);
            }
            if(this.getCell(x-1, y -1) != null) {
                this.getCell(x-1, y-1).setDiscovered(true);
            }
            if(this.getCell(x, y-1) != null) {
                this.getCell(x, y-1).setDiscovered(true);
            }
            if(this.getCell(x+1, y-1) != null) {
                this.getCell(x+1, y-1).setDiscovered(true);
            }
            if(this.getCell(x+1, y) != null) {
                this.getCell(x+1, y).setDiscovered(true);
            }
            if(this.getCell(x+1, y+1) != null) {
                this.getCell(x+1, y+1).setDiscovered(true);
            }
            if(this.getCell(x+1, y-1) != null) {
                this.getCell(x+1, y-1).setDiscovered(true);
            }
        
        }
        
        
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
            res = 0;
            
        }
        else {
            res = super.getConteneur().numeroEtage() + 1;
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
}
