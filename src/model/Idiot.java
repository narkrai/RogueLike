package model;

import controller.Game;
import controller.MonsterFactory;

import java.io.Console;

import java.util.ArrayList;

import java.util.Random;

import view.IHM_GameUI;


public class Idiot implements IStrategy {

    OptionData op = OptionData.getDataInstance();
    
    public Idiot() {
        super();
        
    }
    /**
     * Cette methode permet de creer les cellules de la room ainsi que ces Room fils selon l'OptionData
     * il cree egalement un escalier descendant si la room a un pere et le joueur dans la Room pere
     * @param Room r room à creer 
     * 
     */  
    @Override
    public void CreationRoom(Room r) {
        
        Cell c;
        Cell t;
        
        
        Random rand = new Random();
        int randX;
        int randY;
        
        r.setTailleX(op.getTailleXRoom());
        r.setTailleY(op.getTailleYRoom());
        
        
        //Creation de la salle selon sa taille
        for( int x = 0 ; x < op.getTailleXRoom() ;x++) {
            for(int y = 0 ; y < op.getTailleYRoom(); y++){
                
                c = CreationCell(r);
                c.setPositionX(x);
                c.setPositionY(y);
                c.setConteneur(r);
                r.AjoutCell(c);
                System.out.println(x+" , "+y);
                
            }
                            
        }
        
        
        
        
        //Creation d'un escalier descendant  vers le pere si la Room est un fils
            
            while(!r.aCheminVersPere()) { 
                 randX=  rand.nextInt( r.getTailleX()) ;
                randY =  rand.nextInt( r.getTailleY());
                
                 t = r.getCell(randX, randY);
                  
                  if( !(t instanceof Room) ) {
                      
                      CellUnit cC = (CellUnit) t;
                      
                      
                          
                          Stair st = new Stair(r);
                          cC.setItem(st);
                          System.out.println("Chemin vers pere crée");
                        
                      
                
                
            }
            
        
        }
            
        
        

        
        System.out.println("Room terminé etage" +r.numeroEtage() +" et a un chemin vers pere");
    }

    /**
     *Cette fonction renvoit une CellUnit ou une Room selon l'OptionData
     * @param r room parent
     * @return la Cell crée
     */
    public Cell CreationCell(Room r) {
        
        
        Cell c ;

        Random rand = new Random();
        int Random = rand.nextInt(100);
        // si la Room n'est pas  au dernier etage et que le nombre maximal de salle n'est pas depassé
        if( r.numeroEtage() != 0 && r.numberofRoom() < op.getDoormax() ) {
            //la Room a une certaine chance d'avoir une Room fils selon OptionData
            if(Random < op.getLadderLuck()) {
                
                System.out.println("Valeur du rand :"+ Random);
                c = MakeRoom(r);
                
            }
            else {
                c = MakeCellUnit();
                System.out.println("Nouvelle cell crée");
            }
            
        }
        else{
            System.out.println("Nouvelle cell crée");
            c = MakeCellUnit();
        }
 
        return c;
    }

    /**
     * Permet la creation d'une Room 
     * @param pere la Room pere
     * @return un objet Room
     */
    private Room MakeRoom(Room pere) {
        
        Room res  = new Room(this,pere);
        System.out.println("Nouvelle Room crée");
        return res;
    }
    /**
     *Permet la création d'une CellUnit selon l'OptionData et de mettre un objet au hasard
     * @param pere La Room pere
     * @return un objet CellUnit
     */
    private CellUnit MakeCellUnit(){
        
        CellUnit res = new CellUnit();
        
        Random rand = new Random();
        int randomValue = rand.nextInt(100);
        
        if( randomValue  <= op.getMonsterLuck() + op.getLadderLuck()) {
            
            res.setItem(MonsterFactory.buildMonster());
            
        }
        else if( op.getMonsterLuck() < randomValue && randomValue <= op.getPotionLuck() + op.getMonsterLuck() + op.getLadderLuck()  ) {

            int randStrength;
            randStrength =
                (int) (op.getMinPowerPotion() + (Math.random() * (op.getMaxPowerPotion() - op.getMinPowerPotion())));

            Potion p = new Potion(randStrength);
            
            res.setItem(p);
        }
        else if(op.getPotionLuck() < randomValue && randomValue <= op.getPotionLuck() + op.getTreasureLuck() + op.getMonsterLuck() +op.getLadderLuck() ) {
            
            int randOr;
            randOr = (int) (op.getMinGoldTresaure() + (Math.random() * op.getMaxGoldTresaure() - op.getMinGoldTresaure()));
            
            
            
            res.setItem(new Chest(randOr));
            
        }
        else{
            res.setItem(null);
        }
        
        
        return res;
        
        
        
    }
    /**
     * Cette fonction permet de creer un Room père et ses fils et de les mettre dans une liste
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
        System.out.println("La room pere A ete correctement crée");
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
            
       //On verifie d'abord si l'arborescence à bien une room sinon on recrée l'ensemble
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
                          
                          if(cC.getItem() instanceof Stair ) {
                              
                              Exit e = new Exit();
                              cC.setItem(e);
                              
                          }
                          
                      }
           
                   }

                   
               }      
                   
               }
           }
           
       }
       //sinon on recree la room (bah oui la generation d'avant est infonctionnelle donc on jete (//todo trouver une meilleur solution meme si c'est pas ecrit dans les charges
       else{
           System.out.println("r.AvoirLeNiveauMinDesFils() "+r.AvoirLeNiveauMinDesFils());
           System.out.println("RECREATIONNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");
           r  = new Room(this);
           
       }
        }
        
        boolean playerEstPlace = false;
        //et Puis enfin  Placement du Joueur dans la cellule PERE
        if( r.getConteneur() == null) {
            
            while(!playerEstPlace) {
                
                
                RandX =  rand.nextInt(r.getTailleX());
                RandY =  rand.nextInt(r.getTailleY());
                
                 Cell t = r.getCell(RandX, RandY);
                  
                  if( !(t instanceof Room) ) {
                      
                      CellUnit cC = (CellUnit) t;
                      
                      if(!(cC.getItem() instanceof Stair )) {
                          
                            cC.setItem(Player.getInstance());
                            playerEstPlace = true;
                        
                      }
                
                
            }
            
        
        }
            
        }
           
        for( Cell celle : r.getContenus()) {
            System.out.println(celle.toString());
        }
    
       
       
        return res;
    }
    
    
    public static void main(String[] args ) {

        Idiot i = new Idiot();
       
        i.CreateArborescence();
       
    }
    
}
