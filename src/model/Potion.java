package model;

import controller.Game;

public class Potion extends Treasure{
    
    private int strength;
    final char CHARACTER = 'p';

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
    public Message Action(Player p) {
        p.setStrength(p.getStrength()+this.getStrength());
    
        
        return new Message(0, "test");
    }

    @Override
    public char getCHARACTER() {
        
        return this.CHARACTER;
    }
}
