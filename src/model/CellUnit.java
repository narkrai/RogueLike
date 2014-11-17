package model;

public class CellUnit extends Cell {

    private Item item;
    
    
    public CellUnit(){
    
        
    }
    
    public String toString(){

    if(this.item != null)
        return "L'objet contenu est"+ this.item.getClass();
    else
        return "Pas d'objet";
    }
    
    public char getCHARACTER(){
        
        char res;
        
        if(this.isDiscovered()) {
            
            if(this.getItem() != null) {
                res = this.getItem().getCHARACTER();
            
            }
            else {
                res = '.';
            }
            
        }
        else {
            res = super.getCHARACTER();
        }
        
        return res;
    }
    
    
    

    public void deleteItem() 
    {
        this.item = null;
    }
    
    public void setItem(Item item) 
    {
        this.item = item;
    }

    public Item getItem() 
    {
        return item;
    }

    @Override
    public int numeroEtage() {
        return super.getConteneur().numeroEtage();
    }

    @Override
    public int GetTotalGold() 
    {
        int res = 0;
        if(this.item instanceof Chest) 
        {
            Chest t = (Chest)this.item;
            res = t.getGold();
        }
        return res;
    }

    @Override
    public int GetTotalMonster() 
    {
        int i = 0;
        
        if(this.item instanceof Monster) 
        {
            i = 1 ;   
        }
        return i;
    }

    /**
     * Permet de savoir si un objet contient une sortie
     * @return
     */
    @Override
    public int aUneSortie() {
        
        int res = 0 ;
        if(this.getItem() instanceof Exit) {
            res = 1;
        }
        
        
        return res;
    }
}
