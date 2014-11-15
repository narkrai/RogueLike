package controller;

import java.util.ArrayList;
import java.util.List;

import model.Cell;
import model.CellUnit;
import model.IStrategy;
import model.Idiot;
import model.Message;
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


    public static Game getInstance()
    {
        if (uniqueInstance == null) 
        {
            try 
            {
            uniqueInstance = new Game();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        return uniqueInstance;
    }

    private Game() 
    {
        this.strategie = new Idiot() ;
        this.addRoom();
        
        
    }
    
    public void setStrategie(IStrategy strategie) 
    {
        this.strategie = strategie;
    }
    
    public IStrategy getStrategie() 
    {
        return this.strategie;
    }
    
    public void setPlayer(Player player) 
    {
        this.player = player;
    }

    public Player getPlayer() 
    {
        return this.player;
    }
    
    /**
     * fonction permettant de regenener un Game avec une 
     */
    public void restart() 
    {
        uniqueInstance = new Game() ;
    }
    
    
    /**
     * Creation de l'arborescence du jeu 
     */
    public void addRoom() 
    {
        this.rooms = this.strategie.CreateArborescence();
        //pensez a eclairer la la case du joueur
        Room r = this.getCurrentRoom();
        Cell c = this.getCurrentCell();
        r.lightNear(c.getPositionX(),c.getPositionY());
    }
    
    
    /**
     * Permet au joueur de faire un pas
     * @param direction int de direction
     * @return MessageIHM 
     */
    public Message makeStep(int direction)
    {
        int repAction = 0;
            
        int posPlayX = 0;
        int posPlayY = 0;
        Room r = this.getCurrentRoom();
        
        Message res = new Message();
        
        
        //Obtenir la position du joueur dans la Room 
        for (Cell c : r.getContenus()) 
        {
            if (c instanceof CellUnit) 
            {
               CellUnit cU = (CellUnit) c ;
               if(cU.getItem() == player) 
               {
                   posPlayX = cU.getPositionX();
                   posPlayY = cU.getPositionY();
               }
            }
        }
        
        
        switch (direction)
        {
            //droite (X-1,0)
            case RIGHT :
            
            if(posPlayX - 1 >= 0) 
            {
                CellUnit Cdepart = (CellUnit)  r.getCell(posPlayX, posPlayY);
                Cell Carrive = r.getCell(posPlayX -1, posPlayY);
                if (Carrive instanceof Room)                
                {
                           //TODO afficher la boite de dialogue et proceder à la teleportation   
                    
                }
                else 
                {
                    CellUnit cA = (CellUnit) Carrive ;
                    if(cA.getItem() != null) 
                    {
                        repAction  =  cA.getItem().Action(player).getSignal();
                        if(repAction == 0) 
                        {
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
        
        
        return null;
    }
    
    
    public void gameOver() {
        
    }
    
    public void playerWin(){
        
    }
    
    /**
     *Fonction qui permet de connaitre la Room courant ou se trouve le joueur
     * @return Room courant du joueur
     */
    public Room getCurrentRoom() {
        Room res = null;
        
        for( Room r : rooms) {
            
            for (Cell c : r.getContenus()) 
            {
                if( c instanceof CellUnit) 
                {
                   CellUnit cU = (CellUnit) c ;
                   if(cU.getItem() == player) 
                   {
                       res = cU.getConteneur();
                   }
                }
            }
        }
        
        return res ;
        
        
    }
    /**
     *Fonction qui permet de connaitre le niveau courant ou se trouve le joueur
     *
     * @return niveau courant du joueur
     */
    public int getCurrentLevel() {
        
        int resultat = -1;
        Room res = getCurrentRoom();
        
       
        
        if(res != null) {
                
                resultat = res.numeroEtage();
                
            }
        
         return resultat;
        
    }
    /**
     *Fonction qui permet de connaitre la Cell courant ou se trouve le joueur
     * @return  Cell courant du joueur
     */
    public Cell getCurrentCell() {
        Cell res = null;
        
        Room r = this.getCurrentRoom();
            
            for (Cell c : r.getContenus()) 
            {
                if( c instanceof CellUnit) 
                {
                   CellUnit cU = (CellUnit) c ;
                   if(cU.getItem() == player) 
                   {
                       res = cU;
                   }
                }
            }
        
        return res ;
        
        
    }
    
    /**
     * Permet de teleporter le joueur dans une nouvelle case vide choisi au hasard dans une nouvelle
     * Room
     *
     * @param r Room ou teleporte le joueur
     */
    public void TeleportInRoom(Room r){
        
        boolean estDeplace = false;
        int posX;
        int posY;
        
        
        
        while(!estDeplace) {
            
            posX =(int) (Math.random() * r.getTailleX());
            posY = (int) (Math.random() * r.getTailleY());
            
            Cell c = r.getCell(posX, posY);
            
            if( c instanceof CellUnit ) {
                CellUnit cC = (CellUnit) c ;
                
                if( cC.getItem() == null) {
                    cC.setItem(this.player);
                    estDeplace = true ;
                }
            }
            
        }  
    }
    


     /**
     *Permet d'obtenir la Room actuelle avec les objets à  l'interieur
     * @return un Char[][] tableau des caracteres ( correspondant au objet dans la room)
     */
    public  char[][] getTab() {
        
        Room r = this.getCurrentRoom();
        
        char res[][] = new char[r.getTailleX()][r.getTailleY()];
        
        for( int x = 0 ; x < r.getTailleX(); x++) {
            for(int y = 0 ; y < r.getTailleY(); y++) {
                
                res[x][y] = r.getContenus().get(x * r.getTailleX() + y).getCHARACTER();
                System.out.println("get bool"+ r.getContenus().get(x * r.getTailleX() + y).isDiscovered() );
                System.out.println("get char"+ r.getContenus().get(x * r.getTailleX() + y).getCHARACTER() );
                
            }
        }
        
        return res;
        
    }
    
    
    
    

    
}
