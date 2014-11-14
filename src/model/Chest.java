package model;

import controller.Game;

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


    @Override
    public Message Action(Player p) {
        p.setGold(p.getGold() + this.getGold());
        return new Message(0, "Vous avez ouvert un coffre contenant "+this.getGold()+" pièces d'or.");
    }

    @Override
    public char getCHARACTER() {
        
        return this.CHARACTER;
    }
}
