package model;

import controller.Game;

public class Potion extends Treasure{
    private int force;

    public Potion(int minForce,int maxForce) {
        super();
    }

    public Potion(int healthBack) {
        super();
        this.force = healthBack;
    }

    public void setHealthBack(int healthBack) {
        this.force = healthBack;
    }

    public int getHealthBack() {
        return force;
    }

    @Override
    public int Action(Player p) {
        // TODO Implement this method
        return 0;
    }
}
