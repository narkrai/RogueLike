package model;

import controller.Game;
import model.Action;
/**
 * Classe d'item qui permet au joueur de gagner le jeu
 * @author Nguynen
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


    @Override
    public Action action(Player p) {
        return new Action(1, "Exit");
    }

    @Override
    public char getCHARACTER() {
        
        return this.CHARACTER;
    }
}
