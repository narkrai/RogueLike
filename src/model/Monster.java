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
        return this.strength;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return this.gold;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }



    public Message Action(Player p) {
        Message res = null;
        double proba = p.getStrength() / (p.getStrength() + this.getStrength());
        if (Math.random() <= proba) {
            res = new Message(1, "Vous avez battu "+this.getName()+" de force "+this.getStrength()+". Vous recevez "+this.getGold()+ "pièces d'or.");
        }
        else {
            res = new Message(2, "Vous avez perdu contre "+this.getName()+" de force "+this.getStrength()+". Vous recevez "+this.getGold() +"pièces d'or.");
        }
        
        
        return res;
    }
}
