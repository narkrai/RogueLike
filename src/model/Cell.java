package model;

public abstract class Cell {

    private Room conteneur = null;
    private int positionX;
    private int positionY;
    private boolean discovered;


    public Cell() {

    }
    
    public abstract int GetTotalGold();
    public abstract int GetTotalMonster();
    
    public Cell(Room conteneur) {
        this.conteneur = conteneur;
        
    }
    
    
     public Room getConteneur() {
        return conteneur;
    }
     
    public void setConteneur(Room conteneur) {
        this.conteneur = conteneur;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionX() {
        return positionX;
    }
    
    public boolean isDiscovered() {
        return discovered;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionY() {
        return positionY;
    }

     
    public abstract int numeroEtage();

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }


}
