package model;



/**
 * Classe d'item qui permet au joueur de gagner le jeu
 * @author Nguyen
 */
public class Exit extends Item {
    /**
     * caractere de l'Item
     */
    final char CHARACTER = 'O';

    /**
     * Constructeur vide
     */
    public Exit() {
        super();

    }

    /**
     * Permet de gagner le jeu !!
     * @param player le joueur
     * @return le message de victoire
     */
    @Override
    public Action action(Player p) {
        return new Action(1, "Exit");
    }

    @Override
    public char getCHARACTER() {

        return this.CHARACTER;
    }
}
