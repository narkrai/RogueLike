package model;


/**
 * Classe pere regroupant les items contenus dans les CellUnit
 */
public abstract class Item {

    /**
     *Le caractere de l'Item
     * @return le caractere du item
     */
    public abstract char getCharacter();

    /**
     * les Actions fait par les items
     * @param p Le joueur
     * @return le Message
     */
    public abstract Action action(Player p);


}
