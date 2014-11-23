package model;

import controller.Game;
import model.Action;

public class Chest extends Treasure{
    private int gold;
    
    final char CHARACTER = '$';

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }



    public Chest(int gold) {
        super();
        this.gold = gold;
        
    }

    /**
     * Permet de faire gagner un somme de Gold
     * @param player le joueur
     * @return le message de gain
     */
    @Override
    public Action action(Player p) {
        p.setGold(p.getGold() + this.getGold());
        return new Action(0, "Vous avez ouvert un coffre contenant "+this.getGold()+" pièces d'or.");
    }

    @Override
    public char getCHARACTER() {
        
        return this.CHARACTER;
    }
}
