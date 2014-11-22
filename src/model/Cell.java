package model;
/**
 * Les Cells sont les cases contenus dans une Room .
 * Grace au design patter Composite, les Cells peuvent etre , soit des Rooms,soit des CellUnit.
 * @author Dinar
 */
public abstract class Cell {

    /**
     * Conteneur de la Cell (par défaut vide)
     */
    private Room conteneur = null;
    /**
     * Position X de la Cell (n'a de sens uniquement si la Cell posséde un conteneur
     */
    private int positionX;
    /**
     * Position Y de la Cell (n'a de sens uniquement si la Cell posséde un conteneur
     */
    private int positionY;
    /**
     * La Cell a-t'elle été decouverte par le Player ? ( Faux par défaut)
     */
    private boolean discovered = false;
    /**
     * Le symbole Ascii d'une Cell par defaut (c'est-a-dire une Cell non découvert;
     */
    private  char CHARACTER = ' ';


    /**
     * Constructeur de Cell
     */
    public Cell() {

    }
    
    public void setCHARACTER(char CHARACTER) {
        this.CHARACTER = CHARACTER;
    }
    
   

        
    public  char getCHARACTER() {
        return CHARACTER;
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

     

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;   
    }
    
    /**
     * Fonction abstraite permettant de savoir le nombre de Item "Sortie" qu'une Cell posséde 
     * Cette valeur ne peut etre  en théorie  uniquement de 0 ou 1 .
     *
     * @return Nombre de sortie
     */
    public  abstract int aUneSortie();
    /**
     *Fonction abstraite permettant de savoir le numero d'etage courant de la Cell
     * @return le numero d'etage (compris en théorie entre 0 et un nombre négatif
     */
    public abstract int numeroEtage();


}
