package model;

import controller.MonsterFactory;

import java.util.ArrayList;


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
        
        int RandX ;
        int RandY ;
        
        r.setTailleX(op.getTailleXRoom());
        r.setTailleY(op.getTailleYRoom());
        
        //Creation de la salle selon sa taille
        for( int x = 0 ; x < op.getTailleXRoom() ;x++)
        {
            for(int y = 0 ; y < op.getTailleYRoom(); y++)
            {
                c = CreationCell(r);
                c.setPositionX(x);
                c.setPositionY(y);
                c.setConteneur(r);
                r.AjoutCell(c);
            }          
        }

        //Creation d'un escalier descendant  vers le pere si la Room est un fils
        if(r.getConteneur() != null) 
        {
            while(!r.aCheminVersPere())
            { //A tester
                RandX = (int) Math.random() * r.getTailleX();
                RandY = (int) Math.random() * r.getTailleY();
                t = r.getCell(RandX, RandY);//  Atester
                  
                if( !(t instanceof Room))
                {
                      CellUnit cC = (CellUnit) t;
                      if(cC.getItem() instanceof Stair)
                      {
                          Stair st = new Stair(r);
                          cC.setItem(st);
                      }
                }
            } 
        }
        
        //Placement du Joueur dans la cellule 
        if( r.getConteneur() != null)
        {
            while(!r.aCheminVersPere()) 
            {
                RandX = (int) Math.random() * r.getTailleX();
                RandY = (int) Math.random() * r.getTailleY();
                t = r.getCell(RandX, RandY);
                if( !(t instanceof Room) )
                {
                    CellUnit cC = (CellUnit) t;
                    if(cC.getItem() instanceof Stair)
                    {
                        Stair st = new Stair(r);
                        cC.setItem(st);
                    }
                }
            }
        }
    }

    /**
     *Cette fonction renvoit une CellUnit ou une Room selon l'OptionData
     * @param r room parent
     * @return la Cell crée
     */
    public Cell CreationCell(Room r) {
        Cell c ;
        int stage = r.numeroEtage();
        int numberDoor = r.numberofRoom();

        double Random = Math.random() * 100;
        // si la Room n'est pas  au dernier etage et que le nombre maximal de salle n'est pas depassé
        if( stage != 0 && numberDoor < op.getDoormax())
        {
            //la Room a une certaine chance d'avoir une Room fils selon OptionData
            if(Random < op.getLadderLuck())
            {
                c = MakeRoom(r);
            }
            else 
            {
                c = MakeCellUnit(r);
            }
        }
        else
        {
            c = MakeCellUnit(r);
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
        return res;
    }
    /**
     *Permet la création d'une CellUnit selon l'OptionData et de mettre un objet au hasard
     * @param pere La Room pere
     * @return un objet CellUnit
     */
    private CellUnit MakeCellUnit(Room pere){
        CellUnit res = new CellUnit();
        double randomValue = Math.random()*100;
        if(randomValue  <= op.getMonsterLuck())
        {
            res.setItem(MonsterFactory.buildMonster());
        }
        else if(op.getMonsterLuck() < randomValue && randomValue <= op.getPotionLuck() + op.getMonsterLuck())
        {
            int randStrength;
            randStrength =
                (int) (op.getMinPowerPotion() + (Math.random() * (op.getMaxPowerPotion() - op.getMinPowerPotion())));
            Potion p = new Potion(randStrength);
            res.setItem(p);
        }
        else if(op.getPotionLuck() < randomValue && randomValue <= op.getPotionLuck() + op.getTreasureLuck() + op.getMonsterLuck())
        {
            int randOr;
            randOr = (int) (op.getMinGoldTresaure() + (Math.random() * op.getMaxGoldTresaure() - op.getMinGoldTresaure()));

            res.setItem(new Chest(randOr));
        }
        else
        {
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
       
       int Elu ;
      
       Room r  = new Room(this);
       ArrayList<Room> res = new ArrayList<Room>();
       
        //Tant que le jeu n'a pas de sortie on boucl
       
       while(r.aUneSortie() != 1)
       {
           res = new ArrayList<Room>(r.avoirLesRoomsFils());
           if(r.AvoirLeNiveauMinDesFils() == 0 ) 
           {
                //Tant que le jeu n'a pas de sortie on boucle
               for( Room a : res)
               {
                   Elu =(int) Math.random();
                   if(a.numeroEtage() == 0 && r.aUneSortie() != 0 &&  Elu <= (1/res.size()))
                   {
                       while(r.aUneSortie() != 1)
                       {
                           RandX = (int) Math.random() * a.getTailleX();
                           RandY = (int) Math.random() * a.getTailleY();
                           Cell c = a.getCell(RandX, RandY);
                           
                           if(!(c instanceof Room))
                           {
                               CellUnit cC = (CellUnit) c;
                               if(cC.getItem() instanceof Stair)
                               {
                                   Exit e = new Exit();
                                   cC.setItem(e);
                                   }
                               }
                           }
                       }
                   }
            }
            //sinon on recree la room (bah oui la generation d'avant est infonctionnelle donc on jete
           else
           {
               r  = new Room(this);
            }
        }
        return res;
    }
}
