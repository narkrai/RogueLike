package model;

import controller.Game;

public class Chest extends Treasure{
    private int gold;

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }



    public Chest(int gold) {
        super();
        this.gold = gold;
        this.setCHARACTER('$');
    }


    @Override
    public Message Action(Player p) {
        p.setGold(p.getGold() + this.getGold());
        return new Message(0, "Vous avez ouvert un coffre contenant "+this.getGold()+" pi�ces d'or.");
    }
}
