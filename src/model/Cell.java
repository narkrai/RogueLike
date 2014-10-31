package model;

public abstract class Cell {

    private Room conteneur = null;
    private int positionX;
    private int positionY;


    public Cell() {

    }
    
    public abstract int GetTotalGold();
    public abstract int GetTotalMonster();
    
    public Cell(Room conteneur) {
        this.conteneur = conteneur;
        //TODO da
    }
    
    
     public Room getConteneur() {
        return conteneur;
    }
     
    public abstract int numeroEtage();
    
    
    
     
       
    
}
