package model;

import controller.Game;
import controller.MonsterFactory;

import java.io.Console;

import java.util.ArrayList;

import java.util.Random;

import view.IHM_GameUI;

/**
 * La Classe idiot est une strategie envisable pour la cr�ation de l'arborescence de Room � partir de l'OptionData
 * 
 * *Les Room ont tous la  meme taille
 * *les Items sont plac�s al�atoirement
 * *les Room ont tous un unique pere
 * *Il n'y qu'une seule sortie
 * *La cr�ation du chemin gagnant  ( c'est-�-dire le chemin entre le Player et la Sortie) est fait � posteori
 * *Generation lourde en temps de calcul 
 * @author Dinar
 */
public class Idiot implements IStrategy {

    /**
     * L'optionData utilis�
    * 
    */
    OptionData opdataCurrent = OptionData.getDataInstance();
    /**
     * Construteur vide de la classe
     */
    public Idiot() {
        super();
        
    }
    /**
     * Cette methode permet de creer les cellules de la room ainsi que ces Room fils selon l'OptionData
     * il cree egalement un escalier descendant si la room a un pere et le joueur dans la Room pere
     * @param Room r room � creer 
     * 
     */  
    @Override
    public void CreationRoom(Room roomPere) {
        
        Cell cellCreated;
        Cell cellChosen;
        
        
        Random rand = new Random();
        int randX;
        int randY;
        
        roomPere.setTailleX(opdataCurrent.getTailleXRoom());
        roomPere.setTailleY(opdataCurrent.getTailleYRoom());
        
        
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
                          System.out.println("Chemin vers pere cr�e");
                        

            }
            
        
        }
            
        
        

        
        System.out.println("Room termin� etage" +roomPere.numeroEtage() +" et a un chemin vers pere");
    }

    /**
     *Cette fonction renvoit une CellUnit ou une Room selon l'OptionData
     * @param roomPere room parent
     * @return la Cell cr�e
     */
    public Cell CreationCell(Room roomPere) {
        
        
        Cell cellCreated ;

        Random rand = new Random();
        int Random = rand.nextInt(100);
        // si la Room n'est pas  au dernier etage et que le nombre maximal de salle n'est pas depass�
        if( roomPere.numeroEtage() != 0 && roomPere.numberofRoom() < opdataCurrent.getDoormax() ) {
            //la Room a une certaine chance d'avoir une Room fils selon OptionData
            if(Random < opdataCurrent.getLadderLuck()) {
                
                System.out.println("Valeur du rand :"+ Random);
                cellCreated = MakeRoom(roomPere);
                
            }
            else {
                cellCreated = MakeCellUnit();
                System.out.println("Nouvelle cell cr�e");
            }
            
        }
        else{
            System.out.println("Nouvelle cell cr�e");
            cellCreated = MakeCellUnit();
        }
 
        return cellCreated;
    }

    /**
     * Permet la creation d'une Room 
     * @param pere la Room pere
     * @return un objet Room
     */
    private Room MakeRoom(Room pere) {
        
        Room res  = new Room(this,pere);
        System.out.println("Nouvelle Room cr�e");
        return res;
    }
    /**
     *Permet la cr�ation d'une CellUnit selon l'OptionData et de mettre un objet au hasard
     * @param pere La Room pere
     * @return un objet CellUnit
     */
    private CellUnit MakeCellUnit(){
        
        CellUnit res = new CellUnit();
        
        Random rand = new Random();
        int randomValue = rand.nextInt(100);
        
        if( randomValue  <= opdataCurrent.getMonsterLuck() + opdataCurrent.getLadderLuck()) {
            
            res.setItem(MonsterFactory.buildMonster());
            
        }
        else if( opdataCurrent.getMonsterLuck() < randomValue && randomValue <= opdataCurrent.getPotionLuck() + opdataCurrent.getMonsterLuck() + opdataCurrent.getLadderLuck()  ) {

            int randStrength;
            randStrength =
                (int) (opdataCurrent.getMinPowerPotion() + (Math.random() * (opdataCurrent.getMaxPowerPotion() - opdataCurrent.getMinPowerPotion())));

            Potion p = new Potion(randStrength);
            
            res.setItem(p);
        }
        else if(opdataCurrent.getPotionLuck() < randomValue && randomValue <= opdataCurrent.getPotionLuck() + opdataCurrent.getTreasureLuck() + opdataCurrent.getMonsterLuck() +opdataCurrent.getLadderLuck() ) {
            
            int randOr;
            randOr = (int) (opdataCurrent.getMinGoldTresaure() + (Math.random() * opdataCurrent.getMaxGoldTresaure() - opdataCurrent.getMinGoldTresaure()));
            
            
            
            res.setItem(new Chest(randOr));
            
        }
        else{
            res.setItem(null);
        }
        
        
        return res;
        
        
        
    }
    /**
     * Cette fonction permet de creer un Room p�re et ses fils et de les mettre dans une liste
     * Cette methode cree egalement un objet sortie sur une des cases  d'une Room au niveau 0
     * @return la liste complete des Room
     */
    public ArrayList<Room> CreateArborescence() {
       
       int RandX;
       int RandY;
        Random rand = new Random();
       double Elu ;
      
      
      // Room de Tous
       Room r  = new Room(this);
        System.out.println("La room pere A ete correctement cr�e");
        ArrayList<Room> res = new ArrayList<Room>();
       
        //Tant que le jeu n'a pas de sortie on boucle
        while(r.aUneSortie() != 1)
        {
            System.out.println("r.aUneSortie() "+r.aUneSortie());
            
            System.out.println("aUneSortie "+r.aUneSortie());
            
            for( Room rF : r.avoirLesRoomsFils()) {
                res.add(rF);
            }
            res.add(r);
            
            System.out.println("Liste iteration + 1");
            
       //On verifie d'abord si l'arborescence � bien une room sinon on recr�e l'ensemble
       if(r.AvoirLeNiveauMinDesFils() == 0 ) {
           System.out.println("r.AvoirLeNiveauMinDesFils() "+r.AvoirLeNiveauMinDesFils());
           //Tant que le jeu n'a pas de sortie on boucle
           while(r.aUneSortie() != 1)
           {
            for( Room a : res){
               //
               System.out.println("a.numeroEtage() "+a.numeroEtage());
               Elu = rand.nextDouble();
               
               if(a.numeroEtage() == 0 && r.aUneSortie() != 1) {
                   
                   
                   while(r.aUneSortie() != 1) 
                   {
                    RandX = rand.nextInt(a.getTailleX()) ;
                    RandY = rand.nextInt(a.getTailleY()) ;
                    
                    Cell c = a.getCell(RandX, RandY);
                      
                      if( !(c instanceof Room) ) {
                          
                          CellUnit cC = (CellUnit) c;
                          
                              
                              Exit e = new Exit();
                              cC.setItem(e);
                              
                          
                          
                      }
           
                   }

                   
               }      
                   
               }
           }
           
       }
       // il est possible qu'aucune Room soit � l'etage zero. Dans ce cas on prend une des Rooms les plus hautes et on la regenerer
       else{
           
           Random roomChosen = new Random(); 
           Room roomTaken = res.get(roomChosen.nextInt(res.size()));
        
           if(roomTaken.numeroEtage() == r.AvoirLeNiveauMinDesFils())
           {
             roomTaken = new Room(this,r);

           }
        }
        }
        
        boolean playerIsPlaced = false;
        //et Puis enfin  Placement du Joueur dans la Room PERE de tous
        
            
            while(!playerIsPlaced) {
                
                
                RandX =  rand.nextInt(r.getTailleX());
                RandY =  rand.nextInt(r.getTailleY());
                
                 Cell cellChosen = r.getCell(RandX, RandY);
                  
                  if( !(cellChosen instanceof Room) ) {
                      
                      CellUnit cC = (CellUnit) cellChosen;
                      
                      if(!(cC.getItem() instanceof Stair )) {
                          
                            cC.setItem(Player.getInstance());
                            playerIsPlaced = true;
                        
                      }
                
                
            }
            
        
        }
       
        return res;
            
            
    
    
    

    }
}