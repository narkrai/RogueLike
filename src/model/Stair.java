package model;

/**
 * les classes Stairs permentte au Player de descendre d'un étage et ainsi d'aller dans la Room pere de Cell actuelle
 * le contenant
 * @author Dinar
 */
public class Stair extends Item {

    /**
     * Room sur lequelle Stair pointe
     */
    Room pointeur = null;
    final char CHARACTER = '<';


    /**
     *
     * @param p Le Player actuelle
     * @return le message d'action
     */
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
    public char getCharacter() {

        return this.CHARACTER;
    }
}
