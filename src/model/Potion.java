package model;

import controller.Game;

public class Potion extends Treasure{
    private int strength;

    public Potion(int minForce,int maxForce) {
        super();
    }

    public Potion(int strength) {
        super();
        this.setStrength(strength);
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return this.strength;
    }

    @Override
    public int Action(Player p) {
        p.setStrength(this.getStrength());
        /**
         * @TODO : Supprimer l'instance
         */
        return 0;
    }
}
