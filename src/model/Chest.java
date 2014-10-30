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

    public Chest(int minGold,int maxGold) {
        super();
    }

    public Chest(int gold) {
        super();
        this.gold = gold;
    }


    @Override
    public int Action(Player p) {
        // TODO Implement this method
        return 0;
    }
}
