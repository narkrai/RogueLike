package model;
/**
 * les classes Stairs permentte au Player de descendre d'un étage et ainsi d'aller dans la Room pere de  Cell actuelle 
 * le contenant
 * @author Dinar
 */
public class Stair extends Item {
    
    
    Room pointeur = null;
    final char CHARACTER = '<';



    @Override
    public Action action(Player p) {
        Action res = null;
        return res;
    }
    
    public Stair(Room p) {
    
        this.pointeur = p;
       
    }   
        public Room getPointeur() {
        return pointeur;
    }

    @Override
    public char getCHARACTER() {
        
        return this.CHARACTER;
    }
}
