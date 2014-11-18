package model;

import controller.Game;

import java.util.Random;

public class Monster extends Character {
    private int strength;
    private int gold;
    private String name;
    private int level;
    
    //constante de valeurs entre Game et action
    private final int NORMAL = 0 ;
    private final int VICTORY = 1;
    private final int LOSE = 2;
    
    
    final char CHARACTER = '!';

    public Monster() {
        super();
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
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

    public Monster(String name, int strength, int gold, int level) {
        super();
        this.strength = strength;
        this.gold = gold;
        this.name = name;
        this.level = level;
    }


    public Action action(Player p) {
        Action res = null;
        
        Random rand = new Random();
        double chance = rand.nextDouble();
        
        double proba = p.getStrength() / (p.getStrength() + this.getStrength());
        if (chance <= proba) {
            res = new Action(VICTORY , "Vous avez battu "+this.getName()+" de force "+this.getStrength()+". Vous recevez "+this.getGold()+ "pièces d'or.");
        }
        else {
            res = new Action(LOSE, "Vous avez perdu contre "+this.getName()+" de force "+this.getStrength()+". Vous recevez "+this.getGold() +"pièces d'or.");
        }
        return res;
    }

    @Override
    public char getCHARACTER() {
        
        return this.CHARACTER;
    }
}
