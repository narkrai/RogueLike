package model;

import controller.Game;

import model.Action;
/**
 * La classe herite de Tresaure ,elle contient les pieces d'or que le joueur va ramasser 
 * @author Dinar
 */
public class Chest extends Treasure {
    /**
     * Nombre de Gold 
     */
    private int gold;
/**
 * character de l'objet
 */
    final char CHARACTER = '$';



    /**
     *Constructeur
     * @param gold nb de gold
     */
    public Chest(int gold) {
        super();
        this.gold = gold;

    }
    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    /**
     * Permet de faire gagner un somme de Gold
     * @param player le joueur
     * @return le message de gain
     */
    @Override
    public Action action(Player p) {
        p.setGold(p.getGold() + this.getGold());
        return new Action(0, "Vous avez ouvert un coffre contenant " + this.getGold() + " pièces d'or.");
    }

    @Override
    public char getCHARACTER() {

        return this.CHARACTER;
    }
}
