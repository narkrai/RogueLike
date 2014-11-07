package model;

public class CellUnit extends Cell {
    
    
    
    private Item item;


    public void deleteItem() {
        this.item = null;
    }
    
    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }




    @Override
    public int numeroEtage() {
        
        return super.getConteneur().numeroEtage();
    }

    @Override
    public int GetTotalGold() {
      int res = 0;
      
      if(this.item instanceof Chest) {
          Chest t =(Chest) this.item;
          res = t.getGold();
          
      }
      
      
        return res;
    }

    @Override
    public int GetTotalMonster() {
        
        int i = 0;
        
        if(this.item instanceof Monster) {
            
            i = 1 ;
            
        }
        
        
        return 0;
    }
}
