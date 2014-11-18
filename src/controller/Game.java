package controller;

import java.util.ArrayList;

import model.Action;
import model.Cell;
import model.CellUnit;
import model.Exit;
import model.IStrategy;
import model.Idiot;
import model.Item;
import model.Message;
import model.Player;
import model.Room;
import model.Stair;

public class Game {
    
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private IStrategy strategie;
    private Player player;
    
    //constante de valeurs entre Game et action
    private final int NORMAL = 0 ;
    private final int VICTORY = 1;
    private final int LOSE = 2;
    
    //constante correspondant aux movements
    private final int RIGHT = 0;
    private final int LEFT = 1;
    private final int UP = 2;
    private final int DOWN = 3;
    //constante cde valeurs pour le MessageIHM
    final int RIEN = 0;
    final int GAMEOVER = 1;
    final int WIN = 2 ;
    final int TELEPORT = 3 ;

    
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
        player = Player.getInstance();
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

        Message res = new Message();
        
        int repAction = 0;
                    

                //Obtenir la cell du joueur et sa Room
                Room r = this.getCurrentRoom(); 
                Cell c = this.getCurrentCell();
                Cell cArrive;
      
        
        
        switch (direction)
        {
            //droite (X-1,0)
            case UP:
            
            if(c.getPositionX() - 1 >= 0) 
            {
                cArrive = r.getCell(c.getPositionX() -1, c.getPositionY());
                if (cArrive instanceof Room)                   
                {
                           res = this.DemandeDeTeleport((Room)cArrive);
                    
                }
                else 
                {
                res = this.DemandeDeDeplacement((CellUnit)cArrive);
                }
                   
            }
                           
            else {
                      
                    res.setSignal(this.RIEN);
                    res.setMessage("Hop dans le mur");
                    res.setRoom(null);
            }
            break;
        
            //left (X,0)    
            case DOWN :
            
            
            if(c.getPositionX() + 1 < r.getTailleX()) 
            {
               
                cArrive = r.getCell(c.getPositionX() + 1, c.getPositionY());
                if (cArrive instanceof Room)                
                {
                        res = this.DemandeDeTeleport((Room)cArrive);
                }
                else 
                {
                    res = this.DemandeDeDeplacement((CellUnit)cArrive);
                }
            }
            else {
                res.setSignal(this.RIEN);
                res.setMessage("Hop dans le mur");
                res.setRoom(null);
            }
            
            
            break;
        
            //UP (0,Y)
            case RIGHT :
            
            if(c.getPositionY() + 1 < r.getTailleY()) 
            {
               
                cArrive = r.getCell(c.getPositionX() , c.getPositionY()+1);
                if (cArrive instanceof Room)                
                {
                        res = this.DemandeDeTeleport((Room)cArrive);
                }
                else 
                {
                    res = this.DemandeDeDeplacement((CellUnit)cArrive);
                }
            }
            else {
                res.setSignal(this.RIEN);
                res.setMessage("Hop dans le mur");
                res.setRoom(null);
            }
            break;
        
            //DOWN(0,-Y)
            case LEFT:
            
            if(c.getPositionY() - 1 >= 0 )
            {
               
                cArrive = r.getCell(c.getPositionX() , c.getPositionY()-1);
                if (cArrive instanceof Room)                
                {
                        res = this.DemandeDeTeleport((Room)cArrive);
                }
                else 
                {
                    res = this.DemandeDeDeplacement((CellUnit)cArrive);
                }
            }
            else {
                res.setSignal(this.RIEN);
                res.setMessage("Hop dans le mur");
                res.setRoom(null);
            }
            
            
            break;
        
            //erreur
            default:
            
            res.setSignal(this.RIEN);
            res.setMessage("Erreur valeur envoy? inconnu");
            res.setRoom(null);
                       
            
            
           
            
        }
        
        
        return res;
    }
    
    /**
        * Cette methode permet de former le MessageIHM pour une demande de Teleportation dans un Room
        * @param rArrivee Room cible
        * @return
        */
       private Message DemandeDeTeleport(Room rArrivee){
           
           Message res = new Message(this.TELEPORT,"Changement de salle",rArrivee);
           return res;
       }
       /**
        * Cette methode permet de former le MessageIHM pour une demande de deplacement dans un cellule point?
        * @param cArrivee
        * @return
        */
       private Message DemandeDeDeplacement(CellUnit cArrivee){
           
           Message res = new Message();
           Item it = cArrivee.getItem();
           
           CellUnit cPlayer =(CellUnit) this.getCurrentCell();
           
           
           if(it == null)
           {
               res.setSignal(this.RIEN);
               res.setMessage("Rien pour l'instant");
               res.setRoom(null);
               res.setMonsterNearby(getCurrentRoom().nbMonsterNear(cArrivee.getPositionX(),cArrivee.getPositionY()));
               
               cPlayer.setItem(null);
               cArrivee.setItem(this.player);

               this.getCurrentRoom().lightNear(cArrivee.getPositionX(), cArrivee.getPositionY());
               
           }
           else if(it instanceof Exit) {
               
               res.setSignal(this.WIN);
               res.setRoom(null);
               res.setMessage("Vous avez gagne !");
               res.setMonsterNearby(getCurrentRoom().nbMonsterNear(cArrivee.getPositionX(),cArrivee.getPositionY()));
               
           }
           else if(it instanceof Stair){
               
               res.setSignal(this.RIEN);
               res.setMessage("Descente dans la salle du dessous !");
               res.setRoom(null);
               
               this.TeleportInRoom(cPlayer.getConteneur().getConteneur());
               
               this.getCurrentRoom().lightNear(this.getCurrentCell().getPositionX(), this.getCurrentCell().getPositionY());
               res.setMonsterNearby(getCurrentRoom().nbMonsterNear(cArrivee.getPositionX(),cArrivee.getPositionY()));
           }
           else
           {
               Action reponse = it.action(this.player);
               
               if( reponse.getSignal() == this.NORMAL)
               {
                   res.setMessage(reponse.getMessage());
                   res.setRoom(null);
                   res.setSignal(RIEN);
                   res.setMonsterNearby(getCurrentRoom().nbMonsterNear(cArrivee.getPositionX(),cArrivee.getPositionY()));
                   
                   cPlayer.setItem(null);
                   cArrivee.setItem(this.player);
                   
                   this.getCurrentRoom().lightNear(cArrivee.getPositionX(), cArrivee.getPositionY());
                   
                   
               }
               else if (reponse.getSignal() == this.VICTORY) {
                   
                   res.setMessage(reponse.getMessage());
                   res.setRoom(null);
                   res.setSignal(this.RIEN);
                   res.setMonsterNearby(getCurrentRoom().nbMonsterNear(cArrivee.getPositionX(),cArrivee.getPositionY()));
                   
                   cPlayer.setItem(null);
                   cArrivee.setItem(this.player);
                   
                   this.getCurrentRoom().lightNear(cArrivee.getPositionX(), cArrivee.getPositionY());
                   
               }
               //signal = LOSE
               else {
                   res.setMessage(reponse.getMessage());
                   res.setRoom(null);
                   res.setSignal(this.GAMEOVER);
                   res.setMonsterNearby(getCurrentRoom().nbMonsterNear(cArrivee.getPositionX(),cArrivee.getPositionY()));
                   
                   cPlayer.setItem(null);
                   cArrivee.setItem(this.player);
                   
                   this.getCurrentRoom().lightNear(cArrivee.getPositionX(), cArrivee.getPositionY());
               }
               
               
           }
          
         
           
           
           
           
           return res;
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
        
        boolean estTrouve = false;
        
        for(int z=0; z < this.rooms.size() && !estTrouve ; z++ )
        {
            Room r = this.rooms.get(z);
            
            for(int i = 0 ; i < r.getContenus().size() && !estTrouve ; i++)
            {
                Cell c = r.getContenus().get(i);
                if( c instanceof CellUnit) 
                {
                   CellUnit cU = (CellUnit) c ;
                   if(cU.getItem() == player) 
                   {
                       System.out.println("La case trouve est "+cU.toString());
                       res = cU.getConteneur();
                       estTrouve = true;
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
        
        CellUnit cCurrent = (CellUnit) this.getCurrentCell();
    
        
        while(!estDeplace) {
            
            posX =(int) (Math.random() * r.getTailleX());
            posY = (int) (Math.random() * r.getTailleY());
            
            Cell c = r.getCell(posX, posY);
            
            if( c instanceof CellUnit ) {
                CellUnit cC = (CellUnit) c ;
                
                if( cC.getItem() == null) {
                    cC.setItem(this.player);
                    r.lightNear(cC.getPositionX(), cC.getPositionY());
                    
                    cCurrent.setItem(null);
            
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
                
                res[x][y] = r.getCell(x, y).getCHARACTER();
                //System.out.println("get BOOL :"+ r.getCell(x, y).isDiscovered() );
                System.out.println("get char :"+ r.getCell(x, y).getCHARACTER() );
                
            }
        }
        
        return res;
        
    }
    
    
    
    

    
}
