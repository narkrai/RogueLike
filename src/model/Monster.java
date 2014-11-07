package model;

import controller.Game;

public class Monster extends Character {
    private int strength;
    private int gold;
    private String name;

    public Monster() {
        super();
    }

    public Monster(String name, int strength, int gold) {
        super();
        this.strength = strength;
        this.gold = gold;
        this.name = name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



    @Override
    public int Action(Player p) {
        int proba = p.getStrength() / (p.getStrength() + this.getStrength());
        
        
        return 0;
    }
}
