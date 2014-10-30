package model;

public class CellUnit extends Cell {
    
    
    
    private Item item;
    private  boolean discovered;
    
    
    public void deleteItem() {
        this.item = null;
    }
    
    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    @Override
    public int numeroEtage() {
        // TODO Implement this method
        return 0;
    }

    @Override
    public int GetTotalGold() {
        // TODO Implement this method
        return 0;
    }

    @Override
    public int GetTotalMonster() {
        // TODO Implement this method
        return 0;
    }
}
