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
     * @param Room r room à creer 
     * 
     */  
    @Override
    public void CreationRoom(Room r) {
        
        Cell c;
        
        int RandX ;
        int RandY ;
        
        r.setTailleX(op.getTailleXRoom());
        r.setTailleY(op.getTailleYRoom());
        
        for( int x = 0 ; x < op.getTailleXRoom() ;x++) {
            for(int y = 0 ; y < op.getTailleYRoom(); y++){
                
                c = CreationCell(r);
                c.setPositionX(x);
                c.setPositionY(y);
                c.setConteneur(r);
                r.getContenus().add(c);
                
                
                
                
            }
                            
        }

        
      
    }

    /**
     *Cette fonction renvoit une CellUnit ou une Room selon l'OptionData
     * @param r room parent
     * @return la Cell crée
     */
    public Cell CreationCell(Room r) {
        
        
        Cell c = MakeCellUnit(r) ;
        
        int stage = r.numeroEtage();
        Room conteneur = r.getConteneur();
        int numberDoor = r.numberofRoom();
        boolean AEscalier  = r.aCheminVersPere();
        
        
        
        double Random = Math.random() * 100;
        
        if( stage != 0 && numberDoor < op.getDoormax() ) {
            
            if(Random < op.getLadderLuck()) {
                c = MakeRoom(r);
            }
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
     *Permet la création d'une CellUnit selon l'OptionData
     * @param pere La Room pere
     * @return un objet CellUnit
     */
    private CellUnit MakeCellUnit(Room pere){
        
        CellUnit res = new CellUnit();
        double randomValue = Math.random()*100;
        
        if( randomValue  <= op.getMonsterLuck()) {
            
            res.setItem(MonsterFactory.buildMonster());
            
        }
        else if( op.getMonsterLuck() < randomValue && randomValue <= op.getPotionLuck() + op.getMonsterLuck()  ) {

            int randStrength;
            randStrength =
                (int) (op.getMinPowerPotion() + (Math.random() * (op.getMaxPowerPotion() - op.getMinPowerPotion())));

            Potion p = new Potion(randStrength);
            
            res.setItem(p);
        }
        else if(op.getPotionLuck() < randomValue && randomValue <= op.getPotionLuck() + op.getTreasureLuck()  ) {
            
            int randOr;
            randOr = (int) (op.getMinGoldTresaure() + (Math.random() * op.getMaxGoldTresaure() - op.getMinGoldTresaure()));
            
            
            
            res.setItem(new Chest(randOr));
            
        }
        else{
            res.setItem(null);
        }
        
        
        
        
        return res;
        
        
        
    }

    
    public ArrayList<Room> CreateArborescence() {
       
       ArrayList<Room> res = new ArrayList<Room>();
       
       
        return res;
    }
}
