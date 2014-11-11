package model;

import controller.MonsterFactory;

import java.util.ArrayList;

public class Idiot implements IStrategy {

    OptionData op = OptionData.getDataInstance();
    
    public Idiot() {
        super();
        
    }

    @Override
    public void CreationRoom(Room r) {
        
        Cell c;
        
        r.setTailleX(op.getTailleXRoom());
        r.setTailleY(op.getTailleYRoom());
        
        for( int x = 0 ; x < op.getTailleXRoom() ;x++) {
            for(int y = 0 ; y < op.getTailleYRoom(); y++){
                
                c = CreationCell(r);
                
                if( c instanceof Room) {
                    Room rC = (Room) c;
                    rC.setPositionX(x);
                    rC.setPositionY(y);
                    rC.setConteneur(r);
                    r.getContenus().add(rC);
                    
                }
                else {
                    CellUnit rC = (CellUnit) c;
                    rC.setPositionX(x);
                    rC.setPositionY(y);
                    rC.setConteneur(r);
                    r.getContenus().add(rC);
                }
                
                
                
            }
                            
        }
      
    }

    @Override
    public Cell CreationCell(Room r, Cell c) {
        int stage = r.numeroEtage();
        Room conteneur = r.getConteneur();
        int numberDoor = r.numberofRoom();
        boolean AEscalier  = r.aCheminVersPere();
        
        
        
        
        return null;
    }
    
    public Cell CreationCell(Room r) {
        Cell c ;
        
        int stage = r.numeroEtage();
        Room conteneur = r.getConteneur();
        int numberDoor = r.numberofRoom();
        boolean AEscalier  = r.aCheminVersPere();
        
        
        
        double Random = Math.random() * 100;
        
        if( stage != 0 && numberDoor < op.getDoormax() ) {
            
            if(Random < op.getLadderLuck()) {
                c = new Room(this,r);
            }
            
            
            
        }
        
        
        
        
        
        
        
        
        
        
        return c;
    }
    
    
    private Room MakeRoom(Room pere) {
        
        Room res  = new Room(this,pere);
        
        return res;
    }
    
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

    /*@Override
    public ArrayList<Room> CreateArborescence() {
        // TODO Implement this method
        return null;
    }*/
}
